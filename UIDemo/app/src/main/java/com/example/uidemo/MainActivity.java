package com.example.uidemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;


public class MainActivity extends AppCompatActivity {
    private Uri selectImage;
    String[] dv_list;
    ArrayList<NhanVien> nv_list = new ArrayList<NhanVien>();
    String donvi;
    ImageView imgViewAnh;
    Button btnAnh, btnGhi, btnDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_ma = findViewById(R.id.edittext_ma);
        EditText et_ten = findViewById(R.id.edittext_ten);
        ListView lv_NhanVien = findViewById(R.id.listview_nhanvien);
        RadioGroup rg_GioiTinh = findViewById(R.id.radiogroup_gioitinh);
        RadioButton rb_Nam = findViewById(R.id.radiobutton_nam);
        RadioButton rb_Nu = findViewById(R.id.radiobutton_nu);
        btnAnh = findViewById(R.id.button_anhdaidien);
        imgViewAnh = findViewById(R.id.imgview_anhdaidien);
        Button btnThoat = findViewById(R.id.button_thoat);
        Button btnSua = findViewById(R.id.button_sua);
        Button btn_TruyVan = findViewById(R.id.button_truyvan);
        btnDoc = findViewById(R.id.button_doc);
        btnGhi = findViewById(R.id.button_ghi);


        Spinner sp_DOnVi = findViewById(R.id.spinner_donvi);

        btnAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, 3);
                Intent intent = new Intent();

                intent.setType("image/*");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), 1);

            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        dv_list = getResources().getStringArray(R.array.donvi_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dv_list);
        sp_DOnVi.setAdapter(adapter);
        sp_DOnVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_list[1];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        MyArrayAdapter adapter1 = new MyArrayAdapter(MainActivity.this, nv_list, R.layout.nhanvien_item_layout);
        lv_NhanVien.setAdapter(adapter1);

        Button bt_Them = findViewById(R.id.button_them);
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int maso = Integer.parseInt(et_ma.getText().toString());
                String hoten = et_ten.getText().toString();
                String gioitinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();
                String donVi = (String) sp_DOnVi.getSelectedItem();

                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaso(maso);
                nhanVien.setHoten(hoten);
                nhanVien.setGioitinh(gioitinh);
                nhanVien.setDonvi(donVi);
                nhanVien.setHinhDaiDien(selectImage);
                Log.d("ủi-hinh", String.valueOf(selectImage));

                nv_list.add(nhanVien);
                adapter1.notifyDataSetChanged();

                et_ma.setText("");
                et_ten.setText("");

            }
        });

        btn_TruyVan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final EditText text = new EditText(MainActivity.this);
                text.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(text);
                builder.setTitle("Nhập").setMessage("Nhập vào mã nhân viên muốn tìm dưới đây: ").setPositiveButton("Truy vấn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int index = Integer.parseInt(text.getText().toString());
                        NhanVien nhanVien = null;
                        for (NhanVien nv : nv_list
                        ) {
                            if (nv.getMaso() == index) {
                                nhanVien = nv;
                                break;
                            }
                        }
                        if (nhanVien == null)
                            Toast.makeText(MainActivity.this, "Không tìm thấy nhân viên nào có mã vừa nhập.", Toast.LENGTH_SHORT).show();
                        else {

                            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                            builder1.setTitle("KẾT QUẢ");
                            builder1.setMessage(nhanVien.toString());
                            Dialog dialog1 = builder1.create();
                            dialog1.show();
//                            Toast.makeText(MainActivity.this, "tìm thấy nhân viên:" + nhanVien + ", ở vị trí thứ" + nv_list.indexOf(nhanVien), Toast.LENGTH_LONG).show();
                        }

                    }
                }).setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });
        btnGhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = "danhsachnhanvien.txt";
                String data = "";
                NhanVien nhanVien = null;
                for (NhanVien nhanVien1 : nv_list) {
                    data += nhanVien1.getMaso() + ", " + nhanVien1.getHoten() + ", " + nhanVien1.getGioitinh() + ", " + nhanVien1.getDonvi() + ", " + nhanVien1.getHinhDaiDien().normalizeScheme() + "\n";
                }
                FileOutputStream fout = null;
                try {
                    fout = openFileOutput(fileName, Context.MODE_PRIVATE);
                    fout.write(data.getBytes());
                    fout.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream in = openFileInput("danhsachnhanvien.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    StringBuffer buffer = new StringBuffer();
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        String[] thongTin = line.split(", ");
                        NhanVien nhanVien = new NhanVien();
                        nhanVien.setMaso(Integer.parseInt(thongTin[0]));
                        nhanVien.setHoten(thongTin[1]);
                        nhanVien.setGioitinh(thongTin[2]);
                        nhanVien.setDonvi(thongTin[3]);
                        Log.d("uri-hinh-in", thongTin[4]);
                        nhanVien.setHinhDaiDien(Uri.parse(thongTin[4]));

                        nv_list.add(nhanVien);
                        adapter1.notifyDataSetChanged();

                        buffer.append(line).append("\n");

                    }
                    Log.d("read-data:", buffer.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        lv_NhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nv_list.get(i);
                et_ma.setText(nv.getMaso() + "");
                et_ten.setText(nv.getHoten());
                if (nv.getGioitinh().equals("Nam"))
                    rb_Nam.setChecked(true);
                else
                    rb_Nu.setChecked(true);
                for (int j = 0; j < dv_list.length; j++)
                    if (dv_list[j].equals(nv.getDonvi()))
                        sp_DOnVi.setSelection(j);


                imgViewAnh.setImageURI(nv.getHinhDaiDien());
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso = Integer.parseInt(et_ma.getText().toString());
                String hoten = et_ten.getText().toString();
                String gioitinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();
                String donVi = (String) sp_DOnVi.getSelectedItem();
                for (NhanVien nv : nv_list) {
                    if (nv.getMaso() == maso) {
                        nv.setHoten(hoten);
                        nv.setGioitinh(gioitinh);
                        nv.setDonvi(donVi);
                        nv.setHinhDaiDien(selectImage);
                    }
                }
                adapter1.notifyDataSetChanged();

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            selectImage = data.getData();
            imgViewAnh.setImageURI(selectImage);
        }
        if(requestCode==3 & data!=null){
            selectImage = data.getData();
            imgViewAnh.setImageURI(selectImage);
        }
    }
}