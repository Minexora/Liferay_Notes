<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var="myFunction" name="myFunctionMethod"></portlet:actionURL>

<portlet:renderURL var="myRenderUrl">
	<portlet:param name="jspPage" value="" />
</portlet:renderURL>

 <b>First Mvc Portlet</b>

 <form action="${myFunction}" method="post">
 Name: <input type="text" name="name"/>
 <input type="submit">
 </form>
 
 <a href="${myRenderUrl}"> Click  for  greeting.</a>