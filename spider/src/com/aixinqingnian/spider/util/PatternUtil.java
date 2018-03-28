package com.aixinqingnian.spider.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {

	public static void main(String[] args) {
		String path = "ab12234324.txt";
		// + ����һ�� ?���һ�� *�����
		System.out.println(path.replaceAll("ab([0-9]*).txt", "123.txt"));
		//System.out.println(path.replace("abc", "123"));
		// spu sku ������ԵĹ�ϵ  ����ʹ���������ȥ�� ���ݳ�ȡ
		String regex = "http([s]?)://detail.tmall.com/item.htm?(.*?)id=([0-9]+)";
		String input = "https://detail.tmall.com/item.htm?n=23423&id=563691293403";
		Matcher matcher = Pattern.compile(regex).matcher(input);
		if(matcher.find()){
			System.out.println("ƥ��ɹ�");
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
		}else{
			System.out.println("ƥ��ʧ��");
		}
		//  (.*?) (.*)
		regex = "a(.*)a";
		input = "234abcdeafaaaga";
		matcher = Pattern.compile(regex).matcher(input);
		if(matcher.find()){
			System.out.println("ƥ��ɹ�");
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group(1));
		}else{
			System.out.println("ƥ��ʧ��");
		}
	}
}
