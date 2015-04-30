package test.compare;
import java.util.Arrays;
public class UserComparable implements Comparable<UserComparable> {
  private String id;
  private int age;
  public UserComparable(String id, int age) {
    this.id = id;
    this.age = age;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public int compareTo(UserComparable u) {
    return u.getAge() - this.age;
  }
  /**
   * 测试方法
   */
  public static void main(String[] args) {
	  UserComparable[] users = new UserComparable[] { new UserComparable("a", 30), new UserComparable("b", 20) };
    Arrays.sort(users);
    for (int i = 0; i < users.length; i++) {
    	UserComparable user = users[i];
      System.out.println(user.getId() + " " + user.getAge());
    }
  }
} 