package test;

public class Test {
    public static String habit = "habit";
    String name;
    int age;

    public Test() {
        super();
    }

    public Test(String name) {
        super();
        this.name = name;
    }

    public Test(String name, int age) {
        this(name);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test [name=" + this.name + ", age=" + this.age + "]";
    }
}