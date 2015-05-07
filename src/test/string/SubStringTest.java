package test.string;

public class SubStringTest {

    public static void main(String[] args) {
        String str = "aaaaaaaaaa";
        try{
            System.out.println(str.substring(0, 3));
        }catch (Exception e){
            System.out.println("is null------------");
        }
        System.out.println(Float.parseFloat("1416453328024"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
