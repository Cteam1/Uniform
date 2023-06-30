package util;

import java.text.DecimalFormat;


public class MyFormat {



	//インスタンス化と同時にpriceのフォーマット("最初につく文字,0の数でカンマ区切り,0の数だけ小数点を表示")
	public String moneyFormat (int price) {

		DecimalFormat df = new DecimalFormat("\\,000");

		df.format(price);

		return df.format(price);

	}


}
