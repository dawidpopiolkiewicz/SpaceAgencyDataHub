package com.spaceagencydatahub.service;

import java.util.List;

public interface GenericService<T> {

	List<T> getAll();

	void save(T t);

	T getOne(int id);

	void delete(int id);
}
