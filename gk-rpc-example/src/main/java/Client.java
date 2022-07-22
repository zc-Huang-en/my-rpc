import com.smgeek.gkrpc.client.RpcClient;

/**
 * @author : hzc
 * @date: 2022/7/15 - 07 - 15 - 16:05
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int n1 = service.add(1,2);
        int n2 = service.minus(10,8);
        System.out.println(n1+"  "+n2);
    }
}
