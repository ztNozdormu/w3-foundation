<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="币种基础名称" prop="tokenBaseName">
        <el-input v-model="queryParams.tokenBaseName" placeholder="请输入币种基础名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否有最新事件触发(0:没有 1：有)" prop="event">
        <el-input v-model="queryParams.event" placeholder="请输入是否有最新事件触发(0:没有 1：有)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否有近期热点消息(0:没有 1：有)" prop="hot">
        <el-input v-model="queryParams.hot" placeholder="请输入是否有近期热点消息(0:没有 1：有)" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市值排名" prop="capRanking">
        <el-input v-model="queryParams.capRanking" placeholder="请输入市值排名" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="近期交易量" prop="volRanking">
        <el-input v-model="queryParams.volRanking" placeholder="请输入近期交易量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="板块概念" prop="concept">
        <el-input v-model="queryParams.concept" placeholder="请输入板块概念" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高" prop="comprehensiveRanking">
        <el-input v-model="queryParams.comprehensiveRanking" placeholder="请输入根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['mk:token-rank:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['mk:token-rank:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="币种基础名称" align="center" prop="tokenBaseName" />
      <el-table-column label="是否有最新事件触发(0:没有 1：有)" align="center" prop="event" />
      <el-table-column label="是否有近期热点消息(0:没有 1：有)" align="center" prop="hot" />
      <el-table-column label="市值排名" align="center" prop="capRanking" />
      <el-table-column label="近期交易量" align="center" prop="volRanking" />
      <el-table-column label="板块概念" align="center" prop="concept" />
      <el-table-column label="根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高" align="center" prop="comprehensiveRanking" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['mk:token-rank:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['mk:token-rank:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="币种基础名称" prop="tokenBaseName">
          <el-input v-model="form.tokenBaseName" placeholder="请输入币种基础名称" />
        </el-form-item>
        <el-form-item label="是否有最新事件触发(0:没有 1：有)" prop="event">
          <el-input v-model="form.event" placeholder="请输入是否有最新事件触发(0:没有 1：有)" />
        </el-form-item>
        <el-form-item label="是否有近期热点消息(0:没有 1：有)" prop="hot">
          <el-input v-model="form.hot" placeholder="请输入是否有近期热点消息(0:没有 1：有)" />
        </el-form-item>
        <el-form-item label="市值排名" prop="capRanking">
          <el-input v-model="form.capRanking" placeholder="请输入市值排名" />
        </el-form-item>
        <el-form-item label="近期交易量" prop="volRanking">
          <el-input v-model="form.volRanking" placeholder="请输入近期交易量" />
        </el-form-item>
        <el-form-item label="板块概念" prop="concept">
          <el-input v-model="form.concept" placeholder="请输入板块概念" />
        </el-form-item>
        <el-form-item label="根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高" prop="comprehensiveRanking">
          <el-input v-model="form.comprehensiveRanking" placeholder="请输入根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高" />
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
import { createTokenRank, updateTokenRank, deleteTokenRank, getTokenRank, getTokenRankPage, exportTokenRankExcel } from "@/api/mk/tokenRank";

export default {
  name: "TokenRank",
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
      // TOKEN排名信息列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        tokenBaseName: null,
        event: null,
        hot: null,
        capRanking: null,
        volRanking: null,
        concept: null,
        comprehensiveRanking: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        tokenBaseName: [{ required: true, message: "币种基础名称不能为空", trigger: "blur" }],
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
      getTokenRankPage(this.queryParams).then(response => {
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
        tokenBaseName: undefined,
        event: undefined,
        hot: undefined,
        capRanking: undefined,
        volRanking: undefined,
        concept: undefined,
        comprehensiveRanking: undefined,
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
      this.title = "添加TOKEN排名信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getTokenRank(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改TOKEN排名信息";
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
          updateTokenRank(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createTokenRank(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除TOKEN排名信息编号为"' + id + '"的数据项?').then(function() {
          return deleteTokenRank(id);
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
      this.$modal.confirm('是否确认导出所有TOKEN排名信息数据项?').then(() => {
          this.exportLoading = true;
          return exportTokenRankExcel(params);
        }).then(response => {
          this.$download.excel(response, 'TOKEN排名信息.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
