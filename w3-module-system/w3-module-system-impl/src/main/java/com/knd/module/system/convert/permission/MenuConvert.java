package com.w3.module.system.convert.permission;


import com.w3.module.system.controller.admin.permission.vo.menu.MenuCreateReqVO;
import com.w3.module.system.controller.admin.permission.vo.menu.MenuRespVO;
import com.w3.module.system.controller.admin.permission.vo.menu.MenuSimpleRespVO;
import com.w3.module.system.controller.admin.permission.vo.menu.MenuUpdateReqVO;
import com.w3.module.system.dal.dataobject.permission.MenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuConvert {

    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    List<MenuRespVO> convertList(List<MenuDO> list);

    MenuDO convert(MenuCreateReqVO bean);

    MenuDO convert(MenuUpdateReqVO bean);

    MenuRespVO convert(MenuDO bean);

    List<MenuSimpleRespVO> convertList02(List<MenuDO> list);

}
