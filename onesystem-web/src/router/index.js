import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/components/home'
import HomePage from '@/components/homePage/homePage'
import HealthTools from '@/components/healthTools/healthToolsList'
import BodyMassIndex from '@/components/healthTools/bodyMassIndex'
import BodySurfaceArea from '@/components/healthTools/bodySurfaceArea'
import ChildrenDose from '@/components/healthTools/childrenDose'
import CreatinineClearanceRate from '@/components/healthTools/creatinineClearanceRate'
import StandardBodyWeight from '@/components/healthTools/standardBodyWeight'
import ExpectedDateOfConfinement from '@/components/healthTools/expectedDateOfConfinement'
import ShockIndex from '@/components/healthTools/shockIndex'
import BasicsConsumption from '@/components/healthTools/basicsConsumption'
import FetusWeight from '@/components/healthTools/fetusWeight'
import Register from '@/components/shop/loginEndRegister/Register'
import Login from '@/components/shop/loginEndRegister/Login'
import CheckLogin from '@/components/shop/loginEndRegister/CheckLogin'
import ResetPassword from '@/components/shop/loginEndRegister/ResetPassword'
import Shop from '@/components/shop/shoppingMall/Shop'
import Article from '@/components/article/article'
import ArticleDetail from '@/components/article/articleDetail'
import SearchKey from '@/components/search/searchKey'
import Search from '@/components/search/search'
import Disease from '@/components/disease/disease'
import Medicine from '@/components/medicine/medicine'
import MedicineClassify from '@/components/medicine/medicineClassify'
import MedicineTwostage from '@/components/medicine/medicineTwostage'
import MedicineThreestage from '@/components/medicine/medicineThreestage'
import MedicineDetail from '@/components/medicine/medicineDetail'
import Myself from '@/components/myself/myself'
import TdApp from '@/components/tdApp/tdApp'
import AddrManage from '@/components/myself/addrManage'
import QRcode from '@/components/myself/QRcode'

Vue.use(Router);

export default new Router({

  routes: [
    //首页
    {
      path: '/',
      name: 'Home',
      component: Home,
      children : [
        {path:'/home/homePage',component:HomePage}
      ]
    },
    //医学计算
    {
      path: '/healthTools',
      name: 'HealthTools',
      component: HealthTools
    },
    // BMI
    {
      path: '/healthTools/bodyMassIndex',
      name: 'BodyMassIndex',
      component: BodyMassIndex
    },
    // 体表面积
    {
      path: '/healthTools/bodySurfaceArea',
      name: 'BodySurfaceArea',
      component: BodySurfaceArea
    },
    // 儿童用药剂量（按体表面积）
    {
      path: '/healthTools/childrenDose',
      name: 'ChildrenDose',
      component: ChildrenDose
    },
    // 肌酐清除率
    {
      path: '/healthTools/creatinineClearanceRate',
      name: 'CreatinineClearanceRate',
      component: CreatinineClearanceRate
    },
    // 标准体重（IBW）
    {
      path: '/healthTools/standardBodyWeight',
      name: 'StandardBodyWeight',
      component: StandardBodyWeight
    },
    // 孕周预产期计算
    {
      path: '/healthTools/expectedDateOfConfinement',
      name: 'ExpectedDateOfConfinement',
      component: ExpectedDateOfConfinement
    },
    // 休克指数
    {
      path: '/healthTools/shockIndex',
      name: 'ShockIndex',
      component: ShockIndex
    },
    // 基础能耗（成人）
    {
      path: '/healthTools/basicsConsumption',
      name: 'BasicsConsumption',
      component: BasicsConsumption
    },
    // 胎儿体重预测
    {
      path: '/healthTools/fetusWeight',
      name: 'FetusWeight',
      component: FetusWeight
    },
    //注册与登录 找回密码
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/checkLogin',
      name: 'CheckLogin',
      component: CheckLogin
    },
    {
      path: '/resetPassword',
      name: 'ResetPassword',
      component: ResetPassword
    },
    //商城
    {
      path: '/shoppingMall',
      name: 'Shop ',
      component: Shop
    },
    //文章
    {
      path: '/article',
      name: Article,
      component: Article,
    },
    //文章详情页
    {
      path: '/articleDetail',
      name: ArticleDetail,
      component: ArticleDetail,
    },
    //搜索疾病和药品列表
    {
      path:'/search',
      name:Search,
      component:Search,
    },
    {
      path:'/searchKey',
      name:SearchKey,
      component:SearchKey,
    },
    //疾病
    {
      path: '/disease',
      name: Disease,
      component: Disease,
    },
    //药品(顶部分类)
    {
      path: '/medicine',
      name: Medicine,
      component: Medicine,
    },
    //药品二级分类（顶部下面的分类）
    {
      path:'/medicineClassify',
      name:MedicineClassify,
      component:MedicineClassify
    },
    //三级分类下面的分类（点击下一级页面）
    {
      path:'/medicineTwostage',
      name:MedicineTwostage,
      component:MedicineTwostage
    },
    //四级分类
    {
      path:'/medicineThreestage',
      name:MedicineThreestage,
      component:MedicineThreestage
    },
    //药品详情
    {
      path:'/medicineDetail',
      name:MedicineDetail,
      component:MedicineDetail
    },
    //我的
    {
      path: '/myself',
      name: Myself,
      component: Myself,
    },
    //地址管理
    {
      path: '/addrManage',
      name: AddrManage,
      component: AddrManage,
    },
    //二维码页面
    {
      path: '/QRcode',
      name: QRcode,
      component: QRcode
    },
    //下载app
    {
      path: '/tdApp',
      name: TdApp,
      component: TdApp,
    }


  ]
})



