package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
  @Autowired
  private IStuService stuService;

  @RequestMapping("/selectall")
    public  String selectall(Model model){
    List<Student> studentslist=stuService.list();
    model.addAttribute("studentslist",studentslist);
      return "stulist" ;
  }


    @RequestMapping("/deleteById/{id}")
    public  String deleteById(@PathVariable Integer id){
    stuService.removeById(id);
      return "redirect:/stu/selectall" ;
  }

    @RequestMapping("/addstu")
    public  String addstu(Student student){
      student.setAge(11).setName("张三");
    stuService.save(student);
      return "redirect:/stu/selectall" ;
  }
  @RequestMapping("/selectById/{id}")
    public  String selectById(@PathVariable Integer id,Model model){
              Student stu=stuService.getById(id);
              model.addAttribute("stu",stu);
             System.out.println(stu);
              return "updatestu" ;
  }

  @RequestMapping("/updatestuById")
    public  String updatestu(Student student){
    stuService.saveOrUpdate(student);
    return "redirect:/stu/selectall";

  }


}
