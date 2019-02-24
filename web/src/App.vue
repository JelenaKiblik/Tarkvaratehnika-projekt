<template>
    <div id="app">
        <nav class="menu">
            <div class="container">

                <div class="menu-bar" >

                    <ul style="display: flex; justify-content: space-between">
                        <li>
                            <h1 class="header-logo">FoodBook</h1>
                        </li>

                        <li class="search-box">
                            <input type="text" placeholder="Find recipes.." class="form-control">
                            <button type="submit">Submit</button>
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
        margin-top: 70px;
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
        background-color: white;
        border: black 1px;
        color: black;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 13px;
    }


    ul {
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

    li {
        float: left;
    }

    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover {
        background-color: salmon;
    }

</style>