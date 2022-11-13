const userModel = require("../model/user");
const crypto = require("../server/services/crypto");

module.exports = {
    getViewCtrl: (req, res) => {
        res.render("signup.html");
    },

    doLoginCtrl: async (req, res) => {
        try {
            const response = await userModel.login(req.body.email);
            if (response.length !== 0) {
                const cryptoPwd = await crypto.createHashPassword(req.body.password, response[0].salt);
                if (cryptoPwd.password === response[0].유저비밀번호)
                    res.json(response[0].유저식별코드);
                else
                    res.json(false);
            }
            else res.json(false);
        } catch (error) {
            console.error(error);
        } 
        
    },

    doSignUpCtrl: async (req, res) => {
        let result = false;
        try {
            const originPwd = req.body.password;
            const cryptoPwd = await crypto.createHashPassword(originPwd);
            const data = {
                uid: req.body.uid,
                pwd: cryptoPwd.password,
                email: req.body.email,
                phone: req.body.phone,
                name: req.body.name,
                sex: req.body.sex,
                age: req.body.age,
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