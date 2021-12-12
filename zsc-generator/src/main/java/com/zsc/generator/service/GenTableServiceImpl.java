package com.zsc.generator.service;

import com.zsc.common.domain.ApiResult;
import com.zsc.generator.domain.GenTable;
import com.zsc.generator.domain.GenTableColumn;
import com.zsc.generator.repository.GenTableColumnReposity;
import com.zsc.generator.repository.GenTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @author : xingpeng
 * @date : 2021-12-11 11:20
 **/
@Service
public class GenTableServiceImpl implements IGenTableService{

    @Autowired
    private GenTableRepository genTableRepository;

    @Autowired
    private GenTableColumnReposity genTableColumnReposity;

    @Override
    public List<GenTableColumn> seletGenTableColumById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public ApiResult deleteGenTableByIds(List<Long> ids) {
        long delCount = 0;
        for (var id : ids) {
            genTableRepository.deleteById(id);
            genTableColumnReposity.deleteByTableId(id);
            delCount++;
        }
        Assert.isTrue(delCount == ids.size(), "删除数据失败");
        return ApiResult.successResult();
    }

    @Override
    public Map<String, String> previewCode(Long id) {
        return null;
    }

    @Override
    public GenTable saveGenTable(GenTable table) {
        GenTable genTable = genTableRepository.save(table);
        return genTable;
    }

    @Override
    public GenTable updateGenTable(GenTable table) {
        GenTable genTable = genTableRepository.save(table);
        return genTable;
    }
}
