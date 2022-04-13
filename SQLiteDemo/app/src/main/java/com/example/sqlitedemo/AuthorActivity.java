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

import com.example.sqlitedemo.Author;
import com.example.sqlitedemo.DBHelper;
import com.example.sqlitedemo.R;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {
    EditText etId, etName, etAddress, etEmail;
    ArrayList<Author> authors;
    ArrayAdapter<String> adapter;
    ArrayList<String> strings;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        etId = findViewById(R.id.edittext_id);
        etName = findViewById(R.id.edittext_name);
        etAddress = findViewById(R.id.edittext_address);
        etEmail = findViewById(R.id.edittext_email);
        gridView = findViewById(R.id.gridview_authors);

        DBHelper dbHelper = new DBHelper(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                etId.setText(authors.get(position / 4).getIdAuthor() + "");
                etName.setText(authors.get(position / 4).getName());
                etAddress.setText(authors.get(position / 4).getAddress());
                etEmail.setText(authors.get(position / 4).getEmail());
            }
        });



        Button bt_Save = findViewById(R.id.button_save);
        bt_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etId.getText().toString().trim().equals("") || etName.getText().toString().trim().equals("") || etAddress.getText().toString().trim().equals("") || etEmail.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    Author author = new Author();
                    author.setIdAuthor(Integer.parseInt(etId.getText().toString()));
                    author.setName(etName.getText().toString());
                    author.setAddress(etAddress.getText().toString());
                    author.setEmail(etEmail.getText().toString());
                    if (dbHelper.insertAuthor(author) > 0) {
                        xoaText();
                        authors = dbHelper.getAllAuthors();
                        taoAdapterAuthor(authors);
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
                authors = new ArrayList<>();
                Author author = null;
                if (etId.getText().toString().trim().equals("")) {
                    authors = dbHelper.getAllAuthors();
                } else {
                    int ma = Integer.parseInt(etId.getText().toString().trim());
                    try {
                        author = dbHelper.getAuthorById(ma);
                        authors.add(author);
                        xoaText();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                        xoaText();
                    }
                }
                taoAdapterAuthor(authors);
            }
        });

        Button btn_update = findViewById(R.id.button_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Author author = new Author();
                author.setIdAuthor(Integer.parseInt(etId.getText().toString()));
                author.setName(etName.getText().toString());
                author.setAddress(etAddress.getText().toString());
                author.setEmail(etEmail.getText().toString());

                if (etId.getText().toString().trim().equals("") || etName.getText().toString().trim().equals("") || etAddress.getText().toString().trim().equals("") || etEmail.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    int res = dbHelper.updateAuthor(author.getIdAuthor(), author.getName(), author.getAddress(), author.getEmail());
                    if (res > 0) {
                        authors = dbHelper.getAllAuthors();
                        taoAdapterAuthor(authors);
                        Toast.makeText(AuthorActivity.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                        xoaText();
                    } else {
                        Toast.makeText(AuthorActivity.this, "Cập nhật không thành công", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

        Button btn_delete = findViewById(R.id.button_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString().trim());
                if (dbHelper.deleteAuthor(id) > 0) {
                    authors = dbHelper.getAllAuthors();

                    taoAdapterAuthor(authors);
                    xoaText();
                } else {
                    Toast.makeText(AuthorActivity.this, "Xóa không thành công", Toast.LENGTH_LONG).show();
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
        etName.setText("");
        etEmail.setText("");
        etAddress.setText("");
    }

    private void taoAdapterAuthor(ArrayList<Author> author) {
        strings = new ArrayList<>();
        for (Author au : authors) {
            strings.add(au.getIdAuthor() + "");
            strings.add(au.getName());
            strings.add(au.getAddress());
            strings.add(au.getEmail());
        }
        adapter = new ArrayAdapter<>(AuthorActivity.this,
                android.R.layout.simple_list_item_1, strings);
        gridView.setAdapter(adapter);
    }


}