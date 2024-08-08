package solid.interface_segregation.after.service;

import solid.interface_segregation.before.entity.Entity;

//common interface to be implemented by all persistence services. 
public interface PersistenceService<T extends Entity> {

	public void save(T entity);

	public void delete(T entity);

	public T findById(Long id);

	// we remove this method
	// public List<T> findByName(String name);
}
