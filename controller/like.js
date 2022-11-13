const likeModel = require("../model/like");

module.exports = {
    likeCtrl: async (req, res) => {
        let response;
        const uCode = req.body.uCode;
        const pCode = req.body.pCode;
        const data = [uCode, pCode];

        try {
            const existResponse = await likeModel.likeExist(data);

            if (existResponse.length === 0) {
                const postResponse = await likeModel.postLike(data);
                response = postResponse;
            }
            else {
                const lCode = existResponse[0].좋아요분류코드;
                const deleteResponse = await likeModel.deleteLike(lCode);
                response = deleteResponse;
            }
        } catch (error) {
            console.error(error);
        }
        res.json(response);
    },

    getAllProductByLikeCtrl: async (req, res) => {
        try {
            const uCode = req.body.uCode;
            const response = await likeModel.getAllProductByLike(uCode);
            res.json(response);
        } catch (error) {
            console.error(error);
        }
    }
};