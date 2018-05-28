
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cavalo extends Peca {
	public Cavalo(int x, int y, int jogador) {
		super(x, y, jogador);
		this.tipo = 99;
		try {
			this.imagem = jogador == 1 ? ImageIO.read(new File("Pecas/PurpleN.png"))
					: ImageIO.read(new File("Pecas/CyanN.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void marcaCasasDisponiveis(Tabuleiro t) {
		if (this.casay > 1) {
			if (this.casax > 0 && (t.casas[this.casax - 1][this.casay - 2].estaLivre()
					|| !t.casas[this.casax - 1][this.casay - 2].estaLivre()
							&& t.casas[this.casax - 1][this.casay - 2].peca.cor != this.cor)) {
				t.casas[this.casax - 1][this.casay - 2].marca();
			}
			if (this.casax < 7 && (t.casas[this.casax + 1][this.casay - 2].estaLivre()
					|| !t.casas[this.casax + 1][this.casay - 2].estaLivre()
							&& t.casas[this.casax + 1][this.casay - 2].peca.cor != this.cor)) {
				t.casas[this.casax + 1][this.casay - 2].marca();
			}
		}
		if (this.casay < 6) {
			if (this.casax > 0 && (t.casas[this.casax - 1][this.casay + 2].estaLivre()
					|| !t.casas[this.casax - 1][this.casay + 2].estaLivre()
							&& t.casas[this.casax - 1][this.casay + 2].peca.cor != this.cor)) {
				t.casas[this.casax - 1][this.casay + 2].marca();
			}
			if (this.casax < 7 && (t.casas[this.casax + 1][this.casay + 2].estaLivre()
					|| !t.casas[this.casax + 1][this.casay + 2].estaLivre()
							&& t.casas[this.casax + 1][this.casay + 2].peca.cor != this.cor)) {
				t.casas[this.casax + 1][this.casay + 2].marca();
			}
		}
		if (this.casax < 6) {
			if (this.casay > 0 && (t.casas[this.casax + 2][this.casay - 1].estaLivre()
					|| !t.casas[this.casax + 2][this.casay - 1].estaLivre()
							&& t.casas[this.casax + 2][this.casay - 1].peca.cor != this.cor)) {
				t.casas[this.casax + 2][this.casay - 1].marca();
			}
			if (this.casay < 7 && (t.casas[this.casax + 2][this.casay + 1].estaLivre()
					|| !t.casas[this.casax + 2][this.casay + 1].estaLivre()
							&& t.casas[this.casax + 2][this.casay + 1].peca.cor != this.cor)) {
				t.casas[this.casax + 2][this.casay + 1].marca();
			}
		}
		if (this.casax > 1) {
			if (this.casay > 0 && (t.casas[this.casax - 2][this.casay - 1].estaLivre()
					|| !t.casas[this.casax - 2][this.casay - 1].estaLivre()
							&& t.casas[this.casax - 2][this.casay - 1].peca.cor != this.cor)) {
				t.casas[this.casax - 2][this.casay - 1].marca();
			}
			if (this.casay < 7 && (t.casas[this.casax - 2][this.casay + 1].estaLivre()
					|| !t.casas[this.casax - 2][this.casay + 1].estaLivre()
							&& t.casas[this.casax - 2][this.casay + 1].peca.cor != this.cor)) {
				t.casas[this.casax - 2][this.casay + 1].marca();
			}
		}
	}

	void apagaCasas(Tabuleiro t) {
		if (this.casay > 1) {
			if (this.casax > 0) {
				t.casas[this.casax - 1][this.casay - 2].apaga();
			}
			if (this.casax < 7) {
				t.casas[this.casax + 1][this.casay - 2].apaga();
			}
		}
		if (this.casay < 6) {
			if (this.casax > 0) {
				t.casas[this.casax - 1][this.casay + 2].apaga();
			}
			if (this.casax < 7) {
				t.casas[this.casax + 1][this.casay + 2].apaga();
			}
		}
		if (this.casax < 6) {
			if (this.casay > 0) {
				t.casas[this.casax + 2][this.casay - 1].apaga();
			}
			if (this.casay < 7) {
				t.casas[this.casax + 2][this.casay + 1].apaga();
			}
		}
		if (this.casax > 1) {
			if (this.casay > 0) {
				t.casas[this.casax - 2][this.casay - 1].apaga();
			}
			if (this.casay < 7) {
				t.casas[this.casax - 2][this.casay + 1].apaga();
			}
		}
	}

	void moveu() {
	}

	public boolean jaMoveu() {
		return this.jaFoiMovida;
	}
}
