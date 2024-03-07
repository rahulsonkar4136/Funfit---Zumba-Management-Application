package com.funfit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.models.Batch;
import com.funfit.operations.BatchOperations;

@WebServlet("/batchList")
public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BatchOperations batchOperations = new BatchOperations();
            List<Batch> batchList = batchOperations.viewAllBatches();
            request.setAttribute("batchList", batchList);
            request.getRequestDispatcher("batchList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed (e.g., show an error message)
        }
    }


}
