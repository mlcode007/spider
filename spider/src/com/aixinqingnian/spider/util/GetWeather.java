package com.aixinqingnian.spider.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetWeather {
	public static void main(String[] args) throws Exception {
		
		
		Document doc = Jsoup.connect("http://weather.sina.com.cn/")
				.ignoreContentType(true).ignoreHttpErrors(true).timeout(20000).get();
		String cssQuery = "div#blk_fc_c0_scroll div.blk_fc_c0_i";
		
		Elements blks = doc.select(cssQuery);
		if(blks.size() < 10){
			throw new RuntimeException("获取天气失败");
		}
		for(Element blk : blks){
			String time = blk.select("p.wt_fc_c0_i_day").text();
			String temp = blk.select("p.wt_fc_c0_i_temp").text();
			String tip = blk.select("p.wt_fc_c0_i_tip").text();
			String levell = blk.select("ul.wt_fc_c0_i_level li.l").text();
			String levelr = blk.select("ul.wt_fc_c0_i_level li.r").text();
			Elements days = blk.select("p.wt_fc_c0_i_icons img");
			for(Element day : days){
				String icons = day.attr("title");
				System.out.print(icons+"\t");
			}
			System.out.print(time+"\t");
			System.out.print(tip+"\t");
			System.out.print(levell+"\t");
			System.out.print(levelr+"\t");
			System.out.println(temp);
		}
	}
}
