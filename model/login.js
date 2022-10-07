const mysql = require("mysql2");
const dbConfig = require("../server/config/dbconfig");

module.exports = {
    doLogin: () => {
        return new Promise((resolve, reject) => {
            const pool = mysql.createPool(dbConfig);
            
            pool.getConnection((error, connection) => {
                if(error) throw error;
                
            })
        });
    }
}