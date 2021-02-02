package com.wanghanle.myrpc.Version3.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wanghanle.myrpc.Version3.pojo.RPCRequest;
import com.wanghanle.myrpc.Version3.pojo.RPCResponse;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 23:56
 */
public class JsonSerializer implements Serializer{
    @Override
    public byte[] serialize(Object obj) {
        byte[] bytes = JSONObject.toJSONBytes(obj);
        return bytes;
    }

    @Override
    public Object deserialize(byte[] bytes, int messageType) {
        Object obj = null;
        // 传输的消息分为request与response
        switch (messageType){
            case 0:
                RPCRequest request = JSON.parseObject(bytes, RPCRequest.class);
                Object[] objects = new Object[request.getParams().length];
                // 把json字串转化成对应的对象， fastjson可以读出基本数据类型，不用转化
                for(int i = 0; i < objects.length; i++){
                    Class<?> paramsType = request.getParamsTypes()[i];
                    if (!paramsType.isAssignableFrom(request.getParams()[i].getClass())){
                        objects[i] = JSONObject.toJavaObject((JSONObject) request.getParams()[i],request.getParamsTypes()[i]);
                    }else{
                        objects[i] = request.getParams()[i];
                    }

                }
                request.setParams(objects);
                obj = request;
                break;
            case 1:
                RPCResponse response = JSON.parseObject(bytes, RPCResponse.class);
                Class<?> dataType = response.getDataType();
                if(! dataType.isAssignableFrom(response.getData().getClass())){
                    response.setData(JSONObject.toJavaObject((JSONObject) response.getData(),dataType));
                }
                obj = response;
                break;
            default:
                System.out.println("暂时不支持此种消息");
                throw new RuntimeException();
        }
        return obj;
    }

    // 1 代表着json序列化方式
    @Override
    public int getType() {
        return 1;
    }
}
