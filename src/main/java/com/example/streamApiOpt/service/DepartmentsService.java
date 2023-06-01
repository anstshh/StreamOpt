package com.example.streamApiOpt.service;

import com.example.streamApiOpt.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentsService {
    final EmployeeService employeeService;

    public DepartmentsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee getMinSalaryByDep(int dep) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == dep)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getMaxSalaryByDep(int dep) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == dep)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> employeesByDepartment(int dep) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == dep)
                .toList();
    }

    public Map<Integer, List<Employee>> employeesByDepartments (){
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));


    }

}

