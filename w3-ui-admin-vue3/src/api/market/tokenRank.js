import request from '@/utils/request'

// 创建TOKEN排名信息
export function createTokenRank(data) {
  return request({
    url: '/mk/token-rank/create',
    method: 'post',
    data: data
  })
}

// 更新TOKEN排名信息
export function updateTokenRank(data) {
  return request({
    url: '/mk/token-rank/update',
    method: 'put',
    data: data
  })
}

// 删除TOKEN排名信息
export function deleteTokenRank(id) {
  return request({
    url: '/mk/token-rank/delete?id=' + id,
    method: 'delete'
  })
}

// 获得TOKEN排名信息
export function getTokenRank(id) {
  return request({
    url: '/mk/token-rank/get?id=' + id,
    method: 'get'
  })
}

// 获得TOKEN排名信息分页
export function getTokenRankPage(query) {
  return request({
    url: '/mk/token-rank/page',
    method: 'get',
    params: query
  })
}

// 导出TOKEN排名信息 Excel
export function exportTokenRankExcel(query) {
  return request({
    url: '/mk/token-rank/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
