package org.example;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class AsteriskMessage  {



        private String type;
        private String timestamp;
        private Object[] args;
        private Channel channel;
        private String asterisk_id;
        private String application;


        public String getType() { return type; }
        public void setType(String value) { this.type = value; }

        public String getTimestamp() { return timestamp; }
        public void setTimestamp(String value) { this.timestamp = value; }

        public Object[] getArgs() { return args; }
        public void setArgs(Object[] value) { this.args = value; }

        public Channel getChannel() { return channel; }
        public void setChannel(Channel value) { this.channel = value; }

        public String getAsterisk_id() { return asterisk_id; }
        public void setAsterisk_id(String value) { this.asterisk_id = value; }

        public String getApplication() { return application; }
        public void setApplication(String value) { this.application = value; }


}

// Channel.java



    class Channel {
        private String id;
        private String name;
        private String state;

        private String protocol_id;
        private Caller caller;
        private Caller connected;
        private String accountcode;
        private Dialplan dialplan;
        private String creationtime;
        private String language;

        public String getID() { return id; }
        public void setID(String value) { this.id = value; }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public String getState() { return state; }
        public void setState(String value) { this.state = value; }

        public String getProtocol_id() { return protocol_id; }
        public void setProtocol_id(String value) { this.protocol_id= value; }

        public Caller getCaller() { return caller; }

        public void setCaller(Caller value) { this.caller = value; }

        public Caller getConnected() { return connected; }
        public void setConnected(Caller value) { this.connected = value; }

        public String getAccountcode() { return accountcode; }
        public void setAccountcode(String value) { this.accountcode = value; }

        public Dialplan getDialplan() { return dialplan; }
        public void setDialplan(Dialplan value) { this.dialplan = value; }

        public String getCreationtime() { return creationtime; }
        public void setCreationtime(String value) { this.creationtime = value; }

        public String getLanguage() { return language; }
        public void setLanguage(String value) { this.language = value; }
    }

// Caller.java



     class Caller {
        private String name;
        private String number;

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public String getNumber() { return number; }
        public void setNumber(String value) { this.number = value; }
    }

// Dialplan.java


     class Dialplan {
        private String context;
        private String exten;
        private long priority;
        private String app_name;
        private String app_data;

        public String getContext() { return context; }
        public void setContext(String value) { this.context = value; }

        public String getExten() { return exten; }
        public void setExten(String value) { this.exten = value; }

        public long getPriority() { return priority; }
        public void setPriority(long value) { this.priority = value; }

        public String getApp_name() { return app_name; }
        public void setApp_name(String value) { this.app_name = value; }

        public String getApp_data() { return app_data; }
        public void setApp_data(String value) { this.app_data = value; }
    }

