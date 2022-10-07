const userModel = require("../model/login");

module.exports = {
    getView: (req, res) => {
        res.render("signup.html");
    },
    
    doLogin: (req, res) => {
        res.send(req.body);
    }
};