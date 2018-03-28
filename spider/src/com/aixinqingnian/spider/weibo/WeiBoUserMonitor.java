package com.aixinqingnian.spider.weibo;

import org.jsoup.Jsoup;

/**
 * Î¢²©ÓÃ»§¼à¿Ø
 * https://weibo.com/Lady66SH?profile_ftype=1&is_all=1#_0
 * https://weibo.com/shopadidas?profile_ftype=1&is_all=1#_0
 * @author admin
 *
 */
public class WeiBoUserMonitor {
	public static void main(String[] args) throws Exception{
		String url = "https://weibo.com/p/aj/v6/mblog/mbloglist?"
				+ "ajwvr=6"
				+ "&domain=100306"
				+ "&is_search=0"
				+ "&visible=0"
				+ "&is_all=1"
				+ "&is_tag=0"
				+ "&profile_ftype=1"
				+ "&page=2"
				+ "&pagebar=1"
				+ "&pl_name=Pl_Official_MyProfileFeed__22"
				+ "&id=1003061706987705"
				+ "&script_uri=/Lady66SH"
				+ "&feed_type=0"
				+ "&pre_page=2"
				+ "&domain_op=100306"
				+ "&__rnd=1521552367808";
		
		String html = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true).get().html();
		if(html.contains("<title>Sina Visitor System</title>")){
			System.out.println("Î¢²©±»·â:Sina Visitor System");
		}else{
			System.out.println(html);
		}
	}
}
