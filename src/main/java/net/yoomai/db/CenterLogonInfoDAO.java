/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.db;

import com.google.inject.name.Named;
import com.wideplay.warp.persist.Transactional;
import com.wideplay.warp.persist.dao.Finder;
import com.wideplay.warp.persist.dao.FirstResult;
import com.wideplay.warp.persist.dao.MaxResults;
import net.yoomai.model.CenterLogonInfo;
import org.hibernate.Query;

/**
 * @(#)CenterLogonInfoDAO.java 1.0 13/11/2012
 */
public class CenterLogonInfoDAO extends BaseDAO<CenterLogonInfo, Long> {
	public CenterLogonInfoDAO() {
		super(CenterLogonInfo.class);
	}

	@Transactional
	@Finder(query = "from CenterLogonInfo where userid=:userid order by id desc")
	public CenterLogonInfo getLogonInfo(@Named("userid") Long userid, @FirstResult int first, @MaxResults int max) {
		throw new AssertionError();
	}

	@Transactional
	public long getSeq() {
		String sql = "SELECT WEB5I5JDBA.CENTER_LOGON_INFO_SEQ.NEXTVAL AS id FROM DUAL";
		Query query = session.get().createSQLQuery(sql);
		return Long.parseLong(query.uniqueResult().toString());
	}
}
