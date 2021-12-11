package com.zsc.generator.controller;

import com.zsc.common.domain.ApiResult;
import com.zsc.common.domain.DataApiResult;
import com.zsc.common.domain.TableDataInfo;
import com.zsc.generator.domain.GenTable;
import com.zsc.generator.service.IGenTableColumnService;
import com.zsc.generator.service.IGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping("/db/save")
    public DataApiResult<GenTable> dataSave(GenTable genTable) {
        var re = iGenTableService.saveGenTableInfo(genTable);
        return DataApiResult.success(re);
    }
}
