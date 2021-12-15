package org.eniso.pmfwk.Controller;

import io.dropwizard.hibernate.UnitOfWork;
import org.eniso.pmfwk.DAO.UserDAO;
import org.eniso.pmfwk.Entity.User;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public User getUser(@PathParam("id") String userId){
        return this.userDAO.getUser(userId);
    }

    @GET
    @UnitOfWork
    public List<User> getUsers(){
        return this.userDAO.getUsers();
    }

    @POST
    @UnitOfWork
    public User addUser(@Valid User User){
        return this.userDAO.addUser(User);
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void deleteUser(@PathParam("id") String UserId){
        this.userDAO.deleteUser(UserId);
    }

    @PUT
    @UnitOfWork
    public User updateUser(@Valid User User){
        return this.userDAO.updateUser(User);
    }
}