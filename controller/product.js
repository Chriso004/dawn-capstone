const productModel = require("../model/product");

module.exports = {
    getProductCtrl: async (req, res) => {
        try {
            const pCode = req.body.pCode;
            const response = await productModel.getProduct(pCode);
            
            res.json(response);
        } catch (error) {
            console.error(error);
        }
    },

    getProductByCategoryCtrl: async (req, res) => {
        try {
            const category = req.body.category;
            const response = await productModel.getProductByCategory(category);

            res.json(response);
        } catch(error) {
            console.error(error);
        }
    },

    getProductByDetailCtrl: async (req, res) => {
        try {
            const detail = req.body.detail;
            const response = await productModel.getProductByDetail(detail);
            
            res.json(response);
        } catch(error) {
            console.error(error);
        }
    },

    getAllProductsCtrl: async (req, res) => {
        try {
            const response = await productModel.getAllProducts();
            res.json(response);
        } catch (error) {
            console.error(error);
        }
    },

    getProductsImgCtrl: async (req, res) => {
        try {
            res.sendFile(req.params.id, { root: "public/img" });
        } catch(error) {
            console.error(error);
        }
    },
};