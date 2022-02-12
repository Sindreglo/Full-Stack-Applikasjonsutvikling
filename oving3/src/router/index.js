import { createRouter, createWebHistory } from 'vue-router'
import Calculator from "../views/Calculator.vue";

const routes = [
  {
    path: "/",
    name: "Calculator",
    component: Calculator
  },
  {
    path: "/Kontaktskjema",
    name: "Kontaktskjema",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Kontaktskjema.vue")
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
