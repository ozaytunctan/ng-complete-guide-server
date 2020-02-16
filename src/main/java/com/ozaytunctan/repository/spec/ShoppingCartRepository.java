package com.ozaytunctan.repository.spec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozaytunctan.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository
		extends JpaRepository<ShoppingCart, Long>, ExtendedQuerydslPredicateExecutor<ShoppingCart> {

}
