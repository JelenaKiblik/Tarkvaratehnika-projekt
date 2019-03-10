<template>
    <div class="recipe">
        <div class="container">
            <div v-if="!submitted">
                <h4>{{this.recipe.name}}</h4>

                <div v-if="this.recipe" style="text-align:left">
                    <div>
                        <label>Kirjeldus: </label> {{this.recipe.description}}
                    </div>
                    <div>
                        <label>Materialid: </label> {{this.recipe.materials}}
                    </div>
                    <button class="button is-small btn-danger" v-on:click="deleteRecipe()">Delete</button>
                    <button class="button is-small btn-danger" v-on:click="changeRecipe()">Edit</button>
                    <router-link :to="{name: 'Edit', params: {id: recipe.id}}">Edit</router-link>
                </div>
            </div>
            <div v-else>
                <h3>Recipe is deleted!</h3>
                <div class="col-md-6">
                    <router-view @refreshData="refreshDetails"></router-view>
                </div>
            </div>
        </div></div>
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
            deleteRecipe() {
                http
                    .delete("/recipe/" + this.recipe.id)
                    .then(response => {
                        this.$emit("refreshData");
                        this.$router.push('/');
                    });
                this.submitted = true;
            },
            changeRecipe(){
            }
        }
    }
</script>

<style scoped>
</style>