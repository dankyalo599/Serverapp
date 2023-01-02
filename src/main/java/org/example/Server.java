package org.example;

import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Server {


    private final Disposable server = null;

    public Server() {
        RSocketServer.create(
                        SocketAcceptor.forRequestResponse(
                                p -> {
                                    System.out.println("Server 1 got fnf " + p.getDataUtf8());
                                    return Mono.just(DefaultPayload.create("Server 1 response"))
                                            .delayElement(Duration.ofMillis(100));
                                }))
                .bindNow(TcpServerTransport.create(8080));

    }
        public void dispose(){


            this.server.dispose();
        }

    public static void main(String[] args)

    {
        System.out.println("Hello world!");
    }
}