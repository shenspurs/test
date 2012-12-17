package com.test.socket;

import java.net.*;
import java.io.*;

public class ServerTcpListener implements Runnable {

    public static void main(String[] args) {

        try {
            final ServerSocket server = new ServerSocket(33456);
            Thread th = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            System.out.println("开端监听...");
                            Socket socket = server.accept();
                            System.out.println("有链接");
                            receiveFile(socket);
                        } catch (Exception e) {
                        }
                    }
                }

            });

            th.run(); //启动线程运行
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void receiveFile(Socket socket) {

        byte[] inputByte = null;
        int length = 0;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        try {
            try {

                dis = new DataInputStream(socket.getInputStream());
                fos = new FileOutputStream(new File("d:\\cc.jpg"));
                inputByte = new byte[1024];
                System.out.println("开端接管数据...");
                while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
                    System.out.println(length);
                    fos.write(inputByte, 0, length);
                    fos.flush();
                }
                System.out.println("完成接管");
            } finally {
                if (fos != null)
                    fos.close();
                if (dis != null)
                    dis.close();
                if (socket != null)
                    socket.close();
            }
        } catch (Exception e) {

        }

    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
