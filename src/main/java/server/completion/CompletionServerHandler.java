package server.completion;

import coordinator.CompletionProtocol;
import org.apache.thrift.TException;
import thriftgen.completion.CompletionService;
import thriftgen.completion.ServiceResponse;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/2/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompletionServerHandler implements CompletionService.Iface {

    @Override
    public ServiceResponse commit(String txIdentifier) throws TException, HeuristicRollbackException, HeuristicMixedException, RollbackException, SystemException {
        CompletionProtocol completionProtocol = new CompletionProtocol();
        ServiceResponse serviceResponse = completionProtocol.commit(txIdentifier);
        return serviceResponse;
    }

    @Override
    public ServiceResponse rollBack(String txIdentifier) throws TException {
        CompletionProtocol completionProtocol = new CompletionProtocol();
        return completionProtocol.abort(txIdentifier);
    }
}
