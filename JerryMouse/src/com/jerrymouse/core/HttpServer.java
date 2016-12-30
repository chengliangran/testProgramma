package com.jerrymouse.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.jerrymouse.tools.Request;
import com.jerrymouse.tools.Response;

public class HttpServer {
	public static final String WEB_ROOT=System.getProperty("user.dir")+File.separator+"webroot";
	private static final String SHUTDOWN_COMMAND="/SHUTDOWN";
	private boolean shutdown=false;
	public static void main(String[] args) {
		HttpServer httpServer=new HttpServer();
		
		System.out.println(httpServer.WEB_ROOT);
		httpServer.await();
	}
	private void await() {
		// TODO Auto-generated method stub
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(8080);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		while(true){
			try {
 				Socket socket=null;
				socket=serverSocket.accept();
				System.out.println("deal one socket");
				Request request=null;
				Response response=null;
				request = new Request(socket.getInputStream());
				response = new Response(socket.getOutputStream());
				request.parse();
				System.out.println(request.getUrl());
				response.setRequest(request);
				socket.close();
				shutdown=request.getUrl().equals("/SHUTDOWN");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
			
			
			
		}
		
	}
	
}
