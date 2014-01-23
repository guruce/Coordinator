package server.activation;

import org.apache.thrift.TException;
import thriftgen.activation.EndPointReference;
import thriftgen.activation.ActivationService;
import thriftgen.activation.CoordinationContext;
import util.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/2/13
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivationServerHandler implements ActivationService.Iface {
    private CoordinationContext coordinationContext;
    private String wait = new String();
    @Override
    public CoordinationContext createCoordinationContext(final String coordinationType, CoordinationContext currentContext, final int expires) throws TException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String transactionId;
                EndPointReference registrationEPR = new EndPointReference();
                coordinationContext = new CoordinationContext();
                coordinator.ActivationService activationService = new coordinator.ActivationService();
                transactionId = activationService.createCoordinationContext();
                registrationEPR.setAddress(Constants.serverAddress);
                registrationEPR.setPrivateInstance(Constants.registrationPort);
                coordinationContext.setIdentifier(transactionId);
                coordinationContext.setCoordination_type(coordinationType);
                coordinationContext.setRegistrationEPR(registrationEPR);
                coordinationContext.setExpires(expires);
                synchronized (wait){
                    wait.notifyAll();
                }
            }
        }).start();

        synchronized (wait){
            try {
                wait.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return coordinationContext;
    }
}
