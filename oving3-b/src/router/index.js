import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login_Page.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('../views/Home_Page.vue')
  },
  {
    path: '/register',
    name: 'Register',

    component: () => import('../views/Register_Page.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

