package servlets;

import model.NotesModelFactory;
import model.note.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/noteEditor.html")
public class NoteEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("note", NotesModelFactory.getNotesModel().findNoteById(request.getParameter(Note.ID)));
        getServletContext().getRequestDispatcher("/noteEditor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NotesModelFactory.getNotesModel().updateNotes(new Note(
                request.getParameter(Note.ID),
                request.getParameter(Note.NAME),
                request.getParameter(Note.URL),
                request.getParameter(Note.IMAGE),
                request.getParameter(Note.TEXT)
        ));

        response.sendRedirect("notesIndex.html");
    }
}
