package coordinator;

import com.atomikos.icatch.jta.UserTransactionManager;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: guruce
 * Date: 6/28/13
 * Time: 1:51 PM
 *
 * This class will create only a single object to handle all the transaction in the coordinator.
 * It contains Atomikos transaction object which handle all the operations with Atomikos.
 */
@SuppressWarnings("JavaDoc")
public class TransactionHandler {

    // Create a hash map to store transaction objects
    private HashMap transactionMap;
    private UserTransactionManager userTransactionManager;
    private static TransactionHandler instance = new TransactionHandler();

    /**
     * Create singleton instance for this class
     * @return TransactionHandler
     */
    public static TransactionHandler getInstance() {
        return instance;
    }

    /**
     * Initiate Atomikos tm
     */
    private TransactionHandler() {
        userTransactionManager = new UserTransactionManager();
    }

    /**
     * Create Transaction object for single multiple transaction and return map key
     * @return String transactionID
     */
    public String createTransaction() {

        try {
            userTransactionManager.begin();
            Transaction transaction = userTransactionManager.getTransaction();
            String transactionID = transaction.toString();
            return transactionID;

        } catch (SystemException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        } catch (NotSupportedException e) {
            e.printStackTrace();
            return null; //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * Push transaction object from tm
     * @param transactionID
     * @return Transaction
     */
    public Transaction getTransaction(String transactionID) throws SystemException{
        return (Transaction) userTransactionManager.getTransaction(transactionID) ;
    }

}
