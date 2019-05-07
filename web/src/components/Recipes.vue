<template>
    <div class="container" style="justify-content: center;max-width: 100%
">
        <h1 style="color: #873600; font-family: Papyrus">Recipes</h1>
        <div class="col">
            <div class="row" style="justify-content: center; ">

                <div  v-for="(recipe, index) in recipes" :key="index">
                    <router-link :to="{
                     name: 'recipe',
                     params:{ recipe: recipe, id: recipe.id }}">
                    <div class="row">
                        <div class="col" style="padding-top: 40px; margin-left:25%">
                            <img src="../assets/foodpic.jpeg"  class="rounded w-100 d-block ">
                            <h2 style="color: #873600; font-family: Papyrus">{{ recipe.name }}</h2>
        <!--                    Description: {{ recipe.description }}-->
        <!--                    Ingredients: {{ recipe.ingredients }}-->
                            <a class="btn btn-outline-success my-2 my-sm-0" role="button">View recipe</a>
                            <br>
                        </div>
                    </div>
                    </router-link>
                </div>
            </div>
        </div>
    <div>
    <router-view @refreshData="refreshList"></router-view>
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

    a {
        color: black;
        text-decoration: none;
    }

    h1 {
        margin-top:100px;
    }
    h2 {
        margin-top:25px;
    }

    recipe {
        border: 1px solid black;
        list-style-type: none;
        padding-bottom: 10px;
    }
</style>
