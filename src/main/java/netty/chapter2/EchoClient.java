package netty.chapter2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/7.
 */
public class EchoClient {
    /**
     *  需要同时指定host和port来告诉客户端连接哪个服务器
     */
    private String host;
    private int port;
    EchoClient(String host,int port){
        this.host = host;
        this.port = port;
    }
    public void start() throws InterruptedException {
        EventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try{
            // bootstrap 启动客户端时间 group
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(nioEventLoopGroup).channel(NioSocketChannel.class)
                    // 连接接口
                    .remoteAddress(new InetSocketAddress(host,port))
                    // 指定处理消息拦截器
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            // 客户端成功连接服务器后就会执行 ChannelHandler
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            nioEventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) {
        new EchoClient("localhost",20000);
    }
}
