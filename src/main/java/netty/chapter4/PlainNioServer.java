package netty.chapter4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * NIO 非阻塞方式(异步)
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/17.
 */
public class PlainNioServer {
    public static void server(int port) throws IOException {
        System.out.println("Listening port: "+port);
        // 打开selector拦截channel
        Selector selector = Selector.open();
        // 打开 ServerSocketChannel
        // The new channel's socket is initially unbound;
        // it must be bound to a specific address via one of its socket's
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // Channel -> Socket
        ServerSocket serverSocket = serverChannel.socket();
        // 绑定 port
        serverSocket.bind(new InetSocketAddress(port));
        // 设置非阻塞模式
        serverChannel.configureBlocking(false);
        // 注册拦截器，当有新链接的时候触发
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        // ByteBuffer
        final ByteBuffer msg = ByteBuffer.wrap("Hello HWOLF".getBytes(Charset.forName("UTF-8")));
        while (true){
            // 当有新事件准备好的时候触发
            // The number of keys, possibly zero whose ready-operation sets were updated
            int n = selector.select();
            if (n > 0){
                // 获取接收事件的所有SelectionKey实例
                // This selector's selected-key set
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    try{
                        // 检查是否是新事件，并且是否准备好链接
                        if (key.isAcceptable()){
                            ServerSocketChannel server = (ServerSocketChannel) key.channel();
                            // client 通信信息
                            SocketChannel client = server.accept();
                            System.out.println("允许客户端链接 : "+ client);
                            // 客户端也是异步
                            client.configureBlocking(false);
                            // 客户端注册到selector, 动作为：允许写消息
                            client.register(selector,SelectionKey.OP_WRITE,msg);
                        }
                        // 是否允许写数据
                        if (key.isWritable()){
                            SocketChannel client = (SocketChannel) key.channel();
                            // 检索存在的消息
                            ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                            // 检查buffer是否里面还有
                            while(byteBuffer.hasRemaining()){
                                if (client.write(byteBuffer)==0){
                                    break;
                                }
                            }
                            client.close();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        key.cancel();
                        key.channel().close();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        server(8080);
    }
}
