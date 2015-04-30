package test;

import redis.clients.jedis.Jedis;

public class RedisTest {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Jedis jr = new Jedis("127.0.0.1", 6379);//redis服务地址和端口号
        String key = "author";
        String v = new String(jr.get(key));
        String k2 = "count";
        jr.incr(k2);
        jr.incr(k2);
        System.out.println(v);
        System.out.println(new String(jr.get(k2)));
    }
}
