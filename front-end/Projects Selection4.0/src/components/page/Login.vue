<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">Projects Selection System</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="userName">
                    <el-input v-model="param.userName" placeholder="userName">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="param.password"
                        @keyup.enter.native="submitForm1()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>

                <div style="margin-bottom:10px;color:#fff" @click="LoginOfRegister">register</div>

                <div class="login-btn">
                    <el-button type="primary" @click="submitForm1()">login</el-button>
                </div>
                
            </el-form>
        </div>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            param: {
                userName: '',
                password: '',
            },
            rules: {
                userName: [{ required: true, message: 'enter your username', trigger: 'blur' }],
                password: [{ required: true, message: 'enter your password', trigger: 'blur' }],
            },
        };
    },
    methods: {
        submitForm1() {
            this.$refs.login.validate(async valid => {
                if (valid) {
                    const {data:res} =  await this.$http.post('/user/login', this.param)
                    
                    if (res.code !== 200 ) {
                        this.$message(res.message)
                        return
                    }else{

                        this.$message.success('success')
                        window.localStorage.setItem('token',res.data.token)
                        this.$router.push('/dashboard');
                        
                        
                    }
                    
                } else {
                    this.$message.error('enter your account&password');
                    console.log('error submit!!');
                    return false;
                }
            });

            
        },
        LoginOfRegister(){
            this.$router.push('/register');
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
</style>