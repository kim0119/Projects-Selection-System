<template>
    <div>
        
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">

                    <el-form-item label="name">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    
                    <el-form-item label="technology">
                        <el-input v-model="form.technology"></el-input>
                    </el-form-item>

                    <el-form-item label="introduction">
                        <el-input v-model="form.introduction"></el-input>
                    </el-form-item>

                    <el-form-item label="max number">
                        <el-input v-model="form.maxNumber"></el-input>
                    </el-form-item>


                    <el-form-item label="optional number">
                        <el-input v-model="form.determineNumber"></el-input>
                    </el-form-item>

                
                    <el-form-item label="teacher">
                        <el-select v-model="form.teacherId" placeholder="teacher">
                            <el-option v-for="(item,index) in teacherList" :key="index"  :label="item.userName" :value="item.id" ></el-option>
                        </el-select>
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
import VueCropper  from 'vue-cropperjs';
export default {
    name: 'baseform',
    components: {
        VueCropper
    },
    data() {
        return {
            imgActionUrl:'http://4s56h34109.51vip.biz/file/uploadSingle',
            imageUrl: '',
            form: {
                id:'',
                name: '',
                technology: '',
                introduction: '',
                maxNumber: '',
                teacherId: '',
                determineNumber:''
            },
            teacherList:[]

        };
    },
    created(){
        this.getParentList()
        if(this.$route.query) {
      
            this.form.id = this.$route.query.row.id
            this.form.name = this.$route.query.row.name
            this.form.technology = this.$route.query.row.technology
            this.form.introduction = this.$route.query.row.introduction
            this.form.maxNumber = this.$route.query.row.maxNumber
            this.form.teacherId = this.$route.query.row.teacherId
   

           
        }
        
    },
    methods: {
        async getParentList(){
           const {data:res} = await this.$http.post('/user/findByModal',{})
           res.data.list.forEach(item =>{
                if (item.roleId == 1) {
                    this.teacherList.push(item)
                }
           })
           
        },
        async onSubmit() {
            const {data:res} = await this.$http.post('/project/update',this.form)

            if (res.code !== 200) {
                this.$message.error(res.message)
                console.log(res)
                return
            }else {
                this.$message.success('success')
                this.$router.push('/adminProject')
            }
        },
        handleAvatarSuccess(res, file) {
            this.form.avatar = res.data
        },
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 1;

            if (!isJPG) {
            this.$message.error('JPG!');
            }
            if (!isLt2M) {
            this.$message.error('2MB!');
            }
            return isJPG && isLt2M;
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