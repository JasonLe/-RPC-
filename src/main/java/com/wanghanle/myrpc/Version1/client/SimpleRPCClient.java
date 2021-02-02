package com.wanghanle.myrpc.Version1.client;

import com.wanghanle.myrpc.Version1.pojo.RPCRequest;
import com.wanghanle.myrpc.Version1.pojo.RPCResponse;
import com.wanghanle.myrpc.Version1.service.RPCClient;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 14:46
 * 使用 BIO 方式
 */
@AllArgsConstructor
public class SimpleRPCClient implements RPCClient {

    private String host;
    private int port;

    @Override
    public RPCResponse sendRequest(RPCRequest request) {
        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            System.out.println(request);

            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            RPCResponse response = (RPCResponse) objectInputStream.readObject();
            return response;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("SimpleRPCClient连接失败!");
            return null;
        }
    }
}
