package com.czp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @description:
 * @author: chenzhipeng@anji-leasing.cn
 * @date: 2022/07/25
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        // 得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置非阻塞
        socketChannel.configureBlocking(false);
        // 设置服务器端 ip和端口
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
        // 连接服务器
        if (!socketChannel.connect(address)) {
            // 如果没完成连接
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他工作..");
            }
        }

        // 连接成功，发送数据
        String str = "hello netty czp";
        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        //发送数据，将buffer写入channel
        socketChannel.write(byteBuffer);
        System.in.read();
    }
}
