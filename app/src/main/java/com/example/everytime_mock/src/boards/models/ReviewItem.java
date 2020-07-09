package com.example.everytime_mock.src.Boards.models;

public class ReviewItem {

    private int classCommentIdx;
    private String className;
    private String professor;
    private String classCommentInf;
    private String classStudent;
    private double classStar;
    private int classCommentLike;

    public int getClassCommentIdx() {
        return classCommentIdx;
    }

    public void setClassCommentIdx(int classCommentIdx) {
        this.classCommentIdx = classCommentIdx;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getClassCommentInf() {
        return classCommentInf;
    }

    public void setClassCommentInf(String classCommentInf) {
        this.classCommentInf = classCommentInf;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public double getClassStar() {
        return classStar;
    }

    public void setClassStar(double classStar) {
        this.classStar = classStar;
    }

    public int getClassCommentLike() {
        return classCommentLike;
    }

    public void setClassCommentLike(int classCommentLike) {
        this.classCommentLike = classCommentLike;
    }
}
