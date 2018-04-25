<template>
  <div>
    <div>
      <mt-header title="健康计算">
        <router-link to="/" slot="left">
          <mt-button icon="back"></mt-button>
        </router-link>
      </mt-header>
    </div>
    <div>
      <mt-cell to="/healthTools/bodyMassIndex" title="体重指数（BMI）" is-link></mt-cell>
      <mt-cell to="/healthTools/bodySurfaceArea" title="体表面积" is-link></mt-cell>
      <mt-cell to="/healthTools/childrenDose" title="儿童用药剂量（按体表面积）" is-link></mt-cell>
      <mt-cell to="/healthTools/creatinineClearanceRate" title="肌酐清除率" is-link></mt-cell>
      <mt-cell to="/healthTools/standardBodyWeight" title="标准体重（IBW）" is-link></mt-cell>
      <mt-cell to="/healthTools/expectedDateOfConfinement" title="孕周预产期计算" is-link></mt-cell>
      <mt-cell to="/healthTools/shockIndex" title="休克指数" is-link></mt-cell>
      <mt-cell to="/healthTools/basicsConsumption" title="基础能耗（成人）" is-link></mt-cell>
      <mt-cell to="/healthTools/fetusWeight" title="胎儿体重预测" is-link></mt-cell>
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
