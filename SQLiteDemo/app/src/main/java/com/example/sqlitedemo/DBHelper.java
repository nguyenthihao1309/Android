package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "data1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Authors(id integer primary key, name text, address text, email text);");
        sqLiteDatabase.execSQL("create table Books(id_book integer primary key, title text, id_author integer not null constraint id_author references Authors(id) on delete cascade on update cascade);");
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Books");
        sqLiteDatabase.execSQL("drop table if exists Authors");
        onCreate(sqLiteDatabase);
    }

    //thêm - xóa - sửa - truy vấn author
    public int insertAuthor(Author author) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", author.getIdAuthor() + "");
        contentValues.put("name", author.getName());
        contentValues.put("address", author.getAddress());
        contentValues.put("email", author.getEmail());
        int res = (int) sqLiteDatabase.insert("Authors", null, contentValues);
        sqLiteDatabase.close();

        return res;
    }

    public int insertBook(Book book) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_book", book.getId() + "");
        contentValues.put("title", book.getTitle()+"");
        contentValues.put("id_author", book.getId_author()+"");
        int res = (int) sqLiteDatabase.insert("Books", null, contentValues);
        sqLiteDatabase.close();

        return res;
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String strSQL = "Select * from Books";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(strSQL, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                books.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();
        }
        return books;
    }

    public ArrayList<Book> getBooksByIdAuthor(int id) {
        ArrayList<Book> books = new ArrayList<>();
        String strSQL = "Select * from Books where id_author=?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books where id_author=?", new String[]{String.valueOf(id)});
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

    public Book getBookById(int id) {
       Book book = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Books where id_book=?", new String[]{String.valueOf(id)});
        if (cursor != null) {
            cursor.moveToFirst();
            book = new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            cursor.close();
            db.close();
        }
        return book;
    }



    public int updateBook(int id, String title, int id_author) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("id_author", id_author);
        int res = db.update("Books", values, "id_book = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    public int deleteBook(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete("Books", "id_book = ?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    /*Author*/
    public ArrayList<Author> getAllAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        String strSQL = "Select * from Authors";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(strSQL, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                authors.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();
        }
        return authors;
    }

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

    public int updateAuthor(int id, String name, String address, String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", mail);
        values.put("address", address);
        int res = db.update("Authors", values, "id = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

    public int deleteAuthor(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete("Authors", "id = ?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }

}
