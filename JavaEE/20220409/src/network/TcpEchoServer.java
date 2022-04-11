package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
    // listen 英文原意：监听。但是 Java socket 中体现出 "监听" 的含义，
    // 这样叫是因为，操作系统原生的 API 中，有一个操作叫做 listen
    // private ServerSocket listenSocket = null;
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动了！");
        while (true) {
            // 1、建立连接
            // 由于 TCP 是有连接的，不能一上来就读数据，需要先建立连接 (接电话)
            // accept 就是在接电话，接电话的前提是，有人给你打，如果当前客户端尝试建立连接，此处的 accept 就会阻塞
            // accept 返回了一个 socket 对象，称为 clientSocket，后续和客户端之间的沟通，都是都过 clientSocket 来完成的
            Socket clientSocket  = serverSocket.accept();

            // 2、处理连接
            // 这里之所分成了两步 就是因为要建立连接 一个专门负责建立连接 一个专门负责数据通信
            processConnection(clientSocket);
        }
    }

    // 处理连接
    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s : %d] 客户端建立连接！\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        // 接下来处理请求和响应
        try (InputStream inputStream = clientSocket.getInputStream()) {
            try (OutputStream outputStream = clientSocket.getOutputStream()) {
                // 把 inputStream 中的数据读出来，写入到 outputStream 中
                // 循环地处理每个请求，分别返回响应
                Scanner scanner = new Scanner(inputStream);
                while (true) {
                    // 1、读取请求
                    if (!scanner.hasNext()) {
                        System.out.printf("[%s : %d] 客户端断开连接！\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
                        break;
                    }
                    String request = scanner.next(); // 此处用 Scanner 更方便，如果用 InputStream 的 read 也可以

                    // 2、根据请求，计算响应
                    String response = process(request);

                    // 3、将这个响应返回客户端
                    //    方便起见，用 PrintWriter 把 OutputStream 包裹一下
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    //  刷新，如果没有这个刷新，可能客户端就不能第一时间看到响应结果
                    printWriter.flush();

                    System.out.printf("[%s : %d] req : %s, resp: %s！\n", clientSocket.getInetAddress().toString(),
                            clientSocket.getPort(), request, response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 记得关闭！
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}