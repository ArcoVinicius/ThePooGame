
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
	private static final long serialVersionUID = 1;
	public int i;
	public int j;
	public int lado = 64;
	public int trocaCor = 1;
	public static int trocaCorSelecao = -1;
	public int pecax = this.lado / 2 + 5 * this.lado;
	public int pecay = this.lado / 2 + 7 * this.lado;

	public Game() {
		this.addKeyListener(new Key(this));
		this.addMouseListener(new Mouse(this));
		this.setFocusable(true);
	}

	public boolean verificaRoque(Tabuleiro t, int cliqueX, int cliqueY) {
		return false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GRAY);
		this.i = 0;
		while (this.i < 8) {
			this.j = 0;
			while (this.j < 8) {
				if (this.trocaCor == 1) {
					g.setColor(Color.WHITE);
				} else if (this.trocaCor == -1) {
					g.setColor(Color.BLACK);
				}
				g.fillRect(this.j * this.lado, this.i * this.lado, this.lado, this.lado);
				g.setColor(Color.RED);
				if (Regras.getMarcador(Regras.tab, this.j, this.i)) {
					g.fillRect(this.j * this.lado, this.i * this.lado, this.lado, this.lado);
				}
				g.setColor(Color.YELLOW);
				if (Regras.casaOcupada(Regras.tab, this.j, this.i)
						&& Regras.tab.casas[this.j][this.i].peca.imagem != null) {
					g.drawImage(Regras.tab.casas[this.j][this.i].peca.imagem, this.j * this.lado, this.i * this.lado,
							null);
				}
				this.trocaCor *= -1;
				++this.j;
			}
			this.trocaCor *= -1;
			++this.i;
		}
		this.i = 0;
		this.j = 0;
		g.setColor(Color.BLUE);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(3);
		Game panel = new Game();
		frame.add(panel);
		frame.setVisible(true);
	}

	private class Key extends KeyAdapter {
		final /* synthetic */ Game this$0;

		private Key(Game game) {
			this.this$0 = game;
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int b = e.getKeyCode();
			Regras.teclado(b);
			this.this$0.repaint();
		}

		// /* synthetic */ Key(Game game, Key key) {
		// Key key2;
		// key2(game);
		// }
	}

	private class Mouse extends MouseAdapter {
		final /* synthetic */ Game this$0;

		private Mouse(Game game) {
			this.this$0 = game;
		}

		public void mouseClicked(MouseEvent e) {
			int x = e.getX() / this.this$0.lado;
			int y = e.getY() / this.this$0.lado;
			int button = e.getButton();
			Regras.clique(Regras.getTabuleiro(), x, y, button);
			this.this$0.repaint();
		}

		// /* synthetic */ Mouse(Game game, Mouse mouse) {
		// Mouse mouse2;
		// mouse2(game);
		// }
	}

}
