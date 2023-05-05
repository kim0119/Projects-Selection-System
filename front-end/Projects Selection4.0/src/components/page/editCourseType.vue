<template>
    <div>
        
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">

                     <el-form-item label="name">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                     
                
                    <el-form-item>
                        <el-button type="danger" @click="onSubmit">Submit</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    data() {
        return {
            imgActionUrl:'http://4s56h34109.51vip.biz/file/uploadSingle',
            imageUrl: '',
            form: {
                id:'',
                name: '',
                
            },

        };
    },
    created(){
        if(this.$route.query) {
      
            this.form.id = this.$route.query.row.id
            this.form.name = this.$route.query.row.name
           
   

           
        }
    },
    methods: {
        async onSubmit() {
            const {data:res} = await this.$http.post('/course/type/update',this.form)

            if (res.code !== 200) {
                this.$message.error(res.message)
                console.log(res)
                return
            }else {
                this.$message.success('success')
                this.$router.push('/courseType')
            }
        }
    }
};
</script>


<style scoped>
.content-title{
    font-weight: 400;
    line-height: 50px;
    margin: 10px 0;
    font-size: 22px;
    color: #1f2f3d;
}

.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>