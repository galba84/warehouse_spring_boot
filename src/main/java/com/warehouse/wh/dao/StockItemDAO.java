package com.warehouse.wh.dao;

import com.warehouse.wh.Entity.StockItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockItemDAO extends CrudRepository<StockItem, Long> {

}