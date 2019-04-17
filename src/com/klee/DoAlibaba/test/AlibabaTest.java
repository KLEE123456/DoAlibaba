package com.klee.DoAlibaba.test;

import com.klee.DoAlibaba.dao.AlibabaDao;
import com.klee.DoAlibaba.pojo.Employee;
import com.klee.DoAlibaba.pojo.EmpsBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class AlibabaTest {

    @Test
    public void testQuery(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext1.xml");
        AlibabaDao alibabaDao=(AlibabaDao) context.getBean("alibabaDao");
//         List<Employee> employeeList=alibabaDao.findLikeByPage(2,2,"李");
//          List<Employee> employeeList=alibabaDao.findAllEmps();
//         List<Employee> employeeList=alibabaDao.findLikeEmps("李");
//      List<Employee> employeeList=alibabaDao.findByPage(2,2);
//      EmpsBean empsBean=alibabaDao.ConnFindEmpsById(1);
      List<EmpsBean> empsBeans=alibabaDao.ConnFindAllEmps();
        for (EmpsBean empsBean:empsBeans){
            System.out.println(empsBean);
        }
//        for (Employee  employee:employeeList) {
//            System.out.println(employee);
//        }
//           Employee employee=alibabaDao.findEmpsById(1);
//          System.out.println(empsBean);
//        Employee employee=alibabaDao.findEmpsById(1);
//        System.out.println(employee);
    }
    @Test
    public void testTransfer(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext1.xml");
        AlibabaDao alibabaDao=(AlibabaDao) context.getBean("alibabaDao");
        boolean result =alibabaDao.transfer("王芳","张三",500);
       if (result){
           System.out.println("转账成功");
       }
       else {
           System.out.println("转账失败");
       }
    }
    @Test
    public  void  testCUD(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext1.xml");
        AlibabaDao alibabaDao=(AlibabaDao) context.getBean("alibabaDao");
          Employee employee =new Employee(14,2,"李金","男",40,20000);
//       System.out.println(alibabaDao.insertEmps(employee));
        System.out.println(alibabaDao.updateEmps(employee));
        List<Object[]> bufList=new ArrayList<>();
        //String[] buf2=new String[]{"1","周五","男","20","10000","1","王冰","男","40","30000"};
         //String[] buf2=new String[]{"成伟","男","33","15000","10","李海","男","32","10000","11"};
        String[] buf2=new String[]{"17","18"};
        for (int i=0;i<buf2.length;i++){
            String[] sBuf2=new String[1];
            sBuf2[0]=buf2[i];
            bufList.add(sBuf2);
        }
        boolean result=alibabaDao.deleteBatEmps(bufList);
        if (result){
            System.out.println("批处理成功");
        }
        else {
            System.out.println("批处理失败");
        }
//        alibabaDao.updateBatEmps(bufList);
//        alibabaDao.deleteBatEmps(bufList);

    }
}
