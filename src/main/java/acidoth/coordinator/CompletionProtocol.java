package acidoth.coordinator;

import javax.transaction.*;

/**
 * Created with IntelliJ IDEA.
 * User: guruce
 * Date: 6/28/13
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompletionProtocol {

    /**
     * WS-AT completion protocol to starts 2pc protocol
     * @param transactionID
     * @return
     */
    public void commit(String transactionID) {
        try {
            Transaction transaction = TransactionHandler.getInstance().getTransaction(transactionID);
            transaction.commit();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (RollbackException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SystemException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
