package com.zsc.generator.controller;

import com.zsc.common.domain.ApiResult;
import com.zsc.common.domain.DataApiResult;
import com.zsc.common.domain.TableDataInfo;
import com.zsc.generator.domain.GenTable;
import com.zsc.generator.service.IGenTableColumnService;
import com.zsc.generator.service.IGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : xingpeng
 * @date : 2021-12-09 20:28
 **/
@RestController
@RequestMapping("/zsc/gen")
public class GenController {

    @Autowired
    private IGenTableColumnService iGenTableColumnService;

    @Autowired
    private IGenTableService iGenTableService;

//    @GetMapping("/db/list")
//    public TableDataInfo dataList(GenTable genTable) {
//
//    }

    /**
     * 保存GenTable
     * @param genTable
     * @return
     */
    @PutMapping("/db/save")
    public DataApiResult<GenTable> dataSave(GenTable genTable) {
        var re = iGenTableService.saveGenTable(genTable);
        return DataApiResult.success(re);
    }

    /**
     * 删除GenTable
     * @param ids
     * @return
     */
    @DeleteMapping("")
    public ApiResult deleteGenTable(List<Long> ids){
        iGenTableService.deleteGenTableByIds(ids);
        return DataApiResult.successResult();
    }

    /**
     * 更新GenTable
     * @param genTable
     * @return
     */
    @PutMapping("/db/update")
    public DataApiResult<GenTable> updateGenTable(GenTable genTable) {
        var re = iGenTableService.updateGenTable(genTable);
        return DataApiResult.success(re);
    }

}
