package server.completion;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.*;
import thriftgen.completion.CompletionService;
import util.Constants;

/**
 * Created with IntelliJ IDEA.
 * User: Pirinthapan
 * Date: 11/2/13
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompletionServer {
    public void startServer(int port){
        CompletionService.Processor<CompletionServerHandler> processor = new CompletionService.Processor<CompletionServerHandler>(new CompletionServerHandler());
        try {
            TServerTransport serverTransport = new TServerSocket(port);
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport);
            args.processor(processor);
            args.maxWorkerThreads(1000);
            TServer server = new TThreadPoolServer(args);
            /*TNonblockingServerTransport tNonblockingServerTransport = new TNonblockingServerSocket(port);
//            TServer server = new TNonblockingServer(new TNonblockingServer.Args(tNonblockingServerTransport).processor(processor));
            TThreadedSelectorServer.Args args = new TThreadedSelectorServer.Args(tNonblockingServerTransport);
            args.transportFactory(new TFramedTransport.Factory());
            args.protocolFactory(new TBinaryProtocol.Factory());
            args.processor(processor);
            args.selectorThreads(4);
            args.workerThreads(32);
            TServer server = new TThreadedSelectorServer(args);*/
            System.out.println("Starting Completion Server...");
            server.serve();
        } catch (TTransportException e) {
            System.out.println("Could not Start the Server...");
        }
    }
}
