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
        serverIP = ip;
        serverPort = port;
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("-> ");
            String request = scanner.next();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIP), serverPort);
            socket.send(requestPacket);
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "UTF-8");
            System.out.printf("request: %s, response: %s\n", request, response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}