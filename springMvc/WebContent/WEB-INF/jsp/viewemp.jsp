<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1> 


   <table border="2" width="70%" cellpadding="2">  
<tr><th>DATE</th><th>DELIVERED DATE</th></tr> 
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.date}</td> 
   <%-- <td>${emp.salary}</td> --%>
   <td>${emp.delivereddate}</td>
   </tr>  
   </c:forEach>  
   </table>  
  
  