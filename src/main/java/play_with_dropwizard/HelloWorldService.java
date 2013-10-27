package play_with_dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.config.HttpConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play_with_dropwizard.health.TemplateHealthCheck;
import play_with_dropwizard.resources.HelloWorldResource;

public class HelloWorldService extends Service<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.setName("hello-world"); // (does not need to be same as yml file name)
     }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        Logger logger = LoggerFactory.getLogger("com.nomistech.play_with_dropwizard");

        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));

        HttpConfiguration foo = configuration.getHttpConfiguration();
        logger.info("httpConfiguration = ["
                + configuration.getHttpConfiguration().getPort()
                + ", "
                + configuration.getHttpConfiguration().getAdminPort()
                + "]");
    }
}
