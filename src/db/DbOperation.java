package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import english_01.QA;

public class DbOperation {
	//フィールド
	String url = "jdbc:postgresql://localhost:5432/postgres" ;	//DBのURL
	String user = "postgres" ;		//DBのユーザー名
	String password = "postgrestest" ;	//DBのパスワード
	ArrayList<QA> list;
	int[] randomNumArray = new int[5];

	//コンストラクタ
	public DbOperation() {	
	}

	//DBから問題を取得
	public ArrayList<QA> dbGetQuestion(String unit) {
		int[] array = array(dbGetCount(unit), unit);
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		ArrayList<QA> list = new ArrayList<>();
		//5回回して主キーが乱数であるものをとってくる
		for(int i=0; i<array.length; i++) {
			String sql = "select * from "+ unit +"\n"
					+ "WHERE id = '" + array[i] + "'\n";
			try {
				con = DriverManager.getConnection ( url, user, password );
				stmt = con.createStatement();
				result = stmt.executeQuery ( sql );
				while ( result.next() ) {
					int id = result.getInt(1);
					String question = result.getString(2);
					String answer = result.getString(3);
					String translation = result.getString(4);
					QA qa = new QA(id, question, answer, translation);
					list.add(qa);
				}
			} catch ( SQLException e ){
				e.printStackTrace() ;
			}finally{
				try {////クローズ処理クローズ処理
					if(con != null) con.close();
					if(stmt != null) stmt.close();
					if(result != null) result.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}



	//DBから最初の１件を取得
	public int dbGetFirst(String unit) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		int firstId=0;
		int count=0;
		String sql = "select id from "+ unit ;
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			while (result.next()) {
				firstId = result.getInt("id");
				System.out.println("firstId:"+firstId);
				count++;
				if(count>0) {
					break;
				}
			}
		} catch ( SQLException e ){
			e.printStackTrace() ;
		}finally{
			try {////クローズ処理クローズ処理
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(result != null) result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return firstId;
	}



	//DBから件数を取得
	public int dbGetCount(String unit) {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		int count=0;
		String sql = "select count(*) from "+ unit;
		try {
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );
			if (result.next()) {
				count = result.getInt("count");
			}
		} catch ( SQLException e ){
			e.printStackTrace() ;
		}finally{
			try {////クローズ処理クローズ処理
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(result != null) result.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}



	//乱数作成メソッド
	public int[] array(int num, String unit) {
		System.out.println("件数: " + num);
		Random rand = new Random();
		for(int i=0; i<randomNumArray.length; i++) {
			randomNumArray[i]=rand.nextInt(num)+dbGetFirst(unit);
		}
		return randomNumArray;
	}



}






//DBから文型問題一覧を選択
//	public ArrayList<QA> dbGetSentence() {
//		int[] array = array(dbGetCount());
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet result = null;
//		ArrayList<QA> list = new ArrayList<>();
//		//5回回して主キーが乱数であるものをとってくる
//		for(int i=0; i<array.length; i++) {
//			String sql = "select * from sentence\n"
//					+ "WHERE id = '" + array[i] + "'\n";
//			try {
//				con = DriverManager.getConnection ( url, user, password );
//				stmt = con.createStatement();
//				result = stmt.executeQuery ( sql );
//				while ( result.next() ) {
//					int id = result.getInt(1);
//					String question = result.getString(2);
//					String answer = result.getString(3);
//					String translation = result.getString(4);
//					QA qa = new QA(id, question, answer, translation);
//					list.add(qa);
//				}
//			} catch ( SQLException e ){
//				e.printStackTrace() ;
//			}finally{
//				try {////クローズ処理クローズ処理
//					if(con != null) con.close();
//					if(stmt != null) stmt.close();
//					if(result != null) result.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return list;
//	}


//DBから不定詞問題一覧を選択
//		public ArrayList<QA> dbGetInfinitive() {
//			int[] array = array(dbGetCount());
//			Connection con = null;
//			Statement stmt = null;
//			ResultSet result = null;
//			ArrayList<QA> list = new ArrayList<>();
//			//5回回して主キーが乱数であるものをとってくる
//			for(int i=0; i<array.length; i++) {
//				String sql = "select * from infinitive\n"
//						+ "WHERE id = '" + array[i] + "'\n";
//				try {
//					con = DriverManager.getConnection ( url, user, password );
//					stmt = con.createStatement();
//					result = stmt.executeQuery ( sql );
//					while ( result.next() ) {
//						int id = result.getInt(1);
//						String question = result.getString(2);
//						String answer = result.getString(3);
//						String translation = result.getString(4);
//						QA qa = new QA(id, question, answer, translation);
//						list.add(qa);
//					}
//				} catch ( SQLException e ){
//					e.printStackTrace() ;
//				}finally{
//					try {////クローズ処理クローズ処理
//						if(con != null) con.close();
//						if(stmt != null) stmt.close();
//						if(result != null) result.close();
//					}catch(Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			return list;
//		}
//		
//DBから文型問題一覧を選択
//	public ArrayList<QA> dbGetSentence() {
//		int[] array = array(dbGetCount());
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet result = null;
//		ArrayList<QA> list = new ArrayList<>();
//		//5回回して主キーが乱数であるものをとってくる
//		for(int i=0; i<array.length; i++) {
//			String sql = "select * from sentence\n"
//					+ "WHERE id = '" + array[i] + "'\n";
//			try {
//				con = DriverManager.getConnection ( url, user, password );
//				stmt = con.createStatement();
//				result = stmt.executeQuery ( sql );
//				while ( result.next() ) {
//					int id = result.getInt(1);
//					String question = result.getString(2);
//					String answer = result.getString(3);
//					String translation = result.getString(4);
//					QA qa = new QA(id, question, answer, translation);
//					list.add(qa);
//				}
//			} catch ( SQLException e ){
//				e.printStackTrace() ;
//			}finally{
//				try {////クローズ処理クローズ処理
//					if(con != null) con.close();
//					if(stmt != null) stmt.close();
//					if(result != null) result.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return list;
//	}


//DBから不定詞問題一覧を選択
//		public ArrayList<QA> dbGetInfinitive() {
//			int[] array = array(dbGetCount());
//			Connection con = null;
//			Statement stmt = null;
//			ResultSet result = null;
//			ArrayList<QA> list = new ArrayList<>();
//			//5回回して主キーが乱数であるものをとってくる
//			for(int i=0; i<array.length; i++) {
//				String sql = "select * from infinitive\n"
//						+ "WHERE id = '" + array[i] + "'\n";
//				try {
//					con = DriverManager.getConnection ( url, user, password );
//					stmt = con.createStatement();
//					result = stmt.executeQuery ( sql );
//					while ( result.next() ) {
//						int id = result.getInt(1);
//						String question = result.getString(2);
//						String answer = result.getString(3);
//						String translation = result.getString(4);
//						QA qa = new QA(id, question, answer, translation);
//						list.add(qa);
//					}
//				} catch ( SQLException e ){
//					e.printStackTrace() ;
//				}finally{
//					try {////クローズ処理クローズ処理
//						if(con != null) con.close();
//						if(stmt != null) stmt.close();
//						if(result != null) result.close();
//					}catch(Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			return list;
//		}
//		
