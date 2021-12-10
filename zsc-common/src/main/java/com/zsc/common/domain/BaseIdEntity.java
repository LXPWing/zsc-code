package com.zsc.common.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author : xingpeng
 * @date : 2021-12-10 23:09
 **/
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseIdEntity implements IOnlyIdEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
}
