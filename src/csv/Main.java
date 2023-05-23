package csv;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		//{ファイルパス、キー}
		String[][] unit = {
				{"C:\\Users\\3030855\\Desktop\\GUI\\CSV関連\\文型.csv", "文型"},
				{"C:\\Users\\3030855\\Desktop\\GUI\\CSV関連\\【英語】不定詞(基本).csv", "不定詞"},
				{"C:\\Users\\3030855\\Desktop\\GUI\\CSV関連\\不定詞・動名詞　2択問題.csv", "不定詞vs動名詞"},
				{"", ""}
		};
		
		//インスタンス化
		CSV csv = new CSV( unit[2][0], unit[2][1]);		
		
		//"英文"の読み取り
		try {
			csv.csvReader();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
