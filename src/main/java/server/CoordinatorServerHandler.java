package server;

import coordinator.ActivationService;
import coordinator.CompletionProtocol;
import coordinator.RegistrationService;
import org.apache.thrift.TException;
import thrift.AcidothCoordinatorServices;
import thrift.CoordinationContext;
import thrift.EndPointReference;
import thrift.ServiceResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 7/9/13
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 * this class implements the services provided by coordinator
 */
public class CoordinatorServerHandler implements AcidothCoordinatorServices.Iface {

    /**
     *
     * @param coordinationType
     * @param currentContext
     * @param expires
     * @return
     * @throws TException
     */
    @Override
    public CoordinationContext createCoordinationContext(String coordinationType, CoordinationContext currentContext, int expires) throws TException {

        String transactionId;
        EndPointReference registrationEPR = new EndPointReference();
        CoordinationContext coordinationContext = new CoordinationContext();
        ActivationService activationService = new ActivationService();

        transactionId = activationService.createCoordinationContext();

        registrationEPR.setAddress(Constants.coordinatorServerAddress);
        registrationEPR.setPrivateInstance(Constants.coordinatorServerPortNumber);

        coordinationContext.setIdentifier(transactionId);
        coordinationContext.setCoordination_type(coordinationType);
        coordinationContext.setRegistrationEPR(registrationEPR);
        coordinationContext.setExpires(expires);

        return coordinationContext;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param txIdentifier
     * @return
     * @throws TException
     */
    @Override
    public ServiceResponse commit(String txIdentifier) throws TException {

        CompletionProtocol completionProtocol = new CompletionProtocol();
        completionProtocol.commit(txIdentifier);

        return ServiceResponse.commited;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param txIdentifier
     * @return
     * @throws TException
     */
    @Override
    public ServiceResponse rollBack(String txIdentifier) throws TException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param coorContext
     * @param protocolIdentifier
     * @param participantEPR
     * @return
     * @throws TException
     */
    @Override
    public boolean registerParticipant(CoordinationContext coorContext, String protocolIdentifier, EndPointReference participantEPR) throws TException {
        boolean registerReturn = false;

        RegistrationService registrationService = new RegistrationService();
        registerReturn = registrationService.register(coorContext.getIdentifier(), protocolIdentifier, participantEPR.getAddress(), participantEPR.getPrivateInstance());

        return registerReturn;
    }
}
