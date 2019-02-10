package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class sqliteProgram {
	
	private Connection connect() {
		Connection conn = null;
		String url = "jdbc:sqlite:D:\\Java\\Project INT-104\\kanjiDB.db";
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Failed");
		}
		return conn;
	}
	
	public String select(int kanji_id) {
		String sql = "SELECT kanji_id, kanji_char, kanji_meaning, kanji_reading "
				+ "FROM kanji "
				+ "WHERE kanji_id = ?";
		String temp = "";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, kanji_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = rs.getString("kanji_char");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return temp;
	}
	
	public String search(String kanji_char) {
		String sql = "SELECT kanji_id, kanji_char, kanji_meaning, kanji_reading "
				+ "FROM kanji "
				+ "WHERE kanji_id = ?";
		String temp = "";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, kanji_char);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = rs.getString("kanji_char");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return temp;
	}
}
