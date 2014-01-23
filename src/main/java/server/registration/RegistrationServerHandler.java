package server.registration;

import org.apache.thrift.TException;
import thriftgen.registration.CoordinationContext;
import thriftgen.registration.EndPointReference;
import thriftgen.registration.RegistrationService;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/2/13
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationServerHandler implements RegistrationService.Iface {
    private boolean registerReturn = false;
    private String wait = new String();
    @Override
    public boolean registerParticipant(final CoordinationContext coorContext, final String protocolIdentifier, final EndPointReference participantEPR) {

        try{
                coordinator.RegistrationService registrationService = new coordinator.RegistrationService();
                registerReturn = registrationService.register(coorContext.getIdentifier(), protocolIdentifier, participantEPR.getAddress(), participantEPR.getPrivateInstance());

        }
        catch (Exception e){
            e.printStackTrace();
        }


        return registerReturn;
    }
}
