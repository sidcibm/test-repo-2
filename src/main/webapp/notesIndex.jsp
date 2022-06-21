<%@ page import="model.note.Note" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="meta.jsp"/>
    <title>Notes Index</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <h2>Index</h2>
    <form style="display:inline-block;" action="index.html">
        <input type="submit" value="Home">
    </form>
    <form style="display:inline-block;" action="noteEditor.html">
        <input type="submit" value="Add Note">
    </form>
    <%String query = request.getAttribute("query") == null ? "" : (String) request.getAttribute("query");%>
    <form style="display:inline-block;" action="sortNotes.html">
        <input type="hidden" name="key" value="<%=Note.ID%>">
        <input type="hidden" name="query" value="<%=query%>">
        <input type="submit" value="Sort Notes By ID (Default)">
    </form>
    <form style="display:inline-block;" action="sortNotes.html">
        <input type="hidden" name="key" value="<%=Note.NAME%>">
        <input type="hidden" name="query" value="<%=query%>">
        <input type="submit" value="Sort Notes By Name">
    </form>
    <br>
    <form style="display:inline-block;" action="notesIndex.html">
        <label for="query">Search Query:</label>
        <input type="text" id="query" name="query" placeholder="Enter keyword here">
        <input type="submit" value="Filter Notes">
    </form>
    <form style="display:inline-block;" action="notesIndex.html">
        <input type="submit" value="Reset Filter">
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th colspan="4">Actions</th>
        </tr>
        <%
            @SuppressWarnings("unchecked")
            List<Note> notes = (List<Note>) request.getAttribute("notes");

            // Filter notes by query parameter
            notes.removeIf(note -> !note.getName().toLowerCase().contains(query.toLowerCase()));

            for(Note note : notes) {
        %>
        <tr>
            <td>
                <%=note.getId()%>
            </td>
            <td>
                <%=note.getName()%>
            </td>
            <td>
                <a href="noteSummaryViewer.html?<%=Note.ID%>=<%=note.getId()%>">View Note Summary</a>
            </td>
            <td>
                <a href="fullNoteViewer.html?<%=Note.ID%>=<%=note.getId()%>">View Full Note</a>
            </td>
            <td>
                <a href="noteEditor.html?<%=Note.ID%>=<%=note.getId()%>">Edit Note</a>
            </td>
            <td>
                <a href="deleteNote.html?<%=Note.ID%>=<%=note.getId()%>">Delete Note</a>
            </td>
        </tr>
        <%}%>
    </table>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
