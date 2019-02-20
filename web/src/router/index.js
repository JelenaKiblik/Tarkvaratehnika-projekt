import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Recipes from '@/components/Recipes'
import AddRecipe from '@/components/AddRecipe'
import MyAccount from '@/components/MyAccount'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/Recipes',
            name: 'Recipes',
            component: Recipes
        },
        {
            path: '/AddRecipe',
            name: 'AddRecipe',
            component: AddRecipe
        },
        {
            path: '/MyAccount',
            name: 'MyAccount',
            component: MyAccount
        }
    ]
})