package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    // 1、网络编程，第一步就要准备好 socket 实例，这是进行网络编程的大前提
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        // 此处在构造服务器这边的 socket 对象的时候就需要显式的绑定一个端口号
        // port 在运行程序的时候来指定即可
        socket = new DatagramSocket(port);
    }

    // 启动服务器
    public void start() throws IOException {
        System.out.println("启动服务器！");
        // UDP 不需要建立连接，直接接收从客户端来的数据即可
        while (true) {
            // 1、读取客户端发来的请求
            //    为了接收数据，需要先准备好一个空的 DatagramPacket 对象，由 receive 进行填充数据
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024); //  把一个字节数组包装了
            //    参数为 "输出型参数"
            socket.receive(requestPacket);
            //    把 DatagramPacket 解析成一个 String
            //    假设此处的 UDP 数据报最长是 1024，这个长度不一定是 1024，实际的数据可能不够 1024
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength(), "UTF-8");

            // 2、根据请求计算响应(由于咱们这是一个回显服务，2省略)
            String response = process(request);

            // 3、把响应写回到客户端
            //    send 方法的参数，也是 DatagramPacket，需要把响应数据先构造成一个 DatagramPacket 再进行发送，这里就不是构造一个空的数据报
            //    这里的参数不再是一个空的字节数组了，response 是刚才根据请求计算得到的响应，非空的 DatagramPacket 里面的数据就是String response的数据
            //    写成 response.length() 表示(字符的个数)。  这里拿到的是字节数组的长度(字节的个数)

            /*如果代码光是这么写，还是不太行，此时就无法区分出，这个数据要交给谁了
            在发送数据的时候，必须要指定，这个数据报发给谁？地址 + 电话
            lP + port
            在当前的场景中，哪个客户端发来的请求，就把数据返回给哪个客户端
            进之后的版本，在 DatagramPacket构造方法中，指定了第三个参数，表示要把数据发给哪个地址 + 端口
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length);*/
            // 改进：
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress()); // SocketAddress 就可以视为是一个类，里面包含了 IP 和端口
            socket.send(responsePacket);
            System.out.printf("[%s : %d] request: %s, response: %s\n",
                    requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    // 由于是回显服务，响应和请求一样
    // 实际上对于一个真实的服务器来说，这个过程是最复杂的，为了实现这个过程，可能需要几万，几十万代码
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
