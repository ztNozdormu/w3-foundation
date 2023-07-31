package com.knd.module.infra.service.logger;


import com.knd.framework.common.enums.UserTypeEnum;
import com.knd.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.test.core.ut.BaseDbUnitTest;
import com.knd.module.infra.api.dal.dataobject.logger.ApiAccessLogDO;
import com.knd.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import com.knd.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import com.knd.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import com.knd.module.infra.dal.mysql.logger.ApiAccessLogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.List;

import static com.knd.framework.common.util.date.LocalDateTimeUtils.buildBetweenTime;
import static com.knd.framework.common.util.date.LocalDateTimeUtils.buildTime;
import static com.knd.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static com.knd.framework.test.core.util.AssertUtils.assertPojoEquals;
import static com.knd.framework.test.core.util.RandomUtils.randomPojo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(ApiAccessLogServiceImpl.class)
public class ApiAccessLogServiceImplTest extends BaseDbUnitTest {

    @Resource
    private ApiAccessLogServiceImpl apiAccessLogService;

    @Resource
    private ApiAccessLogMapper apiAccessLogMapper;

    @Test
    public void testGetApiAccessLogPage() {
        ApiAccessLogDO apiAccessLogDO = randomPojo(ApiAccessLogDO.class, o -> {
            o.setUserId(2233L);
            o.setUserType(UserTypeEnum.ADMIN.getValue());
            o.setApplicationName("yudao-test");
            o.setRequestUrl("foo");
            o.setBeginTime(buildTime(2021, 3, 13));
            o.setDuration(1000);
            o.setResultCode(GlobalErrorCodeConstants.SUCCESS.getCode());
        });
        apiAccessLogMapper.insert(apiAccessLogDO);
        // 测试 userId 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setUserId(3344L)));
        // 测试 userType 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setUserType(UserTypeEnum.MEMBER.getValue())));
        // 测试 applicationName 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setApplicationName("test")));
        // 测试 requestUrl 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setRequestUrl("bar")));
        // 测试 beginTime 不匹配：构造一个早期时间 2021-02-06 00:00:00
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setBeginTime(buildTime(2021, 2, 6))));
        // 测试 duration 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setDuration(100)));
        // 测试 resultCode 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setResultCode(2)));
        // 准备参数
        ApiAccessLogPageReqVO reqVO = new ApiAccessLogPageReqVO();
        reqVO.setUserId(2233L);
        reqVO.setUserType(UserTypeEnum.ADMIN.getValue());
        reqVO.setApplicationName("yudao-test");
        reqVO.setRequestUrl("foo");
        reqVO.setBeginTime(buildBetweenTime(2021, 3, 13, 2021, 3, 13));
        reqVO.setDuration(1000);
        reqVO.setResultCode(GlobalErrorCodeConstants.SUCCESS.getCode());

        // 调用
        PageResult<ApiAccessLogDO> pageResult = apiAccessLogService.getApiAccessLogPage(reqVO);
        // 断言，只查到了一条符合条件的
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(apiAccessLogDO, pageResult.getList().get(0));
    }

    @Test
    public void testGetApiAccessLogList() {
        ApiAccessLogDO apiAccessLogDO = randomPojo(ApiAccessLogDO.class, o -> {
            o.setUserId(2233L);
            o.setUserType(UserTypeEnum.ADMIN.getValue());
            o.setApplicationName("yudao-test");
            o.setRequestUrl("foo");
            o.setBeginTime(buildTime(2021, 3, 13));
            o.setDuration(1000);
            o.setResultCode(GlobalErrorCodeConstants.SUCCESS.getCode());
        });
        apiAccessLogMapper.insert(apiAccessLogDO);
        // 测试 userId 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setUserId(3344L)));
        // 测试 userType 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setUserType(UserTypeEnum.MEMBER.getValue())));
        // 测试 applicationName 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setApplicationName("test")));
        // 测试 requestUrl 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setRequestUrl("bar")));
        // 测试 beginTime 不匹配：构造一个早期时间 2021-02-06 00:00:00
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setBeginTime(buildTime(2021, 2, 6))));
        // 测试 duration 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setDuration(100)));
        // 测试 resultCode 不匹配
        apiAccessLogMapper.insert(cloneIgnoreId(apiAccessLogDO, o -> o.setResultCode(2)));
        // 准备参数
        ApiAccessLogExportReqVO reqVO = new ApiAccessLogExportReqVO();
        reqVO.setUserId(2233L);
        reqVO.setUserType(UserTypeEnum.ADMIN.getValue());
        reqVO.setApplicationName("yudao-test");
        reqVO.setRequestUrl("foo");
        reqVO.setBeginTime(buildBetweenTime(2021, 3, 13, 2021, 3, 13));
        reqVO.setDuration(1000);
        reqVO.setResultCode(GlobalErrorCodeConstants.SUCCESS.getCode());

        // 调用
        List<ApiAccessLogDO> list = apiAccessLogService.getApiAccessLogList(reqVO);
        // 断言，只查到了一条符合条件的
        assertEquals(1, list.size());
        assertPojoEquals(apiAccessLogDO, list.get(0));
    }

    @Test
    public void testCreateApiAccessLog() {
        // 准备参数
        ApiAccessLogCreateReqDTO createDTO = randomPojo(ApiAccessLogCreateReqDTO.class);

        // 调用
        apiAccessLogService.createApiAccessLog(createDTO);
        // 断言
        ApiAccessLogDO apiAccessLogDO = apiAccessLogMapper.selectOne(null);
        assertPojoEquals(createDTO, apiAccessLogDO);
    }

}
