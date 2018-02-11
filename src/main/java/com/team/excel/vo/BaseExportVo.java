package com.team.excel.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.team.excel.annotation.ExportCellStyle;


/** 
 * Excel导出 
 * @author haohao 
 * @date 2018年2月2日 
 */
public class BaseExportVo<T> {

	private List<T> datas = new ArrayList<T>();  //数据集合
	
	private Map<String,ExcelCellStyle> cellStyles;  //单元格样式
	
	
	//初始化
	public void init(){
		if(datas!=null&&datas.size()>0){
			T data = datas.get(0);
			//获取class
			Class clazz = data.getClass();
			//获取所有字段
			Field[] fields = clazz.getDeclaredFields();
			//遍历获取ExportCellStyle注解
			if(fields!=null&&fields.length>0){
				cellStyles = new HashMap<String,ExcelCellStyle>();
				for(int i = 0 ;i<fields.length;i++ ){
					ExportCellStyle exportAnnotation = fields[i].getAnnotation(ExportCellStyle.class);
					if(exportAnnotation!=null){
						ExcelCellStyle excelCellStyle = new ExcelCellStyle();
						excelCellStyle.setColumnName(exportAnnotation.columnName());
						excelCellStyle.setColumnWidth(exportAnnotation.columnWidth());
						excelCellStyle.setIndex(exportAnnotation.index());
						excelCellStyle.setCellType(exportAnnotation.cellType());
						cellStyles.put(fields[i].getName(), excelCellStyle);
					}
				}
			}
		}
	}


	public List<T> getDatas() {
		return datas;
	}


	public void setDatas(List<T> datas) {
		this.datas = datas;
	}


	public Map<String, ExcelCellStyle> getCellStyles() {
		return cellStyles;
	}


	public void setCellStyles(Map<String, ExcelCellStyle> cellStyles) {
		this.cellStyles = cellStyles;
	};
	
}
