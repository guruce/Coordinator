package tests;

import coordinator.CompletionProtocol;
import coordinator.TransactionHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import thriftgen.completion.ServiceResponse;

import static org.junit.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 12/4/13
 * Time: 7:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class CompletionProtocolTest {

    CompletionProtocol completionProtocol;
    String tid;

    @Before
    public void setUp() throws Exception {
        tid = TransactionHandler.getInstance().createTransaction();
        completionProtocol = new CompletionProtocol();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAbort() throws Exception {
        ServiceResponse st = completionProtocol.abort(tid);
        assertEquals(ServiceResponse.aborted, ServiceResponse.findByValue(st.getValue()));
    }

    @Test(expected = NullPointerException.class)
    public void testAbortForInvalidTid() throws Exception {
        ServiceResponse st = completionProtocol.abort("INVALID_TID");
    }

    @Test(expected = NullPointerException.class)
    public void testAbortForAlreadyCommitedTid() throws Exception {
        completionProtocol.commit(tid);

        completionProtocol.abort(tid);
    }

    @Test(expected = NullPointerException.class)
    public void testAbortForAlreadyAbortedTid() throws Exception {
        completionProtocol.abort(tid);

        completionProtocol.abort(tid);
    }

    /////////////////////////////////////////////////

    @Test
    public void testCommit() throws Exception {
        ServiceResponse st = completionProtocol.commit(tid);
        assertEquals(ServiceResponse.commited, ServiceResponse.findByValue(st.getValue()));
    }

    @Test(expected = NullPointerException.class)
    public void testCommitForInvalidTid() throws Exception {
        completionProtocol.commit("INVALID_TID");
    }

    @Test(expected = NullPointerException.class)
    public void testCommitForAlreadyCommitedTid() throws Exception {
        completionProtocol.commit(tid);

        completionProtocol.commit(tid);
    }

    @Test(expected = NullPointerException.class)
    public void testCommitForAlreadyAbortedTid() throws Exception {
        completionProtocol.abort(tid);

        completionProtocol.commit(tid);
    }

}
