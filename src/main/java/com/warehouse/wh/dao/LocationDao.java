package com.warehouse.wh.dao;

import com.warehouse.wh.Entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends CrudRepository<Location, Long> {


}