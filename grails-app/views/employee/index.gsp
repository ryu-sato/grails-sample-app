<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <script language="javascript">
      var edit_button_id = "edit_button";
      function enableEditButton() {
        document.getElementById(edit_button_id).disabled = false;
      }
      function disableEditButton() {
        document.getElementById(edit_button_id).disabled = true;
      }
      function handleEditButtonStatus() {
        var radios = document.getElementsByName('id');
        var checkedNum = 0;
        radios.forEach(e => e.checked && checkedNum++);
        if (checkedNum > 0) {
          enableEditButton();
        } else {
          disableEditButton();
        }
      }
    </script>
  </head>
  <body onload="handleEditButtonStatus()">
    <a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
      <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
      </ul>
    </div>
    <div id="list-employee" class="content scaffold-list" role="main">
      <h1><g:message code="default.list.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
      </g:if>

      <g:form action="edit">
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Edit</th>
              <g:each in="${['id', 'name', 'department', 'gender']}" var="p">
                <g:set var="propTitle">${p}</g:set>
                <g:sortableColumn property="${p}" title="${message(code: propTitle, default: p)}" />
              </g:each>
            </tr>
          </thead>
          <tbody>
          <g:each in="${employeeList}" var="employee">
            <tr>
              <td><input name="id" type="radio" value="${employee.id}" onclick="handleEditButtonStatus()" /></td>
              <g:each in="${['id', 'name', 'department', 'gender']}" var="p">
                <g:if test="${p=='id'}">
                  <td><g:link method="GET" resource="${employee}">${employee.properties[p]}</g:link></td>
                </g:if>
                <g:else>
                  <td>${employee.properties[p]}</td>
                </g:else>
              </g:each>
            </tr>
          </g:each>
          </tbody>
        </table>

        <button disabled="false" id="edit_button"><g:message code="default.edit.label" args="[entityName]" /></button>
      </g:form>

      <div class="pagination">
        <g:paginate total="${employeeCount ?: 0}" />
      </div>
    </div>
  </body>
</html>