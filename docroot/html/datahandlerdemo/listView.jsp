<%@page import="es.vass.demo.portlet.view.CreateHeroView"%>
<%@include file="/html/init.jsp"%>

<%@include file="/html/datahandlerdemo/errorMsg.jspf"%>

<div>
	<h4>Heroes</h4>
	<div>
		<c:set var="createHeroView" value="<%=CreateHeroView.VIEW_NAME%>" />

		<portlet:renderURL var="addNewURL">
			<portlet:param name="view" value="${createHeroView}" />
		</portlet:renderURL>
		
		<%@include file="/html/datahandlerdemo/addNewButton.jspf"%>

		<liferay-ui:search-container
			searchContainer="${heroSearchContainer}">
			<liferay-ui:search-container-results
				results="<%=searchContainer.getResults()%>"
				total="<%=searchContainer.getTotal() %>">
				<liferay-ui:search-container-row
					className="es.vass.demo.service.model.Hero"
					modelVar="hero">
					<liferay-ui:search-container-column-text name="Name"
						property="name" />
					<liferay-ui:search-container-column-text name="Description"
						property="description" />	
					<liferay-ui:search-container-column-jsp align="right"
						path="/html/datahandlerdemo/options.jsp" />
				</liferay-ui:search-container-row>
				<!-- Iterating the Results -->
				<liferay-ui:search-iterator />
			</liferay-ui:search-container-results>
		</liferay-ui:search-container>
	</div>
</div>