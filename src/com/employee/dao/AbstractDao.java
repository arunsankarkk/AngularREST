package com.employee.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.record.Employee;

public abstract class AbstractDao<PK extends Serializable, T> {
    
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
    	Session session = null;
    	try {
    		session = sessionFactory.getCurrentSession();
    	} catch (Exception e) {
    		session = sessionFactory.openSession();
    	}
        return session;
    }
 
    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    
    public void saveRecord(Employee entity) {
        getSession().save(entity);
    }
    
    public Serializable save(T entity) {
        return getSession().save(entity);
    }
    
    public void saveAllRecord(List<Employee> empList) {
        for(Employee employee  : empList){
        	getSession().save(employee);
        }
    }
    
    public void update(Employee entity) {
        getSession().update(entity);
    }
    
    public List<Employee> getAll() {
    	Criteria criteria = getSession().createCriteria(Employee.class);
    	List<Employee> employee = (List<Employee>) criteria.list();
         return employee;
    }
 
    public void delete(Integer id) {
    	Query query = getSession().createQuery("delete Employee where id = :ID");
    	query.setParameter("ID", id);
    	 
    	int result = query.executeUpdate();
    }
     
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
    
    public Employee find(Integer id){
    	Employee employee = (Employee) getSession().get(Employee.class, id);
    	return employee;
    }
    
 
}
