package coordinator;

/**
 * Created with IntelliJ IDEA.
 * User: guruce
 * Date: 6/28/13
 * Time: 2:57 PM
 *
 * Implementation of ActivationService in WS-Coordination.
 */
public class ActivationService {

    /**
     * Coordination context identifier for a transaction
     * @return
     */
    public String createCoordinationContext() {
        return TransactionHandler.getInstance().createTransaction();
    }

}
