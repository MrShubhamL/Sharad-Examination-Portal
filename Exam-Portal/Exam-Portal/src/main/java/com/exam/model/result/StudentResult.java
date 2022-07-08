package com.exam.model.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class StudentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studId;
    private String studentName;
    private String studentUsername;
    private String yearsOfStudy;
    private String department;
    private String time;
    private String date;
    private String numberOfQuestions;
    private String maxMark;
    private double marksGot;
    private double correctAnswers;
    private double attemted;
    private String title;
    private String examStatus;

    public StudentResult() {
    }

    public Long getStudId() {
        return studId;
    }

    public void setStudId(Long studId) {
        this.studId = studId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getYearsOfStudy() {
        return yearsOfStudy;
    }

    public void setYearsOfStudy(String yearsOfStudy) {
        this.yearsOfStudy = yearsOfStudy;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(String numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(String maxMark) {
        this.maxMark = maxMark;
    }

    public double getMarksGot() {
        return marksGot;
    }

    public void setMarksGot(double marksGot) {
        this.marksGot = marksGot;
    }

    public double getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(double correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public double getAttemted() {
        return attemted;
    }

    public void setAttemted(double attemted) {
        this.attemted = attemted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }
}
