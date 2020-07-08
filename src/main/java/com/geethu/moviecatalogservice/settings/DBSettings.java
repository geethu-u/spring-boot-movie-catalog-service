package com.geethu.moviecatalogservice.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

//When actuator/refresh is fired by localhost/actuator/refresh(POST) this will refresh the config
@Configuration
@ConfigurationProperties("db")
@RefreshScope
public class DBSettings {

    private  String connection;
    private String host;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
