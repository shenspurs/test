package com.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Myclient {
	public static final String IP = "10.3.34.118";
	public static final int port = 8962;
	private Socket s;

	public Myclient() throws IOException {
		try {
			s = new Socket(IP, port);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void setConnection() throws IOException {

		InputStream is;

		try {
			is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			System.out.println(br.readLine());

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String args[]) throws IOException {

		Myclient mc = new Myclient();
		mc.setConnection();

	}
}
