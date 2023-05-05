<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">Projects Selection System</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                
                
              
                <!---<el-upload 
                    class="avatar-uploader"
                    :action="imgActionUrl"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload">
                    <img v-if="param.avatar" :src="param.avatar" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>-->

                
                <el-form-item prop="userName">
                    <el-input v-model="param.userName" placeholder="Username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>


                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="Password"
                        v-model="param.password"
                        
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>


                
                <el-form-item prop="email">
                    <el-input v-model="param.email" placeholder="Email">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
  
                <el-form-item prop="phone">
                    <el-input v-model="param.phone" placeholder="Phone">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>

                <el-form-item prop="sex">
                    <el-select v-model="param.sex" placeholder="Sex">
                        <el-option key="bbk" label="Woman" value="0"></el-option>
                        <el-option key="xtc" label="Man" value="1"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="role">
                        <el-select v-model="param.roleId" placeholder="Role">
                            <el-option key="bbk" label="Admin" value="0"></el-option>
                            <el-option key="xtc" label="Teacher" value="2"></el-option>
                            <el-option key="xtc" label="Student" value="1"></el-option>
                        </el-select>
                    </el-form-item>


                <div style="margin-bottom:20px;color:#fff" @click="LoginOfRegister">Login</div>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm1()">Register</el-button>
                </div>
                
            </el-form>
        </div>
    </div>
</template>

<script>
import VueCropper  from 'vue-cropperjs';
export default {
    components: {
        VueCropper
    },
    data: function() {
        return {
            imgActionUrl:'http://localhost:7007/file/uploadSingle',
            imageUrl: '',
            param: {
                userName: '',
                password: '',
                email:'',
                phone:'',
                sex: '',
                roleId:'',
                avatar: '',
            },
            rules: {
                userName: [{ required: true, message: 'username is empty', trigger: 'blur' }],
                password: [{ required: true, message: 'password is empty', trigger: 'blur' }],
                email: [{ required: true, message: 'email is empty', trigger: 'blur' }],
                phone: [{ required: true, message: 'phone is empty', trigger: 'blur' }],
                sex: [{ required: true, message: 'please select', trigger: 'blur' }],
                roleId: [{ required: true, message: 'please select', trigger: 'blur' }],
            },
        };
    },
    methods: {
        submitForm1() {
            this.$refs.login.validate(async valid => {
                if (valid) {
                    const {data:res} =  await this.$http.post('/user/add', this.param)
                    
                    if (res.code !== 200 ) {
                        this.$message(res.message)
                        return
                    }else{

                        this.$message.success('success！')
                        this.$router.push('/login');
                        
                    }
                    
                } else {
                    this.$message.error('enter your account&password');
                    console.log('error submit!!');
                    return false;
                }
            });

            
        },
        handleAvatarSuccess(res, file) {
            // this.form.avatar = URL.createObjectURL(file.raw);
            this.param.avatar = res.data
        },
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 1;

            if (!isJPG) {
            this.$message.error('上传头像图片只能是 JPG 格式!');
            }
            if (!isLt2M) {
            this.$message.error('上传头像图片大小不能超过 2MB!');
            }
            return isJPG && isLt2M;
        },
        LoginOfRegister(){
            this.$router.push('/login');
        }
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/loginBG.jpg);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
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
    font-size: 16px;
    color: #8c939d;
    width: 50px;
    height: 50px;
    line-height: 50px;
    text-align: center;
  }
  .avatar {
    width: 50px;
    height: 50px;
    display: block;
  }

  /*/deep/ .el-upload--picture-card{
    width: 100px;
    height: 100px;
}
/deep/ .el-upload{
    width: 100px;
    height: 100px;
    line-height: 100px;
    margin-bottom: 15px;
}
/deep/ .el-upload-list--picture-card .el-upload-list__item{
    width: 100px;
    height: 100px;
    line-height: 100px;
}
/deep/ .el-upload-list--picture-card .el-upload-list__item-thumbnail{
    width: 100px;
    height: 100px;
    line-height: 100px;
}
/deep/ .avatar{
    width: 100px;
    height: 100px;
}*/
</style>