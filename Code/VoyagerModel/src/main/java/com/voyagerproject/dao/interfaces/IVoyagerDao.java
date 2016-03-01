package com.voyagerproject.dao.interfaces;

public interface IVoyagerDao<T> {
	
	public void persist(T transientInstance);
	public void remove(T transientInstance);
	public T merge(T transientInstance);
	public T findById(int id);

}
