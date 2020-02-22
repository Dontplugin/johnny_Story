package top.sinfulxx.rpc;

/**
 * @author hanyuzhe
 * @date 2020/2/22 10:57 下午
 * @since 1.0
 */
public class TargetImpl implements TargetService {

    @Override
    public String hello() {
        return "ok";
    }
}
