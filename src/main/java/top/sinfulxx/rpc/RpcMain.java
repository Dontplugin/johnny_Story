package top.sinfulxx.rpc;

/**
 * 示例: RPC客户端调用服务中, 本地jdk动态代理+责任链调用远程服务
 *
 * @author hanyuzhe
 * @date 2020/2/23 12:17 上午
 * @since 1.0
 */
public class RpcMain {

    public static void main(String[] args) {
        LuConsumer<TargetService> luConsumer = new LuConsumer<TargetService>();
        TargetService ref = luConsumer.ref();
        System.out.println(ref.hello());
    }
}
