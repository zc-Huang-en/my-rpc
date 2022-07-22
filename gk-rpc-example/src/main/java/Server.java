import com.smgeek.gkrpc.server.RpcServer;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 16:05
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class,new CalcServiceImpl());
        server.start();
    }
}
