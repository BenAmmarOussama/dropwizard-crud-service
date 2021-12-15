package org.eniso.pmfwk.Controller;

import io.dropwizard.hibernate.UnitOfWork;
import org.eniso.pmfwk.DAO.EquipmentDAO;
import org.eniso.pmfwk.Entity.Equipment;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/equipments")
@Produces(MediaType.APPLICATION_JSON)
public class EquipmentController {
    private final EquipmentDAO equipmentDAO;

    public EquipmentController(EquipmentDAO equipmentDAO) {
        this.equipmentDAO = equipmentDAO;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Equipment getEquipment(@PathParam("id") int equipmentId){
        return this.equipmentDAO.getEquipment(equipmentId);
    }

    @GET
    @UnitOfWork
    public List<Equipment> getEquipments(){
        try{
            return this.equipmentDAO.getEquipments();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @POST
    @UnitOfWork
    public Equipment addEquipment(@Valid Equipment equipment){
        return this.equipmentDAO.addEquipment(equipment);
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void deleteEquipment(@PathParam("id") int equipmentId){
        this.equipmentDAO.deleteEquipment(equipmentId);
    }

    @PUT
    @UnitOfWork
    public Equipment updateEquipment(@Valid Equipment equipment){
        return this.equipmentDAO.updateEquipment(equipment);
    }
}
