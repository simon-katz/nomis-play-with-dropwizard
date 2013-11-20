package play_with_dropwizard.views;

import com.yammer.dropwizard.views.View;
import play_with_dropwizard.core.HelloWorld;
import play_with_dropwizard.core.Person;

public class HelloWorldView extends View {
    private HelloWorld helloWorld;

    public HelloWorldView(HelloWorld helloWorld) {
        super("helloWorld.ftl");
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }
}