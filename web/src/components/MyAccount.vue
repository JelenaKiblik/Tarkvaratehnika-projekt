<template>
    <div class="account">
        <div class="container">
            <h4>My Account</h4>
            <div class="labelid">
                <div>
                    <label>Username: </label> {{user.username}}
                </div>
                <div>
                    <label>Email: </label> {{user.email}}
                </div>
                <div>
                    <label>My recipes: </label> {{user.recipes}}
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from "axios";
    export default {
        name: "MyAccount",
        data() {
            return {
                user: {
                    email: '',
                    username: '',
                    recipes: []
                }
            }
        },
        mounted() {
            axios.get('http://localhost:9000/api/loggedIn').then(response => (this.user = response.data));
        }
    }
</script>

<style scoped>
</style>