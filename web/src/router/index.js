import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home'
import Recipe from '@/components/Recipe'
import Recipes from '@/components/Recipes'
import AddRecipe from '@/components/AddRecipe'
import MyAccount from '@/components/MyAccount'
import Edit from "@/components/Edit";
import authorization from "@/components/Authorization";
// import store from "@/store";

Vue.use(VueRouter)

const router = new VueRouter({
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/Authorization',
            name: 'authorization',
            component: authorization
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
    ]
});

// router.beforeEach((to, from, next) => {
//     const publicPages = ['/authorization'];
//     const authRequired = !publicPages.includes(to.path);
//     const loggedIn = store.getters.isAuthenticated;
//
//     if (authRequired && !loggedIn) {
//         return next('/authorization');
//     }
//     next();
// });

export default router;