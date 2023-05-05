<template>
    <div>
        
        <div class="container">
            <div class="handle-box">
                
                
                <div style="display:flex;align-items:center;justify-content:space-between;">
                    <div>
                        <el-input v-model="pageInfo.name"  placeholder="search" class="handle-input mr10"></el-input>
                        <el-button type="primary" icon="el-icon-search" @click="handleSearch">search</el-button>
                    </div>
                    <div>
                        <el-button type="danger" size="medium" @click="toAdduser">Add</el-button>
                    </div>
                </div>
            </div>
            <el-table
                :data="tableData"
                border
                class="table"
                ref="multipleTable"
                header-cell-class-name="table-header"
                
            >
                
                
                <el-table-column prop="name" label="name"></el-table-column>
               
                
                <el-table-column label="Events" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.row)"
                        >Edit</el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.row)"
                        >Delete</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    layout="total, prev, pager, next"
                    :current-page="pageInfo.page"
                    :page-size="pageInfo.limit"
                    :total="total"
                    @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>

       
    </div>
</template>

<script>
import Tags from '../common/Tags.vue';
export default {
  components: { Tags },
    name: 'basetable',
    data() {
        return {
            total:0,
            pageInfo:{
                name:'',
                page:1,
                limit:5
            },
            tableData: [],
        };
    },
    created() {
        this.getData();
    },
    mounted(){
         this.getData();
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        async getData() {
            const {data:res} = await this.$http.post('/course/type/findByModal',this.pageInfo)
            // this.tableData = []
            if (res.code !== 200) {
                this.$message.error(res.message)
                return
            }else {
                this.tableData = res.data.list
                this.total = res.data.total
                console.log(res)
            }
        },
        // 触发搜索按钮
        handleSearch() {
            this.getData();
        },
        // 删除操作
        async handleDelete(row) {
            const confirmValue = await this.$confirm(`sure delete?`,'delete',{
              confirmButtonText: 'yes',
              cancelButtonText: 'close',
              type: 'warning'
              }
          ).catch(err=>err)

          if (confirmValue !== 'confirm') {
              this.$message.info('close delete')
              return
          }else{
              const {data:res} = await this.$http.post('/course/type/delete?id='+row.id)

              if (res.code !== 200) {
                  this.$message.error(`error`)
                  return
              }else {
                  this.$message.success(`success`)
                  this.getData()
              }

          }
        },
        // 编辑操作
        handleEdit(row) {
            this.$router.push({
                path:'/editCourseType',
                query:{
                row:row
                }
            })
        },
        
        // 分页导航
        handlePageChange(val) {
            this.pageInfo.page = val
            this.getData();
        },
        // 跳转新增页面
        toAdduser(){
            this.$router.push('/addCourseType');
        }
    }
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
