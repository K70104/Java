package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;

    private String serverIP;
    private int serverPort;

    public UdpEchoClient(String ip, int port) throws SocketException {
        socket = new DatagramSocket();
        this.serverIP = ip;
        this.serverPort = port;
        // 此处的 port 是服务器的端口，客户端启动的时候，不需要给 socket 指定端口，客户端自己的端口是系统随机分配的
    }

    // 在客户端构造 socket 对象的时候，就不再手动指定端口号，使用无参版本的构造方法
    /*public UdpEchoClient() throws SocketException {
        socket = new DatagramSocket();
    }*/

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1、先从控制台读取用户输入的字符串
            System.out.print("-> ");
            String request = scanner.next();

            // 2、把这个用户输入的内容，构造成一个 UDP 请求，并发送
            //    构造的请求里包含两部分信息
            //    1) 数据的内容：request 字符串
            //    2) 数据要发给谁：服务器的 IP + 端口号
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIP), serverPort);
            socket.send(requestPacket);

            // 3、从服务器读取响应数据，并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "UTF-8");

            // 4、把响应结果显示到控制台上
            System.out.printf("request: %s, response: %s\n", request, response);
        }
    }

    public static void main(String[] args) throws IOException {
        // 由于客户端和服务器在同一个机器上，使用的 IP 仍是 127.0.0.1，如果是不同的机器，就要修改这里的 IP
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}