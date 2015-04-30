package test;
import net.sf.json.JSONArray;


public class JsonTest{
    public static void main(String []args)
    {
           String json = "[{\"a\":\"111\",\"b\":\"222\",\"c\":\"333\"},{\"a\":\"1000\",\"b\":\"2000\",\"c\":\"000\"},{\"a\":\"999\",\"b\":\"300\",\"c\":\"700\"}]";
             JSONArray jsonArr = JSONArray.fromObject(json);
             String a[] = new String[jsonArr.size()];
             String b[] = new String[jsonArr.size()];
             String c[] = new String[jsonArr.size()];
             for (int i = 0; i < jsonArr.size(); i++) {
                 a[i] = jsonArr.getJSONObject(i).getString("a");
                 b[i] = jsonArr.getJSONObject(i).getString("b");
                 c[i] = jsonArr.getJSONObject(i).getString("c");
            }
              
             for (int i = 0; i < c.length; i++) {
                System.out.print(a[i]+" ");
                System.out.print(b[i]+" ");
                System.out.print(c[i]);
                System.out.println();
            }
     }
}