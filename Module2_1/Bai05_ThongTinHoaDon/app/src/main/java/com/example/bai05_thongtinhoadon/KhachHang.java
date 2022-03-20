package com.example.bai05_thongtinhoadon;

public class KhachHang {
    private String tenKhachHang;
    private int soLuongSach;
    private boolean loaiVip;
    private double thanhTien;

    public KhachHang() {
    }

    public KhachHang(String tenKhachHang, int soLuongSach, boolean loaiVip) {
        this.tenKhachHang = tenKhachHang;
        this.soLuongSach = soLuongSach;
        this.loaiVip = loaiVip;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public int getSoLuongSach() {
        return soLuongSach;
    }

    public boolean isLoaiVip() {
        return loaiVip;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public void setLoaiVip(boolean loaiVip) {
        this.loaiVip = loaiVip;
    }
}
