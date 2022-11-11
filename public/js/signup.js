const signForm = document.querySelector(".sign-form");

const signUp = async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const email = formData.get("email");
    const id = formData.get("id").toLowerCase();
    const pwd = formData.get("pwd");
    const pwdRep = formData.get("pwd-rep");
    const nickname = formData.get("nickname");
    const recommend = formData.get("recommend");

    if (pwd !== pwdRep) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }

    const data = {
        email: email,
        id: id,
        pwd: pwd,
        pwdRep: pwdRep,
        nickname: nickname,
        recommend: recommend
    };

    try {
        const response = await axios.post("user/signup", JSON.stringify(data), {
            headers: {
                "Content-Type": `application/json`,
            }
        });
        console.log(response);
    } catch (error) {
        console.error(error);
    }

}

signForm.addEventListener("submit", signUp);