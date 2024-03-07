package com.funfit.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funfit.models.Participant;
import com.funfit.operations.ParticipantOperations;

@WebServlet("/update-participant")
public class UpdateParticipant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ParticipantOperations participantOperations = null;
		try {
			participantOperations = new ParticipantOperations();
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
            
            List<Participant> participants = participantOperations.viewAllParticipants();

            
            request.setAttribute("participants", participants);

            // Forward the request to the update-participants.html page
            request.getRequestDispatcher("/update-participant.jsp").forward(request, response);
            

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving participants");
        }
    }
}