<%@page import="es.vass.demo.service.model.Hero"%>
<%@page import="es.vass.demo.portlet.view.EditHeroView"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="ui"%>

<%@include file="/html/init.jsp"%>


<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Hero hero = (Hero) row.getObject();
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<ui:icon-menu>

	<c:set var="editHeroView" value="<%=EditHeroView.VIEW_NAME%>" />

	<portlet:renderURL var="editHeroURL">
		<portlet:param name="view" value="${editHeroView}" />
		<portlet:param name="heroId" value="<%=String.valueOf(hero.getHeroId())%>" />
	</portlet:renderURL>

	<ui:icon image="edit" url="${editHeroURL}" />

	<portlet:actionURL name="removeHero" var="removeHeroURL">
		<portlet:param name="heroId" value="<%=String.valueOf(hero.getHeroId())%>" />
	</portlet:actionURL>

	<ui:icon-delete url="${removeHeroURL}" />
</ui:icon-menu>