package com.liu.conf;

import com.liu.utils.JDBCUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ComponentScan("com.liu")
@Import(JDBCUtil.class)
public class SpringConf {
}
