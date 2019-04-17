package com.klee.DoAlibaba.pojo;

import org.springframework.stereotype.Component;

@Component
public class Department {
    private int did;

    private int cid;

    private String dname;

    private Employee emps;

    public Department() {

    }

    public Department(int did, int cid, String dname, Employee emps) {
        this.did = did;
        this.cid = cid;
        this.dname = dname;
        this.emps = emps;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setEmps(Employee emps) {
        this.emps = emps;
    }

    public int getDid() {
        return did;
    }

    public int getCid() {
        return cid;
    }

    public String getDname() {
        return dname;
    }

    public Employee getEmps() {
        return emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", cid=" + cid +
                ", dname='" + dname + '\'' +
                ", emps=" + emps +
                '}';
    }
}
