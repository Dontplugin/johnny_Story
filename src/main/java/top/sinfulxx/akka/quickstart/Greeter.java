package top.sinfulxx.akka.quickstart;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import top.sinfulxx.akka.quickstart.entity.Greet;
import top.sinfulxx.akka.quickstart.entity.Greeting;
import top.sinfulxx.akka.quickstart.entity.WhoToGreet;

public class Greeter extends AbstractActor {
    static public Props props(String message, ActorRef printerActor) {
        return Props.create(Greeter.class, () -> new Greeter(message, printerActor));
    }

    private final String message;
    private final ActorRef printerActor;
    private String greeting = "";

    public Greeter(String message, ActorRef printerActor) {
        this.message = message;
        this.printerActor = printerActor;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(WhoToGreet.class, wtg -> this.greeting = message + ", " + wtg.who)
                .match(Greet.class, x -> printerActor.tell(new Greeting(greeting), getSelf()))
                .build();
    }
}