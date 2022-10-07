const signForm = document.querySelector(".sign-form");

const signUp = (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const email = formData.get("email");
    const pwd = formData.get("pwd");
    const pwdRep = formData.get("pwd-rep");
    const nickname = formData.get("nickname");
    const recommend = formData.get("recommend");

    if(pwd !== pwdRep) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }

    const data = {
        email: email,
        pwd: pwd,
        pwdRep: pwdRep,
        nickname: nickname,
        recommend: recommend
    };

    console.log(JSON.stringify(data));
}

signForm.addEventListener("submit", signUp);