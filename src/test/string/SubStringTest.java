package test.string;

public class SubStringTest {

    public static void main(String[] args) {
        String str = "汉子阿斯顿发生地方师傅告诉梵蒂冈";
        try{
            System.out.println(str.substring(0, 3));
        }catch (Exception e){
            System.out.println("is null------------");
        }
        System.out.println(Float.parseFloat("1416453328024"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
