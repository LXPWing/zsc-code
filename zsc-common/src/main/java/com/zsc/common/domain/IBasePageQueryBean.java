package com.zsc.common.domain;

/**
 * @author : xingpeng
 * @date : 2021-12-11 16:54
 **/
public interface IBasePageQueryBean {
    /** 查询当前的页码 */
    public int getPage();

    /** 返回每页的数据量 */
    public int getPageSize();
}
