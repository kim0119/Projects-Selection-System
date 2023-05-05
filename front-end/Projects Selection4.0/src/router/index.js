import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/dashboard',
                    component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Dashboard.vue'),
                    meta: { title: 'Home' }
                },
                {
                    path: '/userList',
                    component: () => import(/* webpackChunkName: "table" */ '../components/page/userList.vue'),
                    meta: { title: 'Table' }
                },
                {
                    path: '/adduser',
                    component: () => import(/* webpackChunkName: "donate" */ '../components/page/addUser.vue'),
                    meta: { title: 'Add' }
                },
                {
                    path: '/edituser',
                    component: () => import(/* webpackChunkName: "donate" */ '../components/page/editUser.vue'),
                    meta: { title: 'Edit' }
                },
                {
                    path: '/courseList',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/courseList.vue'),
                    meta: { title: 'Course' }
                },
                {
                    path: '/addCourse',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/addCourse.vue'),
                    meta: { title: 'Add' }
                },
                {
                    path: '/courseEdit',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/courseEdit.vue'),
                    meta: { title: 'Edit' }
                },
                {
                    path: '/studentCourse',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/studentCourse.vue'),
                    meta: { title: 'studentCourse' }
                }
                ,
                {
                    path: '/addStudentCourse',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/addStudentCourse.vue'),
                    meta: { title: 'Add' }
                },
                {
                    path: '/courseType',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/courseType.vue'),
                    meta: { title: 'courseType' }
                },
                {
                    path: '/addCourseType',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/addCourseType.vue'),
                    meta: { title: 'Add' }
                }
                ,
                {
                    path: '/editCourseType',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/editCourseType.vue'),
                    meta: { title: 'Edit' }
                },
                {
                    path: '/editStudentCourse',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/editStudentCourse.vue'),
                    meta: { title: 'Edit' }
                },
                {
                    path: '/teaStudentCourse',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/teaStudentCourse.vue'),
                    meta: { title: 'Change Grade' }
                },{
                    path: '/changeGrade',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/changeGrade.vue'),
                    meta: { title: 'Change Grade' }
                } ,{
                    path: '/teacherlist',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/teacherlist.vue'),
                    meta: { title: 'teacherlist' }
                },{
                    path: '/addt',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/addt.vue'),
                    meta: { title: 'add' }
                },
                {
                    path: '/editt',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/editt.vue'),
                    meta: { title: 'edit' }
                },
                {
                    path: '/stul',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/stul.vue'),
                    meta: { title: 'student list' }
                },
                {
                    path: '/addstu',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/addstu.vue'),
                    meta: { title: 'add' }
                },
                {
                    path: '/editt',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/editt.vue'),
                    meta: { title: 'edit' }
                },
                {
                    path: '/adminProject',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/adminProject.vue'),
                    meta: { title: 'Project' }
                },
                {
                    path: '/admingProjectAdd',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/admingProjectAdd.vue'),
                    meta: { title: 'add' }
                },
                {
                    path: '/adminProjectEdit',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/adminProjectEdit.vue'),
                    meta: { title: 'edit' }
                },
                {
                    path: '/studentPro',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/studentPro.vue'),
                    meta: { title: 'Project' }
                },
                {
                    path: '/myselect',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/myselect.vue'),
                    meta: { title: 'My Select' }
                },
                {
                    path: '/teacherMyPro',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/teacher_my_pro.vue'),
                    meta: { title: 'Students Selected' }
                },
                {
                    path: '/userInfo',
                    component: () => import(/* webpackChunkName: "login" */ '../components/page/userInfo.vue'),
                    meta: { title: 'userInfo' }
                }
      
                
            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: 'Login' }
        },
        {
            path: '/register',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/register.vue'),
            meta: { title: 'Register' }
        }
    ]
});
