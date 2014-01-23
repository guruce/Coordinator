package coordinator;

import XAResources.XAResource;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: guruce
 * Date: 6/28/13
 * Time: 2:58 PM
 *
 * RegistrationService implementation in WS-Coordination.
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
    public boolean register(String transactionID, String protocolIdentifier, String participantAddr, int participantPort) throws SystemException, RollbackException {
        boolean registerResult = false;
        Transaction transaction = TransactionHandler.getInstance().getTransaction(transactionID);
        XAResource xaResource = new XAResource(participantAddr, participantPort);
        xaResource.setTransactionId(transactionID);
        registerResult = transaction.enlistResource(xaResource);
        return registerResult;
    }

}
