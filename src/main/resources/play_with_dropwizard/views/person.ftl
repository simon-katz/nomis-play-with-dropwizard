<#-- @ftlvariable name="" type="play_with_dropwizard.views.PersonView" -->
<html>
    <body>
        <!-- calls getPerson().getName() and sanitizes it -->
        <h1>Hello, ${person.name?html}!</h1>
    </body>
</html>
