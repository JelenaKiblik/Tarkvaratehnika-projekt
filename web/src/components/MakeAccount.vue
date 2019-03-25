<template>
    <div id="recipeapp">
        <div class="AddRecipe">
            <h3>Add new recipe</h3>
            <form style="display: flex; flex-direction: column; align-items: baseline; justify-content: space-around " >
                Name: <input v-model="name" type="text" name="Name" id="user_input"><br>
                Description: <input v-model="description" type="text" name="Description"><br>
                Ingredients: <input v-model="ingredients" type="text" name="Ingredients"><br>
                <button class="saveBTN" v-on:click="redirect">Save</button>
            </form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MakeAccount"
    }
</script>

<style scoped>

</style>