package memebershipManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String INSERT_SQL = "INSERT INTO MEMBER VALUES(?, ?, ?)";
	private final String UPDATE_SQL = "UPDATE MEMBER SET PHONE_NUMBER=? WHERE MEMBER_ID=?";
	private final String DELETE_SQL = "DELETE MEMBER WHERE MEMBER_ID=?";
	private final String SELECT_SQL = "SELECT * FROM MEMBER ORDER BY MEMBER_ID ASC";
	private final String SELECT_MEMBER_SQL = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";
	
	public void insertMember(Member member) {
		
		try {
			conn = Utility.getConnection();
			stmt = conn.prepareStatement(INSERT_SQL);
			
			stmt.setString(1, member.getMember_id());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPhone_number());		
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utility.close(conn, stmt, rs);
		}
	}
	
	public void updateMember(Member member) {
		
		try {
			conn = Utility.getConnection();
			stmt = conn.prepareStatement(UPDATE_SQL);
			
			stmt.setString(1, member.getPhone_number());
			stmt.setString(2, member.getMember_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utility.close(conn, stmt, rs);
		}
	}
	
	public void deleteMember(Member member) {
		
		try {
			conn = Utility.getConnection();
			stmt = conn.prepareStatement(DELETE_SQL);
			
			stmt.setString(1, member.getMember_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utility.close(conn, stmt, rs);
		}
	}
	
	public void getMemberList() {
		
		try {
			conn = Utility.getConnection();
			stmt = conn.prepareStatement(SELECT_SQL);
			rs = stmt.executeQuery();
			int count = 0;
			
			while(rs.next()) {
				count++;
				System.out.println("Member [memberId=" + rs.getString("member_id") + ", name=" + rs.getString("name") + ", phoneNumber=" + rs.getString("phone_number") + "]");		
			}
			if(count == 0) {
				System.out.println("��ϵ� ȸ���� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utility.close(conn, stmt, rs);
		}
	}
	
	// ������ �� ����ϴ� �޼���
	public void findMember(Member member) {
		try {
			conn = Utility.getConnection();
			stmt = conn.prepareStatement(SELECT_MEMBER_SQL);
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utility.close(conn, stmt, rs);
		}
	}
}
