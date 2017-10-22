package com.team.framenb.test;

import redis.clients.jedis.Jedis;

/**
 * @author haohao
 * @create 2017/10/23 上午2:01
 **/
public class TestRedis {

    public static void main(String[] args){

        Jedis jedis = new Jedis("192.168.1.100");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }
}
