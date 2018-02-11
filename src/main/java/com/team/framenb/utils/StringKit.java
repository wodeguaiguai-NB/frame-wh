package com.team.framenb.utils;


import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public final class StringKit {

	/**
	 * 转换成String，如果为null，返回""
	 */
	public static String toString(Object object) {
		return toString(object, "");
	}

	/**
	 * 转换成String，如果为null，返回defaultVal
	 */
	public static String toString(Object object, String defaultVal) {
		if (object == null)
			return defaultVal;
		if ("null".equalsIgnoreCase(object.toString()))
			return defaultVal;
		if (StringUtils.isBlank(object.toString()))
			return defaultVal;
		if (object instanceof Number)
			return NumberFormat.getInstance().format(object).replace(",", "");
		return object.toString();
	}
	
	/**
	 * list转string
	 * @param list
	 * @return
	 */
    public static List<String> toStrings(List<? extends Object> list){
        List<String> strings = new ArrayList<String>();
        for (Object obj : list) {
            strings.add(toString(obj));
        }
        return strings;
    }

	/**
	 * 比较俩对象转换成字符串后是否相等。null eq ""
	 */
	public static boolean equals(Object object1, Object object2) {
		String str1 = toString(object1, "");
		String str2 = toString(object2, "");

		return str1.equals(str2);
	}

	/**
	 * 转换成int类型
	 */
	public static Integer toInt(Object object) {
		String value = toString(object, "0");
		String str = StringUtils.contains(value, ".") ? value.substring(0, value.indexOf(".")) : value;
		int intgeo = Integer.parseInt(str);
		return intgeo;
	}

	/**
	 * 转换成double类型
	 * 
	 * @param object
	 * @return
	 */
	public static Double toDouble(Object object) {
		return Double.parseDouble(toString(object, "0"));
	}

	/**
	 * 转换成Long类型
	 * 
	 * @param object
	 * @return
	 */
	public static Long toLong(Object object) {
		return Long.parseLong(toString(object, "0"));
	}

	/**
	 * 格式化Double值，返回String
	 */
	public static String formatNumber(Number d, int scale) {
		if (d == null)
			return null;
		return String.format("%." + scale + "f", Double.parseDouble(d.toString()));
	}

	/**
	 */
	public static String formatNumber(Number d, int length, int scale) {
		return formatNumber(d, length, scale, null);
	}

	public static String formatNumber(Number d, int length, int scale, String defaultValue) {
		if (d == null)
			return defaultValue;
		String value = formatNumber(d, scale); // 22.000000
		length = length + (scale > 0 ? 1 : 0);
		if (value.length() > length) {
			System.out.println("数值：" + value + "超出长度：" + length);
		}
		return StringUtils.right(value, length);
	}

	/**
	 * 由于Java是基于Unicode编码的，因此，一个汉字的长度为1，而不是2。
	 * 但有时需要以字节单位获得字符串的长度。例如，“123abc长城”按字节长度计算是10，而按Unicode计算长度是8。
	 * 为了获得10，需要从头扫描根据字符的Ascii来获得具体的长度。如果是标准的字符，Ascii的范围是0至255，
	 * 如果是汉字或其他全角字符，Ascii会大于255。 因此，可以编写如下的方法来获得以字节为单位的字符串长度。
	 */
	public static int getWordCount(String s) {
		if (StringUtils.isBlank(s))
			return 0;
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			int ascii = Character.codePointAt(s, i);
			if (ascii >= 0 && ascii <= 255)
				length++;
			else
				length += 2;

		}
		return length;

	}

	/**
	 * 基本原理是将字符串中所有的非标准字符（双字节字符）替换成两个标准字符（**，或其他的也可以）。
	 * 这样就可以直接例用length方法获得字符串的字节长度了
	 */
	public static int getWordCountRegex(String s) {
		if (StringUtils.isBlank(s))
			return 0;
		s = s.replaceAll("[^\\x00-\\xff]", "**");
		int length = s.length();
		return length;
	}

	/**
	 * 按特定的编码格式获取长度
	 */
	public static int getWordCountCode(String str, String code) throws UnsupportedEncodingException {
		if (StringUtils.isBlank(str))
			return 0;
		return str.getBytes(code).length;
	}

	/**
	 * 从左向右截取字符串，ascii取1，Unicode取2
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String left(String str, int length) {
		if (StringUtils.isBlank(str))
			return str;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (length >= getWordCount(StringUtils.substring(str, 0, i + 1))) {
				sb.append(str.charAt(i));
			} else {
				break;
			}
		}
		return sb.toString();
	}

	public static boolean isBlank(String string) {
		return StringUtils.isBlank(string) || "null".equalsIgnoreCase(string);
	}

	public static boolean isNotBlank(String string) {
		return !isBlank(string);
	}

	/**
	 * 过滤特殊字符
	 */
	public static String filter(String str) {
		String regEx = "[`~!@#$%^&*()+=|{}':;',\"\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\\\\]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim().replaceAll("\\s", "");
	}

	public static void main(String[] args) {

		System.out.println(filter("美好    旗舰店你好啊\\的带\nD**&()())):\"]\">??栋''冻死\r扥扥赛风阿达的是))__===s-===+++\"?>\n  \\r \\t<??<??~!@#$`是"));
	}
}
