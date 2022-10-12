const mysql = require("mysql2");
const dbConfig = require("../server/config/dbconfig");

module.exports = {
    signUp: (data) => {
        const value = [];
        for (k in data)
            value.push(data[k]);
            
        return new Promise((resolve, reject) => {
            const pool = mysql.createPool(dbConfig);

            pool.getConnection((error, connection) => {
                if (error) throw error;

                const sql = "INSERT INTO user (user_id, user_password, user_email, user_nickname, user_recommend, salt) value (?)";
                connection.query(sql, [value], (error, result) => {
                    if (error) throw error;
                    resolve(true);
                });
                connection.release();
            });
        });
    }
}