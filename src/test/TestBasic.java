package test;

public class TestBasic {

    public static void main(String[] args) {
        int a = 5;
        int b = a;
        a = 3;
        String s1 = "a";
        String s2 = s1;
        s1 = "b";
        Test t1 = new Test("aaa", 3);
        Test t2 = t1;
        t1.setName("bbb");
        System.out.println(a + "," + b + "," + s1 + "," + s2);
        System.out.println(t1);
        System.out.println(t2);
    }
}
