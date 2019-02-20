<template>
    <div class="home">
        <h1>FoodBook</h1>

        <h2>{{ msg }}</h2>
    </div>
</template>

<script>
    export default {
        name: 'Home',
        data () {
            return {
                msg: 'Welcome to FoodBook App'
            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    h3 {
        margin: 50px 0 0;
    }
    ul {
        list-style-type: none;
        padding: 0;
    }
    li {
        display: inline-block;
        margin: 0 20px;
    }
    a {
        color: #5055b9;
    }
</style>