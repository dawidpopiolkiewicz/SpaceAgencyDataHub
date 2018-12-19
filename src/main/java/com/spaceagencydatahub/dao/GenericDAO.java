package com.spaceagencydatahub.dao;

import java.util.List;

public interface GenericDAO<T> {

	List<T> getAll();

	T save(T t);

	T getSingle(int id);

	void delete(int id);

}
