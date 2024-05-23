package com.empManagement.empManagement.repositary;

import com.empManagement.empManagement.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface employeeRepositary extends JpaRepository<employee,Integer> {

    @Query(value = "select * from employee b where b.full_name like %:keyword% or b.NIC like %:keyword%", nativeQuery = true)
    List<employee> findByKeyword(@Param("keyword") String keyword);

    long countByisAttedenceIgnoreCase(String isAttendance);

    long countBydepartmentIgnoreCase(String department);

    List<employee> findByisAttedenceIgnoreCase(String isAttendance);
}
