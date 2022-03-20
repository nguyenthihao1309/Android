package com.example.bai02_quanlysanpham;

public class Product extends Goods {
    private Catalog Dmuc;

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }

    public Product(String id, String name, Catalog dmuc) {
        super(id, name);
        Dmuc = dmuc;
    }

    public Product() {
    }

    public Product(String id, String name) {
        super(id, name);
    }
}
