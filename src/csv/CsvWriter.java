package csv;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import english_01.QA;

public class CsvWriter {


	public static void exportCsv(ArrayList<QA> list, ArrayList<String> selfList, int correctCount, int csvNum, String unit){
		try {			
			// 出力ファイルの作成
			//ファイル名をコンソールに出力
			System.out.println("Userdata."+unit+csvNum+".csv");
			PrintWriter pw = new PrintWriter(new BufferedWriter
					(new OutputStreamWriter(new FileOutputStream("Userdata"+csvNum+".csv"),"Shift-JIS")));
			// ヘッダーの指定
			pw.print("id");
			pw.print(",");
			pw.print("英文");
			pw.print(",");
			pw.print("解答");
			pw.print(",");
			pw.print("和訳");
			pw.print(",");
			pw.print("自分の答え");
			pw.println();

			// データを書き込む
			for(int i = 0; i < list.size(); i++){
				pw.print(list.get(i).getId());
				pw.print(",");
				pw.print(list.get(i).getSentence());
				pw.print(",");
				pw.print(list.get(i).getAnswer());
				pw.print(",");
				pw.print(list.get(i).getTranslation());
				pw.print(",");
				pw.print(selfList.get(i));
				pw.println();
			}
			pw.println("正解数："+ correctCount);

			// ファイルを閉じる
			pw.close();
			// 出力確認用のメッセージ
			System.out.println("csvファイルを出力しました");
			// 出力に失敗したときの処理
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
