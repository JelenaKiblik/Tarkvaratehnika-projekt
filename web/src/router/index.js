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
import Search from "../components/Search";


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
            path: '/addRecipe',
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
        {
            path: '/search',
            name: 'Search',
            component: Search
        },
    ]
});

export default router;
