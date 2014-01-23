package tests.mockParticipantServer;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import tests.mockParticipantServer.thrift.AcidothParticipant2PCServices;

/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 1/22/14
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantXAServer {
    public static void startServer(AcidothParticipant2PCServices.Processor<ParticipantHandler> processor){
        try {
            TServerTransport serverTransport = new TServerSocket(Constants.participantServerPortNumber1);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Starting Server with port No: " +Constants.participantServerPortNumber1+"...");
            server.serve();
        } catch (TTransportException e) {
            System.out.println("Could not create Server...");
        }
    }

    public static void main(String[] args){
        startServer(new AcidothParticipant2PCServices.Processor<ParticipantHandler>(new ParticipantHandler()));
    }
}
