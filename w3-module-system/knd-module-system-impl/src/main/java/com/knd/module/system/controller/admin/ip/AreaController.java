package com.knd.module.system.controller.admin.ip;

import cn.hutool.core.lang.Assert;
import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.ip.core.Area;
import com.knd.framework.ip.core.utils.AreaUtils;
import com.knd.framework.ip.core.utils.IPUtils;
import com.knd.module.system.controller.admin.ip.vo.AreaNodeRespVO;
import com.knd.module.system.convert.ip.AreaConvert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 地区
 */
@RestController
@RequestMapping("/system/area")
@Validated
public class AreaController {
    /**
     * 获得地区树
     * @return
     */
    @GetMapping("/tree")
    public CommonResult<List<AreaNodeRespVO>> getAreaTree() {
        Area area = AreaUtils.getArea(Area.ID_CHINA);
        Assert.notNull(area, "获取不到中国");
        return success(AreaConvert.INSTANCE.convertList(area.getChildren()));
    }

    /**
     * 获得 IP 对应的地区名
     * @param ip  description = "IP", required = true
     * @return
     */
    @GetMapping("/get-by-ip")
    public CommonResult<String> getAreaByIp(@RequestParam("ip") String ip) {
        // 获得城市
        Area area = IPUtils.getArea(ip);
        if (area == null) {
            return success("未知");
        }
        // 格式化返回
        return success(AreaUtils.format(area.getId()));
    }

}
