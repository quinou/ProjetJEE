package fr.cpe;

import fr.cpe.common.UserModel;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserModelDAO {
    List<UserModel> getUsers();
}
