package bean;

public class Order {

	// 注文ユニフォームID
	private String uniformid;

	// ユニフォームの種類
	private String uniformType;

	// 注文ID
	private int orderid;

	// 購入者氏名
	private String name;

	// 購入者Email
	private String email;

	// 購入者住所
	private String address;

	// 購入者電話番号
	private String telNumber;

	// 購入金額合計
	private int price;

	// 個数
	private int quantity;

	// 備考欄
	private String message;

	// 支払状況ステータス
	private String payment;

	// 発送状況ステータス
	private String send;

	// 注文日時
	private String orderTime;

	//注文日
	private String date;



	public Order() {
		// コンストラクタ
		this.uniformid = null;
		this.uniformType = null;
		this.orderid = 0;
		this.name = null;
		this.email = null;
		this.address = null;
		this.telNumber = null;
		this.price = 0;
		this.quantity = 0;
		this.message = null;
		this.payment = null;
		this.send = null;
		this.date = null;
		this.orderTime = null;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getUniformType() {
		return uniformType;
	}

	public void setUniformType(String uniformType) {
		this.uniformType = uniformType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUniformid() {
		return uniformid;
	}

	public void setUniformid(String uniformid) {
		this.uniformid = uniformid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

}
