package netty.chapter4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * 异步模式
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/17.
 */
public class NettyNioServer {
    public static void server(int port) {
        final ByteBuf byteBuf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hello HWOLF!", CharsetUtil.UTF_8));
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 异步模式 NioServerSocketChannel
            ServerBootstrap serverBootstrap1 = serverBootstrap.group(eventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            // 绑定一个"入站"的 ChannelHandler
                            channel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    // 如果是active 链接，写消息到client, 一旦写完关闭
                                    ctx.writeAndFlush(byteBuf).addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                        }
                    });
            ChannelFuture future = serverBootstrap.bind().sync();
            System.out.println(future.getClass());
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        server(55555);
    }
}
