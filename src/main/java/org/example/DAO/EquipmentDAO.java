package org.example.DAO;


import io.dropwizard.hibernate.AbstractDAO;
import org.example.Entity.Equipment;
import org.hibernate.SessionFactory;

import java.util.List;

public class EquipmentDAO extends AbstractDAO<Equipment> {

    public EquipmentDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Equipment getEquipment(int id){
        return get(id);
    }

    public Equipment addEquipment(Equipment equipment){
        return persist(equipment);
    }

    public List<Equipment> getEquipments(){
        return list(currentSession().createQuery("SELECT e FROM Equipment e"));
    }

    public void deleteEquipment(int id){
        Equipment equipment = getEquipment(id);
        currentSession().delete(equipment);
    }

    public Equipment updateEquipment(Equipment equipment){
        int id = equipment.getId();
        currentSession().update(equipment);
        return this.getEquipment(id);
    }
}