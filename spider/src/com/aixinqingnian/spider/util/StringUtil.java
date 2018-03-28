package com.aixinqingnian.spider.util;

import java.io.File;

public class StringUtil {
	public static void main(String[] args) {
		
		String path = "C:\\Users\\admin\\Desktop\\T1\\";
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		File[] files = file.listFiles();
		for(File f : files){
			System.out.println(f.getName());
		}
		
		
		path = "C:\\Users\\admin\\Desktop\\T1\\msg.txt";
		System.out.println(path.substring(path.indexOf("\\")+1));
		if(path.lastIndexOf(".") > -1)
			System.out.println(path.substring(path.lastIndexOf(".")+1));	
		System.out.println(path.contains("msg"));
		System.out.println(path.equals("abc"));
		System.out.println(path.length());
		System.out.println(path.charAt(3));
		System.out.println(path.concat("-").concat("-"));
		System.out.println(path+"-");
		System.out.println(path.isEmpty());
		System.out.println("".isEmpty());
//		path = null;
//		System.out.println(path.isEmpty());
		System.out.println(path.intern());
		System.out.println(path.replace("T1", "T2"));
		System.out.println(path.replaceAll("T([0-9]+)", "T2"));
		System.out.println(path.toLowerCase());
		System.out.println(path.toUpperCase());
		System.out.println(path.startsWith("//"));
		System.out.println(path.endsWith("//"));
		System.out.println(path.matches("(.*)"));
		System.out.println(path.hashCode());
		
		System.out.println("=============================");
		StringBuffer sb = new StringBuffer();
//		String s = new String();
		sb.append("1").append("2").append("3").append("\r\n");
		sb.append("1").append("2").append("3");
		System.out.println(sb);
		sb.replace(0, 3, "a");
		System.out.println(sb);
		
	}
}
