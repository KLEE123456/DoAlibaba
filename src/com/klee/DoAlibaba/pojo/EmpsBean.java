package com.klee.DoAlibaba.pojo;

import org.springframework.stereotype.Component;

@Component
public class EmpsBean {
    private  String ename;

    private String sex;

    private int age;

    private double salary;

    private String dname;

    private String cname;

    public EmpsBean() {

    }

    public EmpsBean(String ename, String sex, int age, double salary, String dname, String cname) {
        this.ename = ename;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
        this.dname = dname;
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "EmpsBean{" +
                "ename='" + ename + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dname='" + dname + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
