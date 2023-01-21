package com.lifelong.study.network.jdk.nio;

import com.lifelong.study.network.jdk.nio.constant.NioConst;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Nio 客户端
 *
 * @author: lin
 * @date: 2023/1/17
 */
public class NioClient {

    //客户端信道选择器,轮询读取服务端返回数据
    private Selector selector;

    //连接信道
    private SocketChannel socketChannel;


    public static void main(String[] args) throws IOException {
        NioClient client = new NioClient();
        client.init();

        new Thread(() -> client.listenResponse()).start();

        client.getInput();

    }


    private void init() throws IOException {
        //打开信道
        this.socketChannel = SocketChannel.open();
        //连接服务端
        socketChannel.connect(new InetSocketAddress(NioConst.IP, NioConst.PORT));
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //必须打开
        selector = Selector.open();
        //将当前客户端注册到多路复用器上,并设置为可读状态
        socketChannel.register(this.selector, SelectionKey.OP_READ);
    }

    private void listenResponse() {
        //一直循环
        while (true) {
            try {
                //多路复用器开始监听
                this.selector.select();
                //获取已经注册在多了复用器上的key通道集
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                //遍历
                while (keys.hasNext()) {
                    //获取key
                    SelectionKey key = keys.next();
                    //如果是有效的
                    if (key.isValid()) {
                        // 如果为可读状态,读取服务端返回的数据
                        if (key.isReadable()) {
                            this.readResponse(key);
                        }
                    }
                    //从容器中移除处理过的key
                    keys.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getInput() throws IOException {
        // 发送数据
        System.out.println("请输入要发送的数据：");
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

        }

    }


    /**
     * 获取服务器相应数据
     */
    private void readResponse(SelectionKey key) {
        try {
            //建立写缓冲区
            ByteBuffer readBuf = ByteBuffer.allocate(1024);
            //2 获取之前注册的socket通道对象
            SocketChannel sc = (SocketChannel) key.channel();
            //3 读取数据
            int count = sc.read(readBuf);
            //4 如果没有数据
            if (count == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            //5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
            readBuf.flip();
            //6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
            byte[] bytes = new byte[readBuf.remaining()];
            //7 接收缓冲区数据
            readBuf.get(bytes);
            //8 打印结果
            String body = new String(bytes).trim();
            System.out.println("\n客户端已接受到服务端返回的数据: " + body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

