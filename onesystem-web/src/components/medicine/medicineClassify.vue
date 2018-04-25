<template>
  <div>
    <header class="mint-header">
      <div class="mint-header-button is-left"><a href="#/" class="router-link-active">
        <button class="mint-button mint-button--default mint-button--normal"><span class="mint-button-icon"><i
          class="mintui mintui-back"></i></span></button>
      </a></div>
      <h1 class="mint-header-title">药品分类</h1>
      <div class="mint-header-button is-right"></div>
    </header>

    <mt-index-list>
      <mt-index-section index="A">
        <router-link to="/medicineDetail"><mt-cell title="埃索美拉唑肠溶胶囊"></mt-cell></router-link>
        <mt-cell title="奥利司他"></mt-cell>
        <mt-cell title="埃索美拉唑肠溶胶囊"></mt-cell>
      </mt-index-section>
      <mt-index-section index="B">
        <mt-cell title="奥利司他"></mt-cell>
        <mt-cell title="奥利司他"></mt-cell>
      </mt-index-section>
      ...
      <mt-index-section index="Z">
        <mt-cell title="Zack"></mt-cell>
        <mt-cell title="Zane"></mt-cell>
      </mt-index-section>
    </mt-index-list>
  </div>
</template>
<script>
</script>
<style type='text/css'>

</style>
