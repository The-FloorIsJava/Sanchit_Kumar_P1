let loginInitial = document.getElementById("login-form").innerHTML
const url = "http://localhost:8080/"

function userLogin(form){
    let username = form.username.value
    let password = form.password.value

    fetch(`${url}login`, {
        method: 'POST',
        body: JSON.stringify({
           employee_username: username,
            employee_password: password
        })
    }
    )
    .then(response => {
        console.log(response)
        console.log(response.status)
        if(response.status === 404){
            throw new Error(response.text().then(body=>console.log(body)))
        }
        console.log(...response.headers)
        document.getElementById("login-form").innerHTML = "<h1 id='welcome'> Welcome to the Customer Tracker, " + username + "</h1><a href='../customers/customers.html'>Customer</a>"
        console.log(password)
        logoutButton()
       // window.localStorage.setItem("token", response.headers.get("authorization"))
    })
    .catch(error => {
        console.error(error)   
        document.getElementById("login-form").innerHTML =`${loginInitial} <h1>Failed to login please try again</h1>`

    })

    
}

function logoutButton(){
    let button = document.createElement("button")
    let node = document.createTextNode("Logout")

    button.appendChild(node); // <button>Logout</button>
    button.setAttribute("onclick", "logout()")// <button onclick="logout()">Logout</button>
    const welcomeH1 = document.getElementById("welcome")
    welcomeH1.appendChild(button)
}

function logout(){
    document.getElementById("login-form").innerHTML = loginInitial;
}
