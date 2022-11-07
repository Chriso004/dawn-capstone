const express = require("express");
const path = require("path");
const dotenv = require("dotenv");
const morgan = require("morgan");
const cookieParser = require("cookie-parser");
const ejs = require("ejs");
const app = express();


dotenv.config();

const routes = require("./routes/routes.js");

/* 서버 미들웨어 설정 */
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(morgan("dev"));

/* port설정 */
app.set("port", process.env.PORT || 8080);

/* 경로, 파일 옵션 설정 */
app.engine("html", ejs.renderFile);
app.set("view engine", "html");
app.set("views", path.join(__dirname, "views"));
app.set("img", path.join(__dirname, "public", "img"));
app.use(express.static(path.join(__dirname, "public")));

/* 라우팅 설정 */
app.use("/", routes);

app.listen(app.get("port"), () => {
    console.log(`connecting to http://localhost:${app.get("port")}`);
});