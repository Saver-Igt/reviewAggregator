package com.example.reviewAggregator.models;

public class Review {
    private int id;
    private int grade;
    private String comment;
    private int idUser;
    private int idProduct;

    public Review(){}
    public Review(int id, int grade, String comment, int idUser, int idProduct){
        this.id = id;
        this.grade = grade;
        this.comment = comment;
        this.idUser = idUser;
        this.idProduct = idProduct;
    }
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
