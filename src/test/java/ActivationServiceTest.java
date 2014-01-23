
import coordinator.ActivationService;
import coordinator.TransactionHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import javax.transaction.Transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 12/4/13
 * Time: 7:33 AM
 * To change this template use File | Settings | File Templates.
 */

public class ActivationServiceTest {

    ActivationService activationService;

    @Before
    public void setUp() {
        activationService = new ActivationService();
    }

    @After
    public void tearDown() {

    }

    @Test
    @Category( InitiatorTestSuite.class)
    public void testCreateCoordinationContextIsString() {
        String tid = activationService.createCoordinationContext();
        assertTrue(tid instanceof String);
    }

    @Test
    @Category( InitiatorTestSuite.class)
    public void testCreateCoordinationContextWithTransactionObject() throws Exception {
        String tid = activationService.createCoordinationContext();
        Transaction transaction = TransactionHandler.getInstance().getTransaction(tid);
        assertTrue(transaction instanceof Transaction);
    }

    @Test
    @Category( InitiatorTestSuite.class)
    public void testTransactionForInvalidCoordContext() throws Exception {
        String tid = "INVALID_TID";
        Transaction transaction = TransactionHandler.getInstance().getTransaction(tid);
        assertNull(transaction);
    }

    @Test
    @Category( InitiatorTestSuite.class)
    public void testCreateCoordinationContextIdSize() {
        String tid = activationService.createCoordinationContext();
        assertEquals(17, tid.length());
    }
}
