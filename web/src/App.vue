<template>
    <header>
    <div id="app">
        <nav class="menu">
            <div class="container">
                <div class="menu-bar" >

                    <ul class="header-ul" style="display: flex; justify-content: space-between">
                        <li>
                            <h1 class="header-logo">FoodBook</h1>
                        </li>

                        <li class="search-box">
                            <input type="text" placeholder="Find recipes.." class="form-control">
                            <button type="submit">Find</button>
                        </li>

                        <div class="menu-buttons">
                            <li>
                            <router-link to="/" class="navbar-brand">Home</router-link>
                            </li>

                            <li>
                                <router-link to="/Recipes">Recipes</router-link>
                            </li>
                            <li>
                                <router-link to="/AddRecipe">Add recipe</router-link>
                            </li>
                            <li>
                                <router-link to="/MyAccount">My account</router-link>
                            </li>
                        </div>
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
    </header>
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
            axios.get('http://localhost:8080/hello-world').then(response => (this.home = response.data));
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #382c50;
        margin-top: 100px;
    }

    .header-logo {
        color: white;
        margin: 5px;
        margin-right: 90px;
    }

    .search-box {
        color: white;
        margin: 10px;
        padding: 6px;
        border: bisque;
        font-size: 17px;
    }

    button {
        background-color: antiquewhite;
        padding:0.3em 1.2em;
        margin:0 0.1em 0.1em 0;
        border:0.16em solid rgba(255,255,255,0);
        border-radius:2em;
        box-sizing: border-box;
        text-decoration:none;
        font-weight:300;
        color: black;
        text-align:center;
    }


    .header-ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: darksalmon;
        position: fixed;
        top:0;
        left: 0;
        width: 100%;
    }

    .menu-buttons {
        float: right;
    }

    .header-ul li {
        float: left;
    }

    .header-ul li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    .header-ul li a:hover {
        background-color: salmon;
    }

</style>