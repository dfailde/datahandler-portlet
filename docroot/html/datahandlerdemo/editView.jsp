<%@include file="/html/init.jsp"%>

<portlet:actionURL var="heroURL" name="updateHero">
	<portlet:param name="javax.portlet.action" value="updateHero" />
</portlet:actionURL>
<div>
	<h4>Edit Hero</h4>
	<%@ include file="/html/datahandlerdemo/form.jspf" %>
</div>
