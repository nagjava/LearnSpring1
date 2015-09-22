package com.spring.mvc.dao.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.base.BaseHibernateDao;
import com.spring.mvc.bean.User;
import com.spring.mvc.dao.UserDao;

@Repository
public class UserDaoImpl extends BaseHibernateDao implements UserDao {
	
	private  Logger logger =Logger.getLogger(UserDaoImpl.class);
	@Override
	public List getAll() {
		return (List) sessionFactory.getCurrentSession().createQuery(
				"from User").list();
	}

	@Override
	public void save(User user) {
		System.out.println("====" + user.getUsername());
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean login(User user) {
		System.out.println("from User where username=" + user.getUsername()
				+ " and password=" + user.getPassword());
		Query query=sessionFactory.getCurrentSession().createQuery("from User where username=:username and password=:password");
		query.setString("username", user.getUsername());
		query.setString("password", user.getPassword());
		if (query.list().size()>0) 
			return true;
		return false;

	}

	@Override
	public void delete(int id) {
			Session session=sessionFactory.getCurrentSession();
			User user=(User)session.createQuery("from User where id="+id).uniqueResult();
			session.delete(user);
			session.flush();
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);		//无法删除对象
	}

}
