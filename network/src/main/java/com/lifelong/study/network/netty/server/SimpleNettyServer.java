package com.lifelong.study.network.netty.server;

import com.lifelong.study.network.constant.NioConst;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * netty 服务端
 *
 * @author: lin
 * @date: 2023/1/21
 */
public class SimpleNettyServer {

    public static void main(String[] args) throws InterruptedException {
        new SimpleNettyServer().start();
    }

    public void start() throws InterruptedException {
        // 线程组
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // 启动必备
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(NioConst.PORT))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new SimpleNettyServerHandler());
                        }
                    });

            // 异步绑定到服务器 ，sync阻塞到完成
            ChannelFuture future = bootstrap.bind().sync();
            // 阻塞当前线程直到ServerChannel被关闭
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }


    }
}
