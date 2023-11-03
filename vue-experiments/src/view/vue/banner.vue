<template>
  <div class="banner">
      <div class="banner-text">
        Banner
      </div>
  </div>
</template>

<script>
import Manager from '../../interests/manager'

export default {
  props: ['bannerId'],
  data() {
    return {
      message: 'Hello World',
    };
  },
  created() {
    this.o = Manager.RegisterInterest('banner', this.bannerId);
    this.o.Subscribe(bannerData => {
      this.message = bannerData.message;
    });
  },
  watch: {
    bannerId: (val, oldVal) => {
      this.o.UpdateKey(val);
    }
  },
  beforeDestroy() {
    this.o.Dispose();
  }
};
</script>

<style>
.banner {
    position: relative;
    height: 250px;
    width: 100%;
    background-color: darkslategrey;
}

.banner-text {
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    position: relative;
    display: inline;
}
</style>