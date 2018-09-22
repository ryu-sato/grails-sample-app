<!doctype html>
<html lang="en" class="no-js">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <title>
    <g:layoutTitle default="Grails"/>
  </title>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

  <asset:stylesheet src="application.css"/>
  <asset:javascript src="application.js"/>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

  <g:layoutHead/>
</head>
<body>

  <nav class="navbar-expand-lg pr-3 navbar navbar-default">
    <a class="navbar-brand" href="/#">
      <asset:image src="grails.svg" alt="Grails Logo"/>
    </a>
    <button class="navbar-toggler mx-2" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="fas fa-bars" style="font-size: 3rem;"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <g:pageProperty name="page.nav" />
      </ul>
    </div>
  </nav>

  <g:layoutBody/>

  <div class="footer" role="contentinfo"></div>

  <div id="spinner" class="spinner" style="display:none;">
      <g:message code="spinner.alt" default="Loading&hellip;"/>
  </div>

</body>
</html>
