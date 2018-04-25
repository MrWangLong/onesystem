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
      <mt-cell class="page-title" title="肌酐清除率"/>
    </div>
    <div>
      <table style="width:80%;">
        <tr>
          <td @click="man_selected()">
            <img v-if="radio_man === 0" src="../../assets/img/home/radio_unchecked.png">
            <img v-if="radio_man === 1" src="../../assets/img/home/radio_selected.png">男性
          </td>
          <td @click="woman_selected()">
            <img v-if="radio_woman === 0" src="../../assets/img/home/radio_unchecked.png">
            <img v-if="radio_woman === 1" src="../../assets/img/home/radio_selected.png">女性
          </td>
        </tr>
      </table>
      <mt-field label="年龄" type='number' placeholder="岁" v-model="age"></mt-field>
      <mt-field label="体重" type='number' placeholder="kg" v-model="weight"></mt-field>
      <mt-field label="血肌酐" type='number' placeholder="umol/L" v-model="serumCreatinine"></mt-field>
      <mt-field label="儿童剂量" type='number' placeholder="g" v-model="childrenDosage"></mt-field>
      <mt-field label="肌酐清除率" readonly='readonly' placeholder="ml/min" v-model="ccr"></mt-field>
      <div style="margin-top: 20px;">
        <mt-button type="primary" size="large" @click="calculate()">开始计算</mt-button>
      </div>
      <div style="margin-left:20px;text-align: left;">
        <p style="font-size:14px;margin-top:10px;">计算公式：</p>
        <p style="font-size:14px;">男性：(140-年龄)*体重(kg)/(0.818*肌酐浓度umol/L)</p>
        <p style="font-size:14px;">女性：(140-年龄)*体重*0.85/(0.818*肌酐浓度umol/L)</p>
        <p style="font-size:14px;margin-top:10px;">参考文献：</p>
        <p style="font-size:14px;">Cockcroft D W,Gault M H. Prediction of creatinine</p>
        <p style="font-size:14px;">clearance from serum creatinine[J]. Nephron, 1976,</p>
        <p style="font-size:14px;">16(1):31-41.</p>
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
        radio_man: 1,
        radio_woman: 0,
        age:'',
        weight:'',
        serumCreatinine:'',
        childrenDosage:'',
        ccr:''
      }
    },
    methods:{
      man_selected:function(){
        this.radio_man = 1;
        this.radio_woman = 0;
      },
      woman_selected:function(){
        this.radio_man = 0;
        this.radio_woman = 1;
      },
      calculate:function(){
        var age_c = this.age;
        var weight_c = this.weight;
        var serumCreatinine_c = this.serumCreatinine;
        var childrenDosage_c = this.childrenDosage;
        var result = '';
        if(this.radio_man == 1){ // 男性
          result = (140-age_c)*weight_c/(0.818*serumCreatinine_c);
        }else if(this.radio_woman == 1){ // 女性
          result = (140-age_c)*weight_c*0.85/(0.818*serumCreatinine_c);
        }
        this.ccr = result;
      }

    }
  }
</script>
