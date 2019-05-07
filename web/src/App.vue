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
                            <li>
                                <router-link to="/search">Search</router-link>
                            </li>
                        </div>
                    </ul>
            </div>
        </nav>
        <div class="container main-content">
            <transition name="moveInUp">
                <router-view/>
            </transition>
        </div>
        <footer class="footer">
            <div  style="background-color: #FAD7A0">
                <div class="container">
                    <div class="row">
                        <div class="col-sm">
                            <div class="c-footer">
                                <div class="card-body">
                                    <div class="row d-flex justify-content-around">
                                        <h5 class="card-title">Contact us</h5>
                                        <h1 class="fas fa-address-card"></h1>
                                    </div>
                                    <div class="col">
                                        <h6>phone: 978 278 782</h6>
                                        <h6>e-mail: foodbook@gmail.com</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm">
                            <div class="c-footer">
                                <div class="card-body">
                                    <div class="row d-flex justify-content-around">
                                        <h5 class="card-title">Follow us</h5>
                                    </div>
                                    <div class="col d-flex justify-content-center" id="socialmedia">
                                        <h1 class="fab fa-facebook-square"></h1>
                                        <h1 class="fab fa-twitter-square" style="margin-left: 7px; margin-right: 7px"></h1>
                                        <h1 class="fab fa-instagram"></h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm">
                            <div class="c-footer">
                                <div class="card-body">
                                    <div class="row d-flex justify-content-around">
                                        <h5 class="card-title">Ask for advertisement</h5>
                                    </div>
                                    <div class="col d-flex justify-content-around">
                                        <a href="#" class="btn btn-dark my-2 my-sm-0">Ask</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</template>

<script>
    export default {
        name: 'app',
    }
</script>

<style>
    #app {
        font-family: Papyrus;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #382c50;
        margin: 0 auto;
        position: relative;
        min-height: 100vh;
    }

    .header-logo {
        color: #873600;
        font-family: Papyrus;
        margin: 5px 90px 5px 5px;
    }

    button {
        background-color: #FAD7A0;
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
        background-color: #FAD7A0;
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
        color: #873600;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-family: Papyrus;
    }

    .header-ul li a:hover {
        background-color: #F39C12;
    }

    .main-content {
        min-width: 80%;
        padding-bottom: 150px;    /* Footer height */
    }

    .footer {
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 150px;            /* Footer height */
    }

</style>
