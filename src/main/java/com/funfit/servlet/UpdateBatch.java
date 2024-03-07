package com.funfit.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.operations.BatchOperations;

@WebServlet("/update-batch")
public class UpdateBatch extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String batchIdString = request.getParameter("updateId");
     String updatedName = request.getParameter("updateName");
     String updatedTime = request.getParameter("updateTime");

     if (batchIdString != null && !batchIdString.isEmpty()) {
         int batchId = Integer.parseInt(batchIdString);

         // Call the updateBatch method
         BatchOperations batchOperations = null;
         try {
             batchOperations = new BatchOperations();
         } catch (Exception e) {
             e.printStackTrace();
         }
         try {
             String result = batchOperations.updateBatch(batchId, updatedName, updatedTime);
             if ("Success".equals(result)) {
                 response.sendRedirect("batchList"); // Redirect to the batch-list page after update
             } else {
                 // Handle error, e.g., show an error message
                 response.getWriter().println("Error updating batch.");
             }
         } finally {
             
         }
     } else {
         // Handle invalid or missing batchId parameter, e.g., show an error message
         response.getWriter().println("Invalid or missing batchId parameter.");
     }
 }
}
