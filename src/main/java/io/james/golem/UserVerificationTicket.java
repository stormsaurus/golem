/**
 * Copyright 2008 James Teer
 */

package io.james.golem;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserVerificationTicket {

    @Id String verificationKey = "";

    @OneToOne User user = null;
    @Basic Date created = new Date();
	
}
