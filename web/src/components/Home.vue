<template>
    <div class="d-flex flex-column">
        <div >
            <img src="../assets/header.jpg">
        </div>
        <div class="caption text-center">
            <h3 style="color: #873600; font-family: Papyrus">Search for recipes by clicking the search button :)</h3>
        </div>
        <h3 style="color: #873600; font-family: Papyrus; ">or</h3>
        <h3 style="color: #873600; font-family: Papyrus; padding-bottom: 50px">...maybe you want to try these recipes?</h3>
        <div>
            <div  v-for="(recipe, index) in recipes.slice(0,3)" :key="index">
                <router-link :to="{
                    name: 'recipe',
                    params:{ recipe: recipe, id: recipe.id }}">
                    <div class="row" style="padding-top: 40px; margin-left:25%">
                        <div class="col-lg-6" style="padding-top: 40px; margin-left:25%">
                            <img src="../assets/foodpic.jpeg"  class="rounded w-100 d-block ">
                            <h2 style="color: #873600; font-family: Papyrus">{{ recipe.name }}</h2>

                            <a class="btn btn-outline-success my-2 my-sm-0" role="button">View recipe</a>
                            <br>
                        </div>
                    </div>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "Recipes",
        data() {
            return {
                recipes: []
            }
        },
        methods: {
            retrieveRecipes() {
                http.
                get("/recipes").
                then(response=> {
                    this.recipes = response.data;
                })
            },
            refreshList() {
                this.retrieveRecipes();
            }
        },
        mounted() {
            this.retrieveRecipes();
        }
    };

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
