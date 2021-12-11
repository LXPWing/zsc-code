package com.zsc.generator.repository;

import com.zsc.generator.domain.GenTableColumn;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : xingpeng
 * @date : 2021-12-11 11:50
 **/
public interface GenTableColumnReposity extends JpaRepository<GenTableColumn, Long> {
}
