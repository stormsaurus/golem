/**
 * Copyright 2008 James Teer
 */

package io.james.golem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//@NamedQuery(name="selectUserByName", query="SELECT u FROM User u WHERE u.userName=:userName"),
//@NamedQuery(name="countUserByName", query="SELECT COUNT(u) FROM User u WHERE u.userName=:userName"),
//@NamedQuery(name="selectUserSessionByName", query="SELECT us FROM UserSession us WHERE us.user.userName=:userName"),
//@NamedQuery(name="updateUserSessionByName", query="UPDATE UserSession us SET us.lastSeen=:lastSeen WHERE us.user.userName=:userName"),	//this doesn't work in MySQL
//@NamedQuery(name="countUserSessionByUser", query="SELECT COUNT(us) FROM UserSession us WHERE us.user=:user"),
//@NamedQuery(name="countUserSessionMatchingKeys", query="SELECT COUNT(us) FROM UserSession us WHERE us.sessionKey=:sessionKey"),
//@NamedQuery(name="countUserVerificationTicketMatchingKeys", query="SELECT COUNT(tickets) FROM UserVerificationTicket tickets WHERE tickets.verificationKey=:verificationKey"),
//@NamedQuery(name="deleteUserVerificationTicketMatchingKeys", query="DELETE ticket FROM UserVerificationTicket tickets WHERE ticket.verificationKey=:verificationKey")
//@NamedQuery(name="selectExpiredSessions", query="SELECT session FROM UserSession session WHERE session.lastSeen<:expires"),
//@NamedQuery(name="deleteUserSessionByName", query="DELETE FROM UserSession session WHERE session.user.userName=:userName")
//@NamedQuery(name="selectUserSessionByUser", query="SELECT session FROM UserSession session WHERE session.user=:user")


@NamedQueries({
    @NamedQuery(name="deleteExpiredSessions", query="DELETE FROM UserSession session WHERE session.lastSeen<:expires"),
    @NamedQuery(name="deleteExpiredVerificationTickets", query="DELETE FROM UserVerificationTicket ticket WHERE ticket.created<:expires")
})

@Entity
public class User {
	
    //@SuppressWarnings("unused")
    //@Id @GeneratedValue
    //private int id;
    @Id String userName = "";
	
    @Basic String givenName = "";
    @Basic String surname = "";
    @Basic String email = "";
    @Basic String password = "";
    @Basic Date registeredOn = new Date();
    @Basic boolean active = false;

    @SuppressWarnings("unchecked")
    @OneToMany(cascade=CascadeType.ALL) 
    Map nicknames = new HashMap<String,String>(); //TODO this blows because it's stored in a Blob, perhaps break it out into it's own entity to get some db transparency
	
    @OneToOne(cascade=CascadeType.REMOVE, mappedBy="user")
    UserSession	session = null;

}
