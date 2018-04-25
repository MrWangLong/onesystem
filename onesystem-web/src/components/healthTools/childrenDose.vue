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
      <mt-cell class="page-title" title="儿童用药剂量（按体表面积）"/>
    </div>
    <div>
      <mt-field label="成人剂量" type='number' placeholder="g" v-model="adultDosage"></mt-field>
      <mt-field label="儿童身高" type='number' placeholder="cm" v-model="childrenHeight"></mt-field>
      <mt-field label="儿童体重" type='number' placeholder="kg" v-model="childrenWeight"></mt-field>
      <mt-field label="儿童剂量" readonly='readonly' v-model="childrenDosage"></mt-field>
      <div style="margin-top: 20px;" >
        <mt-button type="primary" size="large" @click="calculate()">开始计算</mt-button>
      </div>
      <div style="margin-left:20px;text-align: left;">
        <p style="font-size:14px;margin-top:10px;">计算公式：</p>
        <p style="font-size:14px;">儿童剂量（按体表面积）= 成人剂量*儿童表面积/1.73</p>
        <p style="font-size:14px;">儿童体表面积计算：0.0061*身高（cm）+0.0128*体重（kg）-0.1529</p>
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
        adultDosage:'',
        childrenHeight:'',
        childrenWeight:'',
        childrenDosage:''
      }
    },
    methods:{
      calculate:function(){
        var adultDosage_c = this.adultDosage;
        var childrenHeight_c = this.childrenHeight;
        var childrenWeight_c = this.childrenWeight;
        var cbsa = 0.0061*childrenHeight_c+0.0128*childrenWeight_c-0.1529; // 儿童体表面积
        var result = adultDosage_c*cbsa/1.73;
        this.childrenDosage = result;
      }

    }
  }
</script>
