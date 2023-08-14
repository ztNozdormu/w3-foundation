<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="交易货币币种" prop="baseCcy">
        <el-input v-model="queryParams.baseCcy" placeholder="请输入交易货币币种" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合约乘数，仅适用于交割/永续/期权" prop="ctMult">
        <el-input v-model="queryParams.ctMult" placeholder="请输入合约乘数，仅适用于交割/永续/期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="上线日期" prop="listDate">
        <el-date-picker v-model="queryParams.listDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="合约面值，仅适用于交割/永续/期权" prop="ctVal">
        <el-input v-model="queryParams.ctVal" placeholder="请输入合约面值，仅适用于交割/永续/期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合约面值计价币种，仅适用于交割/永续/期权" prop="ctValCcy">
        <el-input v-model="queryParams.ctValCcy" placeholder="请输入合约面值计价币种，仅适用于交割/永续/期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="交割/行权日期，仅适用于交割 和 期权" prop="expDate">
        <el-date-picker v-model="queryParams.expDate" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="交易品种，如 BTC-USD，仅适用于交割/永续/期权" prop="instFamily">
        <el-input v-model="queryParams.instFamily" placeholder="请输入交易品种，如 BTC-USD，仅适用于交割/永续/期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="产品id， 如 BTC-USD-SWAP" prop="instId">
        <el-input v-model="queryParams.instId" placeholder="请输入产品id， 如 BTC-USD-SWAP" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label=" 产品类型	      币币 SPOT	      币币杠杆 MARGIN	      永续合约 SWAP	      交割合约 FUTURES	      期权 OPTION	" prop="instType">
        <el-select v-model="queryParams.instType" placeholder="请选择 产品类型	      币币 SPOT	      币币杠杆 MARGIN	      永续合约 SWAP	      交割合约 FUTURES	      期权 OPTION	" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="该instId支持的最大杠杆倍数，不适用于币币、期权" prop="lever">
        <el-input v-model="queryParams.lever" placeholder="请输入该instId支持的最大杠杆倍数，不适用于币币、期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="下单数量精度，如 BTC-USDT-SWAP：1" prop="lotSz">
        <el-input v-model="queryParams.lotSz" placeholder="请输入下单数量精度，如 BTC-USDT-SWAP：1" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合约或现货冰山委托的单笔最大委托数量" prop="maxIcebergSz">
        <el-input v-model="queryParams.maxIcebergSz" placeholder="请输入合约或现货冰山委托的单笔最大委托数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="最大限制数量" prop="maxLmtSz">
        <el-input v-model="queryParams.maxLmtSz" placeholder="请输入最大限制数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合约或现货市价单的单笔最大委托数量" prop="maxMktSz">
        <el-input v-model="queryParams.maxMktSz" placeholder="请输入合约或现货市价单的单笔最大委托数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合约或现货止盈止损委托的单笔最大委托数量" prop="maxStopSz">
        <el-input v-model="queryParams.maxStopSz" placeholder="请输入合约或现货止盈止损委托的单笔最大委托数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合约或现货计划委托委托的单笔最大委托数量" prop="maxTriggerSz">
        <el-input v-model="queryParams.maxTriggerSz" placeholder="请输入合约或现货计划委托委托的单笔最大委托数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合约或现货时间加权单的单笔最大委托数量" prop="maxTwapSz">
        <el-input v-model="queryParams.maxTwapSz" placeholder="请输入合约或现货时间加权单的单笔最大委托数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="最小下单数量" prop="minSz">
        <el-input v-model="queryParams.minSz" placeholder="请输入最小下单数量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="期权类型，C或P 仅适用于期权" prop="optType">
        <el-select v-model="queryParams.optType" placeholder="请选择期权类型，C或P 仅适用于期权" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆" prop="quoteCcy">
        <el-input v-model="queryParams.quoteCcy" placeholder="请输入计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权" prop="settleCcy">
        <el-input v-model="queryParams.settleCcy" placeholder="请输入盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="/**	     * 产品状态	     * live：交易中	     * suspend：暂停中	     * preopen：预上线	     * test：测试中（测试产品，不可交易）	     * 当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）；	     * 当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品	     */" prop="state">
        <el-input v-model="queryParams.state" placeholder="请输入/**	     * 产品状态	     * live：交易中	     * suspend：暂停中	     * preopen：预上线	     * test：测试中（测试产品，不可交易）	     * 当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）；	     * 当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品	     */" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="行权价格，仅适用于期权" prop="stk">
        <el-input v-model="queryParams.stk" placeholder="请输入行权价格，仅适用于期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="下单价格精度，如 0.0001" prop="tickSz">
        <el-input v-model="queryParams.tickSz" placeholder="请输入下单价格精度，如 0.0001" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="标的指数，如 BTC-USD，仅适用于交割/永续/期权" prop="uly">
        <el-input v-model="queryParams.uly" placeholder="请输入标的指数，如 BTC-USD，仅适用于交割/永续/期权" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所" prop="exchangeType">
        <el-select v-model="queryParams.exchangeType" placeholder="请选择交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['mk:token-info:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['mk:token-info:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="交易货币币种" align="center" prop="baseCcy" />
      <el-table-column label="合约乘数，仅适用于交割/永续/期权" align="center" prop="ctMult" />
      <el-table-column label="上线日期" align="center" prop="listDate" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.listDate) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合约面值，仅适用于交割/永续/期权" align="center" prop="ctVal" />
      <el-table-column label="合约面值计价币种，仅适用于交割/永续/期权" align="center" prop="ctValCcy" />
      <el-table-column label="交割/行权日期，仅适用于交割 和 期权" align="center" prop="expDate" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.expDate) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="交易品种，如 BTC-USD，仅适用于交割/永续/期权" align="center" prop="instFamily" />
      <el-table-column label="产品id， 如 BTC-USD-SWAP" align="center" prop="instId" />
      <el-table-column label=" 产品类型	      币币 SPOT	      币币杠杆 MARGIN	      永续合约 SWAP	      交割合约 FUTURES	      期权 OPTION	" align="center" prop="instType" />
      <el-table-column label="该instId支持的最大杠杆倍数，不适用于币币、期权" align="center" prop="lever" />
      <el-table-column label="下单数量精度，如 BTC-USDT-SWAP：1" align="center" prop="lotSz" />
      <el-table-column label="合约或现货冰山委托的单笔最大委托数量" align="center" prop="maxIcebergSz" />
      <el-table-column label="最大限制数量" align="center" prop="maxLmtSz" />
      <el-table-column label="合约或现货市价单的单笔最大委托数量" align="center" prop="maxMktSz" />
      <el-table-column label="合约或现货止盈止损委托的单笔最大委托数量" align="center" prop="maxStopSz" />
      <el-table-column label="合约或现货计划委托委托的单笔最大委托数量" align="center" prop="maxTriggerSz" />
      <el-table-column label="合约或现货时间加权单的单笔最大委托数量" align="center" prop="maxTwapSz" />
      <el-table-column label="最小下单数量" align="center" prop="minSz" />
      <el-table-column label="期权类型，C或P 仅适用于期权" align="center" prop="optType" />
      <el-table-column label="计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆" align="center" prop="quoteCcy" />
      <el-table-column label="盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权" align="center" prop="settleCcy" />
      <el-table-column label="/**	     * 产品状态	     * live：交易中	     * suspend：暂停中	     * preopen：预上线	     * test：测试中（测试产品，不可交易）	     * 当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）；	     * 当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品	     */" align="center" prop="state" />
      <el-table-column label="行权价格，仅适用于期权" align="center" prop="stk" />
      <el-table-column label="下单价格精度，如 0.0001" align="center" prop="tickSz" />
      <el-table-column label="标的指数，如 BTC-USD，仅适用于交割/永续/期权" align="center" prop="uly" />
      <el-table-column label="交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所" align="center" prop="exchangeType" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['mk:token-info:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['mk:token-info:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="交易货币币种" prop="baseCcy">
          <el-input v-model="form.baseCcy" placeholder="请输入交易货币币种" />
        </el-form-item>
        <el-form-item label="合约乘数，仅适用于交割/永续/期权" prop="ctMult">
          <el-input v-model="form.ctMult" placeholder="请输入合约乘数，仅适用于交割/永续/期权" />
        </el-form-item>
        <el-form-item label="上线日期" prop="listDate">
          <el-date-picker clearable v-model="form.listDate" type="date" value-format="timestamp" placeholder="选择上线日期" />
        </el-form-item>
        <el-form-item label="合约面值，仅适用于交割/永续/期权" prop="ctVal">
          <el-input v-model="form.ctVal" placeholder="请输入合约面值，仅适用于交割/永续/期权" />
        </el-form-item>
        <el-form-item label="合约面值计价币种，仅适用于交割/永续/期权" prop="ctValCcy">
          <el-input v-model="form.ctValCcy" placeholder="请输入合约面值计价币种，仅适用于交割/永续/期权" />
        </el-form-item>
        <el-form-item label="交割/行权日期，仅适用于交割 和 期权" prop="expDate">
          <el-date-picker clearable v-model="form.expDate" type="date" value-format="timestamp" placeholder="选择交割/行权日期，仅适用于交割 和 期权" />
        </el-form-item>
        <el-form-item label="交易品种，如 BTC-USD，仅适用于交割/永续/期权" prop="instFamily">
          <el-input v-model="form.instFamily" placeholder="请输入交易品种，如 BTC-USD，仅适用于交割/永续/期权" />
        </el-form-item>
        <el-form-item label="产品id， 如 BTC-USD-SWAP" prop="instId">
          <el-input v-model="form.instId" placeholder="请输入产品id， 如 BTC-USD-SWAP" />
        </el-form-item>
        <el-form-item label=" 产品类型	      币币 SPOT	      币币杠杆 MARGIN	      永续合约 SWAP	      交割合约 FUTURES	      期权 OPTION	" prop="instType">
          <el-select v-model="form.instType" placeholder="请选择 产品类型	      币币 SPOT	      币币杠杆 MARGIN	      永续合约 SWAP	      交割合约 FUTURES	      期权 OPTION	">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="该instId支持的最大杠杆倍数，不适用于币币、期权" prop="lever">
          <el-input v-model="form.lever" placeholder="请输入该instId支持的最大杠杆倍数，不适用于币币、期权" />
        </el-form-item>
        <el-form-item label="下单数量精度，如 BTC-USDT-SWAP：1" prop="lotSz">
          <el-input v-model="form.lotSz" placeholder="请输入下单数量精度，如 BTC-USDT-SWAP：1" />
        </el-form-item>
        <el-form-item label="合约或现货冰山委托的单笔最大委托数量" prop="maxIcebergSz">
          <el-input v-model="form.maxIcebergSz" placeholder="请输入合约或现货冰山委托的单笔最大委托数量" />
        </el-form-item>
        <el-form-item label="最大限制数量" prop="maxLmtSz">
          <el-input v-model="form.maxLmtSz" placeholder="请输入最大限制数量" />
        </el-form-item>
        <el-form-item label="合约或现货市价单的单笔最大委托数量" prop="maxMktSz">
          <el-input v-model="form.maxMktSz" placeholder="请输入合约或现货市价单的单笔最大委托数量" />
        </el-form-item>
        <el-form-item label="合约或现货止盈止损委托的单笔最大委托数量" prop="maxStopSz">
          <el-input v-model="form.maxStopSz" placeholder="请输入合约或现货止盈止损委托的单笔最大委托数量" />
        </el-form-item>
        <el-form-item label="合约或现货计划委托委托的单笔最大委托数量" prop="maxTriggerSz">
          <el-input v-model="form.maxTriggerSz" placeholder="请输入合约或现货计划委托委托的单笔最大委托数量" />
        </el-form-item>
        <el-form-item label="合约或现货时间加权单的单笔最大委托数量" prop="maxTwapSz">
          <el-input v-model="form.maxTwapSz" placeholder="请输入合约或现货时间加权单的单笔最大委托数量" />
        </el-form-item>
        <el-form-item label="最小下单数量" prop="minSz">
          <el-input v-model="form.minSz" placeholder="请输入最小下单数量" />
        </el-form-item>
        <el-form-item label="期权类型，C或P 仅适用于期权" prop="optType">
          <el-select v-model="form.optType" placeholder="请选择期权类型，C或P 仅适用于期权">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆" prop="quoteCcy">
          <el-input v-model="form.quoteCcy" placeholder="请输入计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆" />
        </el-form-item>
        <el-form-item label="盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权" prop="settleCcy">
          <el-input v-model="form.settleCcy" placeholder="请输入盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权" />
        </el-form-item>
        <el-form-item label="/**	     * 产品状态	     * live：交易中	     * suspend：暂停中	     * preopen：预上线	     * test：测试中（测试产品，不可交易）	     * 当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）；	     * 当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品	     */" prop="state">
          <el-input v-model="form.state" placeholder="请输入/**	     * 产品状态	     * live：交易中	     * suspend：暂停中	     * preopen：预上线	     * test：测试中（测试产品，不可交易）	     * 当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）；	     * 当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品	     */" />
        </el-form-item>
        <el-form-item label="行权价格，仅适用于期权" prop="stk">
          <el-input v-model="form.stk" placeholder="请输入行权价格，仅适用于期权" />
        </el-form-item>
        <el-form-item label="下单价格精度，如 0.0001" prop="tickSz">
          <el-input v-model="form.tickSz" placeholder="请输入下单价格精度，如 0.0001" />
        </el-form-item>
        <el-form-item label="标的指数，如 BTC-USD，仅适用于交割/永续/期权" prop="uly">
          <el-input v-model="form.uly" placeholder="请输入标的指数，如 BTC-USD，仅适用于交割/永续/期权" />
        </el-form-item>
        <el-form-item label="交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所" prop="exchangeType">
          <el-select v-model="form.exchangeType" placeholder="请选择交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createTokenInfo, updateTokenInfo, deleteTokenInfo, getTokenInfo, getTokenInfoPage, exportTokenInfoExcel } from "@/api/mk/tokenInfo";

export default {
  name: "TokenInfo",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // TOKEN基本信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
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
        exchangeType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        exchangeType: [{ required: true, message: "交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所不能为空", trigger: "change" }],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getTokenInfoPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
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
        exchangeType: undefined,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加TOKEN基本信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getTokenInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改TOKEN基本信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.id != null) {
          updateTokenInfo(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createTokenInfo(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除TOKEN基本信息编号为"' + id + '"的数据项?').then(function() {
          return deleteTokenInfo(id);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams};
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有TOKEN基本信息数据项?').then(() => {
          this.exportLoading = true;
          return exportTokenInfoExcel(params);
        }).then(response => {
          this.$download.excel(response, 'TOKEN基本信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
