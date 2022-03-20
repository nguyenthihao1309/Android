package com.example.uidemo;

import android.net.Uri;

public class NhanVien {
    private Uri hinhDaiDien;
    private int maso;
    private String hoten;
    private String gioitinh;
    private String donvi;

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public Uri getHinhDaiDien() {
        return hinhDaiDien;
    }

    public void setHinhDaiDien(Uri hinhDaiDien) {
        this.hinhDaiDien = hinhDaiDien;
    }

    public NhanVien(Uri hinhDaiDien, int maso, String hoten, String gioitinh, String donvi) {
        this.hinhDaiDien = hinhDaiDien;
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
    }

    public NhanVien(int maso, String hoten, String gioitinh, String donvi) {
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return "Mã số: " + maso + "\n"
                + "Họ tên: " + hoten + "\n"
                + "Giới tính: " + gioitinh + "\n" +
                "Đơn vị: " + donvi;
    }
}
