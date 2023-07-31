package com.knd.module.infra.single.controller.admin.codegen.vo;

import cn.hutool.core.util.ObjectUtil;
import com.knd.framework.codegen.enums.CodegenSceneEnum;
import com.knd.module.infra.single.controller.admin.codegen.vo.column.CodegenColumnBaseVO;
import com.knd.module.infra.single.controller.admin.codegen.vo.table.CodegenTableBaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 管理后台 - 代码生成表和字段的修改 Request VO
 */
@Data
public class CodegenUpdateReqVO {

    @Valid // 校验内嵌的字段
    @NotNull(message = "表定义不能为空")
    private Table table;

    @Valid // 校验内嵌的字段
    @NotNull(message = "字段定义不能为空")
    private List<Column> columns;

    /**
     * 更新表定义
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @Valid
    public static class Table extends CodegenTableBaseVO {

        /**
         * 编号 example = "1"
         */
        private Long id;

        @AssertTrue(message = "上级菜单不能为空，请前往 [修改生成配置 -> 生成信息] 界面，设置“上级菜单”字段")
        public boolean isParentMenuIdValid() {
            // 生成场景为管理后台时，必须设置上级菜单，不然生成的菜单 SQL 是无父级菜单的
            return ObjectUtil.notEqual(getScene(), CodegenSceneEnum.ADMIN.getScene())
                    || getParentMenuId() != null;
        }

    }

    /**
     * 更新表定义
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class Column extends CodegenColumnBaseVO {

        /**
         * 编号 example = "1"
         */
        private Long id;

    }

}
