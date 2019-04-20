<template>
    <div class="list row">
        <div class="col-md-6">
            <h3>Recipes</h3>
<!--            <ul>-->
<!--                <li v-for="(recipe, index) in recipes" :key="index">-->
<!--                    <router-link :to="{-->
<!--                                name: 'recipe',-->
<!--                                params:{ recipe: recipe, id: recipe.id }}">-->
<!--                        {{recipe.name}}-->
<!--                    </router-link>-->
<!--                </li>-->
<!--            </ul>-->

            <div v-for="(recipe, index) in recipes" :key="index">
                    <router-link :to="{
                 name: 'recipe',
                 params:{ recipe: recipe, id: recipe.id }}">

                Name: {{ recipe.name }} <br> Description: {{ recipe.description }} <br> Ingredients: {{ recipe.ingredients }}
                </router-link>
            </div>
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
    recipe {
        border: 1px solid black;
        list-style-type: none;
        margin: 20px;
        padding-bottom: 10px;
    }
</style>