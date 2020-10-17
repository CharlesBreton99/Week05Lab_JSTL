package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        log(action);
        if (action != null && action.equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("name", username);

            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        } else if (action != null && action.equals("add")) {
            ArrayList items = (ArrayList) session.getAttribute("items");

            if (items == null) {
                items = new ArrayList<>();
            }

            String input = request.getParameter("item");

            items.add(input);
            session.setAttribute("items", items);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            // response.setContentType("text/html;charset=UTF-8");
            String itemSelected = request.getParameter("anItem");
            log(itemSelected);

            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        } else if (action != null && action.equals("logout")) {
            log("WORKING");
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

}
