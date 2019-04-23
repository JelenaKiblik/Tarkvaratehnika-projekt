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
                    <button class="button is-small btn-primary" style="float:left;" >
                        <router-link :to="{name: 'edit', params: {recipe:recipe, id: recipe.id}}">Edit</router-link></button>
                </div>
                <button class="button is-small btn-primary" style="float:left; margin-left:5px" v-on:click="deleteRecipe()">Delete</button>
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
    h3 {
        margin-top:150px;
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