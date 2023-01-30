package org.example;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;

import jakarta.websocket.Session;
import org.glassfish.tyrus.core.cluster.RemoteSession;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

@ServerEndpoint("/endpoint")

public class ServerAppEndpoint {
        private static final ConcurrentLinkedQueue<Session> peers = new ConcurrentLinkedQueue<>();

        Session sessionData;


    public ServerAppEndpoint() {
    }

    @OnOpen
    public void OnOpen(Session session){

        peers.add(session);

        System.out.println(session.getId() + " Session ID");
    }


    @OnMessage
    public String onMessage(String data, Session session){

        System.out.println("testing blah blah blah");
        return data;
    }


    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error for " + session.getId() + " " + throwable.getMessage());
    }


    @OnClose
    public void onClose(Session session) {
      System.out.println("WebSocket closed for " + session.getId());

    }


   public static void  pushData( String message) throws IOException {
        for (Session peer : peers){
            peer.getBasicRemote().sendText(message);
        }

    }


}

