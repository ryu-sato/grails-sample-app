<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
  </head>
  <body>
    <a href="#show-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
      <ul>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
      </ul>
    </div>
    <div id="show-employee" class="content scaffold-show" role="main">
      <h1><g:message code="default.show.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
      </g:if>

      <ol class="property-list employee">
        <li class="fieldcontain">
          <g:each in="${['id', 'name', 'department', 'gender', 'birth', 'serviceYears', 'payment', 'note']}" var="p">
            <span id="name-label" class="property-label">${p}</span>
            <g:if test="${p=='serviceYears'}">
              <div class="property-value" aria-labelledby="name-label">${employee.serviceYears()}</div>
            </g:if>
            <g:else>
              <div class="property-value" aria-labelledby="name-label">${employee.properties[p]}</div>
            </g:else>
          </g:each>
        </li>
      </ol>
      
      <g:form resource="${this.employee}" method="DELETE">
        <fieldset class="buttons">
          <g:link class="edit" action="edit" resource="${this.employee}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
          <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
        </fieldset>
      </g:form>
    </div>
  </body>
</html>
