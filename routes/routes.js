const express = require("express");
const indexController = require("../controller/index");
const userController = require("../controller/user");

const router = express.Router();

router.get("/", indexController.getView);
router.get("/user", userController.getView);
router.post("/user/login", userController.doLogin);
router.post("/user/signup", userController.doSignUp);

router.get("/test", (req, res) => {
    const response = {
        method: "GET",
        message: "테스트 메세지 입니다."
    };

    res.json(response);
});

router.post("/test", (req, res) => {
    const response = {
        method: "POST",
        message: "테스트 메세지 입니다.",
        body: req.body
    };

    res.json(response);
})

module.exports = router;