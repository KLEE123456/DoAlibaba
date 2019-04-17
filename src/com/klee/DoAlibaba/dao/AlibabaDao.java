package com.klee.DoAlibaba.dao;

import com.klee.DoAlibaba.pojo.Employee;
import com.klee.DoAlibaba.pojo.EmpsBean;

import java.util.List;

public interface AlibabaDao {
    List<Employee>  findAllEmps();
    Employee findEmpsById(int eid);
    boolean insertEmps(Employee employee);
    boolean updateEmps(Employee employee);
    boolean deleteEmps(int eid);
    boolean transfer(String outEmployee,String inEmplyee,double money);
    List<Employee> findLikeEmps(String key);
    List<Employee> findByPage(int pageNu,int pageSize);
    List<Employee> findLikeByPage(int pageNu,int pageSize,String key);
    boolean deleteBatEmps(List<Object[]> params);
    boolean insertBatEmps(List<Object[]> params);
    boolean updateBatEmps(List<Object[]> params);
    List<EmpsBean> ConnFindAllEmps();
    EmpsBean ConnFindEmpsById(int eid);

}
