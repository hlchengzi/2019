package com.example.AiLab.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jing on 2017/7/4.
 */
@Entity
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String sex;
    private String grade;
    private String number;
    private String major;
    private String tel;
    private String qq;
    private String grope;


    public Lab(){}
    public Lab(String name, String sex, String grade, String number, String major, String tel, String qq, String grope) {
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.number = number;
        this.major = major;
        this.tel = tel;
        this.qq = qq;
        this.grope = grope;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getGrope() {
        return grope;
    }

    public void setGrope(String grope) {
        this.grope = grope;
    }
}
