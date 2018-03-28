package com.aixinqingnian.spider.util;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.aixinqingnian.spider.httpclient.Client;

public class HttpClientUtil {
	public static String host;
	
	public static String get(String url) {
		Client client = new Client(null, host);
		CloseableHttpResponse response = null;
		try {
			response = client.request(url);
			int code = response.getStatusLine().getStatusCode();
			if(code == 200){
				return EntityUtils.toString(response.getEntity());
			}else{
				System.out.println("«Î«Û ß∞‹°æ"+code+"°ø");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (response != null)
					response.close();
				if(client != null)
					client.close();
			} catch (Exception e) {
			}
		}
		return null;
	}

}
