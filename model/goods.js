const mysql = require("mysql2");
const dbConfig = require("../server/config/dbconfig");

module.exports = {
    getGoods: () => {
        try {
        return new Promise((resolve, reject) => {
            const pool = mysql.createPool(dbConfig);

            pool.getConnection((error, connection) => {
                if(error) throw error;

                const sql = "SELECT * FROM goods";
                connection.query(sql, (error, rows) => {
                    if(error) throw error;
                    resolve(rows);
                });
                connection.release();
            });
        });
        } catch(error) {
            console.error(error);
        }
    }
};