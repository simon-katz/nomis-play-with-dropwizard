package play_with_dropwizard.resources;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import play_with_dropwizard.core.HelloWorld;
import play_with_dropwizard.core.Person;
import play_with_dropwizard.views.HelloWorldView;
import play_with_dropwizard.views.PersonView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world-as-html")
@Produces(MediaType.TEXT_HTML)
public class HelloWorldAsHtmlResource {

    private final String template;
    private final String defaultName;

    // Note that "we recommend that resources be stateless/immutable".
    // -- so they should put this in the core/domain model part of the app.
    private final AtomicLong counter;

    public HelloWorldAsHtmlResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public HelloWorldView getHelloWorldViewPlop(@QueryParam("name") Optional<String> name) {
        HelloWorld helloWorld = new HelloWorld(counter.incrementAndGet(),
                String.format(template, name.or(defaultName)));
        return new HelloWorldView(helloWorld);
    }
}
