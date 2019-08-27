<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<portlet:actionURL var="register" name="registerMethod"></portlet:actionURL>


<div id="errors">
	<c:if test="${! empty errors}">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li style="color:red;"><c:out value="${error}"></c:out></li>
			</c:forEach>
		</ul>
	</c:if>
</div>


<form action="${register}" method="post">
	<div>
		<label>First Name <sup>*</sup> : </label> 
		<input type="text" value='<c:out value="${User.firstname}"></c:out>' name="firstname">
	</div>
	<div>
		<label>Last Name <sup>*</sup> : </label> 
		<input type="text" value='<c:out value="${User.lastname}"></c:out>' name="lastname">
	</div> 
	<div>
		<label>Phone <sup>*</sup> : </label> 
		<input type="text" value='<c:out value="${User.phone}"></c:out>' name="phone">
	</div>
	<div>
		<label>E-Mail <sup>*</sup> : </label> 
		<input type="text" value='<c:out value="${User.email}"></c:out>' name="email">
	</div>
	<div>		
		<input type="submit" value="Submit">
	</div>
</form>