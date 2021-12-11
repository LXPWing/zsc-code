package com.zsc.generator.service;

import com.zsc.generator.domain.GenTableColumn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author : xingpeng
 * @date : 2021-12-11 11:20
 **/
@Service
public class GenTableServiceImpl implements IGenTableService{

    @Override
    public List<GenTableColumn> seletGenTableColumById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteGenTableByIds(Long[] ids) {

    }

    @Override
    public Map<String, String> previewCode(Long id) {
        return null;
    }
}
