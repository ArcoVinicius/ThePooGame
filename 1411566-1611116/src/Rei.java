import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Rei extends Peca {
	public Rei(int x, int y, int jogador) {
		super(x, y, jogador);
		this.tipo = 114;
		try {
			this.imagem = jogador == 1 ? ImageIO.read(new File("Pecas/PurpleK.png"))
					: ImageIO.read(new File("Pecas/CyanK.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void marcaCasasDisponiveis(Tabuleiro t) {
		int i = this.casax;
		int j = this.casay;
		if (this.casay > 0 && (t.casas[i][j - 1].estaLivre()
				|| !t.casas[i][j - 1].estaLivre() && t.casas[i][j - 1].peca.cor != this.cor)) {
			t.casas[i][j - 1].marca();
		}
		if (j < 7 && (t.casas[i][j + 1].estaLivre()
				|| !t.casas[i][j + 1].estaLivre() && t.casas[i][j + 1].peca.cor != this.cor)) {
			t.casas[i][j + 1].marca();
		}
		if (i > 0) {
			if (t.casas[i - 1][j].estaLivre()
					|| !t.casas[i - 1][j].estaLivre() && t.casas[i - 1][j].peca.cor != this.cor) {
				t.casas[i - 1][j].marca();
			}
			if (j > 0 && (t.casas[i - 1][j - 1].estaLivre()
					|| !t.casas[i - 1][j - 1].estaLivre() && t.casas[i - 1][j - 1].peca.cor != this.cor)) {
				t.casas[i - 1][j - 1].marca();
			}
			if (j < 7 && (t.casas[i - 1][j + 1].estaLivre()
					|| !t.casas[i - 1][j + 1].estaLivre() && t.casas[i - 1][j + 1].peca.cor != this.cor)) {
				t.casas[i - 1][j + 1].marca();
			}
		}
		if (i < 7) {
			if (t.casas[i + 1][j].estaLivre()
					|| !t.casas[i + 1][j].estaLivre() && t.casas[i + 1][j].peca.cor != this.cor) {
				t.casas[i + 1][j].marca();
			}
			if (j > 0 && (t.casas[i + 1][j - 1].estaLivre()
					|| !t.casas[i + 1][j - 1].estaLivre() && t.casas[i + 1][j - 1].peca.cor != this.cor)) {
				t.casas[i + 1][j - 1].marca();
			}
			if (j < 7 && (t.casas[i + 1][j + 1].estaLivre()
					|| !t.casas[i + 1][j + 1].estaLivre() && t.casas[i + 1][j + 1].peca.cor != this.cor)) {
				t.casas[i + 1][j + 1].marca();
			}
		}
	}

	void apagaCasas(Tabuleiro t) {
		if (this.casay > 0) {
			t.casas[this.casax][this.casay - 1].apaga();
		}
		if (this.casay < 7) {
			t.casas[this.casax][this.casay + 1].apaga();
		}
		if (this.casax > 0) {
			t.casas[this.casax - 1][this.casay].apaga();
			if (this.casay > 0) {
				t.casas[this.casax - 1][this.casay - 1].apaga();
			}
			if (this.casay < 7) {
				t.casas[this.casax - 1][this.casay + 1].apaga();
			}
		}
		if (this.casax < 7) {
			t.casas[this.casax + 1][this.casay].apaga();
			if (this.casay > 0) {
				t.casas[this.casax + 1][this.casay - 1].apaga();
			}
			if (this.casay < 7) {
				t.casas[this.casax + 1][this.casay + 1].apaga();
			}
		}
	}

	void moveu() {
		this.jaFoiMovida = true;
	}

	public boolean jaMoveu() {
		return this.jaFoiMovida;
	}
}
