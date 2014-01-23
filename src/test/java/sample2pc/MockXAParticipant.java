package tests.sample2pc;

import coordinationclient.CoordinationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thriftgen.coordination.ServiceResponse;

import javax.transaction.xa.XAException;
import javax.transaction.xa.Xid;

/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 11/4/13
 * Time: 11:34 AM
 *
 * Mock XA resource for testing.
 */
public class MockXAParticipant implements javax.transaction.xa.XAResource {

    /**
     *
     * @param xid
     * @param b
     * @throws javax.transaction.xa.XAException
     */
    public void commit(Xid xid, boolean b) throws XAException {

    }

    /**
     *
     * @param xid
     * @param i
     * @throws javax.transaction.xa.XAException
     */
    public void end(Xid xid, int i) throws XAException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param xid
     * @throws javax.transaction.xa.XAException
     */
    public void forget(Xid xid) throws XAException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @return
     * @throws javax.transaction.xa.XAException
     */
    public int getTransactionTimeout() throws XAException {
        return 0;
    }

    /**
     *
     * @param xaResource
     * @return
     * @throws javax.transaction.xa.XAException
     */
    public boolean isSameRM(javax.transaction.xa.XAResource xaResource) throws XAException {
        return false;
    }

    /**
     *
     * @param xid
     * @return
     * @throws javax.transaction.xa.XAException
     */
    public int prepare(Xid xid) throws XAException {
        return MockXAParticipant.XA_OK;
    }

    /**
     *
     * @param i
     * @return
     * @throws javax.transaction.xa.XAException
     */
    public Xid[] recover(int i) throws XAException {
        return new Xid[0];
    }

    /**
     *
     * @param xid
     * @throws javax.transaction.xa.XAException
     */
    public void rollback(Xid xid) throws XAException {

    }

    /**
     *
     * @param i
     * @return
     * @throws javax.transaction.xa.XAException
     */
    public boolean setTransactionTimeout(int i) throws XAException {
        return false;
    }

    /**
     *
     * @param xid
     * @param i
     * @throws javax.transaction.xa.XAException
     */
    public void start(Xid xid, int i) throws XAException {

    }

}
