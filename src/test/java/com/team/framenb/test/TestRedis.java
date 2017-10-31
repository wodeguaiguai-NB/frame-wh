package com.team.framenb.test;

import com.team.framenb.utils.RedisUtils;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author haohao
 * @create 2017/10/23 上午2:01
 **/
public class TestRedis {

    public static void main(String[] args){

        Client client = new Client();
        
        Jedis jedis = RedisUtils.getJedis();
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
