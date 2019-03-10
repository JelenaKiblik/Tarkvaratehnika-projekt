<template>
    <div class="recipe">
        <div class="container">
            <div v-if="!submitted">
                <h3>{{this.recipe.name}}</h3>

                <div v-if="this.recipe" style="text-align:left">
                    <div>
                        <label>Description: </label> {{this.recipe.description}}
                    </div>
                    <div>
                        <label>Ingredients: </label> {{this.recipe.ingredients}}
                    </div>
                    <button class="button is-small btn-danger" v-on:click="deleteById()">Delete</button>
                    <button class="button is-small btn-danger" v-on:click="changeRecipe()">Edit</button>
                    <router-link :to="{name: 'Edit', params: {id: recipe.id}}">Edit</router-link>
                </div>
            </div>
            <div v-else>
                <h3>Recipe is deleted!</h3>
                <!--<div class="col-md-6">-->
                    <!--<router-view @refreshData="refreshDetails"></router-view>-->
                <!--</div>-->
            </div>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";
    export default {
        name: "Recipe",
        props: ["recipe"],
        data() {
            return{
                submitted: false
            };
        },
        methods: {
            deleteById() {
                http
                    .delete("/recipe/" + this.recipe.id)
                    .then(response => {
                        this.recipes = response.data;
                    });
                this.submitted = true;
            },
            changeRecipe(){
            }
        }
    }
</script>

<style scoped>
    h3 {
        margin-top:150px;
    }
    label{
        min-width: 300px;
        margin:auto
    }
</style>