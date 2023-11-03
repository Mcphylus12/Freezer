import Vue from 'vue';
import Main from './view/vue/main.vue';
import { Bootstrap, RegisterLayout } from './layout/LayoutManager';
import MainLayout from './layout/layouts/main'
import Manager from './interests/manager';
import BannerManager from './interests/managers/bannerManager';

//Layouts
Bootstrap();
RegisterLayout('main', MainLayout);

// Data Management
Manager.RegisterManager('banner', new BannerManager());

new Vue({
  el: '#app',
  render: h => h(Main),
});