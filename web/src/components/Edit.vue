<template id="edit">
    <div v-if="!submitted" style="font-size:20px">
        <h2>Edit recipe</h2>
        <div>
            <div class="form-group">
                <label for="edit-name">Name</label>
                <input class="form-control" type="text" id="edit-name" required v-model="recipe.name"/>
            </div>
            <div class="form-group">
                <label for="edit-description">Description</label>
                <textarea class="form-control" id="edit-description" rows="1"
                          v-model="recipe.description"></textarea>
            </div>
            <div class="form-group">
                <label for="edit-ingredients">Ingredients</label>
                <textarea class="form-control" id="edit-ingredients" rows="1" v-model="recipe.ingredients"></textarea>
            </div>
            <b-button @click="updateRecipe" variant="success"><router-link :to="{
                            name: 'recipe',
                            params: { recipe: recipe, id: recipe.id }
                        }" style="color:black">Save</router-link></b-button>
            <a class="btn btn-default"><router-link :to="{
                            name: 'recipe',
                            params: { recipe: recipe, id: recipe.id }
                        }"><b-button style="color:black" variant="outline-warning">Cancel</b-button></router-link>
            </a>
        </div>
    </div>
    <div v-else>
        <h4>Changes saved! :)</h4>
    </div>
</template>

<script>
    import http from "../http-common"
    export default {
        name: "edit",
        props: ["recipe"],
        data() {
            return {
                recipe: {
                    id: this.recipe.id,
                    name: this.recipe.name,
                    description: this.recipe.description,
                    ingredients: this.recipe.ingredients,
                },
                submitted: false
            };
        },
        methods: {
            updateRecipe() {
                let data = {
                    name: this.recipe.name,
                    description: this.recipe.description,
                    ingredients: this.recipe.ingredients,
                };
                http
                    .put("/recipe/" + this.recipe.id, data)
                    .then(response => {
                        this.recipe.id = response.data.id;
                    });
                this.submitted = true;
            }
        }
    }
</script>

<style scoped>
    h2 {
        margin-top: 10%;
    }

    form {
        margin: 10%;
        float: left;
        width: 80%
    }

</style>
