package com.jerrymouse.servlet;

import java.io.PrintWriter;
import java.io.Writer;

import com.jerrymouse.tools.Request;
import com.jerrymouse.tools.Response;

public class PrimitiveServlet {
	public void init() {
		System.out.println("启动");
		
	}
	
	public void service(Request request,Response response) {
		PrintWriter writer=response.getWriter();
		writer.print("helloWord");
		
		
	}
	
	private void destroy() {
		// TODO Auto-generated method stub
		System.out.println("停止");
	}
	
}
