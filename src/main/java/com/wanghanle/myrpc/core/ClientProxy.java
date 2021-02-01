package com.wanghanle.myrpc.core;

import com.wanghanle.myrpc.pojo.RPCRequest;
import com.wanghanle.myrpc.pojo.RPCResponse;
import javafx.util.converter.ShortStringConverter;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 21:11
 */
@AllArgsConstructor
public class ClientProxy implements InvocationHandler {

    // 传入参数Service接口的class对象，反射封装成一个request
    private String host;
    private int port;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // request的构建，使用了lombok中的builder，代码简洁
        RPCRequest request = RPCRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramsTypes(method.getParameterTypes()).build();
        // 数据传输
        RPCResponse response = IOClient.sendRequest(host, port, request);

        return response.getData();
    }

    <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }
}
