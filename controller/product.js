const { postLike } = require("../model/product");
const productModel = require("../model/product");

module.exports = {
    getProductsControll: async (req, res) => {
        try {
            const response = await productModel.getProducts();
            res.send(response);
        } catch(error) {
            console.error(error);
        }
    },

    getProductsImgControll: async (req, res) => {
        res.sendFile(req.body.fileName, { root: "public/img" });
    },

    likeControll: async (req, res) => {
        let response;
        const uCode = req.body.uCode;
        const pCode = req.body.pCode;
        const data = [uCode, pCode];

        try {
            const existResponse = await productModel.likeExist(data);

            if(existResponse.length === 0) {
                const postResponse = await productModel.postLike(data);
                response = postResponse;
            }
            else {
                const lCode = existResponse[0].좋아요분류코드;
                const deleteResponse = await productModel.deleteLike(lCode);
                response = deleteResponse;
            }
        } catch(error) {
            console.error(error);
        }

        res.send(response);


    }
};