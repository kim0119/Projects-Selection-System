<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#324157"
            text-color="#bfcbd9"
            active-text-color="#20a0ff"
            unique-opened
            router
        >
    
            

            <template v-if="userRole == 0">
                    <template v-for="item in items">
                    <template v-if="item.subs">
                        <el-submenu :index="item.id" :key="item.id">
                            <template slot="title">
                                <i :class="item.icon"></i>
                                <span slot="title">{{ item.title }}</span>
                            </template>
                            <template v-for="subItem in item.subs">
                                <el-submenu
                                    v-if="subItem.subs"
                                    :index="subItem.index"
                                    :key="subItem.index"
                                >
                                    <template slot="title">{{ subItem.title }}</template>
                                    <el-menu-item
                                        v-for="(threeItem,i) in subItem.subs"
                                        :key="i"
                                        :index="threeItem.index"
                                    >{{ threeItem.title }}</el-menu-item>
                                </el-submenu>
                                <el-menu-item
                                    v-else
                                    :index="subItem.index"
                                    :key="subItem.index"
                                >{{ subItem.title }}</el-menu-item>
                            </template>
                        </el-submenu>
                    </template>
                    <template v-else>
                        <el-menu-item :index="item.index" :key="item.index">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </el-menu-item>
                    </template>
                </template>
            </template>


            <template v-if="userRole == 2">
                    <template v-for="item in items2">
                    <template v-if="item.subs">
                        <el-submenu :index="item.id" :key="item.id">
                            <template slot="title">
                                <i :class="item.icon"></i>
                                <span slot="title">{{ item.title }}</span>
                            </template>
                            <template v-for="subItem in item.subs">
                                <el-submenu
                                    v-if="subItem.subs"
                                    :index="subItem.index"
                                    :key="subItem.index"
                                >
                                    <template slot="title">{{ subItem.title }}</template>
                                    <el-menu-item
                                        v-for="(threeItem,i) in subItem.subs"
                                        :key="i"
                                        :index="threeItem.index"
                                    >{{ threeItem.title }}</el-menu-item>
                                </el-submenu>
                                <el-menu-item
                                    v-else
                                    :index="subItem.index"
                                    :key="subItem.index"
                                >{{ subItem.title }}</el-menu-item>
                            </template>
                        </el-submenu>
                    </template>
                    <template v-else>
                        <el-menu-item :index="item.index" :key="item.index">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </el-menu-item>
                    </template>
                </template>
            </template>

            <template v-if="userRole == 1">
                    <template v-for="item in items3">
                    <template v-if="item.subs">
                        <el-submenu :index="item.id" :key="item.id">
                            <template slot="title">
                                <i :class="item.icon"></i>
                                <span slot="title">{{ item.title }}</span>
                            </template>
                            <template v-for="subItem in item.subs">
                                <el-submenu
                                    v-if="subItem.subs"
                                    :index="subItem.index"
                                    :key="subItem.index"
                                >
                                    <template slot="title">{{ subItem.title }}</template>
                                    <el-menu-item
                                        v-for="(threeItem,i) in subItem.subs"
                                        :key="i"
                                        :index="threeItem.index"
                                    >{{ threeItem.title }}</el-menu-item>
                                </el-submenu>
                                <el-menu-item
                                    v-else
                                    :index="subItem.index"
                                    :key="subItem.index"
                                >{{ subItem.title }}</el-menu-item>
                            </template>
                        </el-submenu>
                    </template>
                    <template v-else>
                        <el-menu-item :index="item.index" :key="item.index">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </el-menu-item>
                    </template>
                </template>
            </template>

        </el-menu>
    </div>
</template>

<script>
import bus from '../common/bus';
export default {
    data() {
        return {
            collapse: false,
            userRole:'',
            items: [
                {
                    id:0,
                    icon: 'el-icon-lx-home',
                    index: 'dashboard',
                    title: 'Home',
                },
                {
                    id:1,
                    icon: 'el-icon-lx-cascades',
                    title: 'Accounds',
                    subs: [ {
                        icon: 'el-icon-lx-home',
                        index: 'userList',
                        title: 'adminList',
                    },{
                        
                        icon: 'el-icon-lx-home',
                        index: 'teacherlist',
                        title: 'teacherList',
                    
                    },{
                        
                        icon: 'el-icon-lx-home',
                        index: 'stul',
                        title: 'studentList',
                    
                    },{
                        
                        icon: 'el-icon-lx-home',
                        index: 'adminProject',
                        title: 'Project',
                    
                    }]
                },
            
            ],
            items2: [
                {
                    id:1,
                    icon: 'el-icon-lx-cascades',
                    title: 'All Project',
                    index: 'studentPro',
                    
                },
                {
                    id:2,
                    icon: 'el-icon-lx-cascades',
                    title: 'Selected project',
                    index: 'myselect',
                   
                },
                {
                    id:3,
                    icon: 'el-icon-lx-cascades',
                    title: 'user Info',
                    index: 'userInfo',
                   
                },
            
            ],
            items3: [
                {
                    id:1,
                    icon: 'el-icon-lx-cascades',
                    title: 'projcts',
                    subs: [ {
                        icon: 'el-icon-lx-home',
                        index: 'courseList',
                        title: 'project',
                    }]
                },
                {
                    id:2,
                    icon: 'el-icon-lx-cascades',
                    title: 'students seleted',
                    subs: [ {
                        icon: 'el-icon-lx-home',
                        index: 'teacherMyPro',
                        title: 'selected list',
                    }]
                },
            
            
            ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        }
    },
    created() {
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
        this.getUserDetail()
        
    },
    methods:{
        async getUserDetail(){
            const {data:res} = await this.$http.post('/user/detailByToken')

            this.userRole = res.data.roleId
        }
    }
};
</script>

<style scoped>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}
.sidebar > ul {
    height: 100%;
}
</style>


