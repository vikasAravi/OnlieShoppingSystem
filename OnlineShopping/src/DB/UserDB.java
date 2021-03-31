package DB;

import java.util.HashMap;

import ControllerLayer.AccountController;

public class UserDB {
	/**
	 * Stores User Information in HashMap with "UserName" as the key 
	 */
	
	private static HashMap<String, AccountController> userInformation = new HashMap<>();

	/**
	 * @return the userInformation
	 */
	public HashMap<String, AccountController> getUserInformation() {
		return userInformation;
	}

	/**
	 * @param userInformation the userInformation to set
	 */
	public void setUserInformation(HashMap<String, AccountController> userInformation) {
		UserDB.userInformation = userInformation;
	}
	
	
	
}
