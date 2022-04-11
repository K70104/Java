package network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    // 用普通的 socket 即可，不用 ServerSocket 了
    private Socket socket = null;

    public TcpEchoClient(String serverIP, int serverPort) throws IOException {
        // 这里可以给端口号，但还这里给了之后，含义是不同的
        // 传入的 IP 和 端口号 的含义表示的不是自己绑定，而是服务器的，表示和这个 IP 端口 建立连接！
        // 调用这个构造方法，就是和服务器建立连接 (打电话拨号了)
        socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        System.out.println("和服务器连接成功");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                while (true) {
                    // 仍是四个步骤
                    // 1、先从控制台读取用户输入的字符串
                    System.out.print("-> ");
                    String request = scanner.next();

                    // 2、把这个用户输入的内容，构造成一个请求，并发送
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush(); //  刷新，如果没有这个刷新，可能客户端就不能第一时间看到响应结果

                    // 3、从服务器读取响应数据，并解析
                    Scanner respScanner = new Scanner(inputStream);
                    String response = respScanner.next();

                    // 4、把响应结果显示到控制台上
                    System.out.printf("req : %s, resp : %s\n", request, response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client =  new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}