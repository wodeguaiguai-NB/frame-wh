package com.team.framenb.interceptor;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * 记录每次请求的处理时间
 *
 * @author haohao
 * @create 2017/11/20 上午1:17
 **/
@Aspect
@Component
public class ControllerInterceptor {

    Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Pointcut("execution(* com.team.framenb.controller..*(..))")
    public void controllerPointCut(){}

    @Around("controllerPointCut()")
    public void startRequest(ProceedingJoinPoint pjp) throws Exception {

        MethodSignature signature = (MethodSignature) pjp.getSignature();

        // 方法
        Method method = signature.getMethod();

        String methodName = method.getName();

        Object[] args = pjp.getArgs();

        StringBuilder sb = new StringBuilder();
        if(args!=null&&args.length>0){
            for(int i = 0;i<args.length;i++){
                if(args[i] instanceof HttpServletRequest){
                    HttpServletRequest request = (HttpServletRequest)args[i];
                    Map params = request.getParameterMap();
                    sb.append(new GsonBuilder().create().toJson(params)).append("\n");
                }
            }
        }

        logger.info("===请求处理开始==="+DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
        logger.info("method:"+methodName);
        logger.info("params："+ sb.toString());
        
        try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        logger.info("===请求处理结束==="+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
    }

    public void endResqest() throws Exception {


        logger.info("===请求处理结束==="+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
    }
}
