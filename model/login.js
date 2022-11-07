const mysql = require("mysql2");
const dbConfig = require("../server/config/dbconfig");

module.exports = {
    login: (data) => {
        return new Promise((resolve, reject) => {
            const pool = mysql.createPool(dbConfig);

            pool.getConnection((error, connection) => {
                if (error) throw error;

                const sql = "SELECT user_password, salt FROM user WHERE user_id = ?";
                connection.query(sql, data, (error, row) => {
                    if (error) throw error;
                    resolve(row);
                });
                connection.release();
            });
        });
    }
};