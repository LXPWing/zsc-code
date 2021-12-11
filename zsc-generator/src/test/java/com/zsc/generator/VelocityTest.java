package com.zsc.generator;

import com.zsc.generator.domain.GenTable;
import com.zsc.generator.domain.GenTableColumn;
import com.zsc.generator.utils.VelocityInitializer;
import com.zsc.generator.utils.VelocityUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : xingpeng
 * @date : 2021-12-09 20:34
 **/
@RunWith(MockitoJUnitRunner.class)
public class VelocityTest {

    @Test
    public void testVelocity() throws FileNotFoundException {
        Map<String, String> dataMap = new LinkedHashMap<>();
        List ls = new ArrayList();
        GenTableColumn tableColumn = new GenTableColumn();
        GenTable table = new GenTable();
        table.setClassName("Test");
        table.setModuleName("sys");
        table.setPackageName("cmm.test");

        VelocityInitializer.initVelocity();
        VelocityContext context = VelocityUtils.prepareContext(table);
        List<String> templates = VelocityUtils.getTemplateList();

        for (String template : templates) {
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context,sw);
            dataMap.put(template, sw.toString());

        }
        System.out.println(dataMap.values());
    }
}
