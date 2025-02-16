package com.week4.day6.annotation;
import java.lang.annotation.*;
import java.lang.reflect.Method;

//Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)  // Annotation available at runtime
@Target(ElementType.METHOD)  // applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

//Use the annotation in a class
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task completed.");
    }
}

//Retrieve annotation details using Reflection API
public class TaskInfoAnnotation {
    public static void main(String[] args) throws Exception {
        // Get the class object
        Class<?> taskClass = TaskManager.class;

        // Get the method where annotation is applied
        Method method = taskClass.getMethod("completeTask");

        // Check if annotation is present
        if (method.isAnnotationPresent(TaskInfo.class)) {
            // Retrieve annotation
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            // Print annotation details
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        // Call the annotated method
        TaskManager task = new TaskManager();
        task.completeTask();
    }
}
