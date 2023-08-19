<template>
  <ContentWrap>
    <!-- 搜索工作栏 -->
    <el-form
      class="-mb-15px"
      :model="queryParams"
      ref="queryFormRef"
      :inline="true"
      label-width="68px"
    >
      <el-form-item label="交易货币币种" prop="baseCcy">
        <el-input
          v-model="queryParams.baseCcy"
          placeholder="请输入交易货币币种"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="合约乘数" prop="ctMult">
        <el-input
          v-model="queryParams.ctMult"
          placeholder="请输入合约乘数"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="上线日期" prop="listDate">
        <el-date-picker
          v-model="queryParams.listDate"
          value-format="YYYY-MM-DD HH:mm:ss"
          type="daterange"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :default-time="[new Date('1 00:00:00'), new Date('1 23:59:59')]"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="合约面值" prop="ctVal">
        <el-input
          v-model="queryParams.ctVal"
          placeholder="请输入合约面值"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="合约面值计价币种" prop="ctValCcy">
        <el-input
          v-model="queryParams.ctValCcy"
          placeholder="请输入合约面值计价币种，仅适用于交割/永续/期权"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="交割/行权日期" prop="expDate">
        <el-date-picker
          v-model="queryParams.expDate"
          value-format="YYYY-MM-DD HH:mm:ss"
          type="daterange"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :default-time="[new Date('1 00:00:00'), new Date('1 23:59:59')]"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="交易品种" prop="instFamily">
        <el-input
          v-model="queryParams.instFamily"
          placeholder="请输入交易品种"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="产品id" prop="instId">
        <el-input
          v-model="queryParams.instId"
          placeholder="请输入产品id"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="产品类型">
        <el-select
          v-model="queryParams.instType"
          placeholder="请选择产品类型"
          clearable
          class="!w-240px"
        >
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="该instId支持的最大杠杆倍" prop="lever">
        <el-input
          v-model="queryParams.lever"
          placeholder="请输入该instId支持的最大杠杆倍"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="下单数量精度" prop="lotSz">
        <el-input
          v-model="queryParams.lotSz"
          placeholder="请输入下单数量精度"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="冰山委托最大数量" prop="maxIcebergSz">
        <el-input
          v-model="queryParams.maxIcebergSz"
          placeholder="请输入合约或现货冰山委托的单笔最大委托数量"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="最大限制数量" prop="maxLmtSz">
        <el-input
          v-model="queryParams.maxLmtSz"
          placeholder="请输入最大限制数量"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="市价单委托数量" prop="maxMktSz">
        <el-input
          v-model="queryParams.maxMktSz"
          placeholder="请输入合约或现货市价单的单笔最大委托数量"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="止盈止损委托数量" prop="maxStopSz">
        <el-input
          v-model="queryParams.maxStopSz"
          placeholder="请输入合约或现货止盈止损委托的单笔最大委托数量"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="计划委托数量" prop="maxTriggerSz">
        <el-input
          v-model="queryParams.maxTriggerSz"
          placeholder="请输入合约或现货计划委托委托的单笔最大委托数量"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="时间加权单委托数量" prop="maxTwapSz">
        <el-input
          v-model="queryParams.maxTwapSz"
          placeholder="请输入合约或现货时间加权单的单笔最大委托数量"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="最小下单数量" prop="minSz">
        <el-input
          v-model="queryParams.minSz"
          placeholder="请输入最小下单数量"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="期权类型" prop="optType">
        <el-select
          v-model="queryParams.optType"
          placeholder="请选择期权类型C或P仅适用于期权"
          clearable
          class="!w-240px"
        >
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="计价货币币种" prop="quoteCcy">
        <el-input
          v-model="queryParams.quoteCcy"
          placeholder="请输入计价货币币种，如BTC-USDT中的USDT ，仅适用于币币/币币杠杆"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="结算保证金币种" prop="settleCcy">
        <el-input
          v-model="queryParams.settleCcy"
          placeholder="请输入盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="产品状态" prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入产品状态live：交易中suspend：暂停中 preopen：预上线test：测试中（测试产品，不可交易）当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="行权价格" prop="stk">
        <el-input
          v-model="queryParams.stk"
          placeholder="请输入行权价格，仅适用于期权"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="下单价格精度" prop="tickSz">
        <el-input
          v-model="queryParams.tickSz"
          placeholder="请输入下单价格精度，如 0.0001"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="标的指数" prop="uly">
        <el-input
          v-model="queryParams.uly"
          placeholder="请输入标的指数，如 BTC-USD，仅适用于交割/永续/期权"
          clearable
          @keyup.enter="handleQuery"
          class="!w-240px"
        />
      </el-form-item>
      <el-form-item label="交易所类型" prop="exchangeType">
        <el-select
          v-model="queryParams.exchangeType"
          placeholder="请选择交易所类型1 币安交易所2 欧易交易所3 芝麻开门交易所"
          clearable
          class="!w-240px"
        >
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button @click="handleQuery"><Icon icon="ep:search" class="mr-5px" /> 搜索</el-button>
        <el-button @click="resetQuery"><Icon icon="ep:refresh" class="mr-5px" /> 重置</el-button>
        <el-button
          type="primary"
          plain
          @click="openForm('create')"
          v-hasPermi="['market:token-info:create']"
        >
          <Icon icon="ep:plus" class="mr-5px" /> 新增
        </el-button>
        <el-button
          type="success"
          plain
          @click="handleExport"
          :loading="exportLoading"
          v-hasPermi="['market:token-info:export']"
        >
          <Icon icon="ep:download" class="mr-5px" /> 导出
        </el-button>
      </el-form-item>
    </el-form>
  </ContentWrap>

  <!-- 列表 -->
  <ContentWrap>
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="交易货币币种" align="center" prop="baseCcy" />
      <el-table-column label="合约乘数" align="center" prop="ctMult" />
      <el-table-column label="上线日期" align="center" prop="deploymentTime" width="180" :formatter="dateFormatter" />
      <el-table-column label="合约面值" align="center" prop="ctVal" />
      <el-table-column label="合约面值计价币种" align="center" prop="ctValCcy" />
      <el-table-column
        label="交割/行权日期"
        align="center"
        prop="expDate"
        :formatter="dateFormatter"
      <el-table-column label="交易品种" align="center" prop="instFamily" />
      <el-table-column label="产品id" align="center" prop="instId" />
      <el-table-column label=" 产品类型" align="center" prop="instType" />
      <el-table-column label="该instId支持的最大杠杆倍" align="center" prop="lever" />
      <el-table-column label="下单数量精度" align="center" prop="lotSz" />
      <el-table-column label="冰山委托委托数量" align="center" prop="maxIcebergSz" />
      <el-table-column label="最大限制数量" align="center" prop="maxLmtSz" />
      <el-table-column label="市价单委托数量" align="center" prop="maxMktSz" />
      <el-table-column label="止盈止损委托数量" align="center" prop="maxStopSz" />
      <el-table-column label="计划委托数量" align="center" prop="maxTriggerSz" />
      <el-table-column label="时间加权单委托数量" align="center" prop="maxTwapSz" />
      <el-table-column label="最小下单数量" align="center" prop="minSz" />
      <el-table-column label="期权类型" align="center" prop="optType" />
      <el-table-column label="计价货币币种" align="center" prop="quoteCcy" />
      <el-table-column label="盈亏结算和保证金币种" align="center" prop="settleCcy" />
      <el-table-column label="产品状态" align="center" prop="state" />
      <el-table-column label="行权价格" align="center" prop="stk" />
      <el-table-column label="下单价格精度" align="center" prop="tickSz" />
      <el-table-column label="标的指数" align="center" prop="uly" />
      <el-table-column label="交易所类型" align="center" prop="exchangeType" />
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button
            link
            type="primary"
            @click="openForm('update', scope.row.id)"
            v-hasPermi="['market:token-info:update']"
          >
            编辑
          </el-button>
          <el-button
            link
            type="danger"
            @click="handleDelete(scope.row.id)"
            v-hasPermi="['market:token-info:delete']"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <Pagination
      :total="total"
      v-model:page="queryParams.pageNo"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />
  </ContentWrap>

  <!-- 表单弹窗：添加/修改 -->
  <TokenInfoForm ref="formRef" @success="getList" />
</template>

<script setup lang="ts" name="TokenInfo">
import { dateFormatter } from '@/utils/formatTime'
import download from '@/utils/download'
import * as TokenInfoApi from '@/api/market/tokenInfo'
import TokenInfoForm from './TokenInfoForm.vue'
const message = useMessage() // 消息弹窗
const { t } = useI18n() // 国际化

const loading = ref(true) // 列表的加载中
const total = ref(0) // 列表的总页数
const list = ref([]) // 列表的数据
const queryParams = reactive({
  pageNo: 1,
  pageSize: 10,
  baseCcy: null,
  ctMult: null,
  listDate: [],
  ctVal: null,
  ctValCcy: null,
  expDate: [],
  instFamily: null,
  instId: null,
  instType: null,
  lever: null,
  lotSz: null,
  maxIcebergSz: null,
  maxLmtSz: null,
  maxMktSz: null,
  maxStopSz: null,
  maxTriggerSz: null,
  maxTwapSz: null,
  minSz: null,
  optType: null,
  quoteCcy: null,
  settleCcy: null,
  state: null,
  stk: null,
  tickSz: null,
  uly: null,
  exchangeType: null
})
const queryFormRef = ref() // 搜索的表单
const exportLoading = ref(false) // 导出的加载中

/** 查询列表 */
const getList = async () => {
  loading.value = true
  try {
    const data = await TokenInfoApi.getTokenInfoPage(queryParams)
    list.value = data.list
    total.value = data.total
  } finally {
    loading.value = false
  }
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.pageNo = 1
  getList()
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value.resetFields()
  handleQuery()
}

/** 添加/修改操作 */
const formRef = ref()
const openForm = (type: string, id?: number) => {
  formRef.value.open(type, id)
}

/** 删除按钮操作 */
const handleDelete = async (id: number) => {
  try {
    // 删除的二次确认
    await message.delConfirm()
    // 发起删除
    await TokenInfoApi.deleteTokenInfo(id)
    message.success(t('common.delSuccess'))
    // 刷新列表
    await getList()
  } catch {}
}

/** 导出按钮操作 */
const handleExport = async () => {
  try {
    // 导出的二次确认
    await message.exportConfirm()
    // 发起导出
    exportLoading.value = true
    const data = await TokenInfoApi.exportTokenInfo(queryParams)
    download.excel(data, 'TOKEN基本信息.xls')
  } catch {
  } finally {
    exportLoading.value = false
  }
}

/** 初始化 **/
onMounted(() => {
  getList()
})
</script>
