package com.zsc.common.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : xingpeng
 * @date : 2021-12-11 16:55
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class BasePageQueryBean extends BaseQueryBean implements IBasePageQueryBean {
    /** 查询当前的页码 */
    private int page = 1;

    /** 返回每页的数据量 */
    private int pageSize = 10;
}
