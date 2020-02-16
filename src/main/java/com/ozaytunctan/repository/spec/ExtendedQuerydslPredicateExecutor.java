package com.ozaytunctan.repository.spec;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.querydsl.core.types.Predicate;

public interface ExtendedQuerydslPredicateExecutor<T> extends QuerydslPredicateExecutor<T> {
	
	@Override
	List<T> findAll(Predicate predicate);

	@Override
	List<T> findAll(Predicate predicate, Sort sort);
	
	@Override
	Page<T> findAll(Predicate predicate, Pageable pageable);

	@Override
	long count(Predicate predicate);


}
