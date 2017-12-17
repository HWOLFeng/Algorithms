package netty.chapter4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.oio.OioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;


/**
 * Netty 阻塞 IO
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/17.
 */
public class NettyOioServer {
    public static void server(int port){
        // 字节流
        final ByteBuf byteBuf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hello HWOLF", CharsetUtil.UTF_8));
        // EventLoopGroup
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        // Bootstrap 启动
        try{
            // 引导服务器配置
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 启动阻塞模式 OioServerSocketChannel
            serverBootstrap.group(eventLoopGroup)
                    .channel(OioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress("localhost",port))
                    // 指定ChannelHandler
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            // 绑定一个"入站"的 ChannelHandler
                            channel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    // 如果是active 链接，写消息到client, 一旦写完关闭
                                    ctx.writeAndFlush(byteBuf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                        }
                    });
            // 绑定服务器接受链接 TODO
            ChannelFuture future = serverBootstrap.bind().sync();
            // 关闭
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
            // 释放资源
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        server(8080);
    }
}
