package fr.cpe.impl;

import fr.cpe.MessageSender;
import fr.cpe.common.UserModel;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
@LocalBean
public class MessageSenderImpl implements MessageSender {

    @Inject
    JMSContext context;
    @Resource(mappedName = "java:/jms/watcherAuthJMS")
    Topic topic;
    public void sendMessage(String message) {
        System.out.println("avant envoi du message:"+message);
        context.createProducer().send(topic,message);
        System.out.println("après producer => message envoyé au topic");
    }


    @Override
    public void sendMessage(UserModel user) {

        context.createProducer().send(topic,user);
    }

    private String getUserMessage(UserModel user){
        return "Bienvenue "+user.getLastName()+" "+user.getSurName();
    }
}
