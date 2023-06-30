package util;

import java.util.Properties;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import bean.Order;

import javax.mail.internet.InternetAddress;

public class SendMail {

	public void send(ArrayList<Order> orderList , int total) {

		MyFormat format = new MyFormat();

		//1行目の文章
		String start = orderList.get(0).getName() + "様\n\n";

		//本文の内容
		String contents = "Tシャツのご購入ありがとうございます。\n以下内容でご注文"
				+ "を受け付けましたので、ご連絡致します。\n\n";

		//購入データを配列へ格納
		String [] order = new String[orderList.size()];

		//配列へ購入情報を格納、本文の内容へ結合
		for(int i = 0; i < orderList.size(); i++) {
			//配列orderへ購入情報を１行分追加していく
			order[i] = orderList.get(i).getUniformType() + "\t" + format.moneyFormat(orderList.get(i).getPrice()) + "円\t" + orderList.get(i).getQuantity() +"枚\n";
			//本文の内容へ購入情報を結合
			contents += order[i];
		}

		//合計金額を作成
		String goukei = "合計" + format.moneyFormat(total) + "円";

		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					// メールサーバにログインするメールアドレスとパスワードを設定
					return new PasswordAuthentication("test.sender@kanda-it-school-system.com", "kandaSender202208");
				}
			});

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(
					new InternetAddress("test.sender@kanda-it-school-system.com", "ユニフォーム受注管理システム", "iso-2022-jp"));

			// 送信先メールアドレスを指定（ご自分のメールアドレスに変更）
			mimeMessage.setRecipients(Message.RecipientType.TO, orderList.get(0).getEmail());

			// メールのタイトルを指定
			mimeMessage.setSubject("購入確認", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(start + contents + goukei, "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}

	// 入金状況、発送状況の変更メール
	// 引数 name(名前) payment
	public void send(String name, String payment, String send, String email) {
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					// メールサーバにログインするメールアドレスとパスワードを設定
					return new PasswordAuthentication("test.sender@kanda-it-school-system.com", "kandaSender202208");
				}
			});

			// 1行目の文章
			String start = name + "様\n\n";
			String contents = null;

			if (payment == null) {
				// 本文の内容
				contents = "発送が完了しました。\n" +
						"到着までしばらくお待ちください。\n\n" +
						"ご購入、ありがとうございました。";

			} else if (send == null) {
				// 本文の内容
				contents = "入金を確認しました。\n"
				+ "発送までしばらくお待ちください。\n\n" +
				"引き続き、よろしくお願いいたします。";
			}

			MimeMessage mimeMessage = new MimeMessage(session);

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(
					new InternetAddress("test.sender@kanda-it-school-system.com", "ユニフォーム受注管理システム", "iso-2022-jp"));

			// 送信先メールアドレスを指定（ご自分のメールアドレスに変更）
			mimeMessage.setRecipients(Message.RecipientType.TO, email);

			// メールのタイトルを指定
			mimeMessage.setSubject("支払い状況と発送状況のご確認", "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(start + contents);
			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}

}
