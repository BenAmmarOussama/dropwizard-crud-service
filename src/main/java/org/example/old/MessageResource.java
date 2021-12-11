package org.example.old;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private final MessageDAO messageDAO;

    public MessageResource(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @GET
    @UnitOfWork
    public Message getMessage(){
        // return new Message("Hello World!!");
        Optional<Message> message =  messageDAO.findById(1);

        if (message.isPresent()){
            return message.get();
        } else {
            return new Message("Error");
        }
    }


}
