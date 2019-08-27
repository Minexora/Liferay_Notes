<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<portlet:actionURL var="actionUrl" name="processFood"></portlet:actionURL>

<form action="${actionUrl}" method="post">
<h3><input type="radio" name="foodType" value="veg">Vegetarian</h3>
<h3><input type="radio" name="foodType" value="non-veg">Non-Vegetarian</h3>
<input type="submit" name="submit" value="Submit">
</form>
