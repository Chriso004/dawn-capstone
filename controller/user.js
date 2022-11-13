const userModel = require("../model/user");
const crypto = require("../server/services/crypto");

module.exports = {
    getViewCtrl: (req, res) => {
        res.render("signup.html");
    },

    doLoginCtrl: async (req, res) => {
        try {
            const response = await userModel.login(req.body.id);
            const cryptoPwd = await crypto.createHashPassword(req.body.pwd, response[0].salt);

            if (cryptoPwd.password === response[0].유저비밀번호)
                res.send(response[0].유저식별코드);
            else
                res.send(false);
        } catch (error) {
            console.error(error);
        }

    },

    doSignUpCtrl: async (req, res) => {
        let result;
        try {
            const cryptoPwd = await crypto.createHashPassword(req.body.pwd);
            const data = {
                id: req.body.id,
                pwd: cryptoPwd.password,
                email: req.body.email,
                nickname: req.body.nickname,
                recommend: req.body.recommend,
                salt: cryptoPwd.salt
            };

            result = await userModel.signUp(data);

        } catch (error) {
            console.error(error);
        } finally {
            res.send(result);
        }
    }
};