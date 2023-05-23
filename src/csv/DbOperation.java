package csv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbOperation {
	String url = "jdbc:postgresql://localhost:5432/postgres" ;	//DBのURL
	String user = "postgres" ;		//DBのユーザー名
	String password = "postgrestest" ;	//DBのパスワード
	
	//出退勤をDBに挿入するメソッド(引数４つ)
	//文型
	public void sentence_dataInsert(String sentence, String answer, String translation) throws Exception {
		String sql = "Insert into sentence (sentence, answer, translation) values (?,?,?)" ;
		try (Connection con=DriverManager.getConnection(url, user, password ) ;
			PreparedStatement pstmt = con.prepareStatement(sql); ) {
			pstmt.setString(1, sentence);
			pstmt.setString(2, answer);
			pstmt.setString(3, translation);
			pstmt.execute();
		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}
	}
	
	//不定詞
	public void infinitive_dataInsert(String sentence, String answer, String translation) throws Exception {
		String sql = "Insert into infinitive (sentence, answer, translation) values (?,?,?)" ;
		try (Connection con=DriverManager.getConnection(url, user, password ) ;
			PreparedStatement pstmt = con.prepareStatement(sql); ) {
			pstmt.setString(1, sentence);
			pstmt.setString(2, answer);
			pstmt.setString(3, translation);
			pstmt.execute();
		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}
	}
	
	//不定詞vs動名詞
	public void infinitiveVSgerund_dataInsert(String sentence, String answer, String translation) throws Exception {
		String sql = "Insert into infinitivevsgerund (sentence, answer, translation) values (?,?,?)" ;
		try (Connection con=DriverManager.getConnection(url, user, password ) ;
			PreparedStatement pstmt = con.prepareStatement(sql); ) {
			pstmt.setString(1, sentence);
			pstmt.setString(2, answer);
			pstmt.setString(3, translation);
			pstmt.execute();
		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}
	}
	
	
	
}
