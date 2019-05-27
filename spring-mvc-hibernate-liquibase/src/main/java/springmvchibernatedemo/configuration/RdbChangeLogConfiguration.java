package springmvchibernatedemo.configuration;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author chiennghe
 */
@Configuration
public class RdbChangeLogConfiguration{
    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase() throws LiquibaseException {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:/liquibase/liquibase-changelog-master.xml");
        return liquibase;
    }

}
