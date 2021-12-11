package org.example.old;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class MessageDAO extends AbstractDAO<Message> {

    public MessageDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Message> findById(int id){
        return Optional.fromNullable(get(id));
    }

}
