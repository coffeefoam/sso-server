/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import net.yoomai.model.GrantTicket;

/**
 * @(#)GrantTicketDAO.java 1.0 18/09/2012
 */
public class GrantTicketDAO extends BaseDAO<GrantTicket, String> {
	public GrantTicketDAO() {
		super(GrantTicket.class);
	}
}
