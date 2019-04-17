package com.klee.DoAlibaba.dao.impl;

import com.klee.DoAlibaba.dao.AlibabaDao;
import com.klee.DoAlibaba.pojo.Employee;
import com.klee.DoAlibaba.pojo.EmpsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
/**
 * 数据层实现类
 */
@Repository("alibabaDao")
public class AlibabaDaoImpl implements AlibabaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 查询所有员工
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public List<Employee> findAllEmps() {
        String sql="SELECT * FROM employee";
        RowMapper<Employee> rowMapper =new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employeeList=this.jdbcTemplate.query(sql,rowMapper);
        return employeeList;
    }

    /**
     * 通过id单个查询
     * @param eid
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public Employee findEmpsById(int eid) {
        String sql="SELECT * FROM employee WHERE employee.eid=?";
        RowMapper<Employee> rowMapper =new BeanPropertyRowMapper<>(Employee.class);
        Employee employee=this.jdbcTemplate.queryForObject(sql,rowMapper,eid);
        return employee;
    }

    /**
     * 转账功能实现
     * @param outEmployee
     * @param inEmplyee
     * @param money
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public boolean transfer(String outEmployee, String inEmplyee, double money) {
        System.out.println("正在处理红包业务...");
        //汇款方
        int num1=this.jdbcTemplate.update("UPDATE employee SET salary=salary-? WHERE ename=?",money,outEmployee);

        //收款方
        int num2=this.jdbcTemplate.update("UPDATE employee SET salary=salary+? WHERE ename=?",money,inEmplyee);

        
        return (num1>0&&num2>0);
    }

    /**
     * 模糊查询
     * @param key
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public List<Employee> findLikeEmps(String key) {
        String sql="SELECT * FROM employee WHERE employee.ename LIKE ?";
        RowMapper<Employee> rowMapper =new BeanPropertyRowMapper<>(Employee.class);
        Object[] objects=new Object[]{"%"+key+"%"};
        List<Employee> employeeList=this.jdbcTemplate.query(sql,objects,rowMapper);
        return employeeList;
    }

    /**
     * 分页查询
     * @param pageNu
     * @param pageSize
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public List<Employee> findByPage(int pageNu, int pageSize) {
        String sql="SELECT * FROM employee LIMIT ?,?";
        Object[] objects=new Object[]{(pageNu-1)*pageSize,pageSize};
        RowMapper<Employee> rowMapper =new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employeeList= this.jdbcTemplate.query(sql,objects,rowMapper);
        return employeeList;
    }

    /**
     * 模糊分页，工资降序查询
     * @param pageNu
     * @param pageSize
     * @param key
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public List<Employee> findLikeByPage(int pageNu, int pageSize, String key) {
        String sql="SELECT * FROM employee  WHERE employee.ename LIKE ? ORDER BY  employee.salary DESC  LIMIT ?,?";
        Object[] objects =new Object[]{"%"+key+"%",(pageNu-1)*pageSize,pageSize};
        RowMapper<Employee> rowMapper =new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employeeList=this.jdbcTemplate.query(sql,objects,rowMapper);
        return employeeList;
    }

    /**
     * 新增员工
     * @param employee
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public boolean insertEmps(Employee employee) {
        String sql="INSERT INTO employee VALUES(DEFAULT,?,?,?,?,?)";
        Object[] objects=new Object[]{employee.getDid(),employee.getEname(),employee.getSex(),employee.getAge(),employee.getSalary()};
        int num=this.jdbcTemplate.update(sql,objects);
        return num>0;
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public boolean updateEmps(Employee employee) {
        String sql="UPDATE employee SET ename=?,sex=?,age=?,salary=? WHERE eid=?";
        Object[] objects =new Object[]{employee.getEname(),employee.getSex(),employee.getAge(),employee.getSalary(),employee.getEid()};
        int num=this.jdbcTemplate.update(sql,objects);
        return num>0;
    }

    /**
     * 删除员工
     * @param eid
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public boolean deleteEmps(int eid) {
        String sql="DELETE FROM employee WHERE eid=?";
        int num=this.jdbcTemplate.update(sql,eid);
        return num>0;
    }

    /**
     * 批量增加员工
     * @param params
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public boolean insertBatEmps(List<Object[]> params) {
        String sql="INSERT INTO employee VALUES(DEFAULT,?,?,?,?,?)";
        int[] buf=this.jdbcTemplate.batchUpdate(sql,params);
        for (int i=0;i<buf.length;i++){
            if (buf[i]<=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 批量删除员工
     * @param params
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public boolean deleteBatEmps(List<Object[]> params) {
        String sql="DELETE FROM employee WHERE eid=?";
        int[] buf=this.jdbcTemplate.batchUpdate(sql,params);
        for (int i=0;i<buf.length;i++){
            if (buf[i]<=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 批量修改员工信息
     * @param params
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public boolean updateBatEmps(List<Object[]> params) {
       String sql="UPDATE employee SET ename=?,sex=?,age=?,salary=? WHERE eid=?";
        int[] buf=this.jdbcTemplate.batchUpdate(sql,params);
        for (int i=0;i<buf.length;i++){
            if (buf[i]<=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 关联查询所有
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public List<EmpsBean> ConnFindAllEmps() {
        String sql="SELECT employee.ename,employee.sex,employee.age,employee.salary,department.dname,company.cname FROM employee \n" +
                "JOIN department ON employee.did=department.did\n" +
                "JOIN company ON department.cid=company.cid";
        RowMapper<EmpsBean> rowMapper =new BeanPropertyRowMapper<>(EmpsBean.class);
        List<EmpsBean> employeeList=this.jdbcTemplate.query(sql,rowMapper);
        return employeeList;
    }

    /**
     * 关联查询单个
     * @param eid
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    public EmpsBean ConnFindEmpsById(int eid) {
        String sql="SELECT employee.ename,employee.sex,employee.age,employee.salary,department.dname,company.cname FROM employee \n" +
                "JOIN department ON employee.did=department.did\n" +
                "JOIN company ON department.cid=company.cid\n" +
                "WHERE employee.eid=?";
        RowMapper<EmpsBean> rowMapper =new BeanPropertyRowMapper<>(EmpsBean.class);
        EmpsBean empsBean=this.jdbcTemplate.queryForObject(sql,rowMapper,eid);
        return empsBean;
    }
}
