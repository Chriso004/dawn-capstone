const mysql = require("mysql2");
const dbConfig = require("../server/config/dbconfig");

module.exports = {
    getAllProducts: () => {
        try {
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    const sql = "SELECT * FROM 상품";
                    connection.query(sql, (error, row) => {
                        if (error)
                            resolve({
                                errCode: error.code,
                                errNo: error.errno,
                                errMsg: error.message
                            });
                        resolve(row);
                    });
                    connection.release();
                });
            });
        } catch (error) {
            console.error(error);
        }
    },

    getProductByCategory: (data) => {
        try{
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "SELECT * FROM 상품 WHERE 상품카테고리 = ?";
                    connection.query(sql, data, (error, row) => {
                        if(error) resolve(error);
                        resolve(row);
                    });
                    connection.release();
                });
            });
        } catch(error) {
            console.error(error);
        }
    },

    getProductByDetail: (data) => {
        try {
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "SELECT * FROM 상품 WHERE 상품상세카테고리 = ?";
                    connection.query(sql, data, (error, row) => {
                        if(error) resolve(error);
                        resolve(row);
                    });
                });
            });
        } catch(error) {
            console.error(error);
        }
    },

    getProducts: (data) => {
        try {
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "SELECT * FROM 상품 WHERE 상품분류코드 = ?";
                    connection.query(sql, data, (error, row) => {
                        if(error) resolve(error);
                        resolve(row);
                    });
                    connection.release();
                });
            });
        } catch(error) {
            console.error(error);
        }
    },
};