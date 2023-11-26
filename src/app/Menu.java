package app;

public class Menu {
	static String[] menus = { "とんこつラーメン", "味噌ラーメン", "塩ラーメン", "チャーハン", "餃子", "チャーハンセット", "餃子セット" };
	static int[] prices = { 800, 800, 800, 500, 300, 1000, 1000 };
	int[] orderCount = new int[menus.length];
	static final double TAX = 1.1;

	public static void menuShow() {
		System.out.println("-----メニュー-----");
		for (int i = 0; i < menus.length; i++) {
			System.out.println(i + 1 + ":" + menus[i] + " " + (int) (prices[i] * TAX) + "円(税込み)");
		}
		System.out.println("------------------");
	}

}
