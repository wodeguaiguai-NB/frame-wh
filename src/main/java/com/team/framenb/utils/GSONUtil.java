package com.team.framenb.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

/**
 * GSON 工具类
 * Created by haohao on 2018/3/16.
 */
public class GSONUtil {

    private static Gson gson = null;

    public synchronized static Gson getGson(TypeAdapterFactory...typeAdapterFactorys){
        if(gson==null){
            GsonBuilder builder = new GsonBuilder();
            for(TypeAdapterFactory adapter:typeAdapterFactorys){
                builder.registerTypeAdapterFactory(adapter);
            }
            gson = builder.create();
        }

        return gson;
    }
}
