<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />


<b> This is greeting <%=renderRequest.getParameter("name") %>.</b>