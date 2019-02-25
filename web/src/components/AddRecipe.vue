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
                http.post("/recipes", {
                    recipeName: this.name,
                    recipeDescription: this.description

                });
                //ei tee brauserile refreshi
                if (event) event.preventDefault()
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