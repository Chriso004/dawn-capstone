const crypto = require("crypto");

const createSalt = async () => {
    try {
        return new Promise((resolve, reject) => {
            crypto.randomBytes(64, (error, buf) => {
                if (error) reject(error);
                resolve(buf.toString("base64"));
            });
        });
    } catch (error) {
        console.error(error);
    }
}

module.exports = {
    createHashPassword: (password, salt = 0) => {
        try {
            return new Promise(async (resolve, reject) => {
                try {
                    if (salt === 0)
                        salt = await createSalt();
                    crypto.pbkdf2(password, salt, 512, 64, "sha512", (error, key) => {
                        if (error) reject(error);
                        resolve({ password: key.toString("base64"), salt });
                    });
                } catch (error) {
                    console.error(error);
                }
            });
        } catch (error) {
            console.error(error)
        }
    }
}