
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Torre extends Peca {
	public Torre(int x, int y, int jogador) {
		super(x, y, jogador);
		this.tipo = 116;
		this.jaFoiMovida = false;
		try {
			this.imagem = jogador == 1 ? ImageIO.read(new File("Pecas/PurpleR.png"))
					: ImageIO.read(new File("Pecas/CyanR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void marcaCasasDisponiveis(Tabuleiro t) {
		int i = this.casay;
		while (i > 0) {
			if (!t.casas[this.casax][i - 1].estaLivre() && t.casas[this.casax][i - 1].peca.cor == this.cor)
				break;
			if (!t.casas[this.casax][i - 1].estaLivre() && t.casas[this.casax][i - 1].peca.cor != this.cor) {
				t.casas[this.casax][i - 1].marca();
				break;
			}
			t.casas[this.casax][i - 1].marca();
			--i;
		}
		i = this.casay;
		while (i < 7) {
			if (!t.casas[this.casax][i + 1].estaLivre() && t.casas[this.casax][i + 1].peca.cor == this.cor)
				break;
			if (!t.casas[this.casax][i + 1].estaLivre() && t.casas[this.casax][i + 1].peca.cor != this.cor) {
				t.casas[this.casax][i + 1].marca();
				break;
			}
			t.casas[this.casax][i + 1].marca();
			++i;
		}
		i = this.casax;
		while (i < 7) {
			if (!t.casas[i + 1][this.casay].estaLivre() && t.casas[i + 1][this.casay].peca.cor == this.cor)
				break;
			if (!t.casas[i + 1][this.casay].estaLivre() && t.casas[i + 1][this.casay].peca.cor != this.cor) {
				t.casas[i + 1][this.casay].marca();
				break;
			}
			t.casas[i + 1][this.casay].marca();
			++i;
		}
		i = this.casax;
		while (i > 0) {
			if (!t.casas[i - 1][this.casay].estaLivre() && t.casas[i - 1][this.casay].peca.cor == this.cor)
				break;
			if (!t.casas[i - 1][this.casay].estaLivre() && t.casas[i - 1][this.casay].peca.cor != this.cor) {
				t.casas[i - 1][this.casay].marca();
				break;
			}
			t.casas[i - 1][this.casay].marca();
			--i;
		}
	}

	void apagaCasas(Tabuleiro t) {
		int i = this.casay;
		while (i > 0) {
			t.casas[this.casax][i - 1].apaga();
			--i;
		}
		i = this.casax;
		while (i < 7) {
			t.casas[i + 1][this.casay].apaga();
			++i;
		}
		i = this.casax;
		while (i > 0) {
			t.casas[i - 1][this.casay].apaga();
			--i;
		}
		i = this.casay;
		while (i < 7) {
			t.casas[this.casax][i + 1].apaga();
			++i;
		}
	}

	void moveu() {
		this.jaFoiMovida = true;
	}

	public boolean jaMoveu() {
		return this.jaFoiMovida;
	}
}
