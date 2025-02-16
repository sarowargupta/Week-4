package com.week4.day6.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Create a User class to store roles
class Users {
    private String role;

    public Users(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Create a Service class with role-restricted methods
class SecureService {

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed successfully!");
    }
}

// Access Control Logic (using Reflection)
public class RollAllowedAnnotation{
    public static void main(String[] args) throws Exception {
        Users adminUser = new Users("ADMIN");
        Users normalUser = new Users("USER");

        SecureService service = new SecureService();

        // Check access control for different methods
        invokeIfAuthorized(adminUser, service, "adminTask");
        invokeIfAuthorized(normalUser, service, "adminTask");
        invokeIfAuthorized(normalUser, service, "userTask");
    }

    // Method to check authorization and invoke methods
    public static void invokeIfAuthorized(Users users, Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(users.getRole())) {
                method.invoke(obj);
            } else {
                System.out.println("Access Denied! " + users.getRole() + " cannot access " + methodName);
            }
        }
    }
}
