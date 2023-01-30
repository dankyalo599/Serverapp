package org.example;

import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriVersion;
import ch.loway.oss.ari4java.generated.AriWSHelper;
import ch.loway.oss.ari4java.generated.models.*;
import ch.loway.oss.ari4java.tools.ARIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class AsteriskHQ {

    private final String Address;
    private final String UserName;
    private final String Password;
    private ARI ari;
    private static final Logger logger = LoggerFactory.getLogger(AsteriskHQ.class);

    private static final Map<String, String> lookups = new HashMap<>();
    private static final Map<String, State> states = new HashMap<>();

    public AsteriskHQ(String address, String userName, String password) {
        this.Address = address;
        this.UserName = userName;
        this.Password = password;
    }

    public boolean start() {

        try {
            ari = ARI.build(Address, "hello-world", UserName, Password, AriVersion.ARI_1_6_0);
            AsteriskInfo info = ari.asterisk().getInfo().execute();
            System.out.println("testing ******* " + info.getStatus());
            ari.events().eventWebsocket("hello-world").execute(new Handler());
            logger.info("Connected to Asterisk {}", info.getSystem().getVersion());
        } catch (ARIException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * An object to contain some ids to aid with processing the events.
     */
    static class State {
        private final String id = UUID.randomUUID().toString();
        private String from;
        private String to;
        private String channel1;
        private String channel2;
        private String bridge;
    }



    /**
     * Extension of the AriWSHelper to handle the events from Asterisk.
     */
    class Handler extends AriWSHelper {
        @Override
        public void onChannelStateChange (ChannelStateChange ChannelStateChange){
            System.out.println(ChannelStateChange.getApplication());

        }


        @Override
        public void onChannelHangupRequest(ChannelHangupRequest hangupRequest){
            System.out.println(hangupRequest.getTimestamp());

        }
//        @Override
//        public void onSuccess(Message message) {
//
//            System.out.println("testing again "+ message.getType());
//            // execute message handling in a thead pool to offload the websocket event worker,
//            // so we can get the next event and avoid a potential netty worker group starvation
////            threadPool.execute(() -> super.onSuccess(message));
//        }

        @Override
        protected void onStasisStart(StasisStart message)  {
        try {
            ServerAppEndpoint.pushData(message.getChannel().getCaller().getNumber());
            System.out.println("Fermon testing " + message.getChannel().getCaller().getNumber());
        }
        catch(IOException e){
            e.printStackTrace();

            }

            // StasisStart is created by both the Stasis dialplan app and a call to the channels API in ARI,
            // so we check an argument set in the create channel code and ignore
            logger.debug("onStasisStart, chan id: {}, name: {}", message.getChannel().getId(), message.getChannel().getName());
            if (message.getArgs() != null && !message.getArgs().isEmpty() && "me".equals(message.getArgs().get(0))) {
                logger.debug("started by me, not processing...");
                return;
            }
            // was not created by "me" so we assume it's from the Stasis dialplan app
            // create a State object and extract the info...
//            public void onServerMessage(Session session, Message message) {
//                sessions.get(message.getToUserName())
//                        .getBasicRemote() // see also getAsyncRemote()
//                        .sendText(message.getContent());
//            }
//            // 902 & 903 are "virtual" dialplan extensions that should call endpoint 100 or 200
//            if ("902".equals(state.to) || "903".equals(state.to)) {
//                state.to = "902".equals(state.to) ? "100" : "200";
//                logger.debug("Call received on virtual extension changed to {}", state.to);
//            }

        }

    }
}
