package com.czp.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: chenzhipeng@anji-leasing.cn
 * @date: 2022/07/18
 */
public class NioFileChannel01 {

    public static void main(String []args) throws IOException {

        // 数据写入buffer，channel在写入buffer的数据，输出至文件
        String str = "netty hello";
        // 创建一个输出流 -> channel
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\anji\\Desktop\\netty.txt");
        // 获取channel
        FileChannel fileChannel = fileOutputStream.getChannel();
        // 创建缓冲区 buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 将str写入buffer
        byteBuffer.put(str.getBytes());
        // 反转buffer
        byteBuffer.flip();
        // 将buffer的数据写入channel
        fileChannel.write(byteBuffer);

        fileOutputStream.close();
    }
}
