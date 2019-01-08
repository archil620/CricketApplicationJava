package com.igate.cricketapplication.service;

import java.util.List; 
import java.util.Map;

import com.igate.cricketapplication.dto.Cricket;
import com.igate.cricketapplication.exception.CricketAppException;


public interface ICricketApplicationService {

	public List<Cricket> showPlayers() throws CricketAppException;
	public int addPlayer(Cricket player) throws CricketAppException;
	public Map<String, String> isValidated(Cricket player);
}
