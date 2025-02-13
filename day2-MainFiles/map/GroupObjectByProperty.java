package com.week4.day2.map;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupObjectByProperty {
    // Method to group employees by their department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")

        );

        // Group employees by department
        Map<String, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        // Print the grouped employees
        groupedByDepartment.forEach((department, empList) -> {
            System.out.println(department + ": " + empList);
        });
    }


}

