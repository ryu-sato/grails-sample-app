<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <script type="text/javascript">
      /* 編集ボタンのステータスをラジオボタンのステータスを基に設定する */
      function setEditButtonStatusByRadioButton() {
        var edit_button_id = "edit_button";
        var radios = document.getElementsByName('id');
        var checkedNum = 0;
        radios.forEach(e => e.checked && checkedNum++);
        if (checkedNum > 0) {
          document.getElementById(edit_button_id).disabled = false;
        } else {
          document.getElementById(edit_button_id).disabled = true;
        }
      }

      $(document).ready(function() {
        $('#employeeindex').dataTable({
          "paging": false
        });
      } );
    </script>
  </head>
  <body>
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
        <g:set var="props" value="${['id', 'name', 'department', 'gender']}" />
        <table id="employeeindex" class="display table table-striped">
          <g:set var="props" value="${['id', 'name', 'department', 'gender']}" />
          <thead>
            <tr>
              <th>Edit</th>
              <g:each in="${props}" var="p">
                <g:sortableColumn property="${p}" title="${p}" />
              </g:each>
            </tr>
          </thead>
          <tbody>
          <g:each in="${employeeList}" var="employee">
            <tr>
              <td><input name="id" type="radio" value="${employee.id}" onclick="setEditButtonStatusByRadioButton()" /></td>
              <g:each in="${props}" var="p">
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

        <button class="btn btn-secondary" disabled="false" id="edit_button"><g:message code="default.edit.label" args="[entityName]" /></button>
      </g:form>

      <div class="pagination">
        <g:paginate total="${employeeCount ?: 0}" />
      </div>
    </div>
  </body>
</html>