package top.sinfulxx.stateMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * @author hanyuzhe
 * @date 2020/4/6 11:40 下午
 * @since 1.0
 */
@SpringBootApplication
public class Application /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//
//    @Autowired
//    private StateMachine<OrderStatus, Events> stateMachine;
//
//    @Override
//    public void run(String... args) throws Exception {
//        stateMachine.start();
//        stateMachine.sendEvent(Events.PAY);
//        stateMachine.sendEvent(Events.RECEIVE);
//    }

}