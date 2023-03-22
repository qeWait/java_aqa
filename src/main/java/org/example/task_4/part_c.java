package org.example.task_4;

public class part_c {
//    Create a generic interface that defines a method that takes a parameter of any type,
//    and implement the interface with a concrete class
//    that specifies the type using interface and implements.

    public static void main(String[] args) {
        ConcreteClass concrete = new ConcreteClass();
        concrete.print("Hello, World!");
    }

    public interface GenericInterface<T> {
        void print(T input);
    }

    public static class ConcreteClass implements GenericInterface<String> {
        @Override
        public void print(String input) {
            System.out.println(input);
        }
    }


}
