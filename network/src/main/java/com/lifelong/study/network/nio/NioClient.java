package com.lifelong.study.network.nio;

import com.lifelong.study.network.nio.constant.NioConst;

import java.nio.channels.SocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * Nio 客户端
 *
 * @author: lin
 * @date: 2023/1/17
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        // 创建SocketChannel 并绑定地址和端口
        SocketChannel socketChannel = SocketChannel.open();

        // 设置非阻塞
        socketChannel.configureBlocking(false);

        // 提供 服务端的ip和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress(NioConst.IP, NioConst.PORT);

        // 连接
        socketChannel.connect(inetSocketAddress);

        // 判断连接状态
        while (!socketChannel.finishConnect()) {
        }

        System.out.println("客户端连接成功。。。");

        // 发送数据
        System.out.print("请输入要发送的数据：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            // 退出
            if ("q".equals(nextLine)) {
                scanner.close();
                socketChannel.close();
                System.out.println("客户端退出。。。");
                break;
            }

            System.out.print("请输入要发送的数据：");

            // 发送数据 将Buffer数据写入Channel中
            ByteBuffer byteBuffer = ByteBuffer.wrap(nextLine.getBytes());
            socketChannel.write(byteBuffer);

            // 读取服务端回执消息
            ByteBuffer serverResult = ByteBuffer.allocate(1024);
            socketChannel.read(serverResult);
            String trim = new String(serverResult.array()).trim();
            System.out.println(trim);
        }
    }
}

