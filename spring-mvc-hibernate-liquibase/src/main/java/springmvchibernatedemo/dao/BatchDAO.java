package springmvchibernatedemo.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import springmvchibernatedemo.entity.Batch;

import java.util.List;

/**
 * @author chiennghe
 */
@Repository
public class BatchDAO extends HibernateDaoSupport{

    public BatchDAO(@Autowired SessionFactory sessionFactory){
        super();
        this.setSessionFactory(sessionFactory);
    }


    @SuppressWarnings("unchecked")
    public List<Batch> getBatchList() {
        String query = "from springmvchibernatedemo.entity.Batch";

        List<?> result =  getHibernateTemplate().find(query);
        return (List<Batch>) result;
    }
}
