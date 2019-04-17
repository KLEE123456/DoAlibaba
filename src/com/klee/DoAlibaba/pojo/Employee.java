package com.klee.DoAlibaba.pojo;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private int eid;

    private int did;

    private String ename;

    private String sex;

    private int age;

    private double salary;


    public Employee() {

    }

    public Employee(int eid, int did, String ename, String sex, int age, double salary) {
        this.eid = eid;
        this.did = did;
        this.ename = ename;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setDid(int did) { this.did = did; }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEid() {
        return eid;
    }

    public int getDid() {
        return did;
    }

    public String getEname() {
        return ename;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", did=" + did +
                ", ename='" + ename + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
