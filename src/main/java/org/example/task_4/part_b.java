package org.example.task_4;

import java.lang.reflect.Constructor;

public class part_b {
//    Create your own custom class with a few constructors, and make an object for it.
//    Use getDeclaredConstructors() to print out all the constructors of the class and their parameter types.
//    Choose a specific constructor and create a new instance of the class using newInstance().
//    Print out your results or processing progress

    public static void main(String[] args) {
        try {
            Class<?> customClass = CustomClass.class;

            Constructor<?>[] constructors = customClass.getDeclaredConstructors();

            for (Constructor<?> constructor : constructors) {
                System.out.println("Constructor: " + constructor);
                System.out.print("Parameter types: ");
                for (Class<?> paramType : constructor.getParameterTypes()) {
                    System.out.print(paramType.getName() + ", ");
                }
                System.out.println();
            }

            Constructor<?> chosenConstructor = customClass.getDeclaredConstructor(int.class, String.class);
            CustomClass newInstance = (CustomClass) chosenConstructor.newInstance(42, "example");

            System.out.println("Result: " + newInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class CustomClass {
        private int number;
        private String text;

        public CustomClass() {
            this.number = 0;
            this.text = "";
        }

        public CustomClass(int number) {
            this.number = number;
            this.text = "";
        }

        public CustomClass(int number, String text) {
            this.number = number;
            this.text = text;
        }

        @Override
        public String toString() {
            return "CustomClass{" +
                    "number=" + number +
                    ", text='" + text + '\'' +
                    '}';
        }
    }
}
