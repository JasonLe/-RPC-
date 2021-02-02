package com.wanghanle.myrpc.Version3.client;

import com.wanghanle.myrpc.Version3.core.JsonSerializer;
import com.wanghanle.myrpc.Version3.core.MyDecode;
import com.wanghanle.myrpc.Version3.core.MyEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 16:50
 * 同样的与服务端解码和编码格式
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
//        ChannelPipeline pipeline = ch.pipeline();
//        // 消息格式 [长度][消息体]
//        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
//        // 计算当前待大宋消息的长度，写入到前4个字节中
//        pipeline.addLast(new LengthFieldPrepender(4));
//        pipeline.addLast(new ObjectEncoder());
//
//        pipeline.addLast(new ObjectDecoder(new ClassResolver() {
//            @Override
//            public Class<?> resolve(String className) throws ClassNotFoundException {
//                return Class.forName(className);
//            }
//        }));
//
//        pipeline.addLast(new NettyClientHandler());
        ChannelPipeline pipeline = ch.pipeline();
        // 使用自定义的编解码器
        pipeline.addLast(new MyDecode());
        // 编码需要传入序列化器，这里是json，还支持ObjectSerializer，也可以自己实现其他的
        pipeline.addLast(new MyEncode(new JsonSerializer()));
        pipeline.addLast(new NettyClientHandler());
    }
}
