package com.example.appquiz.Model;

public class TestQuiz {
    int id;
    String title,cau1,cau2,cau3,cau4;

    public TestQuiz(int id, String title, String cau1, String cau2, String cau3, String cau4) {
        this.id = id;
        this.title = title;
        this.cau1 = cau1;
        this.cau2 = cau2;
        this.cau3 = cau3;
        this.cau4 = cau4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCau1() {
        return cau1;
    }

    public void setCau1(String cau1) {
        this.cau1 = cau1;
    }

    public String getCau2() {
        return cau2;
    }

    public void setCau2(String cau2) {
        this.cau2 = cau2;
    }

    public String getCau3() {
        return cau3;
    }

    public void setCau3(String cau3) {
        this.cau3 = cau3;
    }

    public String getCau4() {
        return cau4;
    }

    public void setCau4(String cau4) {
        this.cau4 = cau4;
    }
}
