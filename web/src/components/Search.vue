<template>
    <div id="search" >
        <h2>Type the recipe name you are searching for</h2>
        <div class="search-wrapper" >
            <input type="text" v-model="searchStr" placeholder="Search recipe"
                   style="width: 800px;"/>
        </div>
        <br>
        <h3 >Results:</h3>
        <div class="wrapper" >
                <div v-for="(recipe,index) in filteredList" :key="index">
                    <router-link :to="{
                            name: 'recipe',
                            params: { recipe: recipe, id: recipe.id }
                        }" style="color:#a57934">
                        {{recipe.name }}
                    </router-link>
                </div>
        </div>
        <br>
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

    h2 {
        margin-top:100px;
        /*margin-bottom: 50px;*/
    }


    .search-wrapper {
        margin-top: 50px;
        position: relative;
    }
</style>
