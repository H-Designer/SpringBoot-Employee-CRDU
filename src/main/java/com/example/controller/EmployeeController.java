package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.entities.Department;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有的员工信息,返回到员工列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employee = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employee);
        //thymeleaf会自动进行拼接
        //classpath:/tempaltes/xxx.html
        return "emp/list";
    }
    //来到添加员工信息页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门在页面进行显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工信息提交到后台进行接受
    //SpringMvc自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名称和Javabean和入参对象的名称保持一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存的信息"+employee);
        //保存员工信息
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect:表示重定向到一个地址   /代表的是当前项目的路径
        //forward:表示转发到一个地址
        return  "redirect:/emps";
    }

    //来到修改页面，查出改员工的所有的信息;需要将员工的id信息也提交过来
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        System.out.println("这里是员工信息修改（先查出员工的信息）的模块"+employee);
        //修改页面要显示所有的部门信息进行修改的选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面（add是一个修改添加合为一体的界面）
        return "emp/add";
    }

    //员工修改信息
    @PutMapping("/emp")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工信息是"+employee.getBirth());
        employeeDao.save(employee);
        return  "redirect:/emps";
    }

    //删除员工信息
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println("这里是删除员工信息模块"+id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
