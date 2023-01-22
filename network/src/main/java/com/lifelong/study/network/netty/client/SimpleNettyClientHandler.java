package com.lifelong.study.network.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author: lin
 * @date: 2023/1/21
 */
public class SimpleNettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * 这个会主动释放内存，避免内存泄漏，如果是channelRead一定要注意释放和投递
     * @param channelHandlerContext
     * @param byteBuf
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        System.out.println("SimpleClientHandler.channelRead");
        byte[] result1 = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(result1);
        System.out.println("Server said:" + new String(result1));
    }

    /**
     * 本方法用于处理异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 本方法用于向服务端发送信息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String msg = "hello Server!";
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
        encoded.writeBytes(msg.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

}
