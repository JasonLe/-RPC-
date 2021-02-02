package com.wanghanle.myrpc.Version3.core;

import com.wanghanle.myrpc.Version3.pojo.RPCRequest;
import com.wanghanle.myrpc.Version3.pojo.RPCResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.AllArgsConstructor;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 23:48
 */
@AllArgsConstructor
public class MyEncode extends MessageToByteEncoder {

    private Serializer serializer;

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object msg, ByteBuf out) throws Exception {
        System.out.println(msg.getClass());
        // 写入消息类型
        if(msg instanceof RPCRequest){
            out.writeShort(MessageType.REQUEST.getCode());
        }
        else if(msg instanceof RPCResponse){
            out.writeShort(MessageType.RESPONSE.getCode());
        }
        // 写入序列化方式
        out.writeShort(serializer.getType());
        // 得到序列化数组
        byte[] serialize = serializer.serialize(msg);
        // 写入长度
        out.writeInt(serialize.length);
        // 写入序列化字节数组
        out.writeBytes(serialize);
    }
}
