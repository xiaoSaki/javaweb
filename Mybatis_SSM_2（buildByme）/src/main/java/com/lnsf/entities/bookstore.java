package com.lnsf.entities;

public class bookstore {
    private String bookid;

    private String storenumber;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid == null ? null : bookid.trim();
    }

    public String getStorenumber() {
        return storenumber;
    }

    public void setStorenumber(String storenumber) {
        this.storenumber = storenumber == null ? null : storenumber.trim();
    }
}