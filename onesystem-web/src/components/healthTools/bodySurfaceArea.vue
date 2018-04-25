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
      <mt-cell class="page-title" title="体表面积"/>
    </div>
    <div>
      <table style="width:100%;">
        <tr>
          <td @click="man_selected()">
            <img v-if="radio_man === 0" src="../../assets/img/home/radio_unchecked.png">
            <img v-if="radio_man === 1" src="../../assets/img/home/radio_selected.png">成年男性
          </td>
          <td @click="woman_selected()">
            <img v-if="radio_woman === 0" src="../../assets/img/home/radio_unchecked.png">
            <img v-if="radio_woman === 1" src="../../assets/img/home/radio_selected.png">成年女性
          </td>
          <td @click="child_selected()">
            <img v-if="radio_child === 0" src="../../assets/img/home/radio_unchecked.png">
            <img v-if="radio_child === 1" src="../../assets/img/home/radio_selected.png">儿童
          </td>
        </tr>
      </table>
      <mt-field label="身高" type='number' placeholder="cm" v-model="stature"></mt-field>
      <mt-field label="体重" type='number' placeholder="kg" v-model="weight"></mt-field>
      <mt-field label="体表面积" readonly='readonly' placeholder="㎡" v-model="bsa"></mt-field>
      <div style="margin-top: 20px;" >
        <mt-button type="primary" size="large" @click="calculate()">开始计算</mt-button>
      </div>
      <div style="margin-left:20px;text-align: left;">
        <p style="font-size:14px;margin-top:10px;">计算公式：</p>
        <p style="font-size:14px;">男性：0.00607*身高(cm)+0.0127*体重(kg)-0.0698</p>
        <p style="font-size:14px;">女性：0.00586*身高(cm)+0.0126*体重(kg)-0.0416</p>
        <p style="font-size:14px;">儿童：0.0061*身高(cm)+0.0128*体重(kg)-0.1529</p>
        <p style="font-size:14px;margin-top:10px;">参考文献：</p>
        <p style="font-size:14px;">赵松山,刘海友,姚家邦,等.中国成年男子体表面积的测量</p>
        <p style="font-size:14px;">[J].营养学报,1984,6(2):87-95.</p>
        <p style="font-size:14px;">赵松山,刘海友,姚家邦,等.中国成年男子体表面积的测量</p>
        <p style="font-size:14px;">[J].营养学报,1987,9(3):200-207.</p>
        <p style="font-size:14px;">陈新谦,金有豫,汤光.新编药物学第十三版.人民卫生出版社</p>
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
        radio_child: 0,
        stature:'',
        weight:'',
        bsa:''
      }
    },
    methods:{
      man_selected:function(){
        this.radio_man = 1;
        this.radio_woman = 0;
        this.radio_child = 0;
      },
      woman_selected:function(){
        this.radio_man = 0;
        this.radio_woman = 1;
        this.radio_child = 0;
      },
      child_selected:function(){
        this.radio_man = 0;
        this.radio_woman = 0;
        this.radio_child = 1;
      },
      calculate:function(){
        var stature_c = this.stature;
        var weight_c = this.weight;
        var result = '';
        if(this.radio_man == 1){ // 成年男性
          result = 0.00607*stature_c+0.0127*weight_c-0.0698;
        }else if(this.radio_woman == 1){ // 成年女性
          result = 0.00586*stature_c+0.0126*weight_c-0.0416;
        }else if(this.radio_child == 1){ // 儿童
          result = 0.0061*stature_c+0.0128*weight_c-0.1529;
        }
        this.bsa = result;
      }

    }
  }
</script>
