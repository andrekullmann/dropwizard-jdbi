package io.dropwizard.jdbi.bundles;

import io.dropwizard.core.Configuration;
import io.dropwizard.core.ConfiguredBundle;
import io.dropwizard.jdbi.jersey.LoggingDBIExceptionMapper;
import io.dropwizard.jdbi.jersey.LoggingSQLExceptionMapper;
import io.dropwizard.core.setup.Environment;

/**
 * A bundle for logging SQLExceptions and DBIExceptions so that their actual causes aren't overlooked.
 */
public class DBIExceptionsBundle implements ConfiguredBundle<Configuration> {
    @Override
    public void run(Configuration configuration, Environment environment) {
        environment.jersey().register(new LoggingSQLExceptionMapper());
        environment.jersey().register(new LoggingDBIExceptionMapper());
    }
}
