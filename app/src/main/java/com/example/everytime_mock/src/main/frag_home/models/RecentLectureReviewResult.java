package com.example.everytime_mock.src.Main.frag_home.models;

public class RecentLectureReviewResult {

    String classCommentIdx;
    String className;
    String professor;
    String classCommentInf;
    double classStar;

    public RecentLectureReviewResult(String classCommentIdx, String className, String professor, String classCommentInf, double classStar) {
        this.classCommentIdx = classCommentIdx;
        this.className = className;
        this.professor = professor;
        this.classCommentInf = classCommentInf;
        this.classStar = classStar;
    }

    public String getClassCommentIdx() {
        return classCommentIdx;
    }

    public String getClassName() {
        return className;
    }

    public String getProfessor() {
        return professor;
    }

    public String getClassCommentInf() {
        return classCommentInf;
    }

    public double getClassStar() {
        return classStar;
    }
}
