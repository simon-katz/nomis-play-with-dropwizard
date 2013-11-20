package play_with_dropwizard.resources;

import com.yammer.metrics.annotation.Timed;
import play_with_dropwizard.core.Person;
import play_with_dropwizard.views.PersonView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person/{firstName}")
@Produces(MediaType.TEXT_HTML)
public class PersonAsHtmlResource {

    public PersonAsHtmlResource() {
    }

    @GET
    @Timed
    public PersonView getPerson(@PathParam("firstName") String firstName) {
        return new PersonView(new Person(firstName));
    }
}
