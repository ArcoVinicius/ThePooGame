
public class GameController {
	public static int mouse_x;
	public static int mouse_y;
	public static int mouse_button;
	public static Tabuleiro tab;
	static Game jogo;

	public GameController() {
		tab = new Tabuleiro();
	}

	public int getMouse_X() {
		return mouse_x;
	}

	public int getMouse_Y() {
		return mouse_y;
	}

	public void efeitoClique() {
	}

	public static void trataClique(int x, int y, int button) {
		mouse_x = x;
		mouse_y = y;
		mouse_button = button;
	}

	public Tabuleiro getTabuleiro() {
		return tab;
	}
}
