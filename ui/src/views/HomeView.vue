<template>
  <div style="height: 100%;">
    <el-container style="height: 100vh;">
      <el-aside :width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246); box-shadow: 2px 0 6px rgba(0,21,41,0.4);">
<!--        右上角logo -->
        <div style="height: 60px; line-height: 60px; text-align: center; color: #78cdd1;background-color:rgba(48,56,86,1); border-right: solid 1px #e6e6e6;">
          <span style="font-size: 20px;"><i class="el-icon-loading"></i></span>
          <span style="font-weight: bold; font-size: 20px;">JavaDemo</span>
        </div>
<!--        按钮列表-->
        <el-menu :default-openeds="['1', '3']" style="height: calc(100% - 60px);overflow-x:hidden; "
                 background-color="rgba(48,56,86,1)"
                 text-color="#FFFFFF"
                 active-text-color="#FFD04B"
                 :collapse-transition="false"
                 :collapse="isCollapse"
        >
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-message"></i>
              <span slot="title">导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span slot="title">导航三</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>

        </el-menu>
      </el-aside>

      <el-container>
<!--        顶部信息-->
        <el-header style="text-align: right; font-size: 12px; display: flex;">
          <div style="width: 50px;font-size: 20px; text-align: left;">
            <span :class="collapseBtnClass" style="cursor: pointer;" @click="collapse"></span>
          </div>
          <el-dropdown style="flex: 1;">
            <span>王小虎</span><i class="el-icon-arrow-down" style="margin-right: 5px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

        </el-header>
<!--        主窗口-->
        <el-main>
<!--          筛选区-->
          <div style="height:50px; line-height:50px;display: flex;justify-content: space-between;">
            <div style="width: calc(100% - 500px);height: 50px;line-height:50px;margin-right: 10px;">
              <el-input size="small " placeholder="请输入内容" v-model="condition.value" class="input-with-select">
                <el-select v-model="condition.type" slot="prepend" placeholder="请选择">
                  <el-option label="用户名" value="1"></el-option>
                  <el-option label="昵称" value="2"></el-option>
                  <el-option label="邮箱" value="3"></el-option>
                  <el-option label="地址" value="4"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search" @click="onSelect">查询</el-button>
              </el-input>
            </div>
            <div style="width: 500px;height: 50px;line-height:50px;">
              <el-button type="primary" @click="onAdd">新增<i class="el-icon-circle-plus-outline el-icon--right"></i></el-button>
              <el-button type="danger" @click="onDeleteBatch">批量删除<i class="el-icon-remove-outline el-icon--right"></i></el-button>
              <el-button type="primary">导入<i class="el-icon-download el-icon--right"></i></el-button>
              <el-button type="primary">导出<i class="el-icon-upload2 el-icon--right"></i></el-button>
            </div>
          </div>
          <!--          主表格-->
          <div style="height: calc(100% - 100px); overflow-y: auto;">
            <el-table height="100%" :data="tableData" @selection-change="onSelectChange">
              <el-table-column type="selection" width="55"></el-table-column>
              <el-table-column prop="username" label="用户名" width="140"></el-table-column>
              <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>
              <el-table-column prop="email" label="邮箱"></el-table-column>
              <el-table-column prop="phone" label="电话"></el-table-column>
              <el-table-column prop="address" label="地址"></el-table-column>
              <el-table-column
                  fixed="right"
                  label="操作"
                  align="center"
                  width="120">
                <template slot-scope="scope">
                  <el-button @click="onOperationEdit(scope.row)" type="text" size="small">编辑</el-button>
                  <el-popconfirm
                      class="ml-5"
                      confirm-button-text='确定'
                      cancel-button-text='不用了'
                      icon="el-icon-info"
                      icon-color="red"
                      title="确定要删除这条数据吗？"
                      @confirm="onOperationDel(scope.row)"
                  >
                    <el-button slot="reference" type="text" size="small" style="color: #F56C6C;">删除</el-button>
                  </el-popconfirm>
                </template>
              </el-table-column>
            </el-table>
          </div>
<!--          分页区-->
          <div style="height:50px;line-height:50px;padding: 10px 0">
            <el-pagination
                :page-sizes="[5, 10, 15, 20]"
                :page-size="paging.pagesize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="paging.total"
                @size-change="onPageSizeChange"
                @current-change="onPageCurrentChange"
            >
            </el-pagination>
          </div>
<!--          弹出窗口-新增-->
          <el-dialog title="新增用户" :visible.sync="dialogFormVisible">
            <el-form ref="UserForm" :model="UserFormModel" :rules="UserRules">
              <el-form-item label="用户名称" label-width="100px" prop="username">
                <el-input v-model="UserFormModel.username" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="昵称" label-width="100px" prop="nickname">
                <el-input v-model="UserFormModel.nickname" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="邮箱" label-width="100px" prop="email">
                <el-input v-model="UserFormModel.email" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="电话" label-width="100px" prop="phone">
                <el-input v-model="UserFormModel.phone" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="地址" label-width="100px" prop="address">
                <el-input v-model="UserFormModel.address" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="onClose">取 消</el-button>
              <el-button type="primary" @click="onSave">确 定</el-button>
            </div>
          </el-dialog>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import UserApi from "@/api/UserApi";
export default {
  name: 'HomeView',
  components: {},
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      // 分页
      paging: {
        pagesize: 10,
        pageindex: 1,
        total: 0
      },
      // 搜索条件
      condition:{
        type: '',
        value: ''
      },
      // 是否显示新增编辑弹框
      dialogFormVisible: false,
      // 新增和编辑提交模型
      UserFormModel: {
        id: 0,
        username: "",
        nickname: "",
        phone: "",
        email: "",
        address: "",
        place: "",
      },
      // 表单验证规则
      UserRules:{
        username:[
          {
            required: true,
            message: "请输入内容",
            trigger: 'blur'
          }
        ],
        nickname:[
          {
            required: true,
            message: "请输入内容",
            trigger: 'blur'
          }
        ],
        email:[
          {
            required: true,
            message: "请输入内容",
            trigger: 'blur'
          }
        ],
        phone:[
          {
            required: true,
            message: "请输入内容",
            trigger: 'blur'
          }
        ],
        address:[
          {
            required: true,
            message: "请输入内容",
            trigger: 'blur'
          }
        ]
      },
      // 表格数据
      tableData: [],
      // 选中的表格数据
      SelectId:[],
      collapseBtnClass : "el-icon-s-fold",
      isCollapse: false,
      sideWidth: 200,

    }
  },
  created() {
    this.getData()
  },
  methods: {
    onSelect(){
      console.log('condition',this.condition)
      this.getData()
    },

    // 从后台获取表格数据
    getData(){
      let that = this
      let model = {
        pageNum:this.paging.pageindex,
        pageSize: this.paging.pagesize,
        userName: this.condition.type == '1' ? this.condition.value : '',
        nickName: this.condition.type == '2' ? this.condition.value : '',
        email: this.condition.type == '3' ? this.condition.value : '',
        address: this.condition.type == '4' ? this.condition.value : '',
      }
      UserApi.Page(model).then((response)=>{
        that.tableData = response.records
        that.paging.total = response.total
      }).catch((error)=>{
        console.error(error)
      })
    },

    // 新增数额
    onAdd(){
      this.dialogFormVisible = true
      this.$nextTick(()=>{
        this.$refs["UserForm"].resetFields()
      })

    },
    // 保存数据
    onSave(){
      let that = this
      this.$refs['UserForm'].validate(valid => {
        if (!valid) return
        UserApi.Save(this.UserFormModel).then(response=>{
          if(response){
            that.dialogFormVisible = false
            this.$message({
              message: '保存成功',
              type: 'success'
            });
            that.getData()
          }
          else{
            this.$message({
              message: '警告哦，这是一条警告消息',
              type: 'error',
              duration: 0,
              showClose: true
            });
            that.getData()
          }
        }).catch(error=>{
          console.error(error)
          that.getData()
        })
      })
    },
    // 关闭表单
    onClose(){
      this.$refs["UserForm"].resetFields()
    },
    // 表格行查看事件
    onOperationSee(value){
      // TODO
      console.log(value)
    },
    // 表格行编辑事件
    onOperationEdit(value){
      this.UserFormModel = value
      this.dialogFormVisible = true
    },
    // 表格行删除事件
    onOperationDel(value){
      let that = this
      UserApi.DeleteUser(value.id).then(res =>{
        if(res){
          this.$message({
            message: '删除成功',
            type: 'success'
          });
          that.getData()
        }
        else{
          that.getData()
        }
      }).catch(error=>{
        console.error(error)
        that.getData()
      })
    },
    // 每页数据量改变事件
    onPageSizeChange(val){
      this.paging.pageindex = 1
      this.paging.pagesize = val
      this.getData()
    },

    // 页数改变事件
    onPageCurrentChange(val){
      this.paging.pageindex = val
      this.getData()
    },
    // 获取选中的数据
    onSelectChange(value){
      console.log("value=>",value)
      this.SelectId = value.map(v=>v.id)
      console.log("this.SelectId=>",this.SelectId)
    },

    // 批量删除事件
    onDeleteBatch(){
      let that = this
      this.$confirm('此操作将永久删除数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.DeleteBatch()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

    DeleteBatch(){
      let that = this
      UserApi.DeleteBatchUser(this.SelectId).then(res=>{
        if(res){
          this.$message({
            message: '删除成功',
            type: 'success'
          });
          that.getData()
        }
        else{
          that.getData()
        }
      }).catch(error=>{
        console.log("error=>",error)
        that.getData()
      })
    },

    // 左侧菜单收放事件
    collapse() {
      this.isCollapse = !this.isCollapse
      this.sideWidth = this.isCollapse ? 64 : 200
      this.collapseBtnClass = this.isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'
    },

  }
}
</script>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
  border-bottom: 1px solid #CCC
}

.el-aside {
  color: #333;
}

.el-select .el-input {
  width: 130px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
