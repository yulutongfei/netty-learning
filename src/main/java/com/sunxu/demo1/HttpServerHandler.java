package com.sunxu.demo1;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/1/19 07:22
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        String content = String.format("Receive http request, uri: %s, method: %s, content: %s%n", msg.uri(), msg.method(), msg.content().toString(CharsetUtil.UTF_8));
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK, Unpooled.wrappedBuffer(content.getBytes()));
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
