package fr.cpe;

import fr.cpe.common.UserModel;

import javax.ejb.Local;

@Local
public interface MessageSender {
    void sendMessage(String message);
    void sendMessage(UserModel user);


}
