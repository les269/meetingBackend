package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Autowired
    Environment env;

    @Bean(destroyMethod = "", name = "EmbeddeddataSource")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getProperty("driverClassName"));
        dataSourceBuilder.url(env.getProperty("url"));
        dataSourceBuilder.type(SQLiteDataSource.class);
        return dataSourceBuilder.build();
    }
}
