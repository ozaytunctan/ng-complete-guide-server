package com.ozaytunctan.repository.spec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozaytunctan.model.ShoppingCartItem;

@Repository
public interface ShoppingCartItemRepository
		extends JpaRepository<ShoppingCartItem, Long>, ExtendedQuerydslPredicateExecutor<ShoppingCartItem> {

}
