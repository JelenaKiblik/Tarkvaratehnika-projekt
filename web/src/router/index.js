import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home'
import Recipes from '@/components/Recipes'
import AddRecipe from '@/components/AddRecipe'
import MyAccount from '@/components/MyAccount'
import Recipe from '@/components/Recipe';

import Edit from "@/components/Edit";
import store from "@/store";

import Register from "@/components/Register";
import Authorization from "../components/Authorization";

Vue.use(VueRouter);

const router = new VueRouter({
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/home',
            name: 'Home',
            component: Home
        },
        {
            path: '/authorization',
            name: 'authorization',
            component: Authorization
        },
        {
            path: '/recipes',
            name: 'recipes',
            component: Recipes
        },
        {
            path: '/recipe',
            name: 'recipe',
            component: Recipe,
            props:true
        },
        {
            path: '/edit',
            component: Edit,
            name: 'edit',
            props:true
        },
        {
            path: '/add',
            name: 'AddRecipe',
            component: AddRecipe,
        },
        {
            path: '/MyAccount',
            name: 'MyAccount',
            component: MyAccount,
            props: true
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
    ]
});


router.beforeEach((to, from, next) => {
    const publicPages = ['/authorization', '/register'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = store.getters.isAuthenticated;

    if (authRequired && !loggedIn) {
        return next('/authorization');
    }
    next();
});
export default router;