package com.empManagement.empManagement.service;

import com.empManagement.empManagement.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empManagement.empManagement.repositary.employeeRepositary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class employeeService {

    @Autowired
    private employeeRepositary bRepo;

    public void save(employee b){
        bRepo.save(b);
    }



    public employee getemployeeById(int id){
        return bRepo.findById(id).get();
    }

    public void deleteById(int id) {
        bRepo.deleteById(id);
    }



    public List<employee> getAllemployees(){
        return bRepo.findAll();
    }

    public List<employee> getByKeyword(String keyword){
        return bRepo.findByKeyword(keyword);
    }





    public double getAverageSalary() {
        List<employee> employees = bRepo.findAll();
        double totalSalary = employees.stream()
                .filter(employee -> employee.getSalary() != null)
                .mapToDouble(employee -> {
                    try {
                        return Double.parseDouble(employee.getSalary());
                    } catch (NumberFormatException e) {
                        // Handle invalid salary values here (e.g., log an error)
                        return 0.0; // or another default value
                    }
                })
                .sum();
        return employees.isEmpty() ? 0.0 : totalSalary / employees.size();
    }

    public long getEmployeeCount() {
        return bRepo.count();
    }

    public long getCountOfEmployeesWithAttendance() {
        return bRepo.countByisAttedenceIgnoreCase("Yes");
    }

    public long getCountOfEmployeesWithOutAttendance() {
        return bRepo.countByisAttedenceIgnoreCase("No");
    }

    public List<employee> getEmployeesWithNoAttendance() {
        return bRepo.findByisAttedenceIgnoreCase("No");

    }

    public double getAverageSalaryi() {
        List<employee> employees = bRepo.findAll();
        double totalSalary = employees.stream()
                .mapToDouble(employee -> Double.parseDouble(employee.getSalary()))
                .sum();
        return employees.isEmpty() ? 0.0 : totalSalary / employees.size();
    }

    public double getTotalSalary() {
        List<employee> employees = bRepo.findAll();
        double totalSalary = employees.stream()
                .filter(employee -> employee.getSalary() != null)
                .mapToDouble(employee -> {
                    try {
                        return Double.parseDouble(employee.getSalary());
                    } catch (NumberFormatException e) {
                        // Handle invalid salary values here (e.g., log an error)
                        return 0.0; // or another default value
                    }
                })
                .sum();
        return totalSalary;
    }

    public long getCountOfEmployeesIT() {
        return bRepo.countBydepartmentIgnoreCase("IT");
    }
    public long getCountOfEmployeesHRM() {
        return bRepo.countBydepartmentIgnoreCase("HRM");
    }
    public long getCountOfEmployeesTechnical() {
        return bRepo.countBydepartmentIgnoreCase("Technical");
    }
    public long getCountOfEmployeesDesign() {
        return bRepo.countBydepartmentIgnoreCase("Design");
    }
    public long getCountOfEmployeesSocial() {
        return bRepo.countBydepartmentIgnoreCase("Social Media");
    }

    public Map<String, Double> getSectionPercentages() {
        List<employee> employees = bRepo.findAll();
        Map<String, Long> sectionCounts = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> getSection(employee.getDepartment()),
                        Collectors.counting()
                ));

        long totalEmployees = employees.size();
        Map<String, Double> sectionPercentages = new HashMap<>();

        for (String section : sectionCounts.keySet()) {
            long sectionCount = sectionCounts.get(section);
            double sectionPercentage = (sectionCount * 100.0) / totalEmployees;
            sectionPercentages.put(section, sectionPercentage);
        }

        return sectionPercentages;
    }

    // Helper method to determine the department section
    private String getSection(String department) {
        if (department == null) {
            return "Unknown"; // Handle null values
        }

        department = department.toLowerCase(); // Convert to lowercase for case insensitivity

        if (department.contains("it")) {
            return "IT";
        } else if (department.contains("hrm")) {
            return "HRM";
        } else if (department.contains("technical")) {
            return "Technical";
        } else if (department.contains("design")) {
            return "Design";
        } else if (department.contains("social media")) {
            return "Social";
        } else {
            return "Unknown"; // Handle other department names
        }
    }


}
