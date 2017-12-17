package netty.chapter4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * 阻塞IO , 可以看客户端链接情况
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/17.
 */
public class PlainOioServer {
    public static void server(int port) throws IOException {
        // 绑定端口
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            // 循环监听端口
            while (true){
                // 允许客户端端口链接
                final Socket clientSocket = serverSocket.accept();
                System.out.println("客户端 socket: " + clientSocket);
                // 创建新线程处理clientSocket connection
                new Thread(()->{
                    OutputStream outputStream;
                    try{
                        // 往client发送消息
                        outputStream = clientSocket.getOutputStream();
                        outputStream.write("Hello HWOLF!".getBytes(Charset.forName("UTF-8")));
                        outputStream.flush();
                        // flush 完关闭流
                        clientSocket.close();
                    }catch (IOException e){
                        try{
                            // 异常关闭
                            clientSocket.close();
                        }catch (IOException e1){
                            e1.printStackTrace();
                        }
                    }
                }).start();
            }

        } catch (Exception e){
            e.printStackTrace();
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        server(8080);
    }
}
