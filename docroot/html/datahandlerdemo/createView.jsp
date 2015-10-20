<%@include file="/html/init.jsp"%>

<portlet:actionURL var="heroURL" name="saveHero">
	<portlet:param name="javax.portlet.action" value="saveHero" />
</portlet:actionURL>
<div>
	<h4>New Hero</h4>
	<%@ include file="/html/datahandlerdemo/form.jspf" %>
</div>
