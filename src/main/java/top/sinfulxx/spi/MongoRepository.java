package top.sinfulxx.spi;

/**
 * @author hanyuzhe
 * @date 2020/2/22 8:51 下午
 * @since 1.0
 */
public class MongoRepository implements IRepository {

    @Override
    public void save(String data) {
        System.out.println("Save " + data + " to Mongo");
    }
}
