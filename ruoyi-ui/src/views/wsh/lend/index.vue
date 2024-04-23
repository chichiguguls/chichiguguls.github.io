<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="资产编号" prop="no">
        <el-input
          v-model="queryParams.no"
          placeholder="请输入资产编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入设备名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产分类" prop="sort">
        <el-select v-model="queryParams.sort" placeholder="请选择资产分类" clearable>
          <el-option
            v-for="dict in dict.type.sys_wzh_sort"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['wsh:lend:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['wsh:lend:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['wsh:lend:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wsh:lend:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lendList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="资产编号" align="center" prop="no" />
      <el-table-column label="设备名称" align="center" prop="name" />
      <el-table-column label="资产分类" align="center" prop="sort">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_wzh_sort" :value="scope.row.sort"/>
        </template>
      </el-table-column>
      <el-table-column label="资产图片" align="center" prop="picture" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.picture" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="数量" align="center" prop="quantity" />
      <el-table-column label="借出日期" align="center" prop="lend" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lend, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="借出备注" align="center" prop="remark" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="姓名" align="center" prop="surname" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="身份证" align="center" prop="card" />
      <el-table-column label="是否审核" align="center" prop="ssfh" />
      <el-table-column label="审核回复" align="center" prop="shhf" />
      <el-table-column label="创建时间" align="center" prop="addtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.addtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wsh:lend:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wsh:lend:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改资产借出对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资产编号" prop="no">
          <el-input v-model="form.no" placeholder="请输入资产编号" />
        </el-form-item>
        <el-form-item label="设备名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="资产分类" prop="sort">
          <el-select v-model="form.sort" placeholder="请选择资产分类">
            <el-option
              v-for="dict in dict.type.sys_wzh_sort"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="资产图片" prop="picture">
          <image-upload v-model="form.picture"/>
        </el-form-item>
        <el-form-item label="数量" prop="quantity">
          <el-input v-model="form.quantity" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="借出日期" prop="lend">
          <el-date-picker clearable
            v-model="form.lend"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择借出日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="借出备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入借出备注" />
        </el-form-item>
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="姓名" prop="surname">
          <el-input v-model="form.surname" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="身份证" prop="card">
          <el-input v-model="form.card" placeholder="请输入身份证" />
        </el-form-item>
        <el-form-item label="是否审核" prop="ssfh">
          <el-input v-model="form.ssfh" placeholder="请输入是否审核" />
        </el-form-item>
        <el-form-item label="审核回复" prop="shhf">
          <el-input v-model="form.shhf" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="创建时间" prop="addtime">
          <el-date-picker clearable
            v-model="form.addtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
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
import { listLend, getLend, delLend, addLend, updateLend } from "@/api/wsh/lend";

export default {
  name: "Lend",
  dicts: ['sys_wzh_sort'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 资产借出表格数据
      lendList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        no: null,
        name: null,
        sort: null,
        quantity: null,
        lend: null,
        userName: null,
        surname: null,
        phone: null,
        card: null,
        ssfh: null,
        shhf: null,
        addtime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        sort: [
          { required: true, message: "资产分类不能为空", trigger: "change" }
        ],
        quantity: [
          { required: true, message: "数量不能为空", trigger: "blur" }
        ],
        addtime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询资产借出列表 */
    getList() {
      this.loading = true;
      listLend(this.queryParams).then(response => {
        this.lendList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        no: null,
        name: null,
        sort: null,
        picture: null,
        quantity: null,
        lend: null,
        remark: null,
        userName: null,
        surname: null,
        phone: null,
        card: null,
        ssfh: null,
        shhf: null,
        addtime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加资产借出";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLend(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改资产借出";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLend(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLend(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除资产借出编号为"' + ids + '"的数据项？').then(function() {
        return delLend(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wsh/lend/export', {
        ...this.queryParams
      }, `lend_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
