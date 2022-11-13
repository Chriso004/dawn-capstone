const express = require("express");
const indexController = require("../controller/index");
const userController = require("../controller/user");
const productController = require("../controller/product");
const likeController = require("../controller/like");

const router = express.Router();
/* 인덱스 컨트롤러 */
router.get("/", indexController.getViewCtrl);

/* 유저 컨트롤러 */
router.get("/user", userController.getUserCtrl)
router.post("/user/login", userController.doLoginCtrl);
router.post("/user/signup", userController.doSignUpCtrl);


/* 상품 컨트롤러 */
router.post("/product", productController.getProductCtrl);
router.get("/product/all", productController.getAllProductsCtrl);
router.get("/product/image/:id", productController.getProductsImgCtrl);
router.post("/product/category", productController.getProductByCategoryCtrl);
router.post("/product/category/detail", productController.getProductByDetailCtrl);

/* 상품 좋아요 컨트롤러 */
router.post("/product/like", likeController.likeCtrl);
router.post("/product/like/all", likeController.getAllProductByLikeCtrl);

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