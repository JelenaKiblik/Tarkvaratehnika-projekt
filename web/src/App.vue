<template>
    <div id="app">
        <nav class="menu">
            <div class="container">

                    <ul class="header-ul" style="display: flex; justify-content: space-between">
                        <li>
                            <h1 class="header-logo">FoodBook</h1>
                        </li>


                        <div class="menu-buttons">
                            <li>
                            <router-link to="/" >Home</router-link>
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
                            <li>
                                <router-link to="/Authorization">Login</router-link>
                            </li>
                        </div>
                        <!--<div>-->
                            <!--<router-link to="/authorization">Login</router-link>-->
                        <!--</div>-->
                    </ul>
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
    export default {
        name: 'app',
    }
</script>

<style>
    #app {
        font-family: Geneva, Arial, Helvetica, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #382c50;
        width:80%;
        margin: 0 auto;
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
        background-color: #a5c5fa;
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

    .menu-buttons {
        float: right;
    }

    .header-ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #8aa1e9;
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
        background-color: #98a5fa;
    }

</style>