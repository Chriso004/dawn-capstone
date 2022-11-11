const mysql = require("mysql2");
const dbConfig = require("../server/config/dbconfig");

module.exports = {
    getProducts: () => {
        try {
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    const sql = "SELECT * FROM 상품";
                    connection.query(sql, (error, rows) => {
                        if (error)
                            resolve({
                                errCode: error.code,
                                errNo: error.errno,
                                errMsg: error.message
                            });
                        resolve(rows);
                    });
                    connection.release();
                });
            });
        } catch (error) {
            console.error(error);
        }
    },

    likeExist: (data) => {
        try {
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    const sql = "SELECT 좋아요분류코드 FROM 상품좋아요 WHERE 유저분류코드 = ? AND 상품분류코드 = ?";
                    const sql2 = connection.format(sql, data);

                    connection.query(sql2, (error, row) => {
                        if (error)
                            resolve({
                                errCode: error.code,
                                errNo: error.errno,
                                errMsg: error.message
                            });
                        console.log(sql2);
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
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "INSERT INTO 상품좋아요 (유저분류코드, 상품분류코드) VALUE (?)";
                    connection.query(sql, [data], (error, row) => {
                        if(error) resolve(error);
                        resolve("insert complete");
                    });
                });
            });
        } catch(error) {
            console.error(error);
        }
    },

    deleteLike: (data) => {
        try {
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "DELETE FROM 상품좋아요 WHERE 좋아요분류코드 = ?";
                    connection.query(sql, data, (error, row) => {
                        if(error) resolve(error);
                        resolve("delete complete");
                    });
                });
            });
        } catch(error) {
            console.error(error);
        }
    }
};