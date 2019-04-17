package com.klee.DoAlibaba.pojo;


import org.springframework.stereotype.Component;

@Component
public class Company {

    private int cid;

    private String cname;

    private String address;

    private Department depts;

    public Company() {

    }

    public Company(int cid, String cname, String address, Department depts) {
        this.cid = cid;
        this.cname = cname;
        this.address = address;
        this.depts = depts;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepts(Department depts) {
        this.depts = depts;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getAddress() {
        return address;
    }

    public Department getDepts() {
        return depts;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                ", depts=" + depts +
                '}';
    }
}
