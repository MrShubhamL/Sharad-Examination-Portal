package com.exam.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    @Column(length = 2000)
    private String title;
    @Column(length = 2000)
    private String description;
    private String department;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> quiz = new LinkedHashSet<>();


    public Category() {
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<Quiz> getQuiz() {
        return quiz;
    }

    public void setQuiz(Set<Quiz> quiz) {
        this.quiz = quiz;
    }
}
