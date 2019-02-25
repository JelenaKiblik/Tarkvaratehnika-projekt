<template>
    <div id="recipeapp">
        <div class="AddRecipe">
            <h2>Add new recipe</h2>
            <form style="display: flex; flex-direction: column; align-items: baseline; justify-content: space-around">
                Name: <input v-model="name" type="text" name="Name" id="user_input"><br>
                Description: <input v-model="description" type="text" name="Description"><br>
                Ingredients: <input v-model="ingredients" type="text" name="Ingredients"><br>
                <button class="saveBTN" @click="addRecipe">Save</button>
            </form>
        </div>
    </div>
</template>

<script>
    /* eslint-disable */
    import axios from "axios";

    export default {
        name: 'AddRecipe',
        data() {
            return {
                title: 'AddRecipe',
                name: null,
                description: null,
                ingredients: null
            }
        },
        methods: {
            addRecipe: function (event) {
                axios.post("http://localhost:8080/recipes", {
                    recipeName: this.name,
                    recipeDescription: this.description
                })


            }
        }

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

    form {
        border: black 1px;
        top: 50%;
        left: 50%;
        margin: 50px;

    }

    input {
        width: 100%;
        margin: 10px 0 0;
    }

    .saveBTN {
        border: black 1px ;
    }

</style>