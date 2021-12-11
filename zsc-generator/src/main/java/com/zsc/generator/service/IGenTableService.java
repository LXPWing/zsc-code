package com.zsc.generator.service;

import com.zsc.generator.domain.GenTableColumn;

import java.util.List;
import java.util.Map;

/**
 * @author : xingpeng
 * @date : 2021-12-11 11:19
 **/
public interface IGenTableService {

    /**
     * 通过表ID查询对应Colum
     * @param id
     * @return
     */
    List<GenTableColumn> seletGenTableColumById(Long id);

    /**
     * 根据ID删除Table
     * @param ids
     */
    public void deleteGenTableByIds(Long[] ids);

    /**
     * 预览代码
     * @param id
     * @return
     */
    public Map<String, String> previewCode(Long id);
}
