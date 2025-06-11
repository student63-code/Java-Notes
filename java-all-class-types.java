// =============================================================================
// COMPLETE GUIDE TO ALL JAVA CLASS TYPES WITH SYNTAX/COMMANDS
// =============================================================================

import java.util.*;

// 1. CONCRETE CLASS (Regular/Normal Class)
// Command: [access_modifier] class ClassName { }
public class ConcreteClass {
    private String name;
    
    public ConcreteClass(String name) {
        this.name = name;
    }
    
    public void display() {
        System.out.println("Concrete class: " + name);
    }
}

// 2. ABSTRACT CLASS
// Command: abstract class ClassName { }
abstract class AbstractClass {
    protected String type;
    
    public AbstractClass(String type) {
        this.type = type;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void performAction();
    
    // Concrete method - can be used directly
    public void commonMethod() {
        System.out.println("Common functionality in abstract class");
    }
}

// Subclass implementing abstract class
class ConcreteSubclass extends AbstractClass {
    public ConcreteSubclass(String type) {
        super(type);
    }
    
    @Override
    public void performAction() {
        System.out.println("Performing action in concrete subclass: " + type);
    }
}

// 3. FINAL CLASS
// Command: final class ClassName { }
final class FinalClass {
    private String value;
    
    public FinalClass(String value) {
        this.value = value;
    }
    
    public void display() {
        System.out.println("Final class cannot be extended: " + value);
    }
}

// Cannot extend final class - this would cause compile error:
// class ExtendedFinal extends FinalClass { }

// 4. STATIC NESTED CLASS
// Command: static class NestedClassName { }
class OuterForStaticNested {
    private static String outerStaticField = "Outer static field";
    private String outerInstanceField = "Outer instance field";
    
    static class StaticNestedClass {
        public void display() {
            System.out.println("Static nested class can access: " + outerStaticField);
            // Cannot access non-static members:
            // System.out.println(outerInstanceField); // Compile error
        }
    }
}

// 5. INNER CLASS (Non-static nested class)
// Command: class InnerClassName { } (inside another class)
class OuterForInner {
    private String outerField = "Outer field";
    
    class InnerClass {
        public void display() {
            System.out.println("Inner class can access: " + outerField);
        }
    }
    
    public void createInner() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}

// 6. LOCAL CLASS
// Command: class LocalClassName { } (inside a method)
class OuterForLocal {
    public void methodWithLocalClass() {
        String localVariable = "Local variable";
        
        class LocalClass {
            public void display() {
                System.out.println("Local class accessing: " + localVariable);
            }
        }
        
        LocalClass local = new LocalClass();
        local.display();
    }
}

// 7. ANONYMOUS CLASS
// Command: new Interface/Class() { /* implementation */ }
interface Displayable {
    void show();
}

class OuterForAnonymous {
    public void createAnonymousClass() {
        // Anonymous class implementing interface
        Displayable anonymous = new Displayable() {
            @Override
            public void show() {
                System.out.println("Anonymous class implementation");
            }
        };
        anonymous.show();
        
        // Anonymous class extending class
        ConcreteClass anonymousClass = new ConcreteClass("Anonymous") {
            @Override
            public void display() {
                System.out.println("Anonymous class extending ConcreteClass");
            }
        };
        anonymousClass.display();
    }
}

// 8. INTERFACE
// Command: interface InterfaceName { }
interface SampleInterface {
    // Public static final by default
    int CONSTANT = 100;
    
    // Abstract method (public abstract by default)
    void abstractMethod();
    
    // Default method (Java 8+)
    default void defaultMethod() {
        System.out.println("Default method in interface");
    }
    
    // Static method (Java 8+)
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
}

// 9. FUNCTIONAL INTERFACE (Java 8+)
// Command: @FunctionalInterface interface InterfaceName { }
@FunctionalInterface
interface FunctionalInterfaceExample {
    void singleAbstractMethod(String input);
    
    // Can have default and static methods
    default void defaultMethod() {
        System.out.println("Default method in functional interface");
    }
}

// 10. ENUM CLASS
// Command: enum EnumName { }
enum DaysOfWeek {
    MONDAY("Start of work week"),
    TUESDAY("Second day"),
    WEDNESDAY("Mid week"),
    THURSDAY("Almost there"),
    FRIDAY("TGIF"),
    SATURDAY("Weekend!"),
    SUNDAY("Rest day");
    
    private String description;
    
    // Enum constructor
    DaysOfWeek(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}

// 11. RECORD CLASS (Java 14+)
// Command: record RecordName(parameters) { }
record PersonRecord(String name, int age, String email) {
    // Compact constructor
    public PersonRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    
    // Additional methods can be added
    public String getDisplayName() {
        return name.toUpperCase();
    }
}

// 12. SEALED CLASS (Java 17+)
// Command: sealed class ClassName permits SubclassNames { }
sealed class Shape permits Circle, Rectangle, Triangle {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    public abstract double calculateArea();
}

// Permitted subclasses
final class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle extends Shape {
    private double width, height;
    
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}

non-sealed class Triangle extends Shape {
    private double base, height;
    
    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// 13. GENERIC CLASS
// Command: class ClassName<T> { }
class GenericClass<T> {
    private T data;
    
    public GenericClass(T data) {
        this.data = data;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public void display() {
        System.out.println("Generic class data: " + data + " (Type: " + data.getClass().getSimpleName() + ")");
    }
}

// 14. SINGLETON CLASS
// Command: Regular class with private constructor and static instance
class SingletonClass {
    private static SingletonClass instance;
    private String data;
    
    // Private constructor
    private SingletonClass() {
        data = "Singleton instance";
    }
    
    // Static method to get instance
    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
    
    public void display() {
        System.out.println("Singleton: " + data);
    }
}

// 15. UTILITY CLASS (All static members)
// Command: final class with private constructor and static methods
final class UtilityClass {
    // Private constructor to prevent instantiation
    private UtilityClass() {
        throw new AssertionError("Utility class cannot be instantiated");
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static String formatString(String input) {
        return input.toUpperCase().trim();
    }
}

// 16. POJO CLASS (Plain Old Java Object)
// Command: Regular class with fields, getters, setters, equals, hashCode, toString
class PojoClass {
    private String name;
    private int value;
    
    // Default constructor
    public PojoClass() {}
    
    // Parameterized constructor
    public PojoClass(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    
    // equals, hashCode, toString methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PojoClass pojoClass = (PojoClass) obj;
        return value == pojoClass.value && Objects.equals(name, pojoClass.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
    
    @Override
    public String toString() {
        return "PojoClass{name='" + name + "', value=" + value + '}';
    }
}

// DEMONSTRATION CLASS
public class AllClassTypesDemo {
    public static void main(String[] args) {
        System.out.println("=== JAVA CLASS TYPES DEMONSTRATION ===\n");
        
        // 1. Concrete Class
        ConcreteClass concrete = new ConcreteClass("Regular");
        concrete.display();
        
        // 2. Abstract Class (through subclass)
        ConcreteSubclass abstractImpl = new ConcreteSubclass("Abstract Implementation");
        abstractImpl.performAction();
        abstractImpl.commonMethod();
        
        // 3. Final Class
        FinalClass finalObj = new FinalClass("Cannot extend");
        finalObj.display();
        
        // 4. Static Nested Class
        OuterForStaticNested.StaticNestedClass staticNested = new OuterForStaticNested.StaticNestedClass();
        staticNested.display();
        
        // 5. Inner Class
        OuterForInner outerForInner = new OuterForInner();
        outerForInner.createInner();
        
        // 6. Local Class
        OuterForLocal outerForLocal = new OuterForLocal();
        outerForLocal.methodWithLocalClass();
        
        // 7. Anonymous Class
        OuterForAnonymous outerForAnonymous = new OuterForAnonymous();
        outerForAnonymous.createAnonymousClass();
        
        // 8. Interface implementation
        SampleInterface interfaceImpl = new SampleInterface() {
            @Override
            public void abstractMethod() {
                System.out.println("Interface method implementation");
            }
        };
        interfaceImpl.abstractMethod();
        interfaceImpl.defaultMethod();
        SampleInterface.staticMethod();
        
        // 9. Functional Interface (Lambda)
        FunctionalInterfaceExample funcInterface = (input) -> 
            System.out.println("Functional interface lambda: " + input);
        funcInterface.singleAbstractMethod("Hello Lambda");
        
        // 10. Enum
        DaysOfWeek day = DaysOfWeek.FRIDAY;
        System.out.println("Enum: " + day + " - " + day.getDescription());
        
        // 11. Record
        PersonRecord person = new PersonRecord("John", 30, "john@email.com");
        System.out.println("Record: " + person);
        System.out.println("Record method: " + person.getDisplayName());
        
        // 12. Sealed Class
        Circle circle = new Circle("Red", 5.0);
        System.out.println("Sealed class - Circle area: " + circle.calculateArea());
        
        // 13. Generic Class
        GenericClass<String> genericString = new GenericClass<>("Hello Generics");
        genericString.display();
        GenericClass<Integer> genericInt = new GenericClass<>(42);
        genericInt.display();
        
        // 14. Singleton
        SingletonClass singleton1 = SingletonClass.getInstance();
        SingletonClass singleton2 = SingletonClass.getInstance();
        singleton1.display();
        System.out.println("Singleton instances equal: " + (singleton1 == singleton2));
        
        // 15. Utility Class
        int sum = UtilityClass.add(5, 3);
        String formatted = UtilityClass.formatString("  hello world  ");
        System.out.println("Utility class - Sum: " + sum + ", Formatted: '" + formatted + "'");
        
        // 16. POJO
        PojoClass pojo = new PojoClass("POJO", 100);
        System.out.println("POJO: " + pojo);
    }
}

/*
 * SUMMARY OF ALL JAVA CLASS TYPES AND THEIR COMMANDS:
 * 
 * 1.  Concrete Class:         class ClassName { }
 * 2.  Abstract Class:         abstract class ClassName { }
 * 3.  Final Class:            final class ClassName { }
 * 4.  Static Nested Class:    static class NestedClassName { }
 * 5.  Inner Class:            class InnerClassName { } (inside outer class)
 * 6.  Local Class:            class LocalClassName { } (inside method)
 * 7.  Anonymous Class:        new Interface/Class() { /* implementation */ }
 * 8.  Interface:              interface InterfaceName { }
 * 9.  Functional Interface:   @FunctionalInterface interface InterfaceName { }
 * 10. Enum Class:             enum EnumName { }
 * 11. Record Class:           record RecordName(parameters) { }
 * 12. Sealed Class:           sealed class ClassName permits SubclassNames { }
 * 13. Generic Class:          class ClassName<T> { }
 * 14. Singleton Class:        class with private constructor and static instance
 * 15. Utility Class:          final class with static methods and private constructor
 * 16. POJO Class:             class with fields, getters, setters, equals, hashCode, toString
 * 
 * ACCESS MODIFIERS for classes:
 * - public class ClassName { }
 * - class ClassName { } (default/package-private)
 * - Inner classes can also use: private, protected
 */
