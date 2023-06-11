package main;

import java.awt.EventQueue;

import layouts.Login_Panel;
import layouts.Main_Panel;

public class Main {
	public static int statusPanel = 1;
	public final int loginStatus = 1;
	public final int hienThiNhanKhauStatus = 2;
	public final int themNhanKhauStatus = 3;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Panel login = new Login_Panel();
					Main_Panel main = new Main_Panel(login, 0);
					
					main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
