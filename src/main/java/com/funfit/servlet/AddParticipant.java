package com.funfit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.models.Batch;
import com.funfit.models.Participant;
import com.funfit.operations.BatchOperations;
import com.funfit.operations.ParticipantOperations;

@WebServlet("/participant")
public class AddParticipant extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String batchId = req.getParameter("batchId");

            
            Participant par = new Participant();
            par.setName(name);
            par.setGender(gender);
            par.setBatchId(Integer.parseInt(batchId));

            // Adding the new participant
            ParticipantOperations parOpr = new ParticipantOperations();
            parOpr.addNewParticipant(par);

            // Fetching all batches for the dropdown
            BatchOperations batchOpr = new BatchOperations();
            List<Batch> batches = batchOpr.viewAllBatches();

            // Set the list of batches as an attribute in the request
            req.setAttribute("batches", batches);

            // Forward the request to participant.jsp
            RequestDispatcher dispatcher = req.getRequestDispatcher("participant.jsp");
            dispatcher.forward(req, res);

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            
        }
    }

	

}
