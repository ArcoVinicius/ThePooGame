
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Peao extends Peca {
	private boolean doisPassos = true;

	public Peao(int x, int y, int jogador) {
		super(x, y, jogador);
		this.tipo = 112;
		try {
			this.imagem = jogador == 1 ? ImageIO.read(new File("Pecas/PurpleP.png"))
					: ImageIO.read(new File("Pecas/CyanP.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	void marcaCasasDisponiveis(Tabuleiro t) {
		int modo = Regras.getModo();
		if (modo == 2) {
			if (this.casay > 0 && t.casas[this.casax][this.casay - 1].estaLivre()) {
				t.casas[this.casax][this.casay - 1].marca();
			}
			if (this.doisPassos && t.casas[this.casax][this.casay - 2].estaLivre()
					&& t.casas[this.casax][this.casay - 1].estaLivre()) {
				t.casas[this.casax][this.casay - 2].marca();
			}
			if (this.casay > 0) {
				if (this.casax > 0 && !t.casas[this.casax - 1][this.casay - 1].estaLivre()
						&& t.casas[this.casax - 1][this.casay - 1].peca.cor != this.cor) {
					t.casas[this.casax - 1][this.casay - 1].marca();
				}
				if (this.casax < 7 && !t.casas[this.casax + 1][this.casay - 1].estaLivre()
						&& t.casas[this.casax + 1][this.casay - 1].peca.cor != this.cor) {
					t.casas[this.casax + 1][this.casay - 1].marca();
				}
			}
		} else if (this.cor == 1) {
			if (this.casay > 0 && t.casas[this.casax][this.casay - 1].estaLivre()) {
				t.casas[this.casax][this.casay - 1].marca();
			}
			if (this.doisPassos && t.casas[this.casax][this.casay - 2].estaLivre()
					&& t.casas[this.casax][this.casay - 1].estaLivre()) {
				t.casas[this.casax][this.casay - 2].marca();
			}
			if (this.casay > 0) {
				if (this.casax > 0 && !t.casas[this.casax - 1][this.casay - 1].estaLivre()
						&& t.casas[this.casax - 1][this.casay - 1].peca.cor != this.cor) {
					t.casas[this.casax - 1][this.casay - 1].marca();
				}
				if (this.casax < 7 && !t.casas[this.casax + 1][this.casay - 1].estaLivre()
						&& t.casas[this.casax + 1][this.casay - 1].peca.cor != this.cor) {
					t.casas[this.casax + 1][this.casay - 1].marca();
				}
			}
		} else if (this.cor == -1) {
			if (this.casay < 7 && t.casas[this.casax][this.casay + 1].estaLivre()) {
				t.casas[this.casax][this.casay + 1].marca();
			}
			if (this.doisPassos && t.casas[this.casax][this.casay + 2].estaLivre()
					&& t.casas[this.casax][this.casay + 1].estaLivre()) {
				t.casas[this.casax][this.casay + 2].marca();
			}
			if (this.casay < 7) {
				if (this.casax > 0 && !t.casas[this.casax - 1][this.casay + 1].estaLivre()
						&& t.casas[this.casax - 1][this.casay + 1].peca.cor != this.cor) {
					t.casas[this.casax - 1][this.casay + 1].marca();
				}
				if (this.casax < 7 && !t.casas[this.casax + 1][this.casay + 1].estaLivre()
						&& t.casas[this.casax + 1][this.casay + 1].peca.cor != this.cor) {
					t.casas[this.casax + 1][this.casay + 1].marca();
				}
			}
		}
	}

	@Override
	void apagaCasas(Tabuleiro t) {
		if (this.casay > 0) {
			t.casas[this.casax][this.casay - 1].apaga();
			if (this.casax > 0) {
				t.casas[this.casax - 1][this.casay - 1].apaga();
			}
			if (this.casax < 7) {
				t.casas[this.casax + 1][this.casay - 1].apaga();
			}
		}
		if (this.casay > 1) {
			t.casas[this.casax][this.casay - 2].apaga();
		}
		if (this.casay < 7) {
			t.casas[this.casax][this.casay + 1].apaga();
			if (this.casax > 0) {
				t.casas[this.casax - 1][this.casay + 1].apaga();
			}
			if (this.casax < 7) {
				t.casas[this.casax + 1][this.casay + 1].apaga();
			}
		}
		if (this.casay < 6) {
			t.casas[this.casax][this.casay + 2].apaga();
		}
	}

	@Override
	void moveu() {
		this.doisPassos = false;
	}

	@Override
	public boolean jaMoveu() {
		return this.jaFoiMovida;
	}
}
