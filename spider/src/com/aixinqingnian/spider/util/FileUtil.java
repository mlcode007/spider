package com.aixinqingnian.spider.util;

import java.io.File;
import java.util.*;
import org.apache.commons.io.FileUtils;

public class FileUtil {
	public static void main(String[] args) {
		try{
			List<String> list = FileUtils.readLines(new File("C:\\Users\\admin\\Desktop\\T1\\urls.txt"), "utf-8");
			for(String url : list){
				System.out.println(url);
			}
			
			FileUtils.write(new File("C:\\Users\\admin\\Desktop\\T1\\msg.txt"), "AIÐÂÇàÄê", "UTF-8", false);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
