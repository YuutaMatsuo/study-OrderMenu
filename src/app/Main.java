package app;

public class Main {
	public static void main(String[] args) {
		Order order = new Order();
		boolean isContinue;

		do {
			do {
				order.orderStart();
				isContinue = order.orderContinue("ご注文内容はお間違えありませんか？");
			} while (isContinue != true);
			order.amountCalc();
			System.out.println();
			order.totalOrderShow();
			isContinue = order.orderContinue("ご注文を続けますか？");
		} while (isContinue == true);
		System.out.println("\nご利用ありがとうございました\n");
		order.totalOrderShow();
		order.amountShow();
	}
}
