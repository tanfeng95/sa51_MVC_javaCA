window.onload=function(){
  document.getElementById('button').addEventListener('click', loadUsers);
}

function loadUsers(e){
  e.preventDefault();
  let xhr = new XMLHttpRequest();

  xhr.open("POST","/user/users");
  xhr.setRequestHeader("Content-Type","application/json; charset=utf-8")

  xhr.onload=function(){
    if(this.status===200){
      let users = JSON.parse(this.responseText);
      let output = `
      	<tr>
      		<th>Username</th>
      		<th>Role</th>
      	</tr>`;

      for (let i in users){
        output += `
		  <tr>
		  	<td>
			  <input type="checkbox" id="`+users[i].userName+`" name="deleteUser" value="`+users[i].userName+`">
			  <label for="`+users[i].userName+`"> `+users[i].userName+`</label>
			</td>  
			<td>`+users[i].role+`</td> 
		  </tr>`
      }
	  output += `<input type="submit" value="Delete" id="delete">`;
      document.getElementById('result').innerHTML = output;
    }
  }
  
  let roleType = document.getElementsByClassName("roleType")[0].value;
  let data = {
    "roleType":roleType
  };
  xhr.send(JSON.stringify(data));
}

