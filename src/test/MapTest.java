package test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("aaa", null);
		if(null!=map.get("bbb")){
			System.out.println("aaa yeys!");
		}
		if(null!=map.get("bbb")){
			System.out.println("bbb yeys!");
		}
	}

}
