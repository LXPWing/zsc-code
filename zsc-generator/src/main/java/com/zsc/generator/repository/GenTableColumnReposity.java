package com.zsc.generator.repository;

import com.zsc.generator.domain.GenTableColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : xingpeng
 * @date : 2021-12-11 11:50
 **/
@Repository
public interface GenTableColumnReposity extends JpaRepository<GenTableColumn, Long> {
    void deleteByTableId(Long id);
}
