<template>
    <div class="d-flex flex-column">
        <div >
            <img src="../assets/header.jpg">
        </div>
        <div class="caption text-center">
            <h3 style="color: #873600; font-family: Papyrus">{{ msg }}</h3>
        </div>
        <div id="search">
        <div class="search-wrapper" >
            <input class="form-control form-control-sm" type="text" v-model="searchStr" placeholder="Search recipe"/>
        </div>
            <br>
        <div class="wrapper" >
            <div v-for="(recipe,index) in filteredList" :key="index">
                <router-link :to="{
                            name: 'recipe',
                            params: { recipe: recipe, id: recipe.id }
                        }" style="color:#a57934">
                    {{recipe.name}}
                </router-link>
            </div>
        </div>
        </div>

        <h3 style="color: #873600; font-family: Papyrus; padding-bottom: 50px">...or maybe you wanna try these recipes?</h3>
    </div>
</template>

<script>

    import axios from "axios";
    import http from "../http-common";
    export default {
        name: 'Home',
        data () {
            return {
                msg: 'Search for some recipes'
            }
        },
        name: "Search",
        data() {
            return {
                recipes: [],
                searchStr: ''
            }
        },
        methods: {
        },
        computed: {
            filteredList() {
                return this.recipes.filter(recipe => {
                    return recipe.name.toLowerCase().includes(this.searchStr.toLowerCase())
                })
            }
        },
        mounted() {
            axios.get('http://localhost:8080/api/loggedIn').then(response => (this.user = response.data));
            http.get("/recipes").then(response=> {this.recipes = response.data;})
        }
    }
</script>

<style scoped>

    h3 {
        margin: 40px 0 0;
    }
    ul {
        list-style-type: none;
        padding: 0;
    }
    li {
        display: inline-block;
        margin: 0 10px;
    }
    a {
        color: #447eb9;
    }

    img {
        margin: 70px 0 0;
        max-width: 100%;
    }

</style>