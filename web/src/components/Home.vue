<template>
    <div class="d-flex flex-column">
        <div>
            <h3>{{ msg }}</h3>
        </div>

        <div>
            <img src="../assets/header.jpg">
        </div>

        <br>
        
        <div class="md-form active-pink active-pink-2 mb-3 mt-0">
                <input type="text" placeholder="otsing" aria-label="otsing" class="form-control">
                <button type="submit">Find</button>
        </div>




        <div>
            <!--<button class="saveBTN" v-on:click="redirect">Make an account</button>-->
            <!--<button class="saveBTN" v-on:click="redirect">Sign in</button>-->
        </div>




    </div>
</template>

<script>
    export default {
        name: 'Home',
        data () {
            return {
                msg: 'Welcome to FoodBook!'
            }
        },
        methods: {
            redirect: function (event) {
                this.$router.push('MakeAccount')
            }
        }
    }
</script>

<style scoped>


    h3 {
        margin: 90px 0 0;
    }
    ul {
        list-style-type: none;
        padding: 0;
    }
    li {
        display: inline-block;
        margin: 0 10px;
    }
    a {
        color: #447eb9;
    }

    img {
        max-width: 100%;
    }

</style>