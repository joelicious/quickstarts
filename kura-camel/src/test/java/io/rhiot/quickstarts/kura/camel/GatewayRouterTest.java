package io.rhiot.quickstarts.kura.camel;

import io.rhiot.component.kura.test.TestKuraServer;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class GatewayRouterTest {

    static TestKuraServer testKuraServer = new TestKuraServer();

    @Test
    public void shouldRunRoute() throws InterruptedException {
    	
        GatewayRouter gatewayRouter = testKuraServer.start(GatewayRouter.class);
        MockEndpoint mockEndpoint = gatewayRouter.getContext().getEndpoint("mock:test", MockEndpoint.class);
        mockEndpoint.setMinimumExpectedMessageCount(1);
        mockEndpoint.assertIsSatisfied();
    }

}
