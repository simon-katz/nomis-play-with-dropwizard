package play_with_dropwizard.views;

import com.yammer.dropwizard.views.View;
import play_with_dropwizard.core.Person;

public class PersonView extends View {
    private final Person person;

    public PersonView(Person person) {
        super("person.ftl");
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}