
import coordinator.CompletionProtocol;
import coordinator.RegistrationService;
import coordinator.TransactionHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 12/4/13
 * Time: 7:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationServiceTest {

    RegistrationService registrationService;
    String tid;

    @Before
    public void setUp() {
        tid = TransactionHandler.getInstance().createTransaction();
        registrationService = new RegistrationService();
    }

    @After
    public void tearDown() {

    }

    @Test
    @Category( ParticipantTestSuite.class)
    public void testRegister() throws RollbackException, SystemException {
        boolean success = registrationService.register(tid, "AT", "participant.addr", 9090);
        assertTrue(success);
    }

    @Test(expected = NullPointerException.class)
    @Category( ParticipantTestSuite.class)
    public void testForUnknownTransaction () throws Exception {
        boolean result = registrationService.register("INVALID_TID", "AT", "participant.addr", 9090);

    }

    @Test(expected = NullPointerException.class)
    @Category( ParticipantTestSuite.class)
    public void testRegisterAfterCommit() throws Exception {
        CompletionProtocol completionProtocol = new CompletionProtocol();
        completionProtocol.commit(tid);
        boolean result2 = registrationService.register(tid, "AT", "participant.addr", 9090);
    }

    @Test(expected = NullPointerException.class)
    @Category( ParticipantTestSuite.class)
    public void testRegisterAfterAbort() throws Exception {
        CompletionProtocol completionProtocol = new CompletionProtocol();
        completionProtocol.abort(tid);
        boolean result2 = registrationService.register(tid, "AT", "participant.addr", 9090);
    }
}
