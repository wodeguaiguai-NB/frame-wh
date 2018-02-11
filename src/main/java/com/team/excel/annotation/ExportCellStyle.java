package com.team.excel.annotation;
/** 
 * 用于导出时   声明单元格样式
 * @author haohao 
 * @date 2018年2月5日 
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface ExportCellStyle {

	/**
	 * 列序号
	 * @return
	 */
	int index() default 0;
	
	/**
	 * 列样式
	 * @return
	 */
	int columnCellStyle() default 0;
	
	/**
	 * 列名称
	 * @return
	 */
	String columnName() default "";
	
	/**
	 * 列宽
	 * @return
	 */
	int columnWidth() default 1000;
	
	/**
	 * 单元格值类型
	 * @return
	 */
	int cellType() default 1;
}
