package test;

import test.InnerClassDemo.Inner;

public class InnerClassDemo {
    protected static int a = 9;

    public class Inner {
        private final int t = 1;

        private int getT() {
            return this.t;
        }
    }

    public int getInnerT() {
        return new Inner().getT();
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        InnerClassDemo demo = new InnerClassDemo();
        Inner inner = demo.new Inner();
    }

}

class Test1 {
    int b = InnerClassDemo.a;
    private final Inner inner = new InnerClassDemo().new Inner();
}
