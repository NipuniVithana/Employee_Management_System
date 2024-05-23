package com.empManagement.empManagement.controller;

import com.empManagement.empManagement.entity.employee;
import com.empManagement.empManagement.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller

public class employeeController {





    @Autowired
    private employeeService service;












    @GetMapping("/home")
    public String home1() {
        return "/pages/landing_page";
    }



    @GetMapping("/employee_register")
    public String employeeRegister() {
    return "/pages/employeeRegister";
    }

    @GetMapping("/logout")
    public String logout() {
        return "auth-login";
    }





    @RequestMapping(path = {"/","/search"})
    public String home(employee employee, Model model, String keyword) {
        if(keyword!=null) {
            List<employee> list = service.getByKeyword(keyword);
            model.addAttribute("employee", list);
        }else {
            List<employee> list = service.getAllemployees();
            model.addAttribute("employee", list);}
        return "/pages/employeeDetails";
    }

    @RequestMapping(path = {"/","/search1"})
    public String attendence(employee employee, Model model, String keyword) {
        if(keyword!=null) {
            List<employee> list = service.getByKeyword(keyword);
            model.addAttribute("employee", list);
        }else {
            List<employee> list = service.getAllemployees();
            model.addAttribute("employee", list);}
        return "/pages/attendence";
    }

    @RequestMapping(path = {"/","/search2"})
    public String showAttendence(employee employee, Model model, String keyword) {
        if(keyword!=null) {
            List<employee> list = service.getByKeyword(keyword);
            model.addAttribute("employee", list);
        }else {
            List<employee> list = service.getAllemployees();
            model.addAttribute("employee", list);}
        return "/pages/showAttendence";
    }

    @RequestMapping(path = {"/","/search3"})
    public String showpayroll(employee employee, Model model, String keyword) {
        if(keyword!=null) {
            List<employee> list = service.getByKeyword(keyword);
            model.addAttribute("employee", list);
        }else {
            List<employee> list = service.getAllemployees();
            model.addAttribute("employee", list);}
        return "/pages/payroll";
    }





    @GetMapping("/employee_details")
    public ModelAndView employeeDetails() {
        List<employee>list = service.getAllemployees();
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/employeeDetails");
        m.addObject("employee",list);
        return new ModelAndView("/pages/employeeDetails","employee",list);
    }




    @GetMapping("/add_attendence")
    public ModelAndView Addattendence() {
        List<employee>list = service.getAllemployees();
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/attendence");
        m.addObject("employee",list);
        return new ModelAndView("/pages/attendence","employee",list);
    }

    @GetMapping("/showAttendence")
    public ModelAndView showAttendence() {
        List<employee>list = service.getAllemployees();
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/showAttendence");
        m.addObject("employee",list);
        return new ModelAndView("/pages/showAttendence","employee",list);
    }

    @GetMapping("/payroll")
    public ModelAndView Showpayroll() {
        List<employee>list = service.getAllemployees();
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/payroll");
        m.addObject("employee",list);
        return new ModelAndView("/pages/payroll","employee",list);
    }

    @PostMapping("/save")
    public String addemployee(@ModelAttribute employee b){
        service.save(b);
        return "redirect:/employee_details";
    }



    @RequestMapping("/editemployee{id}")
    public String editemployee(@PathVariable("id") int id,Model model) {
        employee b=service.getemployeeById(id);
        model.addAttribute("employee",b);
        return "/pages/employeeEdit";
    }

    @RequestMapping("/editPayroll{id}")
    public String editPayroll(@PathVariable("id") int id,Model model) {
        employee b=service.getemployeeById(id);
        model.addAttribute("employee",b);
        return "/pages/editPayroll";
    }

    @RequestMapping("/editAttendence{id}")
    public String editAttendence(@PathVariable("id") int id,Model model) {
        employee b=service.getemployeeById(id);
        model.addAttribute("employee",b);
        return "/pages/editAttendence";
    }

    @RequestMapping("/deleteemployee{id}")
    public String deleteemployee(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/employee_details";
    }

    @GetMapping("/landing_page")
    public ModelAndView showAverageSalary(Model model) {

        long employeeCount = service.getEmployeeCount();
        model.addAttribute("employeeCount", employeeCount);

        long attendanceCount = service.getCountOfEmployeesWithAttendance();
        model.addAttribute("attendanceCount", attendanceCount);

        long LeaveCount = service.getCountOfEmployeesWithOutAttendance();
        model.addAttribute("LeaveCount", LeaveCount);

        double averageSalary = service.getAverageSalary();
        model.addAttribute("averageSalary",averageSalary);

        double totalSalary = service.getTotalSalary();
        model.addAttribute("totalSalary",totalSalary);

        long it = service.getCountOfEmployeesIT();
        model.addAttribute("it", it);

        long hrm = service.getCountOfEmployeesHRM();
        model.addAttribute("hrm", hrm);


        long technical = service.getCountOfEmployeesTechnical();
        model.addAttribute("technical", technical);

        long design = service.getCountOfEmployeesDesign();
        model.addAttribute("design", design);

        long social = service.getCountOfEmployeesSocial();
        model.addAttribute("social", social);

        Map<String, Double> sectionPercentages = service.getSectionPercentages();
        model.addAttribute("sectionPercentages", sectionPercentages);




        List<employee>list = service.getEmployeesWithNoAttendance();
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/landing_page");
        m.addObject("employee",list);


        return new ModelAndView("/pages/landing_page","employee",list);
    }

    @GetMapping("/")
    public ModelAndView home(Model model) {

        long employeeCount = service.getEmployeeCount();
        model.addAttribute("employeeCount", employeeCount);

        long attendanceCount = service.getCountOfEmployeesWithAttendance();
        model.addAttribute("attendanceCount", attendanceCount);

        long LeaveCount = service.getCountOfEmployeesWithOutAttendance();
        model.addAttribute("LeaveCount", LeaveCount);


        double averageSalary = service.getAverageSalary();
        model.addAttribute("averageSalary",averageSalary);

        double totalSalary = service.getTotalSalary();
        model.addAttribute("totalSalary",totalSalary);



        List<employee>list = service.getEmployeesWithNoAttendance();
        ModelAndView m = new ModelAndView();
        m.setViewName("/pages/landing_page");
        m.addObject("employee",list);


        long it = service.getCountOfEmployeesIT();
        model.addAttribute("it", it);

        long hrm = service.getCountOfEmployeesHRM();
        model.addAttribute("hrm", hrm);


        long technical = service.getCountOfEmployeesTechnical();
        model.addAttribute("technical", technical);

        long design = service.getCountOfEmployeesDesign();
        model.addAttribute("design", design);

        long social = service.getCountOfEmployeesSocial();
        model.addAttribute("social", social);

        Map<String, Double> sectionPercentages = service.getSectionPercentages();
        model.addAttribute("sectionPercentages", sectionPercentages);

        return new ModelAndView("/pages/landing_page","employee",list);




    }




}
