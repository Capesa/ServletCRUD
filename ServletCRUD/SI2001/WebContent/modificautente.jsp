<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Title</h1>

<form method="post" action="ModificaUtente.do">

 <p>
        First name: <input type = "text" size = "40" maxlength = "40" name = "firstname"  value = "${user.firstname}" > <br>
        <br>
        Last name:  <input type = "text" size = "40" maxlength = "40" name = "lastname"  value = "${user.lastname}" > <br>
        <br>
        
        Stato civile:
        <select name = "marital_status_id" >
            <c:forEach items = "${maritalStatusList}" var = "maritalStatus">
                <option value = "${maritalStatus.maritalId}" ${maritalStatus.maritalId eq user.maritalStatus.maritalId ? 'selected' : ''}>
                        ${maritalStatus.status}
                </option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input type = "hidden" name = "id" value = "${user.id}" >
        <input type = "submit" value="Modifica"/>
    </p>
    
</form>

    
   



</body>
</html>