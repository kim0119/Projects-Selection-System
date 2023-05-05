<template>
    <div>
        
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">


                   <el-form-item label="course">
                        <el-select v-model="form.courseId" placeholder="course">
                            <el-option v-for="(item,index) in parentList" :key="index"  :label="item.name" :value="item.id" ></el-option>
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
            imgActionUrl:this.$http+'file/uploadSingle',
            imageUrl: '',
            form: {
                courseId: '',
                
            },
            parentList:[]

        };
    },
    created(){
        this.getParentList()
    },
    methods: {
        async getParentList(){
           const {data:res} = await this.$http.post('/course/findByModal',{})
           this.parentList = res.data.list;
        },
        async onSubmit() {
            const {data:res} = await this.$http.post('/student/course/add',this.form)

            if (res.code !== 200) {
                this.$message.error(res.message)
                console.log(res)
                return
            }else {
                this.$message.success('success !')
                this.$router.push('/studentCourse')
            }
        },
        handleAvatarSuccess(res, file) {
            // this.form.avatar = URL.createObjectURL(file.raw);
            this.form.avatar = res.data
        },
        beforeAvatarUpload(file) {
            const isJPG = file.type === 'image/jpeg';
            const isLt2M = file.size / 1024 / 1024 < 1;

            if (!isJPG) {
            this.$message.error('JPG!');
            }
            if (!isLt2M) {
            this.$message.error('size > 2MB');
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