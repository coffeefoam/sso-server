/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import com.google.inject.name.Named;
import com.wideplay.warp.persist.Transactional;
import com.wideplay.warp.persist.dao.Finder;
import net.yoomai.model.GrantTicket;

import java.util.List;

/**
 * @(#)GrantTicketDAO.java 1.0 18/09/2012
 */
public class GrantTicketDAO extends BaseDAO<GrantTicket, String> {
	public GrantTicketDAO() {
		super(GrantTicket.class);
	}

	@Transactional
	@Finder(query="from GrantTicket where uid=:uid order by grantTime desc")
	public List<GrantTicket> find(@Named("uid") long uid) {
		throw new AssertionError();
	}
}
