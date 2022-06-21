package servlets;

import model.NotesModelFactory;
import model.note.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fullNoteViewer.html")
public class FullNoteViewerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("note", NotesModelFactory.getNotesModel().findNoteById(request.getParameter(Note.ID)));
        getServletContext().getRequestDispatcher("/fullNoteViewer.jsp").forward(request, response);
    }
}
