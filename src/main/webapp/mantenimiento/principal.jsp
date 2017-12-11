<%-- 
    Document   : contenido
    Created on : 14/11/2010, 01:19:29 PM
    Author     : cesardl
--%>
<script type="text/javascript">
    $(function() {
        $('#accordion').accordion();
    }) ;
</script>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<p>contenido</p>
<%@page import="java.util.Date, java.util.Map, java.util.LinkedHashMap" %>
<%
            String x = "testing";
            String[] arreglo = {"VV", "WW", "XX", "YY", "ZZ"};

            Map<String, String> map = new LinkedHashMap<String, String>();
            map.put("aa", "1");
            map.put("bb", "2");
            map.put("cc", "3");

            session.setAttribute("x", x);
            session.setAttribute("arreglo", arreglo);
            session.setAttribute("map", map);
            session.setAttribute("date", new Date());
%>
<div id="accordion">
    <h3><a href="#">Section 1</a></h3>
    <div>
        <p>
            Cadena ${x}<br />
            De un array ${arreglo[1]}<br />
            De un map ${map["aa"]}<br />
            Some simple math: ${2+2}<br/>
            Some simple math with c:out: <c:out value="${x}" />
        </p>
    </div>

    <h3><a href="#">Section 2</a></h3>
    <div>
        <p>
            <c:forEach var="i" items="${arreglo}">
                <c:out value="${i}" />,
            </c:forEach>

            <fmt:formatDate value="${date}" pattern="yyyy/MM/dd"/>
        </p>
    </div>
</div>