//package com.sunxu.writeandflush;
//
///**
// * @author 孙许
// * @version 1.0
// * @date 2021/1/26 22:27
// */
//public class DataServerInitializer extends ChannelInitializer<Channel> {
//
//    private static final DataServerHandler SHARED = new DataServerHandler();
//
//    @Override
//    public void initChannel(Channel channel) {
//        channel.pipeline().addLast("handler", SHARED);
//
//        ByteBuf buffer = ...;
//        for (int i = 0; i < buffer.capacity(); i ++) {
//            byte b = buffer.getByte(i);
//            System.out.println((char) b);
//        }
//    }
//}
