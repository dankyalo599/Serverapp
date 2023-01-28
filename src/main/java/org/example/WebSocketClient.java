package org.example;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint(decoders = AsteriskDecoder.class, encoders = AsteriskEncoder.class)
public class WebSocketClient {


    @OnOpen
    public void opened(final Session session){

      System.out.println(session.isOpen() + " Hello Fermon");
    }

    @OnMessage
    public void processMessage(final Session session, AsteriskMessage asteriskMessage){
        System.out.println("Fermon testing " + asteriskMessage.toString());

    }
}
