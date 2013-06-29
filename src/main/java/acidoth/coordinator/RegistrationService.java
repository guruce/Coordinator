package acidoth.coordinator;

import XAResources.XAResource;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: guruce
 * Date: 6/28/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationService {

    /**
     * WS-AT registration process
     * @param transactionID
     * @param protocolIdentifier
     * @param participantAddr
     * @param participantPort
     * @return
     */
    public boolean register(String transactionID, String protocolIdentifier, String participantAddr, int participantPort) {
        boolean registerResult = false;
        try {
            Transaction transaction = TransactionHandler.getInstance().getTransaction(transactionID);
            XAResource xaResource = null;
            //todo create xa resource for participant

            registerResult = transaction.enlistResource(xaResource);
        } catch (RollbackException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SystemException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return registerResult;
    }

}
