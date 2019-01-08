package com.igate.cricketapplication.dao;

import java.util.List;

import com.igate.cricketapplication.dto.Cricket;
import com.igate.cricketapplication.exception.CricketAppException;

public interface ICricketApplicationDAO {

	public List<Cricket> showPlayers() throws CricketAppException;
	public int addPlayer(Cricket player) throws CricketAppException;
}
