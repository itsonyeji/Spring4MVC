<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    <%--이거 새로 넣기--%>
<!DOCTYPE html>
<html>

<head>
    <title><tiles:getAsString name="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="/assets/css/project.css" rel="stylesheet">
</head>

<body>
<div id="container">
    <tiles:insertAttribute name="header"/>
<%--    header라는 이름의 것을 여기 넣는다 --%>
    <tiles:insertAttribute name="main" />
    <tiles:insertAttribute name="footer"/>

</div>
</body>

</html>