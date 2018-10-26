package fr.cpe.impl;

import fr.cpe.MessageReceiverSync;
import fr.cpe.common.UserModel;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;


@Stateless(name = "MessageReceiverSyncImpl")
@LocalBean
public class MessageReceiverSyncImpl implements MessageReceiverSync {

    @Inject
    JMSContext context;
    @Resource(mappedName = "java:/jms/queue/watcherqueue")
    Queue queue;

    public UserModel receiveMessage() {
        UserModel message=null;
        JMSConsumer consumer= context.createConsumer(queue);
        try{
            Message m = consumer.receive(1000);
            if (m != null) {
                message=m.getBody(UserModel.class);
            }
        }catch (JMSException jex) {
            jex.printStackTrace();
        }
        return message;
    }

}
