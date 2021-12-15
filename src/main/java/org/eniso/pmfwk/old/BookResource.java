package org.eniso.pmfwk.old;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookDAO bookDAO;

    public BookResource(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GET
    @UnitOfWork
    public Book getBook(){
        // return new Message("Hello World!!");
        Optional<Book> book =  bookDAO.findById(1);

        if (book.isPresent()){
            return book.get();
        } else {
            return new Book("Error");
        }
    }
}
