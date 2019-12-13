package com.liu;

import com.liu.test.DataSourceConf;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.liu")
@Import(DataSourceConf.class)
public class SpringConf {
}
