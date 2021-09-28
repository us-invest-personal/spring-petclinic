<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->  

<petclinic:layout pageName="home">
    <h2><fmt:message key="welcome"/></h2>
    <div class="row">
    	<h2>Project ${title}</h2>
    	<p2><h2>Group ${group}</h2></p2>
    	
    	<p><ul>
    		<c:forEach items="${persons}" var="person">
    			<li>${person.firstName}  -- ${person.lastName}</li>
    		</c:forEach>
    	</ul></p>
    	
        <div class="col-md-12">
            <spring:url value="/resources/images/pets.png" htmlEscape="true" var="petsImage"/>
            <img class="img-responsive" src="${petsImage}"/>
        </div>
        
        <div class="col-md-12">
            <spring:url value="/resources/images/logoPNG_3.png" htmlEscape="true" var="logoUS"/>
            <img class="img-responsive" src="${logoUS}"/>
        </div>
    </div>
</petclinic:layout>
