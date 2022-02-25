import Register from '@/views/Register_Page.vue'
import { mount } from '@vue/test-utils'



describe('Register_Page', () => {
    test('Register user if user contains username and password', async () => {
        /**
         * const user = {
         *             name: 'Ole',
         *             address: 'Oleveien12',
         *             username: 'Ole',
         *             password: 'Ole123',
         *             email: 'ole@gmail.com',
         *             phone: '123456789'
         *         }
         *
         *         const wrapper = mount(Register, { props: {
         *             user
         *             }
         *         })
         */

        const wrapper = mount(Register)

        await wrapper.find('[data-testid="inputName"]').setValue('Ole')
        await wrapper.find('[data-testid="inputAddress"]').setValue('Oleveien12')
        await wrapper.find('[data-testid="inputUsername"]').setValue('Ole')
        await wrapper.find('[data-testid="inputPassword"]').setValue('Ole123')
        await wrapper.find('[data-testid="inputEmail"]').setValue('Ole@ole.com')
        await wrapper.find('[data-testid="inputPhone"]').setValue('12345678')

        expect(wrapper.find('button').element.disabled).toBe(false)
    })

    test('Does not register user if user does not contains username and password', async () => {
        const wrapper = mount(Register)

        await wrapper.find('[data-testid="inputName"]').setValue('Ole')
        await wrapper.find('[data-testid="inputAddress"]').setValue('Oleveien12')
        await wrapper.find('[data-testid="inputUsername"]').setValue('')
        await wrapper.find('[data-testid="inputPassword"]').setValue('')
        await wrapper.find('[data-testid="inputEmail"]').setValue('Ole@ole.com')
        await wrapper.find('[data-testid="inputPhone"]').setValue('12345678')

        expect(wrapper.find('button').element.disabled).toBe(true)
    })

})
