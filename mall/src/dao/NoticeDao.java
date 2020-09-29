package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import commons.DBUtil;
import vo.Notice;

public class NoticeDao {
	public ArrayList<Notice> selectNoticeList() throws Exception {
		ArrayList<Notice> list = new ArrayList<Notice>();
		DBUtil dbUtil = new DBUtil();
		Connection conn = dbUtil.getConnection();
		/* 
		 * select notice_id, notice_title 
		 * from notice 
		 * order by notice_date desc 
		 * limit 0, 2
		 */
		String sql = "select notice_id, notice_title from notice order by notice_date desc limit 0, 2";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Notice n = new Notice();
			// n.noticeId = rs.getInt("notice_id");
			n.setNoticeId(rs.getInt("notice_id"));
			// n.noticeTitle = rs.getString("notice_title");
			n.setNoticeTitle(rs.getString("notice_title"));
			list.add(n);
		}
		conn.close();
		return list;
	}
	
	public Notice selectNoticeOne()  throws Exception {
		DBUtil dbUtil = new DBUtil();
		Connection conn = dbUtil.getConnection();
		// 구현
		conn.close();
		return null;
	}
}
