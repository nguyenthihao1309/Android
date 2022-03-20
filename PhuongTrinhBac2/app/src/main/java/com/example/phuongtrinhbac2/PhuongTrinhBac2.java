package com.example.phuongtrinhbac2;

public class PhuongTrinhBac2 {
    private float a;
    private float b;
    private float c;

    public PhuongTrinhBac2(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public String tinhPhuongTrinhBac2() {
        String ketQua = "";
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    ketQua = "Phương trình vô số nghiệm";
                else
                    ketQua = "Phương trình vô nghiệm";
            } else {
                ketQua = "Phương trình có một nghiệm: "
                        + "x = " + (-c / b);
            }
        } else {
            // tính delta
            float delta = b * b - 4 * a * c;
            float x1;
            float x2;
            // tính nghiệm
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                ketQua = "Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2;
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                ketQua = "Phương trình có nghiệm kép: " + "x1 = x2 = " + x1;
            } else {
                ketQua = "Phương trình vô nghiệm!";
            }
        }

        return ketQua;
    }

}
