import request from '@/config/axios'

export interface TokenInfoVO {
  id: number
  baseCcy: string
  ctMult: string
  listDate: Date
  ctVal: string
  ctValCcy: string
  expDate: Date
  instFamily: string
  instId: string
  instType: string
  lever: string
  lotSz: string
  maxIcebergSz: string
  maxLmtSz: string
  maxMktSz: string
  maxStopSz: string
  maxTriggerSz: string
  maxTwapSz: string
  minSz: string
  optType: string
  quoteCcy: string
  settleCcy: string
  state: string
  stk: string
  tickSz: string
  uly: string
  exchangeType: byte
}

// 查询TOKEN基本信息列表
export const getTokenInfoPage = async (params) => {
  return await request.get({ url: `/market/token-info/page`, params })
}

// 查询TOKEN基本信息详情
export const getTokenInfo = async (id: number) => {
  return await request.get({ url: `/market/token-info/get?id=` + id })
}

// 新增TOKEN基本信息
export const createTokenInfo = async (data: TokenInfoVO) => {
  return await request.post({ url: `/market/token-info/create`, data })
}

// 修改TOKEN基本信息
export const updateTokenInfo = async (data: TokenInfoVO) => {
  return await request.put({ url: `/market/token-info/update`, data })
}

// 删除TOKEN基本信息
export const deleteTokenInfo = async (id: number) => {
  return await request.delete({ url: `/market/token-info/delete?id=` + id })
}

// 导出TOKEN基本信息 Excel
export const exportTokenInfo = async (params) => {
  return await request.download({ url: `/market/token-info/export-excel`, params })
}
