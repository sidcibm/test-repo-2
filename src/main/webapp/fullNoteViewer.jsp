<%@ page import="model.note.Note" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="meta.jsp"/>
    <title>Full Note Viewer</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <h2>Full Note Viewer</h2>
    <form action="notesIndex.html">
        <input type="submit" value="Back">
    </form>
    <%Note note = (Note) request.getAttribute("note");%>
    <table>
        <tr>
            <th>ID</th>
            <th>Text</th>
            <th>Image</th>
        </tr>
        <tr>
            <td>
                <%=note.getId()%>
            </td>
            <td rowspan="5">
                <%=String.join("<br>", note.getText().split("\n"))%>
            </td>
            <td rowspan="5">
                <img src="<%=note.getImage()%>" alt="<%=note.getImage()%>" style="max-width:200px;max-height:200px">
            </td>
        </tr>
        <tr>
            <th>Name</th>
        </tr>
        <tr>
            <td>
                <%=note.getName()%>
            </td>
        </tr>
        <tr>
            <th>URL</th>
        </tr>
        <tr>
            <td>
                <a href="<%=note.getUrl()%>">
                    <%=note.getUrl()%>
                </a>
            </td>
        </tr>
    </table>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
