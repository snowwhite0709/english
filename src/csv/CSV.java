package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSV {
	private static final String CSV_REGEX = "\"([^\"]*)\"|(\\S+)";
	private static String filepath;
	private static String unit;
	private DbOperation db;


	//コンストラクタ(引数：ファイルパス)
	CSV(String filepath, String unit){
		CSV.filepath = filepath;
		CSV.unit = unit;
		db = new DbOperation();
	}
	
	//CSV読み取りメソッド
	public void csvReader() throws IOException {
		System.out.println(filepath);
		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				int count =0;
				Matcher matcher = Pattern.compile(String.valueOf(','))
						.matcher(line);
				while (matcher.find()) {
					count++;
				}
				if(count>2) {
					StringBuilder sb = new StringBuilder();
					String[] tokens1 = line.split(","); // 1回目のカンマで分割
					for(int i=0; i<count-1;i++) {
						sb.append(tokens1[i]);
						if(i<count-2) {
							sb.append(",");
						}
					}
					try {
						switch(unit) {
						case "文型": 
							db.sentence_dataInsert(sb.toString().replaceAll("\"", ""), tokens1[tokens1.length-2], tokens1[tokens1.length-1]);
							break;
						case "不定詞":
							db.infinitive_dataInsert(sb.toString().replaceAll("\"", ""), tokens1[tokens1.length-2], tokens1[tokens1.length-1]);
							break;
						case "不定詞vs動名詞":
							db.infinitiveVSgerund_dataInsert(sb.toString().replaceAll("\"", ""), tokens1[tokens1.length-2], tokens1[tokens1.length-1]);
							break;				
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					String[] s = line.split(",");
					try {
						switch(unit) {
						case "文型": 
							db.sentence_dataInsert(s[0], s[1], s[2]);
							break;
						case "不定詞":
							db.infinitive_dataInsert(s[0], s[1], s[2]);
							break;
						case "不定詞vs動名詞":
							db.infinitiveVSgerund_dataInsert(s[0], s[1], s[2]);
							break;	
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

	}



	//	//不定詞・動名詞
	//	public void readCsvInfinitiveVsGerund() throws IOException {
	//		
	//		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
	//			String line;
	//			while ((line = reader.readLine()) != null) {
	//				System.out.println("line:"+line);
	//				int count =0;
	//				Matcher matcher = Pattern.compile(String.valueOf(','))
	//						.matcher(line);
	//				while (matcher.find()) {
	//					count++;
	//				}
	//				System.out.println("コンマカウント"+ count);
	//				if(count>2) {
	//					StringBuilder sb = new StringBuilder();
	//					String[] tokens1 = line.split(","); // 1回目のカンマで分割
	//					for(int i=0; i<count-1;i++) {
	//						sb.append(tokens1[i]);
	//						if(i<count-2) {
	//							sb.append(",");
	//						}
	//					}
	//					System.out.println(sb.toString().replaceAll("\"", ""));
	//					System.out.println(tokens1[tokens1.length-2]);
	//					System.out.println(tokens1[tokens1.length-1]);
	//					
	//					
	//					try {
	//						db.infinitiveVSgerund_dataInsert(sb.toString().replaceAll("\"", ""), tokens1[tokens1.length-2], tokens1[tokens1.length-1]);
	//					} catch (Exception e) {
	//						// TODO 自動生成された catch ブロック
	//						e.printStackTrace();
	//					}
	//				} else {
	//					String[] s = line.split(",");
	//					System.out.println("=======");
	//					for(int i=0; i<s.length; i++) {
	//						System.out.println(s[i]);
	//					}
	//					try {
	//						db.infinitiveVSgerund_dataInsert(s[0], s[1], s[2]);
	//					} catch (Exception e) {
	//						// TODO 自動生成された catch ブロック
	//						e.printStackTrace();
	//					}
	//				}
	//
	//
	//				//				
	//				//				String[] tokens = tokenizeCsvLine(line);
	//				//				System.out.println("tokens:"+tokens[0]);
	//				//				lines.add(tokens);
	//			}
	//		}
	//
	//	}
	//	
	//	
	//
	//	//	private static String[] tokenizeCsvLine(String line) {
	//	//		Pattern pattern = Pattern.compile(CSV_REGEX);
	//	//		Matcher matcher = pattern.matcher(line);
	//	//		List<String> tokens = new ArrayList<>();
	//	//
	//	//		while (matcher.find()) {
	//	//			String token = matcher.group(1);
	//	//			if (token != null) {
	//	//				// ダブルクォーテーション内の場合は、そのままトークンとして追加する
	//	//				tokens.add(token);
	//	//			} else {
	//	//				// それ以外の場合は、カンマで分割してトークンとして追加する
	//	//				token = matcher.group(2);
	//	//				tokens.add(token);
	//	//			}
	//	//		}
	//	//
	//	//		return tokens.toArray(new String[0]);
	//	//	}
	//



}



////CSVファイルから読み込み、DBに登録するメソッド
//public void csvReader() throws Exception {
//	File file = new File(filepath);
//	//		FileInputStream is = new FileInputStream(file);
//	//        InputStreamReader in = new InputStreamReader(is, "UTF-8");
//	try (BufferedReader br = new BufferedReader(new FileReader(file))){
//		String line;
//		while ((line = br.readLine()) != null) {
//			System.out.println(line);
//			String[] s = line.split(",");
//			System.out.println("=======");
//			for(int i=0; i<s.length; i++) {
//				System.out.println(s[i]);
//
//			}
//			db.sentence_dataInsert(s[0], s[1], s[2]);
//		}
//		br.close();
//	} catch (IOException ex) {
//		ex.printStackTrace();
//	}
//}



