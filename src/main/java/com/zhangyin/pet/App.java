package com.zhangyin.pet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;  

/**
 * Hello world!
 *
 */
public class App 
{
	   public static  String  sendHttpRequest(String content,String url){
	        try {
	        	CloseableHttpClient client= HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).build();  
//	            CloseableHttpClient client=  HttpClients.createDefault();
	            HttpPost httpPost=new HttpPost(url);
	            httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
	            httpPost.setHeader("User-Agent","Dalvik/2.1.0 (Linux; U; Android 6.0.1; SM-G9350 Build/MMB29M)");
	            StringEntity reqEntity = new StringEntity(content,"UTF-8");
	            httpPost.setEntity(reqEntity);
	            HttpResponse response= client.execute(httpPost);
	            if(response.getStatusLine().getStatusCode() == 200) {
	                HttpEntity entity = response.getEntity();
	                String message = EntityUtils.toString(entity, "utf-8");
	                System.out.println(message);
	                try {
	        			Thread.sleep(100);
	        		} catch (InterruptedException e) {
	        			// TODO Auto-generated catch block
	        			e.printStackTrace();
	        		}
	                return  message;
	            } else {
	                System.out.println("请求失败");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        throw new IllegalStateException("请求失败");
	}
	   private static SSLConnectionSocketFactory createSSLConnSocketFactory() {  
	        SSLConnectionSocketFactory sslsf = null;  
	        try {  
	            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {  
	  
	                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {  
	                    return true;  
	                }  
	            }).build();  
	            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {  
	  
	                public boolean verify(String arg0, SSLSession arg1) {  
	                    return true;  
	                }  
	  
	                @Override  
	                public void verify(String host, SSLSocket ssl) throws IOException {  
	                }  
	  
	                @Override  
	                public void verify(String host, X509Certificate cert) throws SSLException {  
	                }  
	  
	                @Override  
	                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {  
	                }  
	            });  
	        } catch (GeneralSecurityException e) {  
	            e.printStackTrace();  
	        }  
	        return sslsf;  
	    }  
}
