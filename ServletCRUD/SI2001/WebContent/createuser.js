

var skillIds = [];


function addSkill( ){
	
	
	
	var eSkillsContainer = document.getElementById('skillsContainer');
	
	 var eSkill = document.createElement('span');
	 
	 /* eSkill.setAttribute('id', 'skill-' + skill.id);
	    eSkill.setAttribute('class', 'upsert__skill');
	    */
	 
	 var select = document.getElementById("skilltoAdd");
	 var value = select.options[select.selectedIndex].value;
	 var text =  select.options[select.selectedIndex].text;
	 console.log(skillIds);
	
	 if(skillIds.indexOf(value) > -1) {
	      alert('Skill already added');
	      return;
	    } else {
	      skillIds.push(value);
	    }
	 
	 
	    eSkill.innerHTML =  text;
	    eSkillsContainer.appendChild(eSkill);
	    
	    
	//document.getElementById("skillsContainer").submit();
	
	
}

function saveUser( ){
	console.log(skillIds.join());
	
	var input = document.createElement("input");

	input.setAttribute("type", "hidden");

	input.setAttribute("name", "skillsIds");

	input.setAttribute("value", skillIds.join());

	document.getElementById("createUser").appendChild(input);
	document.getElementById("createUser").submit();
}