package com.erayt.exception;

public class ExceptionTest {
	public static void main(String[] args) {
		show();
	}

	public static void show(){
		try {
			Class clazz=Class.forName("com.erayt.exception.ExceptionTes");
			clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
