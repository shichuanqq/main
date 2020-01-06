package com.example.service.nio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
@Service
public class NioService {


    /**
     * nio 复制文件 todo 待测试
     * @param resource
     * @param destination
     * @throws Exception
     */
    public static void nioCopyFile(String resource, String destination) throws Exception {
        FileInputStream fi = new FileInputStream(resource);
        FileOutputStream fo = new FileOutputStream(destination);
        FileChannel readChannel = fi.getChannel();
        FileChannel foChannel = fo.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            byteBuffer.clear();

            int read = readChannel.read(byteBuffer);
            if(read == -1){
                //读取完毕
                break;
            }
            byteBuffer.flip();
            foChannel.write(byteBuffer);
            //写入文件
        }
        readChannel.close();
        foChannel.close();
    }

}
