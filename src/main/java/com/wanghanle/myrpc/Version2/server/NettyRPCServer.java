package com.wanghanle.myrpc.Version2.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.AllArgsConstructor;

/**
 * @author WangHanle
 * @version 1.0
 * @date 2021/2/2 16:27
 * Netty服务端的实现
 */
@AllArgsConstructor
public class NettyRPCServer implements RPCServer{

    private ServiceProvider serviceProvider;

    @Override
    public void start(int port) {
        try {
            // netty 服务线程组boss负责建立连接， work负责具体的请求
            NioEventLoopGroup bossGroup = new NioEventLoopGroup();
            NioEventLoopGroup workGroup = new NioEventLoopGroup();
            System.out.println("Netty服务端启动了...");

            // 创建服务端启动引导/辅助类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 初始化
            serverBootstrap.group(bossGroup, workGroup)
                    // 指定 IO 模型
                    .channel(NioServerSocketChannel.class)
                    // 自定义客户端消息的业务处理逻辑
                    .childHandler(new NettyServerInitializer(serviceProvider));
            // 绑定端口,调用 sync 方法阻塞直到绑定完成（bind本身是异步的，调用sync将它变成同步）
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            // 阻塞等待直到服务器Channel关闭
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }
}
