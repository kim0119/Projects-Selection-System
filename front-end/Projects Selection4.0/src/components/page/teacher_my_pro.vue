<template>
    <div>

        <div class="container">
            <div class="handle-box">


                <div style="display:flex;align-items:center;justify-content:space-between;">
                    <div>
                        <el-input v-model="pageInfo.name" placeholder="search" class="handle-input mr10"></el-input>
                        <el-button type="primary" icon="el-icon-search" @click="handleSearch">search</el-button>
                    </div>
                    <!-- <div>
                                    <el-button type="danger" size="medium" @click="toAdduser">Add</el-button>
                                </div> -->
                </div>
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" header-cell-class-name="table-header">


                <el-table-column prop="projectName" label="project name"></el-table-column>
                <el-table-column prop="studentName" label="student name"></el-table-column>
                <el-table-column prop="grade" label="grade"></el-table-column>

                <el-table-column label="Events" width="250" align="center">
                    <template slot-scope="scope">
                        <el-button type="success" v-if="scope.row.status == 1" @click="opendialog(scope.row)">enter
                            grade</el-button>
                        <el-button type="danger" v-else @click="payClick(scope.row)" disabled>arrearage</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination background layout="total, prev, pager, next" :current-page="pageInfo.page"
                    :page-size="pageInfo.limit" :total="total" @current-change="handlePageChange"></el-pagination>
            </div>
        </div>



        <el-dialog title="enter grade" :visible.sync="enterdialog">
            <el-form :model="form">
                <el-form-item label="grade" :label-width="formLabelWidth">
                    <el-input v-model="form.grade" autocomplete="off"></el-input>
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitEnter">Submit</el-button>
            </div>
        </el-dialog>

    </div>
</template>

<script>
import Tags from '../common/Tags.vue';
export default {
    components: { Tags },
    name: 'basetable',
    data() {
        return {
            total: 0,
            enterdialog: false,
            pageInfo: {
                name: '',
                page: 1,
                limit: 5
            },
            tableData: [],
            form: {
                id: '',
                grade: ''
            }
        };
    },
    created() {
        this.getData();
    },
    mounted() {
        this.getData();
    },
    methods: {
        // 获取 easy-mock 的模拟数据
        async getData() {
            const { data: res } = await this.$http.post('/student/course/findByModal', this.pageInfo)
            // this.tableData = []
            if (res.code !== 200) {
                this.$message.error(res.message)
                return
            } else {
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
        async deleteButton(row) {
            const confirmValue = await this.$confirm(`sure delete?`, 'delete', {
                confirmButtonText: 'yes',
                cancelButtonText: 'close',
                type: 'warning'
            }
            ).catch(err => err)

            if (confirmValue !== 'confirm') {
                this.$message.info('close delete')
                return
            } else {
                const { data: res } = await this.$http.post('/student/course/delete?id=' + row.id)

                if (res.code !== 200) {
                    this.$message.error(`error`)
                    return
                } else {
                    this.$message.success(`success`)
                    this.getData()
                }

            }
        },
        async payClick(row) {


            const { data: res } = await this.$http.post('/student/course/update', { id: row.id, status: 1 })

            if (res.code !== 200) {
                this.$message.error(`error`)
                return
            } else {
                this.$message.success(`success`)
                this.getData()
            }
        },
        async passClick(row) {


            const { data: res } = await this.$http.post('/student/course/update', { id: row.id, status: 2 })

            if (res.code !== 200) {
                this.$message.error(`error`)
                return
            } else {
                this.$message.success(`success`)
                this.getData()
            }
        },
        // 编辑操作
        async handleEdit(row) {
            const confirmValue = await this.$confirm(`are you sure select this project?`, 'select project', {
                confirmButtonText: 'sure',
                cancelButtonText: 'close',
                type: 'warning'
            }
            ).catch(err => err)

            if (confirmValue !== 'confirm') {
                this.$message.info('closed')
                return
            } else {
                const { data: res } = await this.$http.post('/student/course/add', { projectId: row.id, teacherId: row.teacherId })

                if (res.code == 400) {
                    this.$message.error(`This course has been applied for, please do not apply again`)
                    return;
                } else if (res.code == 800027) {
                    this.$message.error(`The number is full`)
                    return;

                } else {
                    this.$message.success(`success`)
                    this.getData()
                }

            }
        },
        // 保存编辑
        saveEdit() {
            this.editVisible = false;
            this.$message.success(`修改第 ${this.idx + 1} 行成功`);
            this.$set(this.tableData, this.idx, this.form);
        },
        // 分页导航
        handlePageChange(val) {
            this.pageInfo.page = val
            this.getData();
        },
        // 跳转新增页面
        toAdduser() {
            this.$router.push('/addCourse');
        },
        // open enter grade
        opendialog(data) {
            this.form.id = data.id;
            this.enterdialog = true;
        },
        // submit grade
        async submitEnter() {
            const { data: res } = await this.$http.post('/student/course/update', this.form)

            if (res.code !== 200) {
                this.$message.error(`error`)
                return;
            } else {
                this.$message.success(`success`)
                this.form.grade = ''
                this.enterdialog = false;
                this.getData()
            }

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
