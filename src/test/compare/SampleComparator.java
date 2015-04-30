package test.compare;

import java.util.Arrays;
import java.util.Comparator;
public class SampleComparator implements Comparator<String> {
  public int compare(String o1, String o2) {
    return toInt(o1) - toInt(o2);
  }
  private int toInt(String str) {
    str = str.replaceAll("一", "1");
    str = str.replaceAll("二", "2");
    str = str.replaceAll("三", "3");
  
    return Integer.parseInt(str);
  }
  /**
   * 测试方法
   */
  public static void main(String[] args) {
    String[] array = new String[] { "一二", "三", "二" };
    Arrays.sort(array, new SampleComparator());
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }
}
