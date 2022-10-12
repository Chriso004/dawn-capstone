const userLogin = require("../model/login");
const userSignup = require('../model/signup');
const crypto = require("../server/services/crypto");

module.exports = {
    getView: (req, res) => {
        res.render("signup.html");
    },
    
    doLogin: async (req, res) => {
        const response = await userLogin.login(req.body.id);
        const cryptoPwd = await crypto.createHashPassword(req.body.pwd, response[0].salt);

        if(cryptoPwd.password === response[0].user_password)
            res.send(true);
        else
            res.send(false);
    },

    doSignUp: async (req, res) => {
        const cryptoPwd = await crypto.createHashPassword(req.body.pwd);
        const data = {
            id: req.body.id,
            pwd: cryptoPwd.password,
            email: req.body.email,
            nickname: req.body.nickname,
            recommend: req.body.recommend,
            salt: cryptoPwd.salt
        }
        
        const response = await userSignup.signUp(data);
        res.send(response);
    }
};