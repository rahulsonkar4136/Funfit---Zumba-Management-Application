package com.funfit.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.funfit.connection.DBConnection;
import com.funfit.models.Participant;

public class ParticipantOperations {
	private Connection connection=null;
	private PreparedStatement preparedStatement;
	
	public ParticipantOperations()throws Exception
	{
		connection=DBConnection.getConnection();
		
	}
	
	public String addNewParticipant(Participant participant)throws SQLException
	{
		String result="ERROR";
		
		try {
			preparedStatement=connection.prepareStatement("insert into participants(name, gender, batchId) values (?, ?,?)");
			preparedStatement.setString(1, participant.getName());
			preparedStatement.setString(2, participant.getGender());
			preparedStatement.setInt(3, participant.getBatchId());
			
			int changes=preparedStatement.executeUpdate();
			if(changes>=1)
				result="Success";
			
		}catch(Exception e)
		{
			result="ERROR";
			System.out.println(e);
		}
		return result;
	}
	
	
	public List<Participant> viewAllParticipants(){
		List<Participant> participantList=new ArrayList<>();
		Participant participant=null;
		try {
			preparedStatement=connection.prepareStatement("select * from Participants");
			ResultSet resultSet= preparedStatement.executeQuery();
			while(resultSet.next())
			{
				participant=new Participant();
				participant.setPid(resultSet.getInt("pid"));
				participant.setName(resultSet.getString("name"));
				participant.setGender(resultSet.getString("gender"));
				participant.setBatchId(resultSet.getInt("batchId"));
				participantList.add(participant);
				
				
			}
		}catch(Exception e)
			{
				System.out.println(e);
			}
		
		
		return participantList;
		
	}
	
	public String updateParticipant(int participantId, String updatedName, String updatedGender, int updatedBatchId) throws SQLException {
        String res = "Err";
        try {
            preparedStatement = connection.prepareStatement("UPDATE Participants SET name=?,gender=?, batchId=? WHERE pid=?");
            preparedStatement.setString(1, updatedName);
            preparedStatement.setString(2, updatedGender);
            preparedStatement.setInt(3, updatedBatchId);
            preparedStatement.setInt(4, participantId);

            int ch = preparedStatement.executeUpdate();
            if (ch >= 1)
                res = "Success";

        } catch (Exception e) {
            res = "Err";
            System.out.println(e);
        }
        return res;
    }
	
	public String deleteParticipant(int pid)throws SQLException{
		
	
	String result="ERROR";
	try {
		preparedStatement=connection.prepareStatement("delete from particpants where pid=?");
		preparedStatement.setInt(1,pid);
		int changes=preparedStatement.executeUpdate();
		if(changes>=1)
			result="Success";
		
		
	}catch(Exception e)
	{
		result="ERROR";
		System.out.println(e);
	}
	return result;
	}
}
