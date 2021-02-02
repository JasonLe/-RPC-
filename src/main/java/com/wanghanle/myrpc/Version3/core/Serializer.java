package com.wanghanle.myrpc.Version3.core;
/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 23:41
 */
public interface Serializer {
    // 把对象序列化成字节数组
    byte[] serialize(Object object);

    // 从字节数组反序列化成消息, 使用java自带序列化方式不用messageType也能得到相应的对象（序列化字节数组里包含类信息）
    // 其它方式需指定消息格式，再根据message转化成相应的对象
    Object deserialize(byte[] bytes, int messageType);

    // 返回使用的序列器
    // 0：Java自带的 1：json序列化方式
    int getType();

    // 根据序号取出序列器，暂时有两种实现方式
    static Serializer getSerializerByCode(int code){
        switch (code){
            case 0:
                return new ObjectSerializer();
            case 1:
                return new JsonSerializer();
            default:
                return null;
        }
    }
}
