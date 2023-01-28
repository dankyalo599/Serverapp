package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class AsteriskDecoder implements Decoder.Text<AsteriskMessage> {
    @Override
    public AsteriskMessage decode(String json) throws DecodeException {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.constructType(AsteriskMessage.class);
        AsteriskMessage asteriskMessage;
        try {
            return asteriskMessage = objectMapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            System.out.println("Problem with decoding");
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
