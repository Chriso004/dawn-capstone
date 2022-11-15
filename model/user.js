const pool = require("../server/config/dbconfig");

module.exports = {
    isExist: (data) => {
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    try {
                        const sql = "SELECT 유저이메일 FROM 유저 WHERE 유저이메일 = ?";
                        connection.query(sql, data, (error, row) => {
                            connection.release();
                            if (error) reject(error);
                            if (row.length === 0) resolve(false);
                            else resolve(true);
                        });
                    } catch (error) {
                        throw error;
                    }
                });
            });
        } catch (error) {
            console.error(error);
        }
    },

    getUser: (data) => {
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if(error) throw error;

                    const sql = "SELECT * FROM 유저 WHERE 유저분류코드 = ?";
                    connection.query(sql, data, (error, row) => {
                        connection.release();
                        if(error) reject(error);
                        resolve(row);
                    });
                });
            });
        } catch(error) {
            console.error(error);
        }
    },

    signUp: (data) => {
        const value = [];
        for (k in data)
            value.push(data[k]);
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if (error) throw error;
                    try {
                        const sql = "INSERT INTO 유저 (유저분류코드, 유저비밀번호, 유저이메일, 유저전화번호, 유저이름, 유저성별, 유저나이, salt) VALUE (?)";
                        connection.query(sql, [value], (error, result) => {
                            connection.release();
                            if (error) reject(error);
                            resolve(true);
                        });
                    } catch (error) {
                        console.error(error);
                    }
                });
            });
        } catch (error) {
            console.error(error);
        }
    },

    login: (data) => {
        try {
            return new Promise((resolve, reject) => {
                pool.getConnection((error, connection) => {
                    if (error) throw error;

                    const sql = "SELECT 유저분류코드, 유저비밀번호, salt FROM 유저 WHERE 유저이메일 = ?";
                    connection.query(sql, data, (error, row) => {
                        connection.release();
                        if (error) reject(error);
                        resolve(row);
                    });
                });
            });
        } catch (error) {
            console.error(error);
        }
    }
}