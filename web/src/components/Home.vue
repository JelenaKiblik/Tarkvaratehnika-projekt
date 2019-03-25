<template>
    <div class="home" >

        <h3>{{ msg }}</h3>
    </div>
</template>

<script>
    export default {
        name: 'Home',
        data () {
            return {
                msg: 'Welcome to FoodBook!'
            }
        }
    }
</script>

<style scoped>

    h3 {
        margin: 150px 0 0;
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

</style>