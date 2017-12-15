package netty.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/7.
 */
public class EchoServer {
    private int port;
    EchoServer(int port){
        this.port = port;
    }
    public void start() throws InterruptedException {
        // 指定 NioEventLoopGroup 来处理链接
        EventLoopGroup eventLoop = new NioEventLoopGroup();
        try{
            // serverBootstrap 对象启动服务器
            ServerBootstrap sb = new ServerBootstrap();
            // 设置事件循环，线程模式，端口
            // 指定通道类型为NioServerSocketChannel
            sb.group(eventLoop).channel(NioServerSocketChannel.class).localAddress(port)
                    // 这个方法传ChannelInitializer类型的参数
                    .childHandler(new ChannelInitializer<Channel>() {
                        // 指定连接后调用的ChannelHandler
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            // 绑定服务器等待直到绑定完成
            ChannelFuture future = sb.bind().sync();
            //
            System.out.println(EchoServer.class.getName() + " start and listen"+ future.channel().localAddress());
            // 等待通道关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭EventLoopGroup和释放所有资源，包括创建的线程
            eventLoop.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoServer(65535).start();
    }
}
