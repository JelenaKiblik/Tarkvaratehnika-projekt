<template>
    <div id="search" >
        <div class="search-wrapper" >
            <input type="text" v-model="searchStr" placeholder="Search recipe"/>
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
</template>

<script>
    import axios from "axios";
    import http from "../http-common";
    export default {
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
    .search-wrapper {
        margin-top: 10%;
        position: relative;
    }
</style>
