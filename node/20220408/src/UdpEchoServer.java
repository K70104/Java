import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("启动服务器！");
        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength(), "UTF-8");
            String response = process(request);
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            System.out.printf("[%s : %d] request: %s, response: %s\n",
                    requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
