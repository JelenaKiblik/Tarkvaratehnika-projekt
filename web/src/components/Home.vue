<template>
    <div class="d-flex flex-column">
        <div class="caption text-center">
            <h3>{{ msg }}</h3>

        </div><br>

        <div>
            <img src="../assets/header.jpg">
        </div>

        <br>

        <form class="input-group mb-3 " >
            <input class="form-control form-control-sm" type="search" placeholder="Search" >
            <div class="input-group-append">
                <button class="btn btn-outline-dark btn-sm my-2 my-sm-0" type="submit">Search</button>
            </div>

        </form>






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
                msg: 'Find some recipes!'
            }
        },
        methods: {
            redirect: function (event) {
                this.$router.push('Register')
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