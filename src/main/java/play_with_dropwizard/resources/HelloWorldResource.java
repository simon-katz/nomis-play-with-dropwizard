package play_with_dropwizard.resources;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import play_with_dropwizard.core.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private final String template;
    private final String defaultName;

    // Note that "we recommend that resources be stateless/immutable".
    // -- so they should put this in the core/domain model part of the app.
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    // The method name can be anything. Interesting. And why is it not greyed out in IDEA?
    public Saying thisNameCanBeAnything(@QueryParam("name") Optional<String> name) {
        return new Saying(counter.incrementAndGet(),
                String.format(template, name.or(defaultName)));
    }
}
