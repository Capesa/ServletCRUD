<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="CreateUser.do" id="createUser">

	First name: <input type="text" size="40" maxlength="40" name="firstname"/><br>
	Last name:  <input type="text" size="40" maxlength="40" name="lastname" /><br>
	Marital Status
            
          <select name="marital_status_id">
          	<c:forEach items = "${mstatus}" var = "mstatus">
      		  <option value="${mstatus.maritalId}">${mstatus.status}</option>
            </c:forEach>
          </select>  
          
    
    Skills 
    
    	 <select name="skillsId" id="skilltoAdd">
          	<c:forEach items = "${skills}" var = "skills">
      		  <option value="${skills.skillId}">${skills.skill}</option>
            </c:forEach>
          </select>  
     <button type="button" onclick="addSkill()">Salva</button>     
   
   <br>
  
   <div id="skillsContainer">
   	a
   </div>
   
   
   </form>
   
  
     
  <button onclick="saveUser()">Salva</button>
            
	
	

<script src="createuser.js" type="text/javascript"></script>



</body>
</html>