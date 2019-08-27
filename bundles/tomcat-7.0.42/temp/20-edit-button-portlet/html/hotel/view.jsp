<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />

<c:set var="food" value="${foodType}" />

<c:choose>
	<c:when test="${food == 'veg'}">
		<h3><font color="green">You are vegetarian. You can enjoy Salad.</font></h3>
	</c:when>
	<c:when test="${food == 'non-veg'}">
		<h3><font color="red">You are Non - vegetarian. You can enjoy Chicken.</font></h3>
	</c:when>
	<c:otherwise>
		<h3>Please Select Food Type</h3>
	</c:otherwise>
</c:choose>


