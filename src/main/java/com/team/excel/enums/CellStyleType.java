package com.team.excel.enums;

public enum CellStyleType {
	//标题样式
	Title(1),
	//表格信息样式
	Info(2),
	//数据列列头样式
	Header(3),
	//文本类型数据样式
	Text(4),
	//数值类型数据样式
	Number(5),
	//居中
	Center(6);
	
	
	
	
	private int type;
	private CellStyleType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	
}
