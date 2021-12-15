package org.eniso.pmfwk;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eniso.pmfwk.Config.ApplicationConfiguration;
import org.eniso.pmfwk.Controller.EquipmentController;
import org.eniso.pmfwk.Controller.UserController;
import org.eniso.pmfwk.DAO.EquipmentDAO;
import org.eniso.pmfwk.DAO.UserDAO;
import org.eniso.pmfwk.Entity.Equipment;
import org.eniso.pmfwk.Entity.User;

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
        // environment.jersey().register(ExampleFilter.class);
    }

}