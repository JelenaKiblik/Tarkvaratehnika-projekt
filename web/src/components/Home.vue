<template>
    <div class="d-flex flex-column">
        <div >
            <img src="../assets/header.jpg">
        </div>
        <div class="caption text-center">
            <h3 style="color: #873600; font-family: Papyrus">{{ msg }}</h3>
        </div>
        <h3 style="color: #873600; font-family: Papyrus; padding-bottom: 50px">...or maybe you wanna try these recipes?</h3>
    </div>
</template>

<script>
    export default {
        name: 'Home',
        data () {
            return {
                msg: 'Search for some recipes'
            }
        }
    }
</script>

<style scoped>
    h3 {
        margin: 40px 0 0;
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
        margin: 70px 0 0;
        max-width: 100%;
    }
</style>
