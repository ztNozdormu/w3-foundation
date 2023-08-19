<template>
  <Dialog :title="dialogTitle" v-model="dialogVisible">
    <el-form
      ref="formRef"
      :model="formData"
      :rules="formRules"
      label-width="100px"
      v-loading="formLoading"
    >
      <el-form-item label="交易货币币种" prop="baseCcy">
        <el-input v-model="formData.baseCcy" placeholder="请输入交易货币币种" />
      </el-form-item>
      <el-form-item label="合约乘数" prop="ctMult">
        <el-input v-model="formData.ctMult" placeholder="请输入合约乘数" />
      </el-form-item>
      <el-form-item label="上线日期" prop="listDate">
        <el-date-picker
          v-model="formData.listDate"
          type="date"
          value-format="x"
          placeholder="选择上线日期"
        />
      </el-form-item>
      <el-form-item label="合约面值" prop="ctVal">
        <el-input v-model="formData.ctVal" placeholder="请输入合约面值" />
      </el-form-item>
      <el-form-item label="合约面值计价币种" prop="ctValCcy">
        <el-input v-model="formData.ctValCcy" placeholder="请输入合约面值计价币种，仅适用于交割/永续/期权" />
      </el-form-item>
      <el-form-item label="交割/行权日期" prop="expDate">
        <el-date-picker
          v-model="formData.expDate"
          type="date"
          value-format="x"
          placeholder="选择交割/行权日期"
        />
      </el-form-item>
      <el-form-item label="交易品种" prop="instFamily">
        <el-input v-model="formData.instFamily" placeholder="请输入交易品种" />
      </el-form-item>
      <el-form-item label="产品id" prop="instId">
        <el-input v-model="formData.instId" placeholder="请输入产品id" />
      </el-form-item>
      <el-form-item label=" 产品类型" prop="instType">
        <el-select v-model="formData.instType" placeholder="请选择产品类型币币">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="该instId支持的最大杠杆倍" prop="lever">
        <el-input v-model="formData.lever" placeholder="请输入该instId支持的最大杠杆倍" />
      </el-form-item>
      <el-form-item label="下单数量精度" prop="lotSz">
        <el-input v-model="formData.lotSz" placeholder="请输入下单数量精度" />
      </el-form-item>
      <el-form-item label="合约或现货冰山委托的单笔最大委托数量" prop="maxIcebergSz">
        <el-input v-model="formData.maxIcebergSz" placeholder="请输入合约或现货冰山委托的单笔最大委托数量" />
      </el-form-item>
      <el-form-item label="最大限制数量" prop="maxLmtSz">
        <el-input v-model="formData.maxLmtSz" placeholder="请输入最大限制数量" />
      </el-form-item>
      <el-form-item label="合约或现货市价单的单笔最大委托数量" prop="maxMktSz">
        <el-input v-model="formData.maxMktSz" placeholder="请输入合约或现货市价单的单笔最大委托数量" />
      </el-form-item>
      <el-form-item label="合约或现货止盈止损委托的单笔最大委托数量" prop="maxStopSz">
        <el-input v-model="formData.maxStopSz" placeholder="请输入合约或现货止盈止损委托的单笔最大委托数量" />
      </el-form-item>
      <el-form-item label="合约或现货计划委托委托的单笔最大委托数量" prop="maxTriggerSz">
        <el-input v-model="formData.maxTriggerSz" placeholder="请输入合约或现货计划委托委托的单笔最大委托数量" />
      </el-form-item>
      <el-form-item label="合约或现货时间加权单的单笔最大委托数量" prop="maxTwapSz">
        <el-input v-model="formData.maxTwapSz" placeholder="请输入合约或现货时间加权单的单笔最大委托数量" />
      </el-form-item>
      <el-form-item label="最小下单数量" prop="minSz">
        <el-input v-model="formData.minSz" placeholder="请输入最小下单数量" />
      </el-form-item>
      <el-form-item label="期权类型" prop="optType">
        <el-select v-model="formData.optType" placeholder="请选择期权类型，C或P 仅适用于期权">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="计价货币币种" prop="quoteCcy">
        <el-input v-model="formData.quoteCcy" placeholder="请输入计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆" />
      </el-form-item>
      <el-form-item label="盈亏结算和保证金币种" prop="settleCcy">
        <el-input v-model="formData.settleCcy" placeholder="请输入盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权" />
      </el-form-item>
      <el-form-item label="产品状态" prop="state">
        <el-input v-model="formData.state" placeholder="请输入产品状态" />
      </el-form-item>
      <el-form-item label="行权价格" prop="stk">
        <el-input v-model="formData.stk" placeholder="请输入行权价格，仅适用于期权" />
      </el-form-item>
      <el-form-item label="下单价格精度" prop="tickSz">
        <el-input v-model="formData.tickSz" placeholder="请输入下单价格精度，如 0.0001" />
      </el-form-item>
      <el-form-item label="标的指数" prop="uly">
        <el-input v-model="formData.uly" placeholder="请输入标的指数，如 BTC-USD，仅适用于交割/永续/期权" />
      </el-form-item>
      <el-form-item label="交易所类型" prop="exchangeType">
        <el-select v-model="formData.exchangeType" placeholder="请选择交易所类型">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="submitForm" type="primary" :disabled="formLoading">确 定</el-button>
      <el-button @click="dialogVisible = false">取 消</el-button>
    </template>
  </Dialog>
</template>
<script setup lang="ts">
import * as TokenInfoApi from '@/api/market/tokenInfo'

const { t } = useI18n() // 国际化
const message = useMessage() // 消息弹窗

const dialogVisible = ref(false) // 弹窗的是否展示
const dialogTitle = ref('') // 弹窗的标题
const formLoading = ref(false) // 表单的加载中：1）修改时的数据加载；2）提交的按钮禁用
const formType = ref('') // 表单的类型：create - 新增；update - 修改
const formData = ref({
  id: undefined,
  baseCcy: undefined,
  ctMult: undefined,
  listDate: undefined,
  ctVal: undefined,
  ctValCcy: undefined,
  expDate: undefined,
  instFamily: undefined,
  instId: undefined,
  instType: undefined,
  lever: undefined,
  lotSz: undefined,
  maxIcebergSz: undefined,
  maxLmtSz: undefined,
  maxMktSz: undefined,
  maxStopSz: undefined,
  maxTriggerSz: undefined,
  maxTwapSz: undefined,
  minSz: undefined,
  optType: undefined,
  quoteCcy: undefined,
  settleCcy: undefined,
  state: undefined,
  stk: undefined,
  tickSz: undefined,
  uly: undefined,
  exchangeType: undefined
})
const formRules = reactive({
  exchangeType: [{ required: true, message: '交易所类型', trigger: 'change' }]
})
const formRef = ref() // 表单 Ref

/** 打开弹窗 */
const open = async (type: string, id?: number) => {
  dialogVisible.value = true
  dialogTitle.value = t('action.' + type)
  formType.value = type
  resetForm()
  // 修改时，设置数据
  if (id) {
    formLoading.value = true
    try {
      formData.value = await TokenInfoApi.getTokenInfo(id)
    } finally {
      formLoading.value = false
    }
  }
}
defineExpose({ open }) // 提供 open 方法，用于打开弹窗

/** 提交表单 */
const emit = defineEmits(['success']) // 定义 success 事件，用于操作成功后的回调
const submitForm = async () => {
  // 校验表单
  if (!formRef) return
  const valid = await formRef.value.validate()
  if (!valid) return
  // 提交请求
  formLoading.value = true
  try {
    const data = formData.value as unknown as TokenInfoApi.TokenInfoVO
    if (formType.value === 'create') {
      await TokenInfoApi.createTokenInfo(data)
      message.success(t('common.createSuccess'))
    } else {
      await TokenInfoApi.updateTokenInfo(data)
      message.success(t('common.updateSuccess'))
    }
    dialogVisible.value = false
    // 发送操作成功的事件
    emit('success')
  } finally {
    formLoading.value = false
  }
}

/** 重置表单 */
const resetForm = () => {
  formData.value = {
    id: undefined,
    baseCcy: undefined,
    ctMult: undefined,
    listDate: undefined,
    ctVal: undefined,
    ctValCcy: undefined,
    expDate: undefined,
    instFamily: undefined,
    instId: undefined,
    instType: undefined,
    lever: undefined,
    lotSz: undefined,
    maxIcebergSz: undefined,
    maxLmtSz: undefined,
    maxMktSz: undefined,
    maxStopSz: undefined,
    maxTriggerSz: undefined,
    maxTwapSz: undefined,
    minSz: undefined,
    optType: undefined,
    quoteCcy: undefined,
    settleCcy: undefined,
    state: undefined,
    stk: undefined,
    tickSz: undefined,
    uly: undefined,
    exchangeType: undefined
  }
  formRef.value?.resetFields()
}
</script>

