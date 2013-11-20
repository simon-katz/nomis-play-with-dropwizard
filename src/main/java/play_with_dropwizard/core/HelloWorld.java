package play_with_dropwizard.core;

import java.util.concurrent.atomic.AtomicLong;

public class HelloWorld {

    private static AtomicLong counter = new AtomicLong();

    private final long id;
    private final String content;

    public HelloWorld(String content) {
        this.id = counter.incrementAndGet();
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getP1() {
        return "P1 -- JSON-ified";
    }
    public String p2() {
        return "P2 -- not JSON-ified";
    }
}
