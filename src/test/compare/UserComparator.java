package test.compare;

import java.util.Arrays;
import java.util.Comparator;

import test.compare.bean.User;
  
/** 
 * @author pengcqu 
 *  
 */  
public class UserComparator implements Comparator {  
  
    public int compare(Object arg0, Object arg1) {
        return ((User) arg1).getAge() - ((User) arg0).getAge();  
    }  
  
    /** 
     * 测试方法 
     */  
    public static void main(String[] args) {  
        User[] users = new User[] { new User("u1001", 25),  
                new User("u1002", 20), new User("u1003", 21) };  
        Arrays.sort(users, new UserComparator());  
        for (int i = 0; i < users.length; i++) {  
            User user = users[i];  
            System.out.println(user.getId() + " " + user.getAge());  
        }  
    }  
}  