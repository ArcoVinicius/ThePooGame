import java.awt.Image;

public abstract class Peca implements Cloneable {
	int casax;
	int casay;
	int cor;
	protected char tipo;
	static boolean pecaAtiva = false;
	protected boolean jaFoiMovida;
	boolean action = false;
	protected Image imagem;

	public Peca(int x, int y, int jogador) {
		casax = x;
		casay = y;
		cor = (-jogador);
		imagem = null;
		jaFoiMovida = false;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
		}
		return null;
	}

	private static void algumaPecaAtiva() {
		pecaAtiva = true;
	}

	private static void nenhumaPecaAtiva() {
		pecaAtiva = false;
	}

	public void acionaPeca(Tabuleiro t) {
		action = true;
		algumaPecaAtiva();
		marcaCasasDisponiveis(t);
	}

	public void desativaPeca(Tabuleiro t) {
		action = false;
		nenhumaPecaAtiva();
		apagaCasas(t);
	}

	public char getTipo() {
		return tipo;
	}

	abstract void marcaCasasDisponiveis(Tabuleiro paramTabuleiro);

	abstract void apagaCasas(Tabuleiro paramTabuleiro);

	abstract void moveu();

	abstract boolean jaMoveu();
}
