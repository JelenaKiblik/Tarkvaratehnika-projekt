<template>
    <div id="recipeapp">
        <div class="AddRecipe">
            <h2 style="float:left">Add new recipe</h2>
            <form action="http://localhost:9000/#/Recipes" method="get">
                Name: <input v-model="name" type="text" name="Name" id="user_input"><br>
                Description: <input v-model="description" type="text" name="Description"><br>
                Ingredients: <input v-model="ingredients" type="text" name="Ingredients"><br>
                <button @click="addRecipe">Save</button>
            </form>
        </div>
    </div>
</template>

<script>
    import Vue from "vue";
    export default {
        name: 'AddRecipe',
        data() {
            return {
                title: 'AddRecipe'
            }
        }
    }
    window.onload = function () {
        const app = new Vue({
            el: '#recipeapp',
            data: {
                recipes: [],
                name: null,
                description: null,
                ingredients: null,
            },
            mounted() {
                if (localStorage.getItem('recipes')) {
                    try {
                        this.recipes = JSON.parse(localStorage.getItem('recipes'));
                    } catch (e) {
                        localStorage.removeItem('recipes');
                    }
                }
            },
            methods: {
                addRecipe() {
                    if (!this.name
                        || !this.description
                        || !this.ingredients) {
                        return;
                    }
                    this.recipes.push(this.name);
                    this.recipes.push(this.description);
                    this.recipes.push(this.ingredients);
                    this.name = '';
                    this.description = '';
                    this.ingredients = '';
                    this.saveRecipe();
                },

                saveRecipe() {
                    const parsed = JSON.stringify(this.recipes);
                    localStorage.setItem('recipes', parsed);
                }
            }
        })
    }
</script>


<style scoped>
    input {
        width: 50%;
        margin: 10px 0 0;
    }
    form {
        float: left;
    }
</style>