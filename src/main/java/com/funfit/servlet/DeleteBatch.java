package com.funfit.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.operations.BatchOperations;

@WebServlet("/delete-batch")
public class DeleteBatch extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String batchIdString = request.getParameter("bid");

   if (batchIdString != null && !batchIdString.isEmpty()) {
       int batchId = Integer.parseInt(batchIdString);

       // Call the deleteBatch method
       BatchOperations batchOperations = null;
       try {
           batchOperations = new BatchOperations();
       } catch (Exception e) {
           e.printStackTrace();
       }
       try {
           String result = batchOperations.deleteBatch(batchId);
           if ("Success".equals(result)) {
               response.sendRedirect("batchList"); // Redirect to the batch-list page after deletion
           } else {
               // Handle error, e.g., show an error message
               response.getWriter().println("Error deleting batch.");
           }
       } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
           
       }
   } else {
       // Handle invalid or missing batchId parameter, e.g., show an error message
       response.getWriter().println("Invalid or missing batchId parameter.");
   }
}
}