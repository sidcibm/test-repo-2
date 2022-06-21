<%@ page import="model.note.Note" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="meta.jsp"/>
    <title>Note Summary Viewer</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <h2>Note Summary Viewer</h2>
    <form action="notesIndex.html">
        <input type="submit" value="Back">
    </form>
    <%Note note = (Note) request.getAttribute("note");%>
    <p>
        <b>ID:</b> <%=note.getId()%>
    </p>
    <p>
        <b>Name:</b> <%=note.getName()%>
    </p>
    <p>
        <b>URL:</b> This note <%=note.getUrl().equals("") ? "does not have" : "has"%> a URL.
    </p>
    <p>
        <b>Image:</b> This note <%=note.getImage().equals("") ? "does not have" : "has"%> an image.
    </p>
    <p>
        <b>Text Summary:</b> The first line of text in this note is "<%=note.getText().split("\n")[0]%>"
    </p>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
