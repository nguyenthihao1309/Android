package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    EditText etId, etTitle, etId_Author;
    ArrayList<Book> books = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ArrayList<String> strings;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        etId = findViewById(R.id.edittext_id);
        etTitle = findViewById(R.id.edittext_title);
        etId_Author = findViewById(R.id.edittext_authorid);
        gridView = findViewById(R.id.gridview_books);

        DBHelper dbHelper = new DBHelper(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                etId.setText(books.get(position / 3).getId() + "");
                etTitle.setText(books.get(position / 3).getTitle());
                etId_Author.setText(books.get(position / 3).getId_author()+"");
            }
        });

        Button bt_Save = findViewById(R.id.button_save);
        bt_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etId.getText().toString().trim().equals("") || etTitle.getText().toString().trim().equals("") || etId_Author.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {

                    Book book = new Book();
                    book.setId(Integer.parseInt(etId.getText().toString()));
                    book.setTitle(etTitle.getText().toString());
                    book.setId_author(Integer.parseInt(etId_Author.getText().toString()));
                    if (dbHelper.insertBook(book) > 0) {
                        xoaText();
                        books = dbHelper.getAllBooks();
                        taoAdapterBook(books);
                        Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Bạn lưu không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button btn_Select = findViewById(R.id.button_select);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                books = new ArrayList<>();
                Book book = null;
                if (etId.getText().toString().trim().equals("")) {
                    books = dbHelper.getAllBooks();
                } else {
                    int ma = Integer.parseInt(etId.getText().toString().trim());
                    try {
                        book = dbHelper.getBookById(ma);
                        books.add(book);
                        xoaText();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        xoaText();
                    }
                }
                taoAdapterBook(books);
            }
        });

        Button btn_update = findViewById(R.id.button_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setId(Integer.parseInt(etId.getText().toString()));
                book.setTitle(etTitle.getText().toString());
                book.setId_author(Integer.parseInt(etId_Author.getText().toString()));

                if (etId.getText().toString().trim().equals("") || etTitle.getText().toString().trim().equals("") || etId_Author.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    int res = dbHelper.updateBook(book.getId(), book.getTitle(), book.getId_author());
                    if (res > 0) {
                        books = dbHelper.getAllBooks();
                        taoAdapterBook(books);
                        Toast.makeText(BookActivity.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                        xoaText();
                    } else {
                        Toast.makeText(BookActivity.this, "Cập nhật không thành công", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

        Button btn_delete = findViewById(R.id.button_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString().trim());
                if (dbHelper.deleteBook(id) > 0) {
                    books = dbHelper.getAllBooks();
                    taoAdapterBook(books);
                    xoaText();
                } else {
                    Toast.makeText(BookActivity.this, "Xóa không thành công", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button btn_exit = findViewById(R.id.button_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void xoaText() {
        etId.setText("");
        etTitle.setText("");
        etId_Author.setText("");
    }

    private void taoAdapterBook(ArrayList<Book> books) {
        strings = new ArrayList<>();
        for (Book bo : books) {
            strings.add(bo.getId() + "");
            strings.add(bo.getTitle()+"");
            strings.add(bo.getId_author() + "");
        }
        adapter = new ArrayAdapter<>(BookActivity.this,
                android.R.layout.simple_list_item_1, strings);
        gridView.setAdapter(adapter);
    }
}