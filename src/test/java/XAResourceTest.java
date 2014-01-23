package tests;

import coordinator.ActivationService;
import coordinator.CompletionProtocol;
import coordinator.RegistrationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tests.mockParticipantServer.Constants;
import tests.mockParticipantServer.ParticipantHandler;
import tests.mockParticipantServer.ParticipantXAServer;
import tests.mockParticipantServer.thrift.AcidothParticipant2PCServices;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 1/22/14
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class XAResourceTest {

    String tid;

    @Before
    public void setUp() throws Exception {
        ActivationService activationService;
        activationService = new ActivationService();
        tid = activationService.createCoordinationContext();
        RegistrationService registrationService = new RegistrationService();
        registrationService.register(tid, "AT", "localhost", Constants.participantServerPortNumber1);
    }

    @After
    public void tearDown() {

    }

    /*@Test
    public void testXAPrepare() throws HeuristicRollbackException, HeuristicMixedException, RollbackException, SystemException {
        ParticipantXAServer participantXAServer = new ParticipantXAServer();
        participantXAServer.startServer(new AcidothParticipant2PCServices.Processor<ParticipantHandler>(new ParticipantHandler()));

        CompletionProtocol completionProtocol = new CompletionProtocol();
        completionProtocol.commit(tid);
    }*/

}
