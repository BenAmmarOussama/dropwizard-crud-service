package org.example;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.Config.ApplicationConfiguration;
import org.example.Controller.EquipmentController;
import org.example.Controller.UserController;
import org.example.DAO.EquipmentDAO;
import org.example.DAO.UserDAO;
import org.example.Entity.Equipment;
import org.example.Entity.User;
import org.example.Filter.ExampleFilter;

public class CrudServiceApplication extends Application<ApplicationConfiguration> {
    public static void main(String[] args) throws Exception {
        new CrudServiceApplication().run(args);
    }

    private final HibernateBundle<ApplicationConfiguration> hibernateBundle =
            new HibernateBundle<ApplicationConfiguration>(Equipment.class, User.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(ApplicationConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(ApplicationConfiguration configuration,
                    Environment environment) {
        final EquipmentDAO equipmentDAO = new EquipmentDAO(hibernateBundle.getSessionFactory());
        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new EquipmentController(equipmentDAO));
        environment.jersey().register(new UserController(userDAO));
        environment.jersey().register(ExampleFilter.class);
    }

}