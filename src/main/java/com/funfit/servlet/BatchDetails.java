package com.funfit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.models.Batch;
import com.funfit.models.Participant;
import com.funfit.operations.BatchOperations;

@WebServlet("/batchdetails")
public class BatchDetails extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	 String bidString = req.getParameter("bid");	
    	 if(bidString != null && !bidString.isEmpty()) {
             try {
                 int batchId = Integer.parseInt(bidString);
                 
                 BatchOperations batchOperations = null;
 				try {
 					batchOperations = new BatchOperations();
 				} catch (Exception e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 				
 				Batch batch = batchOperations.getBatchById(batchId);

                if (batch != null) {
                    List<Participant> participants = batchOperations.getParticipantsForBatch(batchId);

                    // Set attributes in the request
                    req.setAttribute("batch", batch);
                    req.setAttribute("participants", participants);
                    req.getRequestDispatcher("/batchDetails.jsp").forward(req, res);
                    
                } else {
                    // Handle case when batch is not found
                    res.getWriter().println("Batch not found for ID: " + batchId);
                }
            } catch (NumberFormatException e) {
                // Handle invalid batchId parameter (not a number)
                res.getWriter().println("Invalid batchId parameter. Please provide a valid number.");
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle SQLException, e.g., show an error message
                res.getWriter().println("Error fetching batch details.");
            } finally {
                // Close resources (if necessary)
                
            }
        } else {
            // Handle missing batchId parameter
            res.getWriter().println("Missing batchId parameter. Please provide a batchId.");
        }
    }
}
