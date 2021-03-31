package ServiceImpl;

import java.util.HashMap;

import ControllerLayer.AccountController;
import DB.UserDB;
import ServiceLayer.AccountService;

public class AccountImpl implements AccountService {
	
	UserDB userDB = new UserDB();
	HashMap<String, AccountController> userDetails;

	@Override
	public boolean isValidCredentials(String userName, String password) {
		userDetails = userDB.getUserInformation();
		if(userDetails.containsKey(userName) == true) {
			AccountController acctDetail = userDetails.get(userName);
			if(acctDetail.getPassword().equals(password)){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean isValidAccountDetail(AccountController acct) {
		// TODO Auto-generated method stub
		userDetails = userDB.getUserInformation();
		if(userDetails.containsKey(acct.getUserName())) {
			System.out.println("User with this username already existed :(");
			return false;
		}
		return true;
	}

	@Override
	public void addAccount(AccountController acct) {
		userDetails = userDB.getUserInformation();
		userDetails.put(acct.getUserName(), acct);
		System.out.println("Thanks for creating an account :)");
	}

	@Override
	public void delAccount(String userName) {
		userDetails = userDB.getUserInformation();
		if(userDetails.containsKey(userName) == false)
			System.out.println("User not found to delete");
		userDetails.remove(userName);
		System.out.println("User Deleted Successfully");
	}

	@Override
	public void udpateAccount(String userName, AccountController acct) {
		// TODO Auto-generated method stub
		userDetails = userDB.getUserInformation();
		if(userDetails.containsKey(userName) == false)
			System.out.println("User not found");
		if(acct.getAddress() != null)
			userDetails.get(userName).setAddress(acct.getAddress());
		if(acct.getEmail() != null)
			userDetails.get(userName).setEmail(acct.getEmail());
		if(acct.getDOB() != null)
			userDetails.get(userName).setDOB(acct.getDOB());
		if(acct.getPhoneNumber() != null)
			userDetails.get(userName).setPhoneNumber(acct.getPhoneNumber());
		if(acct.getPassword() != null)
			userDetails.get(userName).setPassword(acct.getPassword());
		System.out.println("User Information Updated");
	}


	@Override
	public HashMap<String, AccountController> displayAllAccount() {
		userDetails = userDB.getUserInformation();
		return userDetails;
	}
	
	
	
}
