package com.week4.day6.annotation;

// Legacy class with an old method
class LegacyAPI {

    // Marking this method as deprecated
    @Deprecated
    void oldFeature() {
        System.out.println("Warning:This should not be used.");
    }

    // New recommended method
    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class DeprecatedAnnotation{
    public static void main(String[] args) {

        //create object of LegacyAPI class
        LegacyAPI api = new LegacyAPI();

        //(will show a warning)
        api.oldFeature();

        // Calling new method
        api.newFeature();
    }
}
