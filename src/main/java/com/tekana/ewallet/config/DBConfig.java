package com.tekana.ewallet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.tekana.ewallet.dao.CustomerDao;
import com.tekana.ewallet.dao.CustomerDaoImpl;
import com.tekana.ewallet.dao.TransactionDao;
import com.tekana.ewallet.dao.TransactionDaoImpl;
import com.tekana.ewallet.dao.WalletDao;
import com.tekana.ewallet.dao.WalletDaoImpl;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DBConfig {

    @Value("${datasource.driver_name}")
    private String DRIVER;
    @Value("${datasource.url}")
    private String URL;
    @Value("${datasource.username}")
    private String USERNAME;
    @Value("${datasource.password}")
    private String PASSWORD;
    @Value("${hibernate.showSql}")
    private String SHOW_SQL;
    @Value("${hibernate.formatSql}")
    private String FORMAT_SQL;
    @Value("${hibernate.dialect}")
    private String DIALECT;
    
    @Value("${hibernate.ddl}")
    private String DDL;
    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

	@Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", DIALECT);
        hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
        hibernateProperties.put("hibernate.format_sql", FORMAT_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto", DDL);
        sessionFactory.setMappingLocations(loadResources());
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
    
    @Bean
    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean localSessionFactoryBean) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(localSessionFactoryBean.getObject());
        return transactionManager;
    }
    
    @Bean
    public CustomerDao customerDao() {
    	return new CustomerDaoImpl(sessionFactory().getObject());
    }

    @Bean
    public WalletDao walletDao() {
    	return new WalletDaoImpl(sessionFactory().getObject());
    }
    
    @Bean
    public TransactionDao transactionDao() {
    	return new TransactionDaoImpl(sessionFactory().getObject());
    }
    
    public Resource[] loadResources() {
        Resource[] resources = null;
        try {
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                    .getResources("classpath:/mappings/*.hbm.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resources;
    }
}
