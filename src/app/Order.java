package app;

import java.util.Scanner;

public class Order {
	private int selectMenu;
	private int selectQuantity;
	private int amount = 0;
	private int[] orderCount = new int[Menu.menus.length];
	final int MAX_ORDER = 10;

	public void orderStart() {
		System.out.println("いらっしゃいませ");
		Menu.menuShow();
		this.selectMenu();
		this.selectQuantity(this.selectMenu);
		System.out.println();
		this.orderShow();
	}

	public void selectMenu() {
		boolean isError;
		int selectNumber;
		do {
			System.out.print("メニューの番号を選んでEnterを押してください\n>>");
			selectNumber = new Scanner(System.in).nextInt();
			if (selectNumber <= Menu.menus.length && selectNumber > 0) {
				this.selectMenu = selectNumber;
				isError = false;
			} else {
				System.out.println("入力に誤りがあります");
				isError = true;
			}
		} while (isError == true);
	}

	public void selectQuantity(int selectMenu) {
		boolean isError;
		int selectNumber;
		do {
			System.out.print("注文数を入力してEnterを押してください\n>>");
			selectNumber = new Scanner(System.in).nextInt();
			if (selectNumber > 0 && selectNumber + orderCount[selectMenu - 1] <= this.MAX_ORDER) {
				this.selectQuantity = selectNumber;
				isError = false;
			} else {
				System.out.println("入力に誤りがあります\n1回の注文で" + this.MAX_ORDER + "個以上注文することはできません");
				isError = true;
			}
		} while (isError == true);
	}

	public void orderShow() {
		System.out.println("▼選んだメニュー▼");
		System.out.println(Menu.menus[this.selectMenu - 1] + " " + (int) (Menu.prices[this.selectMenu - 1] * Menu.TAX)
				+ "円 x"
				+ this.selectQuantity + "杯\n"
				+ "合計金額：" + (int) (Menu.prices[this.selectMenu - 1] * Menu.TAX) * this.selectQuantity + "円(税込み)");
	}

	public void totalOrderShow() {
		System.out.println("▼注文内容▼");
		for (int i = 0; i < Menu.menus.length; i++) {
			if (this.orderCount[i] > 0) {
				System.out.println(
						Menu.menus[i] + " " + (int) (Menu.prices[i] * Menu.TAX) + "円 x" + this.orderCount[i] + "杯");
			}
		}
	}

	public void amountShow() {
		System.out.println("合計金額：" + (this.amount) + "円(税込み)");
	}

	public boolean orderContinue(String msg) {
		boolean isError;
		int selectNumber;
		do {
			System.out.print(msg + "\n1:はい\n2:いいえ\n>>");
			selectNumber = new Scanner(System.in).nextInt();
			if (selectNumber == 1) {
				isError = false;
				return true;
			} else if (selectNumber == 2) {
				isError = false;
				return false;
			} else {
				System.out.println("入力に誤りがあります");
				isError = true;
			}
		} while (isError == true);
		return false;
	}

	public void amountCalc() {
		this.amount += (Menu.prices[this.selectMenu - 1] * Menu.TAX) * this.selectQuantity;
		this.orderCount[this.selectMenu - 1] += this.selectQuantity;
	}

	public int getSelectMenu() {
		return this.selectMenu;
	}

	public int getSelectQuantity() {
		return this.selectQuantity;
	}

}
