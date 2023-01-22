package com.lifelong.study.network.jdk.nio;

/**
 * Nio Server
 *
 * @author: lin
 * @date: 2023/1/15
 */
import com.lifelong.study.network.constant.NioConst;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author liang
 * @date 2020/12/3
 */
public class NioServer {

    private Selector selector;

    public static void main(String[] args) throws Exception {
        NioServer server = new NioServer();
        server.init();
        server.start();
    }

    public void init() throws IOException {
        // 创建一个选择器
        this.selector = Selector.open();
        // 使用通道计划，服务器
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 这个通道非常高效，所以要非阻塞
        channel.configureBlocking(false);
        ServerSocket serverSocket = channel.socket();
        InetSocketAddress address = new InetSocketAddress(NioConst.PORT);
        serverSocket.bind(address);
        System.out.println("NIO抢票神器已经成功启动，端口" + address.getPort());
        // 注册事件
        channel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void start() throws IOException {
        // 24小时营业，无限循环
        while (true) {
            // 选择器运行
            this.selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            // 抢票软件对每一个用户负责，帮大家处理事情
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 移除，防止重复操作
                iterator.remove();
                // 这个是填写抢票的请求
                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    // 这个是抢票的操作--狂差12306
                    read(key);
                }
            }
        }

    }

    private void accept(SelectionKey key) throws IOException {
        // 事件传过来的key
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        // 转成客户端的通道
        SocketChannel channel = server.accept();
        // 设置成非阻塞
        channel.configureBlocking(false);
        // 注册一个读事件，用作去12306抢票
        // 注册事件
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    /**
     * 12306的抢票事件
     */
    private void read(SelectionKey key) throws IOException {
        // 创建一个缓冲区，大家一起上咯，效率高
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel channel = (SocketChannel) key.channel();
        // 在通道中读取大家的请求
        channel.read(buffer);
        // trim方法用于删除字符串两边的空格字符串
        String request = new String(buffer.array()).trim();
        System.out.println("抢票客户的请求" + request);
        String outString = String.format("数据【%s】请求成功 时间：%s！！！", request, new Date());
        ByteBuffer outBuffer = ByteBuffer.wrap(outString.getBytes());
        // 把我们的数据返回给通道（抢到票了）
        channel.write(outBuffer);

//        channel.close();
    }
}
