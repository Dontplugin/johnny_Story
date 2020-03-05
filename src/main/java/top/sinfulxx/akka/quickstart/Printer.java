package top.sinfulxx.akka.quickstart;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import top.sinfulxx.akka.quickstart.entity.Greeting;

public class Printer extends AbstractActor {
    static public Props props() {
        return Props.create(Printer.class, () -> new Printer());
    }

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public Printer() {
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Greeting.class, greeting -> log.info(greeting.message))
                .build();
    }
}