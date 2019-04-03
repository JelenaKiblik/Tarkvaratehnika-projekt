<template>
    <div>
        <form id="authorization" v-on:submit.prevent="authorization">
            <input type='text' placeholder='username' v-model='username'>
            <input type='password' placeholder='password' v-model='password'>
            <button class="ui primary button">Submit</button>
        </form>
        <router-link to="/register">
            <button type="reset">I'm not a user</button>
        </router-link>
    </div>
</template>

<script>
    import {AUTH_REQUEST} from "../store/constants";
    export default {
        name: 'authorization',
        data() {
            return {
                username: "",
                password: ""
            }
        },
        methods: {

            authorization () {
                const { username, password } = this;
                this.$store.dispatch(AUTH_REQUEST, {username, password}).then(() => {
                    this.$router.push('/home');
                });
            }
        }
    }
</script>

<style scoped>
    button {
        margin-top:100px;
    }
</style>