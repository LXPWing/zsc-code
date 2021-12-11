package com.zsc.generator.repository;

import com.zsc.generator.domain.GenTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : xingpeng
 * @date : 2021-12-11 11:49
 **/
@Repository
public interface GenTableRepository extends JpaRepository<GenTable, Long> {
    
}
