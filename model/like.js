const pool = require("../server/config/dbconfig");

module.exports = {
    likeExist: (data) => {
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    const sql = "SELECT 좋아요분류코드 FROM 상품좋아요 WHERE 유저분류코드 = ? AND 상품분류코드 = ?";
                    const sql2 = connection.format(sql, data);
                    connection.query(sql2, (error, row) => {
                        connection.release();
                        if (error) reject(error);
                        resolve(row);
                    });
                });
            });
        } catch (error) {
            console.error(error);
        }
    },

    postLike: (data) => {
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    const sql = "INSERT INTO 상품좋아요 (유저분류코드, 상품분류코드) VALUE (?)";
                    connection.query(sql, [data], (error, row) => {
                        connection.release();
                        if (error) reject(error);
                        resolve("insert complete");
                    });
                });
            });
        } catch (error) {
            console.error(error);
        }
    },

    deleteLike: (data) => {
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    const sql = "DELETE FROM 상품좋아요 WHERE 좋아요분류코드 = ?";
                    connection.query(sql, data, (error, row) => {
                        connection.release();
                        if (error) reject(error);
                        resolve("delete complete");
                    });
                });
            });
        } catch (error) {
            console.error(error);
        }
    },
    
    getAllProductByLike: (data) => {
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "SELECT 상품분류코드 FROM 상품좋아요 WHERE 유저분류코드 = ?";
                    connection.query(sql, data, (error, row) => {
                        connection.release();
                        if(error) reject(error);
                        resolve(row);
                    });
                })
            });
        } catch(error) {
            console.error(error);
        }
    },
};

