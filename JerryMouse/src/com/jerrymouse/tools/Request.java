package com.jerrymouse.tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.jerrymouse.core.HttpServer;

public class Request {
	private String url;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	public Request(InputStream inputStream) {
		// TODO Auto-generated constructor stub
		this.inputStream=inputStream;
	}

	public void parse() {
		// TODO Auto-generated method stub
		int i;
		byte[] bytebuffer=new byte[2048];
		StringBuffer request=new StringBuffer();
 		try {
			i=inputStream.read(bytebuffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url=null;
			return;
 		}
 		for (int j = 0; j < bytebuffer.length; j++) {
 			request.append((char)bytebuffer[j]);			
		}
 		String requestString=request.toString();
 		url= parseUri(requestString);
 		System.out.println(requestString);
 		System.out.println(url);
  		
 	}

	public String parseUri(String requestString) {
		// TODO Auto-generated method stub
		int index1, index2,index3, index4;
		index1 = requestString.indexOf(' ');
		if (index1 != -1) {
		index2 = requestString.indexOf(' ', index1 + 1);
		index3 = requestString.indexOf(" ",index2+1);
		if (index2 > index1)
			System.out.println(index1+"--"+index2);
		index4=requestString.indexOf(" ",index3+1);
		return requestString.substring(index3,index4);
		}
		return null;
 	}
	

	public String getUrl() {
		return url;
	}
	
}
