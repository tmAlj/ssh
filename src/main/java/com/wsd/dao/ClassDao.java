package com.wsd.dao;

import com.wsd.model.Clazz;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tm on 2018/7/23.
 * 班级dao
 */
@Repository
public interface ClassDao extends PagingAndSortingRepository<Clazz,Integer> {
}
