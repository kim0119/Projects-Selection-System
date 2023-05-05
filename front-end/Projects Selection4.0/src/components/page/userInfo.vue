<template>
    <div>
        
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="username">
                        <el-input v-model="form.userName"></el-input>
                    </el-form-item>
                    
                    <el-form-item label="password">
                        <el-input v-model="form.password"></el-input>
                    </el-form-item>

                    <el-form-item label="email">
                        <el-input v-model="form.email"></el-input>
                    </el-form-item>

                    <el-form-item label="phone">
                        <el-input v-model="form.phone"></el-input>
                    </el-form-item>



                    <el-form-item label="sex">
                        <el-select v-model="form.sex" placeholder="select sex">
                            <el-option key="bbk" label="Woman" value="0"></el-option>
                            <el-option key="xtc" label="Man" value="1"></el-option>
                        </el-select>
                    </el-form-item>
                   

                  <div class="container">
                
                   

                    
                    
                </div>
                
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
            imgActionUrl:'http://localhost:7007/file/uploadSingle',
            imageUrl: '',
            form: {
                id:'',
                userName: '',
                password: '',
                email: '',
                phone: '',
                sex: '',
                roleId: 2,
                avatar: '',
            },

        };
    },
    created(){
        this.getUserInfo()
    },
    methods: {
        async onSubmit() {
            const {data:res} = await this.$http.post('/user/update',this.form)

            if (res.code !== 200) {
                this.$message.error(res.message)
                console.log(res)
                return
            }else {
                this.$message.success('success')
                this.getUserInfo()
            }
        },
        async getUserInfo(){
            const {data:res} = await this.$http.post('/user/detailByToken')
           
            this.form.id = res.data.id
            this.form.userName = res.data.userName
            this.form.password = res.data.password
            this.form.email = res.data.email
            this.form.phone = res.data.phone
            this.form.sex = res.data.sex
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