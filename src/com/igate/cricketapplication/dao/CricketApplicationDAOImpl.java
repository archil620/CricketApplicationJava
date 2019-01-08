package com.igate.cricketapplication.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.igate.cricketapplication.dto.Cricket;
import com.igate.cricketapplication.exception.CricketAppException;



public class CricketApplicationDAOImpl implements ICricketApplicationDAO{
/*******************************************************************************************************
- Function Name		:	showPlayers()
- Input Parameters	:	
- Return Type		:	List<Cricket>
- Throws			:  	CricketAppException
- Author			:	Archil
- Creation Date		:	09/29/2015
- Description		:	Display all cricket players
********************************************************************************************************/
	@Override
	public List<Cricket> showPlayers() throws CricketAppException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		
		final String query = "SELECT player_id,player_name,(sysdate-dob)/365,country,batting_style,centuries,matches,total_run_score from CRICKET_SCORE";
		List<Cricket> playerList = new ArrayList<Cricket>();
		Cricket player = null;
		
		con=DbConnection.getConnection();
		
		try {
			pst=con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				player = new Cricket();
				player.setPlayerId(rs.getInt(1));
				player.setPlayerName(rs.getString(2));
				player.setAge(rs.getInt(3));
				player.setTeam(rs.getString(4));
				player.setBattingStyle(rs.getString(5));
				player.setCenturies(rs.getString(6));
				player.setMatchesPlayed(rs.getString(7));
				player.setRunScore(rs.getString(8));
				
				
				playerList.add(player);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 throw new CricketAppException("SQL Exception in Displaying Block " + e.getMessage());
		}finally{
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CricketAppException("SQL Exception in Displaying Block " + e.getMessage());
			}
		}
		return playerList;
	}
/*******************************************************************************************************
- Function Name		:	addPlayer(Cricket player)
- Input Parameters	:	Cricket player
- Return Type		:	int
- Throws			:  	CricketAppException
- Author			:	Archil
- Creation Date		:	09/29/2015
- Description		:	Add Cricket Player
********************************************************************************************************/

	@Override
	public int addPlayer(Cricket player) throws CricketAppException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		
		final String query="INSERT INTO cricket_score VALUES(player_seq.NEXTVAL,?,?,?,?,?,?,?)";
		final String query1="SELECT player_seq.CURRVAL FROM DUAL";
		
		int rowCount = 0;
		int id=0;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = player.getDob();
		
		con=DbConnection.getConnection();
		
		try {
			Date date = formatter.parse(dateInString);
			pst=con.prepareStatement(query);
			pst1=con.prepareStatement(query1);
			
			pst.setString(1, player.getPlayerName());
			pst.setDate(2, new java.sql.Date(date.getTime()));
			pst.setString(3, player.getTeam());
			pst.setString(4, player.getBattingStyle());
			pst.setString(5, player.getCenturies());
			pst.setString(6, player.getMatchesPlayed());
			pst.setString(7, player.getRunScore());
			
			
			rowCount = pst.executeUpdate();
			
			ResultSet rs = pst1.executeQuery();
			while(rs.next()){
				id=rs.getInt(1);
				System.out.println(id);
			}
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new CricketAppException("Parse Exception in Entering Block " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CricketAppException("SQL Exception in Entering Block " + e.getMessage());
		}finally{
			try {
				pst.close();
				pst1.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CricketAppException("SQL Exception in Entering Block " + e.getMessage());
			}
		}
		
		
		return id;
	}
	
	

}
