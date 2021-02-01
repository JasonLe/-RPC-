package com.wanghanle.myrpc.core;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/1 18:35
 * 这个实现类代表着java原始的BIO监听模式，来一个任务，就new一个线程去处理
 * 处理任务的工作见WorkThread中
 */
public class SimpleRPCServer implements RPCServer{
//    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
//
//        try {
//            ServerSocket serverSocket = new ServerSocket(8888);
//            System.out.println("服务端启动了！");
//            // BIO的方式监听Socket
//            while (true){
//                Socket socket = serverSocket.accept();
//                // 开启一个线程去处理
//                new Thread(()->{
//                    try {
//                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//
//                        // 读取客户端传过来的request
//                        RPCRequest rpcRequest = (RPCRequest) objectInputStream.readObject();
//
//                        // 通过反射调用方法
//                        Method method = userService.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamsTypes());
//                        Object invoke = method.invoke(userService, rpcRequest.getParams());
//
//                        // 封装，写入response对象
//                        objectOutputStream.writeObject(RPCResponse.success(invoke));
//                        objectOutputStream.flush();
//
//                    } catch (IOException | ClassNotFoundException |
//                            NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                        e.printStackTrace();
//                        System.out.println("从IO中读取数据错误");
//                    }
//                }).start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("服务器启动失败");
//        }
//    }

    // 存着服务接口名-> service对象的map
    private ServiceProvider serviceProvide;

    public SimpleRPCServer(ServiceProvider serviceProvide){
        this.serviceProvide = serviceProvide;
    }

    @Override
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了！");
            // BIO的方式监听Socket
            while (true){
                Socket socket = serverSocket.accept();
                // 就新建一个线程去处理
                new Thread(new WorkThread(socket,serviceProvide)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }

    @Override
    public void stop() {

    }
}
