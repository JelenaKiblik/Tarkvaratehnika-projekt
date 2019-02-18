<template>
    <div id = 'app'>
        <md-toolbar class="md-medium md-accent">
            <h1 class="md-title" style="flex: 1"><b>Project: Recipe box</b></h1>
            <modal v-on:add="addItem"></modal>
        </md-toolbar>
        <md-layout md-align="center">
            <recipes :recipes='recipes' v-on:del="delItem" v-on:editIt="editItem"></recipes>
        </md-layout>
    </div>
</template>

<script>
    import modal from './components/modal.vue'
    import recipes from './components/recipe.vue'
    var recipes_data = [
        {
            title: 'Pumpkin Pie',
            ingredients: [
                'Pumpkin Puree',
                'Sweetened Condensed Milk',
                'Eggs',
                'Pumpkin Pie Spice',
                'Pie Crust'
            ]
        },
        {
            title: 'Spaghetti',
            ingredients: ['Noodles', 'Tomato Sauce', '(Optional) Meatballs']
        },
        {
            title: 'Onion Pie',
            ingredients: ['Onion', 'Pie Crust', 'Sounds Yummy right?']
        }
    ]
    var localrecipes
    if(localStorage.getItem('recipes') && localStorage.getItem('recipes').length != 0){
        localrecipes = JSON.parse(localStorage.getItem('recipes'))
    }
    else{
        localStorage.setItem('recipes',JSON.stringify(recipes_data))
        localrecipes = recipes_data.splice(0)
    }
    export default {
        name: 'app',
        components: {
            modal,
            recipes
        },
        data: function () {
            return {
                recipes: localrecipes
            }
        },
        methods: {
            addItem (item) {
                this.recipes.push({
                    title: item.title,
                    ingredients: item.ingredients
                })
                localStorage.setItem('recipes',JSON.stringify(this.recipes))
            },
            delItem (index) {
                console.log(index)
                this.recipes.splice(index,1)
                localStorage.setItem('recipes',JSON.stringify(this.recipes))
            },
            editItem (recipe) {
                //Using object destructuring assignment
                const {id, title, ingredients} = recipe
                //let title = recipe.title
                //let ingredients = recipe.ingredients
                this.recipes[id].title = title
                this.recipes[id].ingredients = ingredients
                localStorage.setItem('recipes',JSON.stringify(this.recipes))
            }
        }
    }
</script>

<style src="../node_modules/vue-material/dist/vue-material.css"></style>