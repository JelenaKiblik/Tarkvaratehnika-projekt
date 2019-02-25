<template>
    <div>
        <h1>Recipes</h1>
        <!--{{ recipes }}-->

        <ul id="listRecipes">
            <li class="recipe-item" v-for="item in recipes" :key="item.id">
                <h3>{{item.recipeName}}</h3>
                {{item.recipeDescription}}
            </li>
        </ul>

    </div>


</template>

<script>
    import axios from "axios";
    export default {
        name: "Recipes",
        data (){
            return{
                title:'Recipes',
                recipes: null
            }
        },
        mounted () {
            axios.get('http://localhost:8080/recipes').then(response => (this.recipes = response.data));
        }
    }
</script>

<style scoped>
    .recipe-item {
        border: black 1px;
        border-style: solid;
        list-style-type: none;
        margin: 20px;
        padding-bottom: 10px;
    }
</style>