package tests;

import coordinator.ActivationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: guru
 * Date: 1/22/14
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class XAResourceTest {

    @Before
    public void setUp() {
        ActivationService activationService;
        activationService = new ActivationService();
    }

    @After
    public void tearDown() {

    }

    /*@Test
    public void test() {

        assertTrue(tid instanceof String);
    }*/
}
