<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var="firstAction" name="firstActionMethod">
</portlet:actionURL>

<portlet:renderURL var="myRenderUrl">
<portlet:param name="redirect" value="greeting"/>
</portlet:renderURL>

<b>My First Generic Project</b>

<form action="${firstAction}" method="post">
Name: <input type="text" name="name">
<input type="submit" value="SUBMIT">
</form>

<a href="${myRenderUrl}" > Click for Greeting</a>