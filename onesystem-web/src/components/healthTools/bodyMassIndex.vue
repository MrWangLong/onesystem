<template>
  <div>
    <div>
      <mt-header title="健康计算">
        <router-link to="/healthTools" slot="left">
          <mt-button icon="back"></mt-button>
        </router-link>
      </mt-header>
    </div>
    <div>
      <mt-cell class="page-title" title="体重指数（BMI）"/>
    </div>
    <div>
      <mt-field label="身高" type='number' placeholder="cm" v-model="stature"></mt-field>
      <mt-field label="体重" type='number' placeholder="kg" v-model="weight"></mt-field>
      <mt-field label="体重指数（BMI）" readonly='readonly' v-model="bmi"></mt-field>
      <div style="margin-top: 20px;" >
        <mt-button type="primary" size="large" @click="calculateBMI">开始计算</mt-button>
      </div>
      <div style="margin-left:20px;text-align: left;">
        <p style="font-size:14px;margin-top:10px;">计算公式：</p>
        <p style="font-size:14px;">体重指数（BMI）= 体重（kg）/身高（m）的平方</p>
        <p style="font-size:14px;margin-top:10px;">说明：</p>
        <p style="font-size:14px;">正常范围：18.5-24.9，超重：25-30，肥胖：30以上</p>
        <p style="font-size:14px;margin-top:10px;">参考文献：</p>
        <p style="font-size:14px;">中国成人超重和肥胖症预防控制指南</p>
      </div>
    </div>
  </div>
</template>

<style>

</style>

<script>
  export default{
    data () {
      return {
        stature:'',
        weight:'',
        bmi:''
      }
    },
    methods:{
      calculateBMI:function(){
        var weight_c = this.weight;
        var stature_c = this.stature/100;
        var result = weight_c/(stature_c*stature_c);
        this.bmi = result;
      }

    }
  }
</script>
