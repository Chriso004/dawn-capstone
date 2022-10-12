const loginForm = document.querySelector(".login-form");

const login = async (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const id = formData.get("id");
    const pwd = formData.get("pwd");

    const data = {
        id: id,
        pwd: pwd
    };

    const response = await axios.post("user/login/", data);
    console.log(response);
}


loginForm.addEventListener("submit", login);