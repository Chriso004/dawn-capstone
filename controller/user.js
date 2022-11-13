const userModel = require("../model/user");
const crypto = require("../server/services/crypto");

module.exports = {
    getUserCtrl: async (req, res) => {
        try {
            const uid = req.query.uid;
            const response = await userModel.getUser(uid);
            const t = response[0];
            const data = {
                uid: t.유저분류코드,
                password: t.유저비밀번호,
                email: t.유저이메일,
                phone: t.유저전화번호,
                name: t.유저이름,
                sex: t.유저성별,
                age: t.유저나이
            };
            res.json(data);
        } catch(error) {
            console.error(error);
        }
    },

    doLoginCtrl: async (req, res) => {
        try {
            const response = await userModel.login(req.body.email);
            if (response.length !== 0) {
                const cryptoPwd = await crypto.createHashPassword(req.body.password, response[0].salt);
                if (cryptoPwd.password === response[0].유저비밀번호)
                    res.json(true);
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