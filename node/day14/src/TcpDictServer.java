
import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpThreadEchoServer {
    private HashMap<String, String> dict = new HashMap<>();

    public TcpDictServer(int port) throws IOException {
        super(port);

        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("pig", "小猪");
        dict.put("fuck", "卧槽");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "当前的词无法翻译");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}
