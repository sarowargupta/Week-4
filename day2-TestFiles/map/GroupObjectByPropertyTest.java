package com.week4.day2.map;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupObjectByPropertyTest {
    @Test
    public void testGroupByDepartment() {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")

        );

        Map<String, List<String>> expectedMap = new HashMap<>();
        expectedMap.put("HR", Arrays.asList("Alice", "Carol"));
        expectedMap.put("IT", Arrays.asList("Bob"));

        Map<String, List<Employee>> groupedMap = GroupObjectByProperty.groupByDepartment(employees);

        Map<String, List<String>> actualMap = new HashMap<>();
        groupedMap.forEach((dept, empList) -> {
            actualMap.put(dept, empList.stream().map(Employee::getName).toList());
        });

        assertEquals(expectedMap, actualMap);
    }
}
