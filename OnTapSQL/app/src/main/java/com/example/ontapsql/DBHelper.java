package com.example.ontapsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "DataSQL_3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Authors(id integer primary key, name text, address text, email text)");
        sqLiteDatabase.execSQL("create table Books(id integer primary key, name text, author_id integer not null constraint author_id references Authors(id) on delete cascade on update cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Books");
        sqLiteDatabase.execSQL("drop table if exists Authors");
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }


    //query
    //Them
    public int insertAuthor(Author author) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", author.getAuthorId());
        values.put("name", author.getAuthorName());
        values.put("address", author.getAuthorAddress());
        values.put("email", author.getAuthorEmail());
        int res = (int) db.insert("Authors", null, values);
        db.close();
        return res;
    }

    public int insertBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", book.getBookId());
        values.put("name", book.getBookName());
        values.put("author_id", book.getAuthorId());
        int res = (int) db.insert("Books", null, values);
        db.close();
        return res;
    }

    //Select all
    public ArrayList<Author> getAllAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Authors", null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                authors.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return authors;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books", null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                books.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return books;
    }

    //select by id
    public Author getAuthorById(int id) {
        Author author = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Authors where id=?", new String[]{String.valueOf(id)});
        if (cursor != null) {
            cursor.moveToFirst();
            author = new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            cursor.close();
            db.close();
        }
        return author;

    }

    public Book getBookById(int id) {
        Book book = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books where id=?", new String[]{String.valueOf(id)});
        if (cursor != null) {
            cursor.moveToFirst();
            book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            cursor.close();
            db.close();
        }
        return book;
    }

    public ArrayList<Book> getBooksByAuthorId(int author_id) {
        ArrayList<Book> books = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books where author_id=?", new String[]{String.valueOf(author_id)});
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                books.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return books;
    }
    public Book getBookByIdAndAuthorId(int id,int author_id) {
        Book book = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books where id=? and author_id=?", new String[]{String.valueOf(id),String.valueOf(author_id)});
        if (cursor != null) {
            cursor.moveToFirst();
            book =new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            cursor.close();
            db.close();
        }
        return book;
    }

    //update
    public int updateAuthor(int id, String name, String address, String email) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        values.put("email", email);
        int res = db.update("Authors", values, "id=?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    public int updateBook(int id, String name, int author_id) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("author_id", author_id);
        int res = db.update("Books", values, "id=?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    //delete
    public int deleteAuthor(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int res = db.delete("Authors", "id=?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    public int deleteBook(int id) {
        SQLiteDatabase db = getWritableDatabase();
        int res = db.delete("Books", "id=?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

}
