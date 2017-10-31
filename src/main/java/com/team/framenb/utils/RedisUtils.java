package com.team.framenb.utils;

import redis.clients.jedis.Jedis;

/**
 * redis操作工具类
 *
 * @author haohao
 * @create 2017/10/23 下午11:26
 **/
public class RedisUtils {

    private static Jedis jedis;

    public static Jedis getJedis() {
        if(jedis==null){
            jedis = new Jedis("192.168.1.101");
        }
        return jedis;
    }
}
