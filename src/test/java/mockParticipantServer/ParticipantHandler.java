package tests.mockParticipantServer;

import org.apache.thrift.TException;
import tests.mockParticipantServer.thrift.AcidothParticipant2PCServices;
import tests.mockParticipantServer.thrift.ServiceResponse;

/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 1/22/14
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantHandler implements AcidothParticipant2PCServices.Iface{

    @Override
    public ServiceResponse commit(String identifier) throws TException {
        System.out.println("Transaction " + identifier + " Successfully Commited");
//        System.out.println("Transaction " + identifier + " abort local");
        // TODO Auto-generated method stub
        return ServiceResponse.commited;    }

    @Override
    public ServiceResponse abort(String identifier) throws TException {
        System.out.println("Transaction " + identifier + " Successfully Aborted");
        return ServiceResponse.aborted;    }

    @Override
    public ServiceResponse rollback(String identifier) throws TException {
        System.out.println("Transaction " + identifier + " Successfully Rolled back");
        return ServiceResponse.aborted;    }

    @Override
    public ServiceResponse prepare(String identifier) throws TException {
        System.out.println("Transaction " + identifier + " Successfully Prepared");
        //System.out.println("Transaction " + identifier + " aborted");
        // TODO Auto-generated method stub
        return ServiceResponse.prepared;
    }
}
