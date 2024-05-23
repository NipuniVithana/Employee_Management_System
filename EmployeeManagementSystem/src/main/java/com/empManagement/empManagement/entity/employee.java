package com.empManagement.empManagement.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String full_name;
    private String date_of_birth;
    private String gender;
    private String nationality;
    private String address;
    private String phone_number;
    private String email;
    private String NIC;
    private String position;
    private String department;
    private String start_date;
    private String employment_status;
    private String salary;

    private String date;

    private String time;

    private String isAttedence;

    private String isPayroll;

    public employee() {
        super();
    }

    public employee(int id, String full_name, String date_of_birth, String gender, String nationality, String address, String phone_number, String email, String NIC, String position, String department, String start_date, String employment_status, String salary,String date,String time,String isAttedence,String isPayroll) {
        super();
        this.id = id;
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.NIC = NIC;
        this.position = position;
        this.department = department;
        this.start_date = start_date;
        this.employment_status = employment_status;
        this.salary = salary;
        this.date = date;
        this.time = time;
        this.isAttedence = isAttedence;
        this.isPayroll=isPayroll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEmployment_status() {
        return employment_status;
    }

    public void setEmployment_status(String employment_status) {
        this.employment_status = employment_status;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsAttedence() {
        return isAttedence;
    }

    public void setIsAttedence(String isAttedence) {
        this.isAttedence = isAttedence;
    }

    public String getIsPayroll() {
        return isPayroll;
    }

    public void setIsPayroll(String isPayroll) {
        this.isPayroll = isPayroll;
    }


}
