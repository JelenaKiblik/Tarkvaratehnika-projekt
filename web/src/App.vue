<template>
    <div id="app">
        <!-- navbar -->
        <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
            <div class="container">
                <router-link to="/" class="navbar-brand">Kodu</router-link>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav">

                        <li class="nav-item">
                            <router-link class="nav-link" to="/Recipes">Retseptid</router-link>
                        </li>
                        <li class="nav-item">
                            <router-link class="nav-link" to="/AddRecipe">Lisa retsept</router-link>
                        </li>
                        <li class="nav-item">
                            <router-link class="nav-link" to="/MyAccount">Minu konto</router-link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <transition name="moveInUp">
                <router-view/>
            </transition>

        </div>

    </div>
</template>


<script>
    import axios from "axios";
    import Home from "./components/Home.vue"
    export default {
        name: 'App',
        component: {
            Home
        },
        mounted () {
            axios.get('http://localhost:63342/hello-world').then(response => (this.home = response.data));
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
</style>