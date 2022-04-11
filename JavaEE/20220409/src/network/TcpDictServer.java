package network;

import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpThreadPoolEchoServer {
    private HashMap<String, String> dict = new HashMap<>();

    public TcpDictServer(int port) throws IOException {
        super(port);

        dict.put("cat", "猫");
        dict.put("dog", "狗");
        dict.put("pig", "猪");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "该词无法被翻译！");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}
