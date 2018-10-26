package fr.cpe.impl;

import fr.cpe.UserModelDAO;
import fr.cpe.common.UserModel;

import javax.ejb.*;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class UserModelDAOImpl implements UserModelDAO {


    @PersistenceContext(unitName = "primary")
    private EntityManager em;


    public List<UserModel> getUsers(){
        List<UserModel> result=new ArrayList<>();
        result.addAll(em.createQuery("select u from UserModel u").getResultList());
        return result;
    }
}
