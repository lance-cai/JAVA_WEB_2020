package com.lance.web_forum.dao;

import java.util.*;

public interface GenericBackendDao<T> {
	List<T> queryAll();
	List<T> queryWith(String attribute, String value);
	int update(T object);
	int create(T object, String sql);
	int delete(String id);
}
