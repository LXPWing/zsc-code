package com.zsc.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author : xingpeng
 * @date : 2021-12-10 23:17
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity extends BaseIdEntity{
    /// 创建时间
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime created;

    /// 修改时间
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime moditime;
}
