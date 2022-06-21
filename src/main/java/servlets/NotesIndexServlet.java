package servlets;

import model.NotesModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notesIndex.html")
public class NotesIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("notes", NotesModelFactory.getNotesModel().getNotes());
        request.setAttribute("query", request.getParameter("query"));
        getServletContext().getRequestDispatcher("/notesIndex.jsp").forward(request, response);
    }
}
