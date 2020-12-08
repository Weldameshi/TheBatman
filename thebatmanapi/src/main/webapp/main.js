function showPeopleDiv(){
    document.getElementById('vehicle_div').style.display = "none";
    document.getElementById('lair_div').style.display = "none";
    document.getElementById('tech_div').style.display = "none";
    document.getElementById('user_div').style.display = "none";
	document.getElementById('people_div').style.display = "block";
	clearAllCreateData();
	clearAllSearchData();
}
function showTechDiv(){
    document.getElementById('vehicle_div').style.display = "none";
    document.getElementById('lair_div').style.display = "none";
    document.getElementById('tech_div').style.display = "block";
	document.getElementById('people_div').style.display = "none";
	document.getElementById('user_div').style.display = "none";
	clearAllCreateData();
	clearAllSearchData();
}
function showLairDiv(){
    document.getElementById('vehicle_div').style.display = "none";
    document.getElementById('lair_div').style.display = "block";
    document.getElementById('tech_div').style.display = "none";
	document.getElementById('people_div').style.display = "none";
	document.getElementById('user_div').style.display = "none";
	clearAllCreateData();
	clearAllSearchData();
}
function showVehicleDiv(){
    document.getElementById('vehicle_div').style.display = "block";
    document.getElementById('lair_div').style.display = "none";
    document.getElementById('tech_div').style.display = "none";
	document.getElementById('people_div').style.display = "none";
	document.getElementById('user_div').style.display = "none";

	clearAllCreateData();
	clearAllSearchData();
}
function showUserDiv(){
    document.getElementById('vehicle_div').style.display = "none";
    document.getElementById('lair_div').style.display = "none";
    document.getElementById('tech_div').style.display = "none";
	document.getElementById('people_div').style.display = "none";
	document.getElementById('user_div').style.display = "block";

	clearAllCreateData();
	clearAllSearchData();
}
function showNoDiv(){
	document.getElementById('vehicle_div').style.display = "none";
    document.getElementById('lair_div').style.display = "none";
    document.getElementById('tech_div').style.display = "none";
	document.getElementById('people_div').style.display = "none";
	document.getElementById('user_div').style.display = "none";

	clearAllCreateData();
	clearAllSearchData();
}
var authHeaderValue = null;
function createPerson(){
	var id = document.getElementById('person_create_id').value;
	var firstName = document.getElementById('firstName').value;
	var lastName = document.getElementById("lastName").value;
	var ailias = document.getElementById("ailias").value;
	var classification = document.getElementById("classification").value;
	var rawAbilities = document.getElementsByName("ability");
	var abilities = [];
	rawAbilities.forEach((ability) => {
		abilities.push(ability.value);
	});
	var person = {
			"_id":id,
			"firstName": firstName,
			"lastName": lastName,
			"ailias": ailias,
			"classification": classification,
			"abilities": abilities
	}
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/people");
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.setRequestHeader('Authorization', authHeaderValue);
	xmlHttp.onreadystatechange = function(){
		if(this.readyState == XMLHttpRequest.DONE){
			if(this.status === 403){
				alert("unauthroized user can not create user");
			}
			if(this.status === 401){
				alert("Must log in to create vehicle")
			}
			if(this.status === 200){
				console.log("Success");
			}
		}
	}
	xmlHttp.send(JSON.stringify(person));
	clearPersonCreateData();
}
function clearAllCreateData(){
	clearPersonCreateData();
	clearLairsCreateData();
	clearTechCreateData();
	clearVehiclesCreateData();
	clearUserCreateData();
}
function clearPersonCreateData(){
	document.getElementById('person_create_id').value = "";
	document.getElementById('firstName').value = "";
	document.getElementById("lastName").value = "";
	document.getElementById("ailias").value = "";
	document.getElementById("classification").value = "";
	document.getElementById("abilityList").innerHTML = "";

}
function clearLairsCreateData(){
	document.getElementById('lair_create_id').value = "";
	document.getElementById('lair_name').value = "";
	document.getElementById('sqrft').value = "";
    document.getElementById("trapsList").innerHTML = "";
}
function clearTechCreateData(){
	document.getElementById('tech_create_id').value = "";
	document.getElementById('tech_name').value = "";
    document.getElementById("functionsList").innerHTML = "";
}
function clearVehiclesCreateData(){
	document.getElementById('vehicle_create_id').value = "";
	document.getElementById('vehicle_name').value = "";
	document.getElementById('mph').value = "";
    document.getElementById("capabilitiesList").innerHTML = "";
}
function clearUserCreateData(){
	document.getElementById('user_create_id').value = "";
	document.getElementById('username').value = "";
	document.getElementById('password').value = "";
	document.getElementById('authoritiesList').value = "";
}
function clearAllSearchData(){
	document.getElementById("people_list").innerHTML = "";
    document.getElementById("lair_list").innerHTML = "";
    document.getElementById("vehicle_list").innerHTML = "";
    document.getElementById("tech_list").innerHTML = "";
}
function createTech(){
	var id = document.getElementById('tech_create_id').value;
	var name = document.getElementById('tech_name').value;
    var rawFunctions = document.getElementsByName("functions");

	var functions = [];
	rawFunctions.forEach((duty) => {
		functions.push(duty.value);
	});
	var tech = {
			"_id":id,
			"name": name,
			"functions": functions
	}
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/tech");
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.setRequestHeader('Authorization', authHeaderValue);
	xmlHttp.onreadystatechange = function(){
		if(this.readyState == XMLHttpRequest.DONE){
			if(this.status === 403){
				alert("unauthroized user can not create user");
			}
			if(this.status === 401){
				alert("Must log in to create vehicle")
			}
			if(this.status === 200){
				console.log("Success");
			}
		}
	}
	xmlHttp.send(JSON.stringify(tech));
	printObject(tech, 'tech');
	clearTechCreateData();
}
function createLair(){
	var id = document.getElementById('lair_create_id').value;
    var name = document.getElementById('lair_name').value;
    var sqrft = document.getElementById('sqrft').value;
    var rawTraps = document.getElementsByName("traps");

	var traps = [];
	rawTraps.forEach((trap) => {
		traps.push(trap.value);
	});
	var lair = {
			"_id":id,
            "name": name,
            "sqrft": sqrft, 
			"traps": traps
	}
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/lair");
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.setRequestHeader('Authorization', authHeaderValue);
	xmlHttp.onreadystatechange = function(){
		if(this.readyState == XMLHttpRequest.DONE){
			if(this.status === 403){
				alert("unauthroized user can not create user");
			}
			if(this.status === 401){
				alert("Must log in to create vehicle")
			}
			if(this.status === 200){
				console.log("Success");
			}
		}
	}
	xmlHttp.send(JSON.stringify(lair));
	printObject(lair, 'lair');
	clearLairsCreateData();
}
function createVehicle(){
	var id = document.getElementById('vehicle_create_id').value;
    var name = document.getElementById('vehicle_name').value;
    var mph = document.getElementById('mph').value;
    var rawCapabilities = document.getElementsByName("capabilities");

	var capabilities = [];
	rawCapabilities.forEach((capability) => {
		capabilities.push(capability.value);
	});
	var vehicle = {
			"_id":id,
            "name": name,
            "mph": mph, 
			"capabilities": capabilities
	}
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/vehicle");
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.setRequestHeader('Authorization', authHeaderValue);
	xmlHttp.onreadystatechange = function(){
		if(this.readyState == XMLHttpRequest.DONE){
			if(this.status === 403){
				alert("unauthroized user can not create user");
			}
			if(this.status === 401){
				alert("Must log in to create vehicle")
			}
			if(this.status === 200){
				console.log("Success");
			}
		}
	}
	xmlHttp.send(JSON.stringify(vehicle));
	printObject(vehicle, 'vehicle');
	clearVehiclesCreateData();
}
function createUser(){
	var id = document.getElementById('user_create_id').value;
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var rawAuthorities = document.getElementsByName("authorities");

	var authroities = [];
	rawAuthorities.forEach((authority) => {
		authroities.push(authority.value);
	});
	var user = {
			"_id":id,
            "username": username,
            "password": password, 
			"authorities": authroities
	}
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/user");
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.setRequestHeader('Authorization', authHeaderValue);
	xmlHttp.onreadystatechange = function(){
		if(this.readyState == XMLHttpRequest.DONE){
			if(this.status === 403){
				alert("unauthroized user can not create user");
			}
			if(this.status === 401){
				alert("Must log in to create user")
			}
			if(this.status === 200){
				console.log("Success");
			}
		}
	}
	xmlHttp.send(JSON.stringify(user));
	clearUserCreateData();
}
function deleteObject(objectType){
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("DELETE", "http://localhost:8080/"+ objectType +"/" 
	+ document.getElementById(objectType +'_delete_id').value, true);
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.setRequestHeader('Authorization', authHeaderValue);
	xmlHttp.send();
	clearAllSearchData();
}
function deleteUser(){
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("DELETE", "http://localhost:8080/user/" 
	+ document.getElementById('user_delete_username').value, true);
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.send();
}
function getObjectById(objectType){
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function(){
		if(this.readyState == XMLHttpRequest.DONE && this.status == 200){
			var ob = JSON.parse(this.responseText);
			printObject(ob, objectType);
		}
	}
	xmlHttp.open("GET", "http://localhost:8080/"+ objectType +"/" + document.getElementById('person_search_id').value);
	xmlHttp.send();
}
function printObject(object, objectType){
	var personList = document.getElementById(objectType+ "_list");
	personList.innerHTML = JSON.stringify(object)
}
function showObject(objectType){
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function(){
		if(this.readyState == XMLHttpRequest.DONE && this.status == 200){
			var ob = JSON.parse(this.responseText);
			printObject(ob, objectType);
		}
	}
	xmlHttp.open("GET", "http://localhost:8080/"+ objectType);
	xmlHttp.send();
}
function addListItem(listType){
	var div = document.getElementById(listType + 'List');
	div.innerHTML += "<input type=\"text\" name=\"" + listType +"\"><br>";
}

function login(){
	var username = document.getElementById('login_username').value
	var password = document.getElementById('login_password').value
	authHeaderValue = "Basic " + btoa(username + ":" + password)

	document.getElementById("buttons").style.display = "block";
	document.getElementById("login").style.display = "none";

}
function logout(){
authHeaderValue = null;

document.getElementById("login").style.display = "block";
document.getElementById("buttons").style.display = "none";
showNoDiv();
}
  