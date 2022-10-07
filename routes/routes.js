const express = require("express");
const indexController = require("../controller/index");
const userController = require("../controller/user");

const router = express.Router();

router.get("/", indexController.getView);
router.get("/user", userController.getView);
router.get("/user/login", userController.doLogin);

module.exports = router;