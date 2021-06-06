package team5.service;

import javax.servlet.http.HttpSession;

import team5.model.User;


public interface SessionService {

	public boolean authenticate(User user);

	public boolean isNotLoggedIn(HttpSession session);
	public boolean hasNoPermission(HttpSession session);
	public boolean hasPermission(HttpSession session);
}