package tests;

import coordinator.ActivationService;
import coordinator.TransactionHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.SystemException;
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
    public void testCreateCoordinationContextIsString() {
        String tid = activationService.createCoordinationContext();
        assertTrue(tid instanceof String);
    }

    @Test
    public void testCreateCoordinationContextWithTransactionObject() throws Exception {
        String tid = activationService.createCoordinationContext();
        Transaction transaction = TransactionHandler.getInstance().getTransaction(tid);
        assertTrue(transaction instanceof Transaction);
    }

    @Test
    public void testTransactionForInvalidCoordContext() throws Exception {
        String tid = "INVALID_TID";
        Transaction transaction = TransactionHandler.getInstance().getTransaction(tid);
        assertNull(transaction);
    }

    @Test
    public void testCreateCoordinationContextIdSize() {
        String tid = activationService.createCoordinationContext();
        assertEquals(17, tid.length());
    }
}
