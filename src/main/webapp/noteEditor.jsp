<%@ page import="model.note.Note" %>
<%@ page import="java.util.UUID" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="meta.jsp"/>
    <title>Note Editor</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <h2>Editor</h2>
    <form action="notesIndex.html">
        <input type="submit" value="Back">
    </form>
    <%
        Note note = (Note) request.getAttribute("note");

        // Generate a universally unique id for a new note
        String id = UUID.randomUUID().toString();

        // Default contents for a new note
        String name = "", url = "", image = "", text = "";

        // Overwrite note attributes if note parameter is given
        if(note != null) {
            id = note.getId();
            name = note.getName();
            url = note.getUrl();
            image = note.getImage();
            text = note.getText();
        }
    %>
    <form action="noteEditor.html" method="post">
        <label for="<%=Note.ID%>">ID:</label><br>
        <input size="100" type="text" id="<%=Note.ID%>" name="<%=Note.ID%>" value="<%=id%>" readonly="readonly"><br><br>
        <label for="<%=Note.NAME%>">Name:</label><br>
        <input size="100" type="text" id="<%=Note.NAME%>" name="<%=Note.NAME%>" value="<%=name%>"><br><br>
        <label for="<%=Note.URL%>">URL:</label><br>
        <input size="100" type="text" id="<%=Note.URL%>" name="<%=Note.URL%>" value="<%=url%>"><br><br>
        <label for="<%=Note.IMAGE%>">Image URL:</label><br>
        <input size="100" type="text" id="<%=Note.IMAGE%>" name="<%=Note.IMAGE%>" value="<%=image%>"><br><br>
        <label for="<%=Note.TEXT%>">Text:</label><br>
        <textarea rows="10" cols="100" id="<%=Note.TEXT%>" name="<%=Note.TEXT%>"><%=text%></textarea><br><br>
        <input type="submit" value="Save">
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
