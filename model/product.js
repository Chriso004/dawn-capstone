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
                        if (error) resolve(error);
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
                    connection.release();
                });
            });
        } catch(error) {
            console.error(error);
        }
    },

    getProduct: (data) => {
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
    
    getProductByArr: (data) => {
        try {
            const pCodeArr = [];
            for(k in data)
                pCodeArr.push(data[k].상품분류코드);
            return new Promise((resolve, reject) => {
                const pool = mysql.createPool(dbConfig);

                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "SELECT * FROM 상품 WHERE 상품분류코드 in (?)";
                    connection.query(sql, [pCodeArr], (error, row) => {
                        if(error) resolve(error);
                        resolve(row);
                    });
                    connection.release();
                });
            });
        } catch(error) {
            console.error(error);
        }
    }
};