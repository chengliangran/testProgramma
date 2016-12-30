package com.jerrymouse.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.ByteBuffer;

import com.jerrymouse.core.HttpServer;

public class Response {
	private OutputStream outputStream;
	private Request request;
	public Response(OutputStream outputStream) {
		// TODO Auto-generated constructor stub
		this.outputStream=outputStream;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	
	public void sendStaticRes() {
		FileInputStream fileInputStream=null;
		File file=new File(HttpServer.WEB_ROOT, request.getUrl());
		String msg= "HTTP/1.1 404 File Not Found\r\n" +
				"Content-Type: text/html\r\n" +
				"Content-Length: 23\r\n" +
				"\r\n" +
				"<h1>File Not Found</h1>";
		try {
			if (file.exists()) {
				byte[] buffer=new byte[2048];
				int c=fileInputStream.read(buffer);
				while(c!=-1){
					outputStream.write(buffer, 0, 2048);
					fileInputStream.read(buffer, 0, 2048);
				}			
			}else{
				outputStream.write(msg.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (fileInputStream!=null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
			
	}
	public PrintWriter getWriter() {
		return null;
	}

	
}
