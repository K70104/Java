package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer {
    public HashMap<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);
        // 简单构造几个词
        dict.put("cat", "猫");
        dict.put("dog", "狗");
        dict.put("pig", "猪");
    }

    @Override
    public String process(String request) {
        // UdpEchoServer 中的 process 改成 public
        return dict.getOrDefault(request, "该词无法被翻译！");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
