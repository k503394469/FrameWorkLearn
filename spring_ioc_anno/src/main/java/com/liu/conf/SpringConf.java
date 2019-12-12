package com.liu.conf;

import com.liu.utils.JdbcDataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ComponentScan("com.liu")
@Import(JdbcDataSource.class)
public class SpringConf {
}
