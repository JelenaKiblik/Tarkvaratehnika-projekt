<template>
    <div class="list row">
        <div class="col-md-6" style="margin-top: 20%;">
            <h3>Recipes</h3>
            <ul style="font-size:20px">
                <li v-for="(recipe, index) in recipes" :key="index">

                    <router-link :to="{
                            name: 'recipe',
                            params: { recipe: recipe, id: recipe.id }
                        }" style="color:#333">
                        {{recipe.name}}
                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
            <!--<ul>-->
                <!--<li class="recipe-item" v-for="recipe in recipes" :key=recipe.id>-->
                    <!--<router-link :to="{-->
                                <!--name: 'recipe-details',-->
                                <!--params:{ recipe: recipe, id:recipe.id }}">-->
                        <!--{{recipe.recipeName}}-->
                    <!--</router-link>-->
                <!--</li>-->
            <!--</ul>-->
        <!--</div>-->
        <!--<div class="col-md-6">-->
            <!--<router-view @refreshData="refreshList"></router-view>-->
        <!--</div>-->
    <!--</div>-->

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

<style>
    .list {
        text-align: left;
        max-width: 450px;
        margin: auto;
    }
    ul {list-style-type: square;}
</style>