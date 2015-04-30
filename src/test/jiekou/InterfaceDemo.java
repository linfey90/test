package test.jiekou;

public interface InterfaceDemo {
    public static int t = 8;

    void test();
}

class IDemo implements InterfaceDemo {
    @Override
    public void test() {
        System.out.println("interface");
    }
}
