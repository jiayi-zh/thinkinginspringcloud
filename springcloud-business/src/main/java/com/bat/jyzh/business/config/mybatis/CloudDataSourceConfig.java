package com.bat.jyzh.business.config.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * Mybatis + Druid 多数据源
 *
 * @author ZhengYu
 * @version 1.0 2021/3/10 9:55
 **/
@Configuration
public class CloudDataSourceConfig {

    @Value("${spring.datasource.cloud.driverClass}")
    private String driverClassName;

    @Value("${spring.datasource.cloud.url}")
    private String url;

    @Value("${spring.datasource.cloud.username}")
    private String username;

    @Value("${spring.datasource.cloud.password}")
    private String password;

    @Bean
    public DataSource cloudAlgorithmAdapterDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(10);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxActive(10);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(true);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory cloudAlgorithmAdapterSqlSessionFactory(@Qualifier("cloudAlgorithmAdapterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager cloudAlgorithmAdapterDataSourceTransactionManager(@Qualifier("cloudAlgorithmAdapterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate cloudAlgorithmAdapterSqlSessionTemplate(@Qualifier("cloudAlgorithmAdapterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
