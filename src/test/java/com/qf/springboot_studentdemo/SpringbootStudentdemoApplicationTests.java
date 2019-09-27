package com.qf.springboot_studentdemo;

import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootStudentdemoApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private IStuService stuService;

    @Test
    public void contextLoads() {
        System.out.println(stuService.list());

    }
    @Test
    public void addStudent() {

        for (int i=0; i<=20;i++){
            Student stu=new Student().setAge(11).setName("张三");
            stuService.save(stu);
        }

    }
    @Test
    public void updateStu() {
        System.out.println(stuService.getById(40));
        Student student=new Student();
        student.setId(40);
        student.setAge(12);
        student.setName("lishi");
         stuService.saveOrUpdate(student);


    }

}
