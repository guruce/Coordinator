package server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.AcidothCoordinatorServices;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 7/9/13
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class CoordinatorServer {

    /**
     *
     * @param processor
     */
    public static void startServer(AcidothCoordinatorServices.Processor<CoordinatorServerHandler> processor){

        try {

            TServerTransport serverTransport = new TServerSocket(Constants.coordinatorServerPortNumber);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting Server...");

            server.serve();

        } catch (TTransportException e) {
            System.out.println("Could not Start the Server...");
        }
    }

    public static void main(String[] args){
        startServer(new AcidothCoordinatorServices.Processor<CoordinatorServerHandler>(new CoordinatorServerHandler()));
    }
}
