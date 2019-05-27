package springmvchibernatedemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author chiennghe
 */
@Configuration
public class RdbConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springhibernatedemodb");
        dataSource.setUsername("codertiensinh");
        dataSource.setPassword("codersontrang");

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean lsf = new LocalSessionFactoryBean();
        lsf.setDataSource(dataSource());
        lsf.getHibernateProperties().setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        lsf.getHibernateProperties().setProperty("hibernate.show_sql", "true");
        lsf.setMappingResources("hibernate/Batch.hbm.xml", "hibernate/Student.hbm.xml");

        return lsf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return transactionManager;
    }
}
