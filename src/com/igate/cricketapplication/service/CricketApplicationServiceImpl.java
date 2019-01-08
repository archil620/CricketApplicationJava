package com.igate.cricketapplication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.igate.cricketapplication.dao.CricketApplicationDAOImpl;
import com.igate.cricketapplication.dao.ICricketApplicationDAO;
import com.igate.cricketapplication.dto.Cricket;
import com.igate.cricketapplication.exception.CricketAppException;

public class CricketApplicationServiceImpl implements ICricketApplicationService {

	
	ICricketApplicationDAO dao = new CricketApplicationDAOImpl();
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
		return dao.showPlayers();
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
		return dao.addPlayer(player);
	}
/*******************************************************************************************************
- Function Name		:	isValidated(Cricket player)
- Input Parameters	:	Cricket player
- Return Type		:	Map<String, String>
- Throws			:  	CricketAppException
- Author			:	Archil
- Creation Date		:	09/29/2015
- Description		:	Validations
********************************************************************************************************/

	
	@Override
	public Map<String, String> isValidated(Cricket player) {
		// TODO Auto-generated method stub
		Map<String, String> errorList = new HashMap<String,String>();
		Pattern pattern = null;
		Matcher matcher = null;
		
		if(player.getPlayerName().isEmpty()){
			errorList.put("nameEmpty", "Name is not Entered");
		}else{
			pattern = Pattern.compile("^[A-Za-z\\s]+$");
			matcher = pattern.matcher(player.getPlayerName());
			if (!matcher.matches()) {
				errorList.put("nameError", "Name is not Entered in alphabetes");
			}
		}
		
		
		
		if(player.getDob().equals("")){
			errorList.put("dobEmpty", "DOB is not Entered");
		}
		
		if(player.getTeam().equals("")){
			errorList.put("teamEmpty", "Team is not Selected");
		}
		
		
		if(player.getCenturies().equals("")){
			errorList.put("centuriesEmpty", "Centuries is not Entered");
		}else{
			pattern = Pattern.compile("^[0-9]+$");
			matcher = pattern.matcher(player.getCenturies());
			if (!matcher.matches()) {
				errorList.put("centuryError", "Century is not Entered in numbers");
			}
		}
		
		
		
		if(player.getMatchesPlayed().equals("")){
			errorList.put("matchEmpty", "Matches Played is not Entered");
		}else{
			pattern = Pattern.compile("^[0-9]+$");
			matcher = pattern.matcher(player.getMatchesPlayed());
			if (!matcher.matches()) {
				errorList.put("matchError", "Match is not Entered in Number");
			}
		}
		
		
		
		if(player.getRunScore().equals("")){
			errorList.put("runsEmpty", "Runs Scored is not Entered");
		}else{
			pattern = Pattern.compile("^[0-9]+$");
			matcher = pattern.matcher(player.getRunScore());
			if (!matcher.matches()) {
				errorList.put("runsError", "Runs Scored is not Entered in Number");
			}
		}
		
		
		
		
		pattern = Pattern.compile("^[0-9]+$");
		matcher = pattern.matcher(player.getCenturies());
		if (matcher.matches()) {
			if(Integer.parseInt(player.getRunScore())<Integer.parseInt(player.getCenturies())*100){
				
				errorList.put("lessRuns", "(Total score cannot be less than no of centuries*100)");
			}
		}
		return errorList;
	}

	
}
