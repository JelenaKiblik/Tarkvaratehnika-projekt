<template>
    <div class="recipe">
        <div class="container">
            <div v-if="!submitted">
                <h2 style="color: #873600; font-family: Papyrus">{{this.recipe.name}}</h2>
                <div v-if="this.recipe" style="text-align:left">
                    <div class="row">
                        <div class="col">
                            <img src="../assets/foodpic.jpeg"  class="rounded w-100 d-block ">
                        </div>
                        <div class="col">
                            <div>
                                <h4 style="color: #873600; font-family: Papyrus">Description: </h4>
                                {{this.recipe.description}}
                            </div>
                            <br>
                            <div>
                                <h4 style="color: #873600; font-family: Papyrus">Ingredients: </h4>
                                {{this.recipe.ingredients}}
                            </div>
                        </div>
                    </div>
                    <button class="button is-small" style="color: #873600;" v-on:click="deleteRecipe()">Delete</button>
                    <button class="button is-small" style="color: #873600;" >
                        <router-link :to="{name: 'edit', params: {recipe:recipe, id: recipe.id}}">Edit</router-link>
                    </button>
                </div>
            </div>
            <div v-else>
                <h3>Recipe is deleted...</h3>
                <router-link to="/recipes">
                    <button type="reset" >All recipes</button>
                </router-link>
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
            return {
                submitted: false
            };
        },
        methods: {
            deleteRecipe() {
                http
                    .delete("/recipe/" + this.recipe.id)
                    .then(response => {
                        this.$emit("refreshData");
                        this.$router.push('/recipe');
                    });
                this.submitted = true;
            }
        }
    }
</script>

<style scoped>
    h2 {
        margin-top:150px;
        margin-bottom: 50px;
    }
    label{
        min-width: 100px;
        margin:auto
    }
    a {
        color: white;
        text-decoration: none;
    }
    button {
        margin-top: 5%;
    }
</style>
