<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil" %><%@
page import="com.liferay.portal.LocaleException" %><%@
page import="com.liferay.portal.NoSuchLayoutException" %><%@
page import="com.liferay.portal.NoSuchRoleException" %><%@
page import="com.liferay.portal.NoSuchUserException" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil" %><%@
page import="com.liferay.portal.kernel.cal.Recurrence" %><%@
page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException" %><%@
page import="com.liferay.portal.kernel.captcha.CaptchaTextException" %><%@
page import="com.liferay.portal.kernel.configuration.Filter" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.DisplayTerms" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.dao.search.RowChecker" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchEntry" %><%@
page import="com.liferay.portal.kernel.dao.search.TextSearchEntry" %><%@
page import="com.liferay.portal.kernel.exception.PortalException" %><%@
page import="com.liferay.portal.kernel.exception.SystemException" %><%@
page import="com.liferay.portal.kernel.json.JSONArray" %><%@
page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %><%@
page import="com.liferay.portal.kernel.json.JSONObject" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.language.LanguageWrapper" %><%@
page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %><%@
page import="com.liferay.portal.kernel.log.Log" %><%@
page import="com.liferay.portal.kernel.log.LogFactoryUtil" %><%@
page import="com.liferay.portal.kernel.log.LogUtil" %><%@
page import="com.liferay.portal.kernel.messaging.DestinationNames" %><%@
page import="com.liferay.portal.kernel.plugin.PluginPackage" %><%@
page import="com.liferay.portal.kernel.portlet.DynamicRenderRequest" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletRequest" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.repository.model.FileEntry" %><%@
page import="com.liferay.portal.kernel.repository.model.FileVersion" %><%@
page import="com.liferay.portal.kernel.search.Field" %><%@
page import="com.liferay.portal.kernel.search.Hits" %><%@
page import="com.liferay.portal.kernel.search.Indexer" %><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.search.QueryConfig" %><%@
page import="com.liferay.portal.kernel.search.SearchContext" %><%@
page import="com.liferay.portal.kernel.search.SearchContextFactory" %><%@
page import="com.liferay.portal.kernel.search.SearchResultUtil" %><%@
page import="com.liferay.portal.kernel.search.Sort" %><%@
page import="com.liferay.portal.kernel.search.SortFactoryUtil" %><%@
page import="com.liferay.portal.kernel.search.Summary" %><%@
page import="com.liferay.portal.kernel.servlet.BrowserSnifferUtil" %><%@
page import="com.liferay.portal.kernel.servlet.BufferCacheServletResponse" %><%@
page import="com.liferay.portal.kernel.servlet.PortalMessages" %><%@
page import="com.liferay.portal.kernel.servlet.ServletContextPool" %><%@
page import="com.liferay.portal.kernel.servlet.ServletContextUtil" %><%@
page import="com.liferay.portal.kernel.servlet.SessionErrors" %><%@
page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.staging.LayoutStagingUtil" %><%@
page import="com.liferay.portal.kernel.template.StringTemplateResource" %><%@
page import="com.liferay.portal.kernel.template.TemplateHandler" %><%@
page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.upload.UploadException" %><%@
page import="com.liferay.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarUtil" %><%@
page import="com.liferay.portal.kernel.util.CharPool" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.ContentTypes" %><%@
page import="com.liferay.portal.kernel.util.CookieKeys" %><%@
page import="com.liferay.portal.kernel.util.DateUtil" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.Http" %><%@
page import="com.liferay.portal.kernel.util.HttpUtil" %><%@
page import="com.liferay.portal.kernel.util.IntegerWrapper" %><%@
page import="com.liferay.portal.kernel.util.JavaConstants" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePair" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePairComparator" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.LocaleUtil" %><%@
page import="com.liferay.portal.kernel.util.LocalizationUtil" %><%@
page import="com.liferay.portal.kernel.util.MapUtil" %><%@
page import="com.liferay.portal.kernel.util.MathUtil" %><%@
page import="com.liferay.portal.kernel.util.ObjectValuePair" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.OrderedProperties" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PrefsParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PropertiesParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PropertiesUtil" %><%@
page import="com.liferay.portal.kernel.util.PropsKeys" %><%@
page import="com.liferay.portal.kernel.util.ReleaseInfo" %><%@
page import="com.liferay.portal.kernel.util.ResourceBundleUtil" %><%@
page import="com.liferay.portal.kernel.util.ServerDetector" %><%@
page import="com.liferay.portal.kernel.util.SetUtil" %><%@
page import="com.liferay.portal.kernel.util.SortedArrayList" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringComparator" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.TextFormatter" %><%@
page import="com.liferay.portal.kernel.util.Time" %><%@
page import="com.liferay.portal.kernel.util.TimeZoneUtil" %><%@
page import="com.liferay.portal.kernel.util.Tuple" %><%@
page import="com.liferay.portal.kernel.util.UnicodeFormatter" %><%@
page import="com.liferay.portal.kernel.util.UnicodeProperties" %><%@
page import="com.liferay.portal.kernel.util.UniqueList" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowDefinition" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowEngineManagerUtil" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil" %><%@
page import="com.liferay.portal.layoutconfiguration.util.RuntimePageUtil" %><%@
page import="com.liferay.portal.model.*" %><%@
page import="com.liferay.portal.model.impl.*" %><%@
page import="com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil" %><%@
page import="com.liferay.portal.security.auth.AuthTokenUtil" %><%@
page import="com.liferay.portal.security.auth.PrincipalException" %><%@
page import="com.liferay.portal.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.security.permission.PermissionChecker" %><%@
page import="com.liferay.portal.security.permission.ResourceActionsUtil" %><%@
page import="com.liferay.portal.service.*" %><%@
page import="com.liferay.portal.service.permission.GroupPermissionUtil" %><%@
page import="com.liferay.portal.service.permission.LayoutPermissionUtil" %><%@
page import="com.liferay.portal.service.permission.LayoutPrototypePermissionUtil" %><%@
page import="com.liferay.portal.service.permission.LayoutSetPrototypePermissionUtil" %><%@
page import="com.liferay.portal.service.permission.PortalPermissionUtil" %><%@
page import="com.liferay.portal.service.permission.PortletPermissionUtil" %><%@
page import="com.liferay.portal.service.permission.RolePermissionUtil" %><%@
page import="com.liferay.portal.theme.ThemeDisplay" %><%@

page import="com.liferay.portal.util.comparator.PortletCategoryComparator" %><%@
page import="com.liferay.portal.util.comparator.PortletTitleComparator" %><%@
page import="com.liferay.portal.webserver.WebServerServletTokenUtil" %><%@
page import="com.liferay.portlet.InvokerPortlet" %><%@
page import="com.liferay.portlet.PortalPreferences" %><%@
page import="com.liferay.portlet.PortletConfigFactoryUtil" %><%@
page import="com.liferay.portlet.PortletInstanceFactoryUtil" %><%@
page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %><%@
page import="com.liferay.portlet.PortletSetupUtil" %><%@
page import="com.liferay.portlet.PortletURLFactoryUtil" %><%@
page import="com.liferay.portlet.PortletURLUtil" %><%@
page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil" %><%@
page import="com.liferay.portlet.asset.model.AssetCategory" %><%@
page import="com.liferay.portlet.asset.model.AssetEntry" %><%@
page import="com.liferay.portlet.asset.model.AssetRenderer" %><%@
page import="com.liferay.portlet.asset.model.AssetRendererFactory" %><%@
page import="com.liferay.portlet.asset.model.AssetTag" %><%@
page import="com.liferay.portlet.asset.model.AssetVocabulary" %><%@
page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetCategoryServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetEntryServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetTagServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.AssetVocabularyServiceUtil" %><%@
page import="com.liferay.portlet.asset.service.persistence.AssetEntryQuery" %><%@
page import="com.liferay.portlet.blogs.model.BlogsEntry" %><%@
page import="com.liferay.portlet.documentlibrary.FileSizeException" %><%@
page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %><%@
page import="com.liferay.portlet.documentlibrary.model.DLFileEntryConstants" %><%@
page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %><%@
page import="com.liferay.portlet.documentlibrary.util.DLUtil" %><%@
page import="com.liferay.portlet.dynamicdatamapping.NoSuchStructureException" %><%@
page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %><%@
page import="com.liferay.portlet.dynamicdatamapping.model.DDMTemplate" %><%@
page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil" %><%@
page import="com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil" %><%@
page import="com.liferay.portlet.expando.model.ExpandoBridge" %><%@
page import="com.liferay.portlet.journal.model.JournalArticle" %><%@
page import="com.liferay.portlet.journal.model.JournalArticleConstants" %><%@
page import="com.liferay.portlet.journal.model.JournalArticleDisplay" %><%@
page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %><%@
page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil" %><%@
page import="com.liferay.portlet.journalcontent.util.JournalContentUtil" %><%@
page import="com.liferay.portlet.messageboards.model.MBMessage" %><%@
page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil" %><%@
page import="com.liferay.portlet.portletconfiguration.util.PortletConfigurationUtil" %><%@
page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil" %><%@
page import="com.liferay.portlet.rolesadmin.util.RolesAdminUtil" %><%@
page import="com.liferay.portlet.sites.util.Sites" %><%@
page import="com.liferay.portlet.sites.util.SitesUtil" %><%@
page import="com.liferay.portlet.trash.model.TrashEntry" %><%@
page import="com.liferay.portlet.trash.util.TrashUtil" %><%@
page import="com.liferay.portlet.usersadmin.util.UsersAdminUtil" %><%@
page import="com.liferay.taglib.util.OutputTag" %><%@
page import="com.liferay.util.ContentUtil" %><%@
page import="com.liferay.util.CreditCard" %><%@
page import="com.liferay.util.Encryptor" %><%@
page import="com.liferay.util.JS" %><%@
page import="com.liferay.util.PKParser" %><%@
page import="com.liferay.util.PwdGenerator" %><%@
page import="com.liferay.util.State" %><%@
page import="com.liferay.util.StateUtil" %><%@
page import="com.liferay.util.log4j.Levels" %><%@
page import="com.liferay.util.portlet.PortletRequestUtil" %><%@

page import="com.liferay.util.xml.XMLFormatter" %>

<%@ page import="java.io.Serializable" %>

<%@ page import="java.text.DateFormat" %><%@
page import="java.text.DecimalFormat" %><%@
page import="java.text.Format" %><%@
page import="java.text.NumberFormat" %><%@
page import="java.text.SimpleDateFormat" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Arrays" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.Collection" %><%@
page import="java.util.Collections" %><%@
page import="java.util.Currency" %><%@
page import="java.util.Date" %><%@
page import="java.util.Enumeration" %><%@
page import="java.util.HashMap" %><%@
page import="java.util.HashSet" %><%@
page import="java.util.Iterator" %><%@
page import="java.util.LinkedHashMap" %><%@
page import="java.util.LinkedHashSet" %><%@
page import="java.util.List" %><%@
page import="java.util.Locale" %><%@
page import="java.util.Map" %><%@
page import="java.util.Properties" %><%@
page import="java.util.ResourceBundle" %><%@
page import="java.util.Set" %><%@
page import="java.util.Stack" %><%@
page import="java.util.TimeZone" %><%@
page import="java.util.TreeMap" %><%@
page import="java.util.TreeSet" %>

<%@ page import="javax.portlet.MimeResponse" %><%@
page import="javax.portlet.PortletConfig" %><%@
page import="javax.portlet.PortletContext" %><%@
page import="javax.portlet.PortletException" %><%@
page import="javax.portlet.PortletMode" %><%@
page import="javax.portlet.PortletPreferences" %><%@
page import="javax.portlet.PortletRequest" %><%@
page import="javax.portlet.PortletResponse" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.ResourceURL" %><%@
page import="javax.portlet.UnavailableException" %><%@
page import="javax.portlet.ValidatorException" %><%@
page import="javax.portlet.WindowState" %>


<%@ page import="com.liferay.portal.DuplicateGroupException" %><%@
page import="com.liferay.portal.DuplicateTeamException" %><%@
page import="com.liferay.portal.GroupFriendlyURLException" %><%@
page import="com.liferay.portal.GroupNameException" %><%@
page import="com.liferay.portal.GroupParentException" %><%@
page import="com.liferay.portal.LayoutSetVirtualHostException" %><%@
page import="com.liferay.portal.MembershipRequestCommentsException" %><%@
page import="com.liferay.portal.NoSuchGroupException" %><%@
page import="com.liferay.portal.NoSuchLayoutSetException" %><%@
page import="com.liferay.portal.PendingBackgroundTaskException" %><%@
page import="com.liferay.portal.RemoteExportException" %><%@
page import="com.liferay.portal.RemoteOptionsException" %><%@
page import="com.liferay.portal.RequiredGroupException" %><%@
page import="com.liferay.portal.TeamNameException" %><%@
page import="com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants" %><%@
page import="com.liferay.portal.kernel.lar.PortletDataHandler" %><%@
page import="com.liferay.portal.kernel.staging.StagingConstants" %><%@
page import="com.liferay.portal.kernel.staging.StagingUtil" %><%@
page import="com.liferay.portal.security.auth.AuthException" %><%@
page import="com.liferay.portal.security.auth.RemoteAuthException" %><%@
page import="com.liferay.portal.security.membershippolicy.SiteMembershipPolicyUtil" %><%@
page import="com.liferay.portal.service.permission.TeamPermissionUtil" %><%@
page import="com.liferay.portal.util.CustomJspRegistryUtil" %>

<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="java.util.List" %>

<%@ page import="com.liferay.portal.DuplicateGroupException" %><%@
page import="com.liferay.portal.DuplicateTeamException" %><%@
page import="com.liferay.portal.GroupFriendlyURLException" %><%@
page import="com.liferay.portal.GroupNameException" %><%@
page import="com.liferay.portal.GroupParentException" %><%@
page import="com.liferay.portal.LayoutSetVirtualHostException" %><%@
page import="com.liferay.portal.MembershipRequestCommentsException" %><%@
page import="com.liferay.portal.NoSuchGroupException" %><%@
page import="com.liferay.portal.NoSuchLayoutSetException" %><%@
page import="com.liferay.portal.PendingBackgroundTaskException" %><%@
page import="com.liferay.portal.RemoteExportException" %><%@
page import="com.liferay.portal.RemoteOptionsException" %><%@
page import="com.liferay.portal.RequiredGroupException" %><%@
page import="com.liferay.portal.TeamNameException" %><%@
page import="com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants" %><%@
page import="com.liferay.portal.kernel.lar.PortletDataHandler" %><%@
page import="com.liferay.portal.kernel.staging.StagingConstants" %><%@
page import="com.liferay.portal.kernel.staging.StagingUtil" %><%@
page import="com.liferay.portal.security.auth.AuthException" %><%@
page import="com.liferay.portal.security.auth.RemoteAuthException" %><%@
page import="com.liferay.portal.security.membershippolicy.SiteMembershipPolicyUtil" %><%@
page import="com.liferay.portal.service.permission.TeamPermissionUtil" %><%@
page import="com.liferay.portal.util.CustomJspRegistryUtil" %><%@
page import="com.liferay.portlet.backgroundtask.util.comparator.BackgroundTaskCreateDateComparator" %>


<%@ page import="com.liferay.portal.util.PortalUtil" %><%@

page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletRequest" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@

page import="com.liferay.portal.util.PortletKeys" %><%@

page import="com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil" %><%@

page import="com.liferay.portlet.assetpublisher.util.AssetPublisherUtil" %>

 <%@ page import="javax.portlet.PortletPreferences" %>
 
 <%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
 
 <%@ page import="com.liferay.portal.kernel.xml.Document"%>
 <%@ page import="com.liferay.portal.kernel.xml.Element"%>
 <%@ page import="com.liferay.portal.kernel.xml.Node"%>
 <%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
 <%@ page import="com.liferay.portal.kernel.xml.XPath"%>
 
  <%@ page import="javax.portlet.Event"%>
  
  <%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
  
  
<%@ page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@ page import="com.liferay.portlet.asset.model.AssetLink"%>
<%@ page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil"%>

<%@ page import="javax.portlet.RenderRequest"%>
<%@ page import="javax.portlet.RenderResponse"%>

<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>

<%@ page import="java.util.LinkedList" %>

<%@ page import="com.liferay.portlet.asset.NoSuchCategoryException" %>





<liferay-theme:defineObjects />
<portlet:defineObjects />

<c:set var="ns">
	<portlet:namespace />
</c:set>



