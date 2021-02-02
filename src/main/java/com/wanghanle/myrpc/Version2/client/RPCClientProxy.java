package com.wanghanle.myrpc.Version2.client;

import com.wanghanle.myrpc.Version2.pojo.RPCRequest;
import com.wanghanle.myrpc.Version2.pojo.RPCResponse;
import com.wanghanle.myrpc.Version2.service.RPCClient;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 14:58
 */
@AllArgsConstructor
public class RPCClientProxy implements InvocationHandler {

    private RPCClient rpcClient;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // request的构建，使用了lombok中的builder，代码简洁
        RPCRequest request = RPCRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramsTypes(method.getParameterTypes()).build();
        // 数据传输
        RPCResponse response = rpcClient.sendRequest(request);
        System.out.println(response.getData());
        return response.getData();
    }

    <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }
}
