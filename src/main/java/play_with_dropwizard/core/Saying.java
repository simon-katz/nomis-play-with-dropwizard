package play_with_dropwizard.core;

public class Saying {

    private final long id;
    private final String content;

    public Saying(long id, String content) {
        this.id = id;
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
