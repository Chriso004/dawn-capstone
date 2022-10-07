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

    const response = await postData(data);
    console.log(response);
}

const postData = async (data) => {
    const response = await fetch("/user/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });
    
    const resData = await response.json();
    return resData;
} 

loginForm.addEventListener("submit", login);