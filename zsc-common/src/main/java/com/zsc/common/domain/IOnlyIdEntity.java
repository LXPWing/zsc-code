package com.zsc.common.domain;

import java.io.Serializable;

/**
 * @author : xingpeng
 * @date : 2021-12-10 23:07
 **/
public interface IOnlyIdEntity<T extends Serializable> {

    T getId();

    void setId(T id);
}
