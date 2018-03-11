/**
 * Copyright 2008 James Teer
 */

package io.james.golem;

import org.testng.annotations.Test;

@Test( groups={ "functest", "checkintest" })
public class UserManagerTest {

	public void generalFunction(){
		UserManager um = new UserManager();
		assert(um.isUserNameAvailable("root")):"root user was not created";
		assert(um.isUserNameAvailable("test1234")) : "data store didn't clear before test";
		try{
			assert(um.login("root", "password")!=null) : "could not log in root user";
		} catch(UserException e){
			System.out.println(e.getMessage());
		}
		User u = new User();
		u.userName = "test1234";
		u.password = "password";
		try{
			assert(um.register(u)!=null) : "could not register new user";
		} catch(UserException e){
			System.out.println(e.getMessage());
		}
		assert(!um.userSeen("root")) : "could not update root user as seen";
		um.logout("root");
	}

}
