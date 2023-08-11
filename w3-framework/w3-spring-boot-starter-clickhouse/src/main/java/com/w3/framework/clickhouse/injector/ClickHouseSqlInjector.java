package com.w3.framework.clickhouse.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.w3.framework.clickhouse.injector.enums.SqlMethodDiv;
import com.w3.framework.clickhouse.injector.methods.DeleteClickHouse;
import com.w3.framework.clickhouse.injector.methods.UpdateByIdClickHouse;
import com.w3.framework.clickhouse.injector.methods.UpdateClickHouse;


import java.util.List;

/**
 * 注册方法
 *
 * @author liuxiansong
 */
public class ClickHouseSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        /**
         * 这里很重要，先要通过父类方法，获取到原有的集合，不然会自带的通用方法会失效的
         */
        List<AbstractMethod> methodList = super.getMethodList(mapperClass,tableInfo);
        /***
         * 添加自定义方法类
         */
        methodList.add(new UpdateByIdClickHouse(SqlMethodDiv.UPDATE_BY_ID.getMethod()));
        methodList.add(new UpdateClickHouse(SqlMethodDiv.UPDATE.getMethod()));
        methodList.add(new DeleteClickHouse(SqlMethodDiv.DELETE_BY_ID.getMethod()));
        return methodList;
    }
}
