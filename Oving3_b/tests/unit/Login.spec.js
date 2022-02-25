import Login from '@/views/Login_Page.vue'
import { mount } from '@vue/test-utils'
import register_Page from "@/views/Register_Page";

describe('Login_Page', () => {
  test('Register option unavaliable before failed login', () => {
    const wrapper = mount(Login)
    expect(wrapper.find('p').isVisible()).toBe(false)
  })

  test('Register option avaliable when failed login', async () => {
    const wrapper = mount(Login)
    await wrapper.setData( { failed: true })
    expect(wrapper.find('p').isVisible()).toBe(true)
  })

  test('Login with right username/password changes view', async () => {
    const wrapper = mount(Login)
    const registerWrapper = mount(register_Page)
    await registerWrapper.setData({ username: 'ole', password: 'ole123'})

    const inputName = wrapper.find('[data-testid="inputName"]')
    await inputName.setValue('ole')
    const inputPassword = wrapper.find('[data-testid="inputPassword"]')
    await inputPassword.setValue('ole123')
    await wrapper.find('button').trigger('click')
    expect(Login.data().failed).toBe(false)
  })
})
