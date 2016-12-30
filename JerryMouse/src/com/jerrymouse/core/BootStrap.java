package com.jerrymouse.core;

public class BootStrap {
	public static void main(String[] args) {
		new Thread(new Connector()).start();
 	}
}
