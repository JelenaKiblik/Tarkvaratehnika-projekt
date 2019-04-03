import {AUTH_REQUEST} from "../constants";
import axios from "axios";

const state = { user: localStorage.getItem('user') || '' };

const getters = {
    isAuthenticated: state => !!state.user
};

const actions = {
    [AUTH_REQUEST]: ({commit, dispatch}, user) => {
        return new Promise((resolve, reject) => {
            commit(AUTH_REQUEST, user);
            resolve()
        })
    }
};

const mutations = {
    [AUTH_REQUEST]: (state, user) => {
        let data = {
            username:user.username,
            password:user.password
        };
        console.log(data);
        let headers = {
            'Content-type': 'application/json'
        };
        console.log(headers);
        axios.post('http://localhost:9000/login', data, {
            headers: headers,
        }).then(response => {
            console.log(response);
            state.user = user;
            localStorage.setItem('user', user);
        }).catch(error => {
            state.user = '';
            localStorage.removeItem('user');
        });
    }
};

export default {
    state,
    getters,
    actions,
    mutations,
}
