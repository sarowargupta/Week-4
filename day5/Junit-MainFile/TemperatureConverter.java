package com.week4.day5.junit;

public class TemperatureConverter {
    //method to convert Converts Celsius to Fahrenheit.
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    //method to convert Converts Fahrenheit to Celsius.
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }


    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        // Test conversions
        double celsius = 25.0;
        double fahrenheit = 77.0;

        //print result
        System.out.println(celsius + "°C to Fahrenheit: " + converter.celsiusToFahrenheit(celsius) + "°F");
        System.out.println(fahrenheit + "°F to Celsius: " + converter.fahrenheitToCelsius(fahrenheit) + "°C");
    }

}
