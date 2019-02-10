package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class sqliteApp {

	private Connection connect() {
		Connection conn = null;
		String url = "jdbc:sqlite:D:\\Java\\Project INT-104\\kanjiDB.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection to SQLite has been established.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void selectAll() {
		String sql = "SELECT kanji_id, kanji_char, kanji_meaning, kanji_reading FROM kanji";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.println(rs.getInt("kanji_id") + "\t" 
						+ rs.getString("kanji_char") + "\t"
						+ rs.getString("kanji_meaning") + "\t" 
						+ rs.getString("kanji_reading"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void insert(int kanji_id, String kanji_char, String kanji_meaning, String kanji_reading) {
		String sql = "INSERT INTO kanji(kanji_id, kanji_char, kanji_meaning, kanji_reading) VALUES(?,?,?,?)";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, kanji_id);
			pstmt.setString(2, kanji_char);
			pstmt.setString(3, kanji_meaning);
			pstmt.setString(4, kanji_reading);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void update(int kanji_id, String kanji_char, String kanji_meaning, String kanji_reading) {
		String sql = "UPDATE kanji" 
				+ " SET kanji_char = ?, kanji_meaning = ?, kanji_reading = ?"
				+ " WHERE kanji_id = ?";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, kanji_char);
			pstmt.setString(2, kanji_meaning);
			pstmt.setString(3, kanji_reading);
			pstmt.setInt(4, kanji_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void selectEach(int kanji_id) {
		String sql = "SELECT kanji_id, kanji_char, kanji_meaning, kanji_reading "
				+ "FROM kanji "
				+ "WHERE kanji_id = ?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, kanji_id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("kanji_id") + "\t" 
						+ rs.getString("kanji_char") + "\t"
						+ rs.getString("kanji_meaning") + "\t" 
						+ rs.getString("kanji_reading"));
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
