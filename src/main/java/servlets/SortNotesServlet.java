package servlets;

import model.NotesModelFactory;
import model.note.Note;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sortNotes.html")
public class SortNotesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch(request.getParameter("key")) {
            case Note.ID:
                NotesModelFactory.getNotesModel().sortNotesByKey(Note::getId);
                break;
            case Note.NAME:
                NotesModelFactory.getNotesModel().sortNotesByKey(Note::getName);
                break;
        }

        response.sendRedirect("notesIndex.html?query=" + request.getParameter("query"));
    }
}
