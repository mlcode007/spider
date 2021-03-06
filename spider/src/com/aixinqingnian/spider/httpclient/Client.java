package com.aixinqingnian.spider.httpclient;

import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
 
public class Client {
 
 
    public static final int max_failures = 3;
    public static final int req_timeout = 60*1000; 
    public HttpHost super_proxy;
    public CloseableHttpClient client;
    public String country;
    public int fail_count;
    public int n_req_for_exit_node;
    public Random rng;
    public String host;

    public Client(String country, String host) {
        this.country = country;
        this.host = host;
        rng = new Random();
        switch_session_id();
    }

    public void switch_session_id() {
        n_req_for_exit_node = 0;
        super_proxy = new HttpHost("127.0.0.1",80);
      
        update_client();
    }

    public void update_client() {
        close();
        
        CredentialsProvider cred_provider = new BasicCredentialsProvider();
//        cred_provider.setCredentials(new AuthScope(super_proxy),
//                new UsernamePasswordCredentials(login, password));
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(req_timeout)
                .setConnectionRequestTimeout(req_timeout)
                .build();
        PoolingHttpClientConnectionManager conn_mgr =
                new PoolingHttpClientConnectionManager();
        conn_mgr.setDefaultMaxPerRoute(Integer.MAX_VALUE);
        conn_mgr.setMaxTotal(Integer.MAX_VALUE);
        client = HttpClients.custom()
                .setConnectionManager(conn_mgr)
//                .setProxy(super_proxy)
//                .setDefaultCredentialsProvider(cred_provider)
                .setDefaultRequestConfig(config)
                .build();
    }

    public CloseableHttpResponse request(String url) throws IOException {
        try {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);
            handle_response(response);
            return response;
        } catch (IOException e) {
            handle_response(null);
            throw e;
        }
    }

    public void handle_response(HttpResponse response) {
        if (response != null && !status_code_requires_exit_node_switch(
                response.getStatusLine().getStatusCode())) {
            // success or other client/website error like 404...
            n_req_for_exit_node++;
            fail_count = 0;
            return;
        }
        switch_session_id();
        fail_count++;
    }

    public boolean status_code_requires_exit_node_switch(int code) {
        return code == 403 || code == 429 || code==502 || code == 503;
    }
 

    public void close() {
        if (client != null)
            try { client.close(); } catch (IOException e) {}
        client = null;
    }
}