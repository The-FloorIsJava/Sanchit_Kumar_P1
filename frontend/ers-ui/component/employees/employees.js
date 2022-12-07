const url = "http://localhost:8080/"
let list = document.getElementById("employeeList");

function getAllEmployees(){
     fetch(`${url}employees`, {
         method: 'GET'
    
    }
    )
    .then(response => {
        console.log(response)
        console.log(response.status)
        if(response.status === 404){
            throw new Error(response.text().then(body=>console.log(body)))
        }
        
        console.log(...response.headers)
        return response.json();
    })
    .then( data => {


        
       console.log(data);


        data.forEach((item)=>{
            let li = document.createElement("li");
            li.innerText = JSON.stringify(item);
            list.appendChild(li);
          })

        
       
    })
    .catch(error => {
        console.error(error)   
        document.getElementById("login-form").innerHTML =`${loginInitial} <h1>Failed to get employees</h1>`

    })

    
}

getAllEmployees();