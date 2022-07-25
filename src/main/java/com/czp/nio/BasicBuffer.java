package com.czp.nio;

import java.nio.IntBuffer;

/**
 * @description: nio中buffer
 * @author: chenzhipeng@anji-leasing.cn
 * @date: 2022/07/18
 */
public class BasicBuffer {

    public static void main(String []agrs) {
        //创建一个buffer，容量为5
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // 向buffer中存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // 从buffer中取数
        // 将buffer转换，todo 读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
