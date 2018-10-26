package fr.cpe.model;

import fr.cpe.UserModelDAO;
import fr.cpe.common.Role;
import fr.cpe.common.UserModel;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
//
@Singleton
@Startup
public class DataContainer {
    private List<UserModel> users;
    private List<UserModel> usersDBVers;
    @Inject
    private UserModelDAO userDAO;


    @PostConstruct
    public void init(){
        //userDAO.getUsers();
        usersDBVers=new ArrayList<>();
    }


    public Role checkUser(UserModel user){

        usersDBVers.addAll(userDAO.getUsers());
        for(UserModel el: usersDBVers){
            if(el.getLogin().matches(user.getLogin()) && el.getPassword().matches(user.getPassword())) {
                return el.getRole();
            }
        }
        return Role.NONE;

    }
}
