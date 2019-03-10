<template>
    <div id="recipeapp">
        <div class="AddRecipe">
            <h3>Add new recipe</h3>
            <form style="display: flex; flex-direction: column; align-items: baseline; justify-content: space-around " >
                Name: <input v-model="name" type="text" name="Name" id="user_input"><br>
                Description: <input v-model="description" type="text" name="Description"><br>
                Ingredients: <input v-model="ingredients" type="text" name="Ingredients"><br>
                <button class="saveBTN" @click="addRecipe">Save</button>
            </form>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";
    export default {
        name: 'add-recipe',
        data() {
            return {
                recipe:{
                    id:0,
                    name: "",
                    description: "",
                    materials: "",
                },
                submitted: false
            };
        },
        methods: {
            addRecipe() {
                let data = {
                    name: this.recipe.name,
                    description: this.recipe.description,
                    materials: this.recipe.materials,
                };
                http
                    .post("/recipe", data)
                    .then(response => {
                        this.recipe.id = response.data.id;
                    });
                this.submitted = true;
            },
            newRecipe() {
                this.submitted = false;
                this.recipe = {};
            }
        }
    };
</script>


<style scoped>
    input {
        width: 50%;
        margin: 10px 0 0;
    }
    form {
        border: black 1px;
        top: 50%;
        left: 50%;
        margin: 50px;

    }
    .saveBTN {
        border: black 1px ;
    }

</style>