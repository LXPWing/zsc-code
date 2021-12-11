package com.zsc.common.domain;

/**
 * @author : xingpeng
 * @date : 2021-12-11 16:53
 **/
public interface IBaseQueryBean {
    
    /** 排序条件 +/-字段名,+号表示升序 */
    public String[] getSorts();
}
