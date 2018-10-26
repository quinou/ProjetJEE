package fr.cpe;

import fr.cpe.common.UserModel;

import javax.ejb.Local;

@Local
public interface MessageReceiverSync {
    UserModel receiveMessage();
}
