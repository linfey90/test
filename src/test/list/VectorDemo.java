package test.list;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vs = new Vector<String>();
        vs.addElement("a");
        System.out.println(vs.elementAt(0));
    }
}
