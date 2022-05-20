package com.example.ontapsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {
    Button btnMoveToBook, btnExit, btnSelect, btnSave, btnUpdate, btnDelete;
    EditText etAuthorAddress, etAuthorEmail, etAuthorId, etAuthorName;
    GridView gridView;
    ArrayList<Author> authors;
    ArrayList<String> strings;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        btnMoveToBook = findViewById(R.id.button_move_to_book);
        btnExit = findViewById(R.id.button_exit);
        btnDelete = findViewById(R.id.button_delete);
        btnSave = findViewById(R.id.button_save);
        btnUpdate = findViewById(R.id.button_update);
        btnSelect = findViewById(R.id.button_select);
        etAuthorAddress = findViewById(R.id.edittext_author_address);
        etAuthorEmail = findViewById(R.id.edittext_author_email);
        etAuthorId = findViewById(R.id.edittext_author_id);
        etAuthorName = findViewById(R.id.edittext_author_name);
        gridView = findViewById(R.id.gridview_authors);

        DBHelper dbHelper = new DBHelper(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                etAuthorId.setText(authors.get(i/4).getAuthorId()+"");
                etAuthorName.setText(authors.get(i/4).getAuthorName());
                etAuthorAddress.setText(authors.get(i/4).getAuthorAddress());
                etAuthorEmail.setText(authors.get(i/4).getAuthorEmail());

            }
        });

        btnMoveToBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthorActivity.this, BookActivity.class);
                startActivity(intent);
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
                if (etAuthorId.getText().toString().trim().equals("") || etAuthorAddress.getText().toString().trim().equals("") || etAuthorEmail.getText().toString().trim().equals("") || etAuthorName.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    Author author = new Author();
                    author.setAuthorId(Integer.parseInt(etAuthorId.getText().toString().trim()));
                    author.setAuthorName(etAuthorName.getText().toString().trim());
                    author.setAuthorAddress(etAuthorAddress.getText().toString().trim());
                    author.setAuthorEmail(etAuthorEmail.getText().toString().trim());
                    if (dbHelper.insertAuthor(author) > 0) {
                        xoaText();
                        authors = dbHelper.getAllAuthors();
                        taoAdapter(authors);
                        Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Bạn lưu không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authors = new ArrayList<>();
                Author author = null;
                if (etAuthorId.getText().toString().trim().equals("")) {
                    authors = dbHelper.getAllAuthors();
                } else {
                    try {
                        author = dbHelper.getAuthorById(Integer.parseInt(etAuthorId.getText().toString().trim()));
                        authors.add(author);
                        xoaText();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        xoaText();
                    }
                }
                taoAdapter(authors);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAuthorId.getText().toString().trim().equals("") || etAuthorName.getText().toString().trim().equals("") || etAuthorEmail.getText().toString().trim().equals("") || etAuthorAddress.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    if (dbHelper.updateAuthor(Integer.parseInt(etAuthorId.getText().toString().trim()), etAuthorName.getText().toString().trim(), etAuthorAddress.getText().toString().trim(), etAuthorEmail.getText().toString().trim()) > 0) {
                        authors = dbHelper.getAllAuthors();
                        taoAdapter(authors);
                        Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                        xoaText();
                    } else {
                        Toast.makeText(getApplicationContext(), "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(etAuthorId.getText().toString().trim());
                if(dbHelper.deleteAuthor(id)>0){
                    authors = dbHelper.getAllAuthors();
                    taoAdapter(authors);
                    xoaText();
                    Toast.makeText(getApplicationContext(), "Đã xóa Author có mã "+id,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Xóa không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void xoaText() {
        etAuthorName.setText("");
        etAuthorId.setText("");
        etAuthorEmail.setText("");
        etAuthorAddress.setText("");
    }

    private void taoAdapter(ArrayList<Author> authors) {
        strings = new ArrayList<>();
        for (Author author : authors) {
            strings.add(author.getAuthorId() + "");
            strings.add(author.getAuthorName());
            strings.add(author.getAuthorAddress());
            strings.add(author.getAuthorEmail());
        }
        adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, strings);
        gridView.setAdapter(adapter);
    }
}