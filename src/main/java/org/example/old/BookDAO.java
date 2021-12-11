package org.example.old;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class BookDAO extends AbstractDAO<Book> {
    public BookDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Book> findById(int id){
        return Optional.fromNullable(get(id));
    }
}
