package client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.AcidothParticipant2PCServices;
import thrift.ServiceResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 7/9/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 * This class will access the thrift server in the participant side, which implements the 2pc
 */

public class ParticipantServiceClient {

    String serverUrl;
    int port;

    /**
     *
     * @param serverUrl server address of the participant
     * @param port      port number of the participant side server
     */
    public ParticipantServiceClient(String serverUrl, int port){
        this.serverUrl = serverUrl;
        this.port = port;
    }

    /**
     *
     * @param identifier transaction identifier
     * @return return whether the commit method success or not
     */
    public ServiceResponse commit(String identifier){

        TTransport transport;
        AcidothParticipant2PCServices.Client commitClient;
        ServiceResponse pcResponse = null;

        transport = new TSocket(serverUrl, port);
        try {

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            commitClient = new AcidothParticipant2PCServices.Client(protocol);

            pcResponse = commitClient.commit(identifier);

            transport.close();

        }catch (TException e) {
            e.printStackTrace();
        }
        return pcResponse;
    }

    /**
     *
     * @param identifier transaction identifier
     * @return      return whether abort method is success or not
     */
    public ServiceResponse abort(String identifier){

        TTransport transport;
        AcidothParticipant2PCServices.Client abortClient;
        ServiceResponse pcResponse = null;

        transport = new TSocket(serverUrl, port);
        try {

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            abortClient = new AcidothParticipant2PCServices.Client(protocol);

            pcResponse = abortClient.abort(identifier);

            transport.close();

        }catch (TException e) {
            e.printStackTrace();
        }
        return pcResponse;
    }

    /**
     *
     * @param identifier transaction identifier
     * @return   return whether rollback method is success or not
     */
    public ServiceResponse rollback(String identifier){

        TTransport transport;
        AcidothParticipant2PCServices.Client rollbackClient;
        ServiceResponse pcResponse = null;

        transport = new TSocket(serverUrl, port);
        try {

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            rollbackClient = new AcidothParticipant2PCServices.Client(protocol);

            pcResponse = rollbackClient.rollback(identifier);

            transport.close();

        }catch (TException e) {
            e.printStackTrace();
        }
        return pcResponse;
    }

    /**
     *
     * @param identifier transaction identifier
     * @return        return whether prepare method is success or not
     */
    public ServiceResponse prepare(String identifier){

        TTransport transport;
        AcidothParticipant2PCServices.Client prepareClient;
        ServiceResponse pcResponse = null;

        transport = new TSocket(serverUrl, port);
        try {

            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            prepareClient = new AcidothParticipant2PCServices.Client(protocol);

            pcResponse = prepareClient.prepare(identifier);

            transport.close();

        }catch (TException e) {
            e.printStackTrace();
        }
        return pcResponse;
    }

}


