package Service;

import fr.cpe.MessageReceiverSync;
import fr.cpe.MessageSender;
import fr.cpe.common.Role;
import fr.cpe.common.UserMin;
import fr.cpe.common.UserModel;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/WatcherAuth")
public class WatcherAuthRest {

    @Inject
    MessageSender sender;
    @Inject
    MessageReceiverSync receiverSync;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserMin Authentification (UserModel user){
        UserModel userAuth;
        UserMin userReturn;
        sender.sendMessage(user);
        userAuth=receiverSync.receiveMessage();
        boolean authOk=(userAuth==null)?false:true;
        if(authOk==true) userReturn= new UserMin(userAuth.getLogin(),authOk,userAuth.getRole());
        else userReturn=new UserMin(user.getLogin(),authOk, Role.NONE);
        return userReturn;
    }

}
