package com.week4.day6.reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

//Define @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {

}
// Define a Service Class (Dependency)
class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

// Class that Requires Injection
class Client {
    @Inject
    private Service service;

    public void doWork() {
        if (service != null) {
            service.serve();
        } else {
            System.out.println("Service not injected.");
        }
    }
}

// Implement Dependency Injector
class SimpleDIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
    }
}
 //Main Class to Demonstrate DI
public class DependencyInjection {
    public static void main(String[] args) throws Exception {

        // Create instance of Client
        Client client = new Client();

        // Perform Dependency Injection
        SimpleDIContainer.injectDependencies(client);

        // Use the injected object
        client.doWork();
    }
}

