package com.exampleui.demoui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com"})
public class DataManager {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
