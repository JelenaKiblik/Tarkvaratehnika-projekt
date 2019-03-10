<template>
    <div class="edit">
        <div class="container">
            <h3>{{this.recipe.name}}</h3>

            <div v-if="this.recipe" style="text-align:left">
                <div>
                    <label>Description: </label> {{this.recipe.description}}
                </div>
                <div>
                    <label>Ingredients: </label> {{this.recipe.ingredients}}
                </div>

            </div>
        </div>

    </div>

</template>

<script>
    import http from "../http-common";
    export default {
        name: "editRecipe",
        props: ["recipe"],
    }
</script>


<style scoped>
    h3 {
        margin-top: 20%;
    }
    form {
        margin: 30px;
        float: left;
        width: 80%
    }
</style>