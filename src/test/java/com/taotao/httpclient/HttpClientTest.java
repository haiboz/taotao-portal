package com.taotao.httpclient;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 测试HttpClient工具包
 * @author 浮生若梦
 * 2016年10月20日 上午10:53:55
 */
public class HttpClientTest {

	public static void main(String[] args) throws Exception {
		
		Map<String,Object> map = new HashMap<>();
		map.put("ss","ss1");
		map.put("sd","sd1");
		for (String str : map.keySet()) {
			System.out.println(str);
		}

//        testGet();
//        testGetWithParam();
//        testPost();
//        testPostWithParam();

    }
	
	/**
	 * 测试get请求
	 */
	public static void testGet() throws Exception{
		// 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http GET请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容长度：" + content.length());
//                FileUtils.writeStringToFile(new File("C:\\baidu.html"), content);
            }else{
            	System.out.println("访问出错："+response.getStatusLine().getStatusCode());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
	}
	
	/**
	 * 测试代参数的get请求
	 */
	public static void testGetWithParam() throws Exception{
		 // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 定义请求的参数
        URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build();

        System.out.println(uri);

        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("成功："+content.length());
            }else{
            	System.out.println("请求失败："+response.getStatusLine().getStatusCode());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }	
	
	public static void testPost() throws Exception{
		// 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http POST请求
//        HttpPost httpPost = new HttpPost("http://localhost:8081/rest/content/list/95");
        HttpPost httpPost = new HttpPost("http://localhost:8082/httpclient/post.html");

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("成功："+content);
            }else{
            	System.out.println("请求失败："+response.getStatusLine().getStatusCode());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
	}
	
	public static void testPostWithParam() throws Exception {
		// 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://localhost:8082/httpclient/post.html");
        
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("username", "张三"));//中文依然乱码
        parameters.add(new BasicNameValuePair("password", "12345"));
        
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("成功："+content);
            }else{
            	System.out.println("请求失败："+response.getStatusLine().getStatusCode());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
	}

}
