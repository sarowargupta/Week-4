package com.week4.day6.reflection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//define interface
interface Greeting {
    void sayHello();
}

//  Implement the Interface
class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}


// Create a Dynamic Proxy Handler
class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // Log method call before execution
        System.out.println("Executing method: " + method.getName());

        // Invoke the actual method
        return method.invoke(target, args);
    }
}
// Create Proxy Instance and Use It
public class CustomLoggingProxy{

    // Create the real object
    public static void main(String[] args) {
        Greeting original = new GreetingImpl();

        // Create the proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),// Class loader
                new Class[]{Greeting.class},// Interfaces to implement
                new LoggingHandler(original) // Invocation handler
        );

        // Use the proxy object
        proxyInstance.sayHello();
    }
}
