package com.example.ontapsql;

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
    Button btnExit, btnSelect, btnSave, btnUpdate, btnDelete;
    EditText etBookId, etAuthorId, etBookName;
    GridView gridView;
    ArrayList<Book> books = null;
    ArrayList<String> strings = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        btnExit = findViewById(R.id.button_exit);
        btnDelete = findViewById(R.id.button_delete);
        btnSave = findViewById(R.id.button_save);
        btnUpdate = findViewById(R.id.button_update);
        btnSelect = findViewById(R.id.button_select);
        etAuthorId = findViewById(R.id.edittext_book_authorId);
        etBookId = findViewById(R.id.edittext_book_id);
        etBookName = findViewById(R.id.edittext_book_name);
        gridView = findViewById(R.id.gridview_books);

        DBHelper dbHelper = new DBHelper(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                etBookId.setText(books.get(i / 3).getBookId() + "");
                etBookName.setText(books.get(i / 3).getBookName());
                etAuthorId.setText(books.get(i / 3).getAuthorId() + "");
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etBookId.getText().toString().trim().equals("") || etBookName.getText().toString().trim().equals("") || etAuthorId.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Book book = new Book(Integer.parseInt(etBookId.getText().toString().trim()), etBookName.getText().toString().trim(), Integer.parseInt(etAuthorId.getText().toString().trim()));
                    if (dbHelper.insertBook(book) > 0) {
                        Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                        xoaText();
                        books = dbHelper.getAllBooks();
                        taoAdapter(books);
                    } else {
                        Toast.makeText(getApplicationContext(), "Lưu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etBookId.getText().toString().trim().equals("") && etAuthorId.getText().toString().trim().equals("")) {
                    books = dbHelper.getAllBooks();
                    taoAdapter(books);
                } else {
                    books = new ArrayList<>();
                    try {
                        if (etAuthorId.getText().toString().trim().equals("") && !etBookId.getText().toString().trim().equals("")) {
                            Book book = dbHelper.getBookById(Integer.parseInt(etBookId.getText().toString().trim()));
                            books.add(book);
                        } else if (etBookId.getText().toString().trim().equals("") && !etAuthorId.getText().toString().trim().equals("")) {
                            books = dbHelper.getBooksByAuthorId(Integer.parseInt(etAuthorId.getText().toString().trim()));
                        } else {
                            Book book = dbHelper.getBookByIdAndAuthorId(Integer.parseInt(etBookId.getText().toString().trim()), Integer.parseInt(etAuthorId.getText().toString().trim()));
                            books.add(book);
                        }
                        if(books.isEmpty()){
                            Toast.makeText(getApplicationContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                    taoAdapter(books);
                    xoaText();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etBookId.getText().toString().trim().equals("") || etBookName.getText().toString().trim().equals("") || etAuthorId.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    if (dbHelper.updateBook(Integer.parseInt(etBookId.getText().toString().trim()), etBookName.getText().toString().trim(), Integer.parseInt(etAuthorId.getText().toString().trim())) > 0) {
                        Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        xoaText();
                        books = new ArrayList<>();
                        books = dbHelper.getAllBooks();
                        taoAdapter(books);
                    } else {
                        Toast.makeText(getApplicationContext(), "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etBookId.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Nhập mã/chọn sách cần xóa", Toast.LENGTH_SHORT).show();
                } else {
                    if (dbHelper.deleteBook(Integer.parseInt(etBookId.getText().toString().trim())) > 0) {
                        Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                        xoaText();
                        books = new ArrayList<>();
                        books = dbHelper.getAllBooks();
                        taoAdapter(books);
                    } else {
                        Toast.makeText(getApplicationContext(), "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        xoaText();
                    }
                }
            }
        });
    }

    private void xoaText() {
        etBookId.setText("");
        etBookName.setText("");
        etAuthorId.setText("");
    }

    private void taoAdapter(ArrayList<Book> books) {
        strings = new ArrayList<>();
        for (Book b : books
        ) {
            strings.add(b.getBookId() + "");
            strings.add(b.getBookName());
            strings.add(b.getAuthorId() + "");

        }
        adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1, strings);
        gridView.setAdapter(adapter);
    }
}