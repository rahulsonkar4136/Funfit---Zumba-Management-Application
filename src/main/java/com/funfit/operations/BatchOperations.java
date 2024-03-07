package com.funfit.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.funfit.connection.DBConnection;
import com.funfit.models.Batch;
import com.funfit.models.Participant;

public class BatchOperations {
	private Connection connection=null;
	private PreparedStatement preparedStatement;
	
	public BatchOperations()throws Exception
	{
		connection=DBConnection.getConnection();
	}
	
	public String addNewBatch(Batch batch) {
        String result = "Err";
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Batches(name, time) VALUES (?, ?)")) {
            pstmt.setString(1, batch.getName());
            pstmt.setString(2, batch.getTime());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected >= 1) {
                result = "Success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public List<Batch> viewAllBatches(){
		List<Batch> batchList=new ArrayList<>();
		Batch batch=null;
		try {
			preparedStatement= connection.prepareStatement("select * from batches");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				batch= new Batch();
				batch.setBid(resultSet.getInt("bid"));
				batch.setName(resultSet.getString("name"));
				batch.setTime(resultSet.getString("time"));
				batchList.add(batch);
			}
		} catch(Exception e)
		{
			System.out.println(e);
		}
		return batchList;
	}
	
	public String updateBatch(int batchId, String updatedBatchName, String updatedBatchTime) {
        String result = "ERROR";
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Batches SET name = ?, time = ? WHERE bid = ?")) {
            preparedStatement.setString(1, updatedBatchName);
            preparedStatement.setString(2, updatedBatchTime);
            preparedStatement.setInt(3, batchId);

            int changes = preparedStatement.executeUpdate();
            if (changes >= 1) {
                result = "Success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

	
	public String deleteBatch(int bid)throws SQLException
	{
		String result="ERROR";
		try {
			preparedStatement=connection.prepareStatement("delete from batches where bid=?");
			
			preparedStatement.setInt(1, bid);
			int changes=preparedStatement.executeUpdate();
			if(changes>=1)
			{
				result="Success";
			}
			}catch (Exception e)
		{
				result="ERROR";
				System.out.println(e);
		}
		
		return result;
		
	}
	
	 public Batch getBatchById(int bid) throws SQLException {
	        Batch batch = null;

	        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Batches WHERE bid = ?")) {
	            preparedStatement.setInt(1, bid);

	            try (ResultSet rs = preparedStatement.executeQuery()) {
	                if (rs.next()) {
	                    batch = new Batch();
	                    batch.setBid(rs.getInt("bid"));
	                    batch.setName(rs.getString("name"));
	                    batch.setTime(rs.getString("time"));
	                }
	            }
	        }

	        return batch;
	    }

	 public List<Batch> getBatchesWithParticipants() throws SQLException {
	        List<Batch> batchesWithParticipants = new ArrayList<>();

	        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Batches");
	             ResultSet rs = pstmt.executeQuery()) {

	            while (rs.next()) {
	                Batch batch = new Batch();
	                batch.setBid(rs.getInt("bid"));
	                batch.setName(rs.getString("name"));
	                batch.setTime(rs.getString("time"));

	                List<Participant> participants = getParticipantsForBatch(batch.getBid());
	                batch.setParticipants(participants);

	                batchesWithParticipants.add(batch);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }

	        return batchesWithParticipants;
	    }

	 public List<Participant> getParticipantsForBatch(int batchId) throws SQLException {
	        List<Participant> participants = new ArrayList<>();

	        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Participants WHERE batch_id = ?");
	             ResultSet rs = pstmt.executeQuery()) {

	            pstmt.setInt(1, batchId);

	            while (rs.next()) {
	                Participant participant = new Participant();
	                participant.setPid(rs.getInt("pid"));
	                participant.setName(rs.getString("pname"));
	                participant.setGender(rs.getString("gender"));
	                participant.setBatchId(rs.getInt(batchId));

	                participants.add(participant);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }

	        return participants;
	    }
	 public List<Batch> getAllBatches() throws SQLException {
	        List<Batch> batches = new ArrayList<>();

	        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Batches");
	             ResultSet rs = pstmt.executeQuery()) {

	            while (rs.next()) {
	                Batch batch = new Batch();
	                batch.setBid(rs.getInt("bid"));
	                batch.setName(rs.getString("name"));
	                batch.setTime(rs.getString("time"));

	                batches.add(batch);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }

	        return batches;
	    }
}
