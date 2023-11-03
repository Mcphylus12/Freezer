<template>
  <div id="app">
  {{ message }}
  <layout layout="main" />
  </div>
</template>

<script>
import fetch from '../../data/fetcher';

export default {
  data() {
    return {
      message: 'Hello World',
    };
  },
  created() {
    fetch('get', '/api/TestData?message=pmessage', null).then(js => {
      this.message = js.data;
    })
  }
};
</script>

<style>
</style>