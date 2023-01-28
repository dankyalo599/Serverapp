package org.example;

import ch.loway.oss.ari4java.generated.AriWSHelper;
import ch.loway.oss.ari4java.generated.ari_6_0_1.models.ChannelCreated_impl_ari_6_0_1;
import ch.loway.oss.ari4java.generated.ari_6_0_1.models.Channel_impl_ari_6_0_1;
import ch.loway.oss.ari4java.generated.models.Channel;
import ch.loway.oss.ari4java.generated.models.ChannelCallerId;
import ch.loway.oss.ari4java.generated.models.ChannelCreated;
import ch.loway.oss.ari4java.tools.ARIException;
import io.rsocket.Payload;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import org.glassfish.tyrus.server.Server;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;

public class ServerStart {


//    private final Disposable server = null;

    public ServerStart() {

//        Function<Payload, Mono<Payload>> handler = (p) -> {
//            System.out.println("Server 1 got fnf " + p.getDataUtf8());
//            return Mono.just(DefaultPayload.create("Server 1 response"))
//                    .delayElement(Duration.ofMillis(100));
//        };
//
//        System.out.println("testing!!!");
//         RSocketServer.create(
//                        SocketAcceptor.forFireAndForget(p -> {
//                            System.out.println("Server 1 got fnf " + p.getDataUtf8());
//                            return Mono.empty();
//                        }))
//                .bindNow(TcpServerTransport.create("127.0.0.1", 9999));


    }

    public static void main(String[] args) throws ARIException {
//
        AsteriskHQ asteriskHQ = new AsteriskHQ("http://12.152.71.226:8088/asterisk","fermon","Bham1984");
        asteriskHQ.start();
        org.glassfish.tyrus.server.Server server1 = new Server("0.0.0.0",8025, "/test",null, ServerAppEndpoint.class);
        try {
            server1.start();
            while (true);
        } catch (Exception e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
        finally {
            server1.stop();
        }


//
//        WebSocketContainer container =  ContainerProvider.getWebSocketContainer();
//
//        try {
//            container.connectToServer(WebSocketClient.class, URI.create("ws://12.152.71.226:8088/asterisk/ari/events?api_key=fermon:Bham1984&app=hello-world"));
//        } catch (DeploymentException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        while (true) {
//
//        }

//        new Server();

//        RSocket rSocket = RSocketConnector.connectWith(TcpClientTransport.create("127.0.0.1", 9999)).block();
//        server.getRequestPayload().flatMap(payload -> rSocket.requestResponse(payload))
//                .doOnNext(response -> System.out.println("Response from server :: "+ response.getDataUtf8()))
//                .blockLast(Duration.ofMinutes(1));

    }




}