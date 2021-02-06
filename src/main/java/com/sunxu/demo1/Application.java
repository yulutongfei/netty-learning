package com.sunxu.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;

/**
 * @author 孙许
 * @version 1.0
 * @date 2021/1/19 07:08
 */
public class Application {

    public static void main(String[] args) throws Exception {
        new Application().startServer(8080);
    }

    public void startServer(int port) throws Exception {
        // 1.配置线程池
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker);

            // 2.channel初始化
            bootstrap.channel(NioServerSocketChannel.class);
            // 设置handler
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    channel.pipeline()
                            .addLast("codec", new HttpServerCodec())
                            .addLast("compressor", new HttpContentCompressor())
                            .addLast("aggregator", new HttpObjectAggregator(65536))
                            .addLast("handler", new HttpServerHandler());
                }
            });
            // 设置网络参数
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

            // 3.端口绑定
            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            worker.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
}
