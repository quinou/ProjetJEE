package fr.cpe;

import fr.cpe.common.UserModel;

public interface MessageSenderQueue {
    void sendMessage(String message);
    void sendMessage(UserModel user);
}
