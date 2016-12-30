package com.jerrymouse.core;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector implements Runnable{
	String scheme="http";
	ServerSocket serverSocket=null;
	public Connector() {
		// TODO Auto-generated constructor stub
		try {
			System.out.println("连接器启动");
			serverSocket=new ServerSocket(8080);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Socket socket=null;
		while (true) {			
			try {
				socket= serverSocket.accept();
				System.out.println("拿到套接字");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("开始处理套接字");
			Processor processor=new Processor();
			if (socket!=null) {
				processor.process(socket);			
			}
		}	
		
	} 
 	
}
