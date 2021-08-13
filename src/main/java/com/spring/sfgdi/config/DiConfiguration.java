package com.spring.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//note this bean can change in runtime since it has setter(hence, mutable bean),  so this not preferred-->go for constructor binding
@ConfigurationProperties("com")
@Configuration
public class DiConfiguration {
    private String username;
    private String password;
    private String jdbcURL;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

}
