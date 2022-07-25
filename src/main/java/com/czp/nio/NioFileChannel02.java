package com.czp.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: chenzhipeng@anji-leasing.cn
 * @date: 2022/07/18
 */
public class NioFileChannel02 {

    public static void main(String []args) throws IOException {
        // 创建文件输入流
        File file = new File("C:\\Users\\anji\\Desktop\\netty.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取channel
        FileChannel channel = fileInputStream.getChannel();
        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        // 将channel中的数据读出到buffer中
        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();
    }
}
