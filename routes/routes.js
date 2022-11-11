const express = require("express");
const indexController = require("../controller/index");
const userController = require("../controller/user");
const productController = require("../controller/product");

const router = express.Router();

router.get("/", indexController.getViewControll);
router.get("/user", userController.getViewControll);
router.post("/user/login", userController.doLoginControll);
router.post("/user/signup", userController.doSignUpControll);
router.get("/product/all", productController.getProductsControll);
router.get("/product/image", productController.getProductsImgControll);
router.post("/product/like", productController.likeControll);

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