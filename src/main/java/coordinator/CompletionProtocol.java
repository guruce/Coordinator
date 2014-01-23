package coordinator;

import thriftgen.completion.ServiceResponse;

import javax.transaction.*;

/**
 * Created with IntelliJ IDEA.
 * User: guruce
 * Date: 6/28/13
 * Time: 3:00 PM
 *
 * CompletionProtocol implementation in WS-Coordination.
 */
public class CompletionProtocol {

    /**
     * WS-AT commit call in completion protocol to starts 2pc protocol
     * @param transactionID
     * @return
     */
    public ServiceResponse commit(String transactionID) throws SystemException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        Transaction transaction = TransactionHandler.getInstance().getTransaction(transactionID);
        transaction.commit();
        return ServiceResponse.commited;
    }

    /**
     * WS-AT abort call in completion protocol
     * @param transactionId
     * @return
     */
    public ServiceResponse abort(String transactionId){
        try {
            Transaction transaction = TransactionHandler.getInstance().getTransaction(transactionId);
            transaction.rollback();
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return ServiceResponse.aborted;
    }

}
