package ServiceLayer;

import java.util.HashMap;

import ControllerLayer.AccountController;

public interface AccountService {
	/**
	 * It provides services to the Account related things
	 */
	
	//Validate the username and password 
	public boolean isValidCredentials(String userName, String password);
	
	//Validate whether account information is unique and correct
	public boolean isValidAccountDetail(AccountController acct);
	
	//add account to DB
	public void addAccount(AccountController acct);
	
	//delete account from DB
	public void delAccount(String userName);
	
	//update the account details
	public void udpateAccount(String userName, AccountController acct);
	
	public HashMap<String, AccountController> displayAllAccount();
	
}
