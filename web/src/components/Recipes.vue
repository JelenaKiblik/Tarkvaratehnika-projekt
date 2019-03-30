<template>
    <div class="list row">
        <div class="col-md-6">
            <h3>Recipes</h3>
            <ul>
                <li class="recipe-item" v-for="recipe in recipes" :key=recipe.id>
                    <router-link :to="{
                                name: 'recipe-details',
                                params:{ recipe: recipe, id:recipe.id }}">
                        {{recipe.recipeName}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
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
    h3 {
        margin-top:100px;
    }
    .recipe-item {
        border: 1px solid black;
        list-style-type: none;
        margin: 20px;
        padding-bottom: 10px;
    }
</style>