<template>
    <div class="d-flex flex-column">
        <div >
            <img src="../assets/header.jpg">
        </div>
        <div  id="start">
            <div class="caption text-center">
                <h3 style="color: #873600; font-family: Papyrus">Let's get started</h3>
            </div>
            <div class="row" style="justify-content: center">
                <h3><router-link to="/search" id='button'>Search for recipes</router-link></h3>
                <h3><router-link to="/Recipes"  id='button'>Browse recipes</router-link></h3>
            </div>
            <h3 style="color: #873600; font-family: Papyrus;padding-top: 10px">...or maybe you want to try these recipes down below?</h3>

        </div>

        <div>
            <div class="col">
                <div class="row" style="justify-content: center">
                    <div  v-for="(recipe, index) in recipes.slice(0,3)" :key="index">
                        <router-link :to="{
                            name: 'recipe',
                            params:{ recipe: recipe, id: recipe.id }}">
                            <div class="row" >
                                <div class="col" style="padding: 30px; ">
                                    <img src="../assets/foodpic.jpeg"  class="rounded w-100 d-block ">
                                    <h2 style="color: #873600; font-family: Papyrus">{{ recipe.name }}</h2>

                                    <a class="btn btn-outline-success my-2 my-sm-0" id='button' role="button">View recipe</a>
                                    <br>
                                </div>
                            </div>
                        </router-link>
                    </div>
                </div>
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

    img {
        margin: 70px 0 0;
        max-width: 100%;
    }
    a {
        color: #447eb9;
        text-decoration: none;
    }

    #start {
        border-style: double;
        width: 1279px;
        align-self: center;
        display: flex;
        flex-direction: column;
        justify-content: end;
        margin: 25px;
        padding: 30px;
    }

    #button {
        background-color: #FAD7A0;
        padding:0.3em 1.2em;
        margin:0 0.1em 0.1em 0;
        border:0.16em solid rgba(255,255,255,0);
        border-radius:2em;
        box-sizing: border-box;
        text-decoration:none;
        font-weight:300;
        color: black;
        text-align:center;
    }

</style>
