<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="java.util.List"%>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

<form id="<portlet:namespace />savePosSearcherPrefsForm"
	action="${configurationURL}" method="post"
	name="<portlet:namespace />fm" class="form-horizontal">

	<fieldset>
		<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden"
			value="<%=Constants.UPDATE%>" />
			
		<div class="control-group">
		  <div class="controls">
		    <input id="folderId" name="<portlet:namespace />preferences--folderId--" />
		  </div>
		</div>
		<div class="control-group">
			<label class="control-label" for=""></label>
			<div class="controls">
				<button id="<portlet:namespace />saveSupportPrefs" name=""
					class="btn btn-primary" type="submit">Guardar
					Preferencias</button>
			</div>
		</div>
	</fieldset>

</form>