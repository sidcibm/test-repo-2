package servlets;

import model.NotesModelFactory;
import model.note.Note;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteNote.html")
public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NotesModelFactory.getNotesModel().deleteNoteById(request.getParameter(Note.ID));
        response.sendRedirect("notesIndex.html");
    }
}
