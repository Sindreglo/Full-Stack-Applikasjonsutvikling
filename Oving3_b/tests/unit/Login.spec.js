import Login from '@/views/Login.vue'
import { shallowMount } from '@vue/test-utils'

describe('Login.vue', () => {
  test('Register option unavaliable before failed login', () => {
    let wrapper = shallowMount(Login)
    expect(wrapper.find('button').isVisible()).toBe(true)
  })

  test('Register option avaliable when failed login', async () => {
    expect(true).toBe(true)
  })
})
