package com.example.streamApiOpt.controller;

import com.example.streamApiOpt.domain.Employee;
import com.example.streamApiOpt.service.DepartmentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentsService departmentsService;

    public DepartmentController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping("/min-salary")
    public Employee minSalaryByDepartment(@RequestParam int departmentId) {
        return departmentsService.getMinSalaryByDep(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryByDepartment(@RequestParam int departmentId) {
        return departmentsService.getMaxSalaryByDep(departmentId);
    }

    @GetMapping("/departmentId")
    public List<Employee> employeeByDepartment(@RequestParam int departmentId) {
        return departmentsService.employeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> allEmployeeByDepartment() {
        return departmentsService.employeesByDepartments();
    }
}