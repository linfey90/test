package test;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    private static List<Test> reset(List<Test> list) {
        List<Test> l2 = new ArrayList<Test>();
        for (Test s : list) {

            s.setName("a");
            l2.add(s);
        }
        return l2;
    }

    public static void main(String[] args) {
        String unitPath = "1,101,631,";

        int start = ("," + unitPath).indexOf("," + 1 + ",");
        int end = ("," + unitPath).indexOf("," + 631 + ",");

        if (start != -1 && end != -1) {
            String u = unitPath.substring(start, end);
            System.out.println("unit:" + u);
        } else {
            System.out.println("not found");
        }

        //        String[] unitIds = u.split(",");
        //        System.out.println(unitIds.length);
    }

}
