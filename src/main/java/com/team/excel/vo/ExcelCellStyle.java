package com.team.excel.vo;

import org.apache.poi.ss.usermodel.CellStyle;

/** 
 * 单元格样式 
 * @author haohao 
 * @date 2018年2月5日 
 */
public class ExcelCellStyle {

	private Integer index;  //列序号
	
	private CellStyle cellStyle;  //单元格样式
	
	private Integer columnWidth;  //列宽

	private String columnName;   //列名
	
	private Integer cellType;    //单元格值类型
	
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public CellStyle getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(CellStyle cellStyle) {
		this.cellStyle = cellStyle;
	}

	public Integer getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(Integer columnWidth) {
		this.columnWidth = columnWidth;
	}

	public Integer getCellType() {
		return cellType;
	}

	public void setCellType(Integer cellType) {
		this.cellType = cellType;
	}
	
	
}
