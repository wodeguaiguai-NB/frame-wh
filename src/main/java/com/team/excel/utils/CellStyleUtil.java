package com.team.excel.utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/** 
 * Excel导出工具类  创建样式
 * @author haohao 
 * @date 2018年2月2日 
 */
public class CellStyleUtil {

	private static CellStyleUtil createCellStyle = new CellStyleUtil();
	private static CellStyle cellStyle = null;
	
	private static Workbook workbook = null;
	
	
	
	
	private CellStyleUtil() {
	}

	/**
	 * 创建单元格样式对象
	 * @param workBook
	 * @return
	 */
	public static CellStyleUtil createCellStyle(Workbook workBook){
		//初始化字段
		createCellStyle.cellStyle = null;
		createCellStyle.workbook = null;
		workbook = workBook;
		cellStyle = workbook.createCellStyle();
		return createCellStyle;
	}
	
	/**
	 * 设置字体
	 * @param fontName  字体名称
	 * @param fontHeight  字体大小,输入多个时，以第一个为准
	 * @return
	 */
	public CellStyleUtil setFont(String fontName,short ...fontHeight){
		if(cellStyle!=null){
			Font font = workbook.createFont();
			font.setFontName(fontName);
			if(fontHeight!=null&&fontHeight.length>0){
				font.setFontHeightInPoints(fontHeight[0]);
			}
			cellStyle.setFont(font);
		}
		
		return createCellStyle;
	}
	
	/**
	 * 设置水平方向对齐方式
	 * @param align
	 * @return
	 */
	public CellStyleUtil setAlign(short align){
		if(cellStyle!=null){
			cellStyle.setAlignment(align);
		}
		return createCellStyle;
	}
	
	/**
	 * 设置垂直方向对齐方式
	 * @param vAlign
	 * @return
	 */
	public CellStyleUtil setVerticalAlignment(short vAlign){
		if(cellStyle!=null){
			cellStyle.setVerticalAlignment(vAlign);
		}
		return createCellStyle;
	}
	
	
	/**
	 * 设置垂直方向对齐方式
	 * @param vAlign
	 * @return
	 */
	public CellStyleUtil setWrapText(boolean flag){
		if(cellStyle!=null){
			cellStyle.setWrapText(flag);
		}
		return createCellStyle;
	}
	
	
	/**
	 * 设置边框样式 设置顺序(上右下左)
	 * @return
	 */
	public CellStyleUtil setAllBorder(short ...borderType){
		if(cellStyle!=null){
			if(borderType!=null){
				int len = borderType.length;
				if(len>0){  //上边框
					cellStyle.setBorderTop(borderType[0]);
				}
				if(len>1){  //右边框
					cellStyle.setBorderRight(borderType[1]);
				}
				if(len>2){  //下边框
					cellStyle.setBorderBottom(borderType[2]);
				}
				if(len>3){  //左边框
					cellStyle.setBorderLeft(borderType[3]);
				}
			}
		}
		return createCellStyle;
	}
	
	/**
	 * 设置边框样式 设置顺序(上右下左)
	 * 根据参数个数，同时给四个边设置属性
	 * @return
	 */
	public CellStyleUtil setAllBorderDefault(short ...borderType){
		if(cellStyle!=null){
			if(borderType!=null){
				int len = borderType.length;
				if(len==1){  //上下左右
					cellStyle.setBorderTop(borderType[0]);
					cellStyle.setBorderRight(borderType[0]);
					cellStyle.setBorderBottom(borderType[0]);
					cellStyle.setBorderLeft(borderType[0]);
				}
				if(len==2){  //上下，左右
					cellStyle.setBorderTop(borderType[0]);
					cellStyle.setBorderRight(borderType[1]);
					cellStyle.setBorderBottom(borderType[0]);
					cellStyle.setBorderLeft(borderType[1]);
				}
				if(len==3){  //上，左右，下
					cellStyle.setBorderTop(borderType[0]);
					cellStyle.setBorderRight(borderType[1]);
					cellStyle.setBorderBottom(borderType[1]);
					cellStyle.setBorderLeft(borderType[2]);
				}
				if(len==4){  //上，右，下，左
					cellStyle.setBorderTop(borderType[0]);
					cellStyle.setBorderRight(borderType[1]);
					cellStyle.setBorderBottom(borderType[2]);
					cellStyle.setBorderLeft(borderType[3]);
				}
			}
		}
		return createCellStyle;
	}
	
	
	/**
	 * 给单元格设置背景色
	 * @param color
	 * @return
	 */
	public CellStyleUtil setCellBackgroundColor(short color,short fillPattern){
		if(cellStyle!=null){
			cellStyle.setFillForegroundColor(color);
			cellStyle.setFillPattern(fillPattern);
		}
		return createCellStyle;
	}
	
	
	/**
	 * 设置边框颜色
	 * @param color
	 * @return
	 */
	public CellStyleUtil setBorderColor(short color){
		if(cellStyle!=null){
			
			cellStyle.setLeftBorderColor(color);
			cellStyle.setRightBorderColor(color);
			cellStyle.setTopBorderColor(color);
			cellStyle.setBottomBorderColor(color);
		}
		return createCellStyle;
	}
	/**
	 * 返回单元格样式对象
	 * @return
	 */
	public CellStyle getCellStyle(){
		return cellStyle;
	}
	
	
}
