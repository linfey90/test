package test;

public abstract class AbstractDemo {

    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        AbstractDemo demo = new Demo();
        demo.test();
    }
}

class Demo extends AbstractDemo {
    @Override
    public void test() {
        System.out.println("demo");
    }
}
