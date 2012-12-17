package com.test.socket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTcpSend {

    public static void main(String[] args) {
        int length = 0;
        byte[] sendBytes = null;
        Socket socket = null;
        DataOutputStream dos = null;
        FileInputStream fis = null;
        try {
            try {
                socket = new Socket();
                socket.connect(new InetSocketAddress("127.0.0.1", 33456),
                        10 * 1000);
                dos = new DataOutputStream(socket.getOutputStream());
                File file = new File("D:\\1.jpg");
                fis = new FileInputStream(file);
                sendBytes = new byte[1024];
                while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
                    dos.write(sendBytes, 0, length);
                    dos.flush();
                }
            } finally {
                if (dos != null)
                    dos.close();
                if (fis != null)
                    fis.close();
                if (socket != null)
                    socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}