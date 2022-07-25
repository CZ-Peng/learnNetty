package com.czp.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: Bio模型，使用cmd telnet 127.0.0.1 6666  Ctrl+] send hello 发送信息
 * @author: chenzhipeng@anji-leasing.cn
 * @date: 2022/07/18
 */
public class BioServer {

    public static void main(String []args) throws IOException {
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建socket连接
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了");

        while (true) {
            System.out.println("等待连接......");
            // 监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executor.execute(() -> handler(socket));
        }
    }

    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];

        try(InputStream inputStream = socket.getInputStream();) {
            System.out.println("线程id：" + Thread.currentThread().getId() +
                    ", 线程name: " + Thread.currentThread().getName());
            while (true) {
                System.out.println("线程id：" + Thread.currentThread().getId() +
                        ", 线程name: " + Thread.currentThread().getName());

                System.out.println("read.......");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println("输出客户端发送的数据：" + new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
