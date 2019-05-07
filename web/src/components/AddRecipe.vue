<template>
    <div id="recipe-app">
        <div class="AddRecipe">
            <h3>Add new recipe</h3>
            <div style="margin-left:40%; display: flex; flex-direction: column; align-items: baseline;" >
                Name: <input v-model="recipe.name" type="text" name="Name" id="user_input"><br>
                Description: <input v-model="recipe.description" type="text" name="Description"><br>
                Ingredients: <input v-model="recipe.ingredients" type="text" name="Ingredients"><br>
                <!--Upload image: <input type="file" @change="onFileChanged">-->
                <!--<button class="uploadBTN" @click="onUpload">Upload!</button>-->
                <button class="saveBTN" v-on:click="addRecipe">Save</button>
            </div>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";
    import Vue from 'vue';
    import VeeValidate from 'vee-validate';
    Vue.use(VeeValidate);
    export default {
        name: 'add',
        data() {
            return {
                recipe:{
                    id:0,
                    name: "",
                    description: "",
                    ingredients: "",
                    recipe_image: ""
                },
                submitted: false
            };
        },
        methods: {
            addRecipe: function (event) {
                let data = {
                    name: this.recipe.name,
                    description: this.recipe.description,
                    ingredients: this.recipe.ingredients,
                    // recipe_image: ""

                };
                http
                    .post("/recipes", data)
                    .then(response => {
                        this.recipe.id = response.data.id;
                    });
                this.submitted = true;
            },
            newRecipe() {
                this.submitted = false;
                this.recipe = {};
            }
        },

        // data_image() {
        //     return {
        //         selectedFile: null
        //     }
            // },
            // methods_image: {
            //     onFileChanged(event) {
            //         this.selectedFile = event.target.files[0]
            //     },
            //     onUpload() {
            //         // upload file, get it from this.selectedFile
            //         http
            //             .post("http://localhost:9000/recipes/" + this.recipe.id + "/image", this.selectedFile)
            //             .then(response => {
            //                 this.recipe.recipe_image = response.data.recipe_image;
            //                 console.log("succsess");
            //             }, error => {console.log("error")}
            //             );
            //
            //         // this.console.log(this.selectedFile);
            //         // this.recipe_image = this.selectedFile;
            //         // return this.selectedFile;
            //     }
            // }

    }
</script>

<style scoped>
    h3 {
        margin-top: 7%;
    }
    input {
        width: 200px;
        margin: 5px 0 0;
    }

    form {
        border: black 1px;
        top: 50%;
        left: 50%;
        margin: 40px;
    }
    .uploadBTN{
        margin-top: 10px;
        border: black 1px ;
    }
    .saveBTN {
        margin-top: 10px;
        border: black 1px ;
    }
</style>
