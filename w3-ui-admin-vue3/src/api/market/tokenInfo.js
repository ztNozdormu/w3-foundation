import request from '@/utils/request'

// 创建TOKEN基本信息
export function createTokenInfo(data) {
  return request({
    url: '/mk/token-info/create',
    method: 'post',
    data: data
  })
}

// 更新TOKEN基本信息
export function updateTokenInfo(data) {
  return request({
    url: '/mk/token-info/update',
    method: 'put',
    data: data
  })
}

// 删除TOKEN基本信息
export function deleteTokenInfo(id) {
  return request({
    url: '/mk/token-info/delete?id=' + id,
    method: 'delete'
  })
}

// 获得TOKEN基本信息
export function getTokenInfo(id) {
  return request({
    url: '/mk/token-info/get?id=' + id,
    method: 'get'
  })
}

// 获得TOKEN基本信息分页
export function getTokenInfoPage(query) {
  return request({
    url: '/mk/token-info/page',
    method: 'get',
    params: query
  })
}

// 导出TOKEN基本信息 Excel
export function exportTokenInfoExcel(query) {
  return request({
    url: '/mk/token-info/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
