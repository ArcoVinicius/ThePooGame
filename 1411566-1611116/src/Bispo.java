
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bispo extends Peca {
	public Bispo(int x, int y, int jogador) {
		super(x, y, jogador);
		this.tipo = 98;
		try {
			this.imagem = jogador == 1 ? ImageIO.read(new File("Pecas/PurpleB.png"))
					: ImageIO.read(new File("Pecas/CyanB.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void marcaCasasDisponiveis(Tabuleiro t) {
		int i = this.casax;
		int j = this.casay;
		while (i < 7 && j > 0) {
			if (!t.casas[i + 1][j - 1].estaLivre() && t.casas[i + 1][j - 1].peca.cor == this.cor)
				break;
			if (!t.casas[i + 1][j - 1].estaLivre() && t.casas[i + 1][j - 1].peca.cor != this.cor) {
				t.casas[i + 1][j - 1].marca();
				break;
			}
			t.casas[i + 1][j - 1].marca();
			++i;
			--j;
		}
		i = this.casax;
		j = this.casay;
		while (i < 7 && j < 7) {
			if (!t.casas[i + 1][j + 1].estaLivre() && t.casas[i + 1][j + 1].peca.cor == this.cor)
				break;
			if (!t.casas[i + 1][j + 1].estaLivre() && t.casas[i + 1][j + 1].peca.cor != this.cor) {
				t.casas[i + 1][j + 1].marca();
				break;
			}
			t.casas[i + 1][j + 1].marca();
			++i;
			++j;
		}
		i = this.casax;
		j = this.casay;
		while (i > 0 && j > 0) {
			if (!t.casas[i - 1][j - 1].estaLivre() && t.casas[i - 1][j - 1].peca.cor == this.cor)
				break;
			if (!t.casas[i - 1][j - 1].estaLivre() && t.casas[i - 1][j - 1].peca.cor != this.cor) {
				t.casas[i - 1][j - 1].marca();
				break;
			}
			t.casas[i - 1][j - 1].marca();
			--i;
			--j;
		}
		i = this.casax;
		j = this.casay;
		while (i > 0 && j < 7) {
			if (!t.casas[i - 1][j + 1].estaLivre() && t.casas[i - 1][j + 1].peca.cor == this.cor)
				break;
			if (!t.casas[i - 1][j + 1].estaLivre() && t.casas[i - 1][j + 1].peca.cor != this.cor) {
				t.casas[i - 1][j + 1].marca();
				break;
			}
			t.casas[i - 1][j + 1].marca();
			--i;
			++j;
		}
	}

	void apagaCasas(Tabuleiro t) {
		int i = this.casax;
		int j = this.casay;
		while (i < 7 && j > 0) {
			t.casas[i + 1][j - 1].apaga();
			++i;
			--j;
		}
		i = this.casax;
		j = this.casay;
		while (i < 7 && j < 7) {
			t.casas[i + 1][j + 1].apaga();
			++i;
			++j;
		}
		i = this.casax;
		j = this.casay;
		while (i > 0 && j > 0) {
			t.casas[i - 1][j - 1].apaga();
			--i;
			--j;
		}
		i = this.casax;
		j = this.casay;
		while (i > 0 && j < 7) {
			t.casas[i - 1][j + 1].apaga();
			--i;
			++j;
		}
	}

	void moveu() {
	}

	public boolean jaMoveu() {
		return this.jaFoiMovida;
	}
}
