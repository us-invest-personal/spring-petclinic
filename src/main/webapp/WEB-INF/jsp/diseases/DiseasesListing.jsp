<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="owners">
	<h2>Diseases</h2>
	    <table id="diseasesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 20%;">Name</th>
            <th style="width: 80%;">Description</th>            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${diseases}" var="disease">
            <tr>
                <td>                    
                    <c:out value="${disease.name}"/>
                </td>
                <td>
                    <c:out value="${disease.description}"/>
                </td>                
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
	
</petclinic:layout>