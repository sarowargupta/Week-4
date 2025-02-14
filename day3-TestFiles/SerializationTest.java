package com.week4.day3;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeSerializationTest {
    private static final String fileName = " src/main/resources/serialFile.txt";

    @Test
    void testSaveAndLoadEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 75000));
        employees.add(new Employee(2, "Jane Smith", "HR", 68000));
        employees.add(new Employee(3, "Mike Johnson", "Finance", 72000));

        Serialization.saveEmployees(employees);
        List<Employee> loadedEmployees = Serialization.loadEmployees();

        assertNotNull(loadedEmployees, "Loaded employees should not be null");
        assertEquals(employees.size(), loadedEmployees.size(), "Employee list sizes should match");
        assertEquals(employees.toString(), loadedEmployees.toString(), "Employee data should match");
    }

}
