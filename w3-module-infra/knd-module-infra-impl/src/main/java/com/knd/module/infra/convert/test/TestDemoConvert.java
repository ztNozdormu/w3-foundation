package com.knd.module.infra.convert.test;


import com.knd.framework.common.pojo.PageResult;
import com.knd.module.infra.api.dal.dataobject.test.TestDemoDO;
import com.knd.module.infra.controller.admin.test.vo.TestDemoCreateReqVO;
import com.knd.module.infra.controller.admin.test.vo.TestDemoExcelVO;
import com.knd.module.infra.controller.admin.test.vo.TestDemoRespVO;
import com.knd.module.infra.controller.admin.test.vo.TestDemoUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 字典类型 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TestDemoConvert {

    TestDemoConvert INSTANCE = Mappers.getMapper(TestDemoConvert.class);

    TestDemoDO convert(TestDemoCreateReqVO bean);

    TestDemoDO convert(TestDemoUpdateReqVO bean);

    TestDemoRespVO convert(TestDemoDO bean);

    List<TestDemoRespVO> convertList(List<TestDemoDO> list);

    PageResult<TestDemoRespVO> convertPage(PageResult<TestDemoDO> page);

    List<TestDemoExcelVO> convertList02(List<TestDemoDO> list);

}
