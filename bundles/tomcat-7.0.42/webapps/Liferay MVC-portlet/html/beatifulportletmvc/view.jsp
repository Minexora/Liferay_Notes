<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />


<portlet:actionURL var="myFunction" name="myFunctionMethod"></portlet:actionURL>

 <b>First Mvc Portlet</b>

 <aui:form action="${myFunction}" method="post">
 <aui:input type="text" name="name" id="name"/>
 <aui:button name="Submit" type="Submit" value="Submit"></aui:button>
 </aui:form>
 