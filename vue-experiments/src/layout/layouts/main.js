export default {
  children: [
    {
      style: {
        'margin-bottom': '20px'
      },
      component: () => import('../../view/vue/banner.vue')
    },
    {
      classes: ['row'],
      children: [
        {
          classes: ["column", "one-third"],
          component: () => import('../../view/vue/banner.vue')
        },
        {
          classes: ["column", "one-third"],
          component: () => import('../../view/vue/banner.vue')
        },
        {
          classes: ["column", "one-third"],
          component: () => import('../../view/vue/banner.vue')
        }
      ]
    },
    {
      style: {
        'margin-top': '20px'
      },
      component: () => import('../../view/vue/banner.vue')
    }
  ]
}