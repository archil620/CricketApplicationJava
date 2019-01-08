package com.igate.cricketapplication.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.cricketapplication.dto.Cricket;
import com.igate.cricketapplication.exception.CricketAppException;
import com.igate.cricketapplication.service.CricketApplicationServiceImpl;
import com.igate.cricketapplication.service.ICricketApplicationService;

/**
 * Servlet implementation class CricketApplication
 */
@WebServlet("/CricketApplication")
public class CricketApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CricketApplication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String input = request.getParameter("input");
		HttpSession session = request.getSession(false);
		if("back".equals(input)){
			session.invalidate();
			response.sendRedirect("index.jsp");
		}else{
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ICricketApplicationService service = new CricketApplicationServiceImpl();
		String input = request.getParameter("input");
		HttpSession session = request.getSession(true);
		
		
		
		try {
		if("display".equals(input)){
				
				List<Cricket> playerList = service.showPlayers();
				session.setAttribute("playerList", playerList);
				response.sendRedirect("index.jsp");
				
		}else if("add".equals(input)){
			
			response.sendRedirect("view/addPlayer.jsp");
			
		}else if("Save Player Data".equals(input)){
			
			String playerName = request.getParameter("pname");
			String dateOfBirth = request.getParameter("date");
			String team = request.getParameter("team");
			String battingStyle = request.getParameter("style");
			String centuries = request.getParameter("centuries");
			String matchesPlayed = request.getParameter("matches");
			String runScored = request.getParameter("runs");
			
			Cricket player = new Cricket();
			
			player.setPlayerName(playerName);
			player.setDob(dateOfBirth);
			player.setTeam(team);
			player.setBattingStyle(battingStyle);
			player.setCenturies(centuries);
			player.setMatchesPlayed(matchesPlayed);
			player.setRunScore(runScored);
			session.setAttribute("errorList","");
			Map<String, String> errorList = service.isValidated(player);
			
			if(errorList.isEmpty()){
				
				int id=service.addPlayer(player);
				player.setPlayerId(id);
				if(id!=0){
					
					session.setAttribute("player", player);
					response.sendRedirect("view/InsertSuccess.jsp");
				}else{
					response.sendRedirect("view/error.jsp");
				}
			
			}else{
				
				
				session.setAttribute("errorList", errorList);
				response.sendRedirect("view/addPlayer.jsp");
			}
		}
		
		
		
		}catch (CricketAppException e) {
				// TODO Auto-generated catch block
				session.setAttribute("error", e.getMessage());
				response.sendRedirect("view/errorPage.jsp");
			}
		
		
		
	}

}
