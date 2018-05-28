
public class Tabuleiro {
	char[][] posicaoInicialPecas = { { 'T', 'C', 'B', 'D', 'R', 'B', 'C', 'T' },
			{ 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }, { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
			{ 't', 'c', 'b', 'd', 'r', 'b', 'c', 't' } };

	Casa[][] casas = new Casa[8][8];
	int i;
	int j;

	public Tabuleiro() {
		for (i = 0; i < 8; i += 1) {
			for (j = 0; j < 8; j += 1) {
				casas[i][j] = new Casa(i, j);
				if (posicaoInicialPecas[j][i] == 'p') {
					casas[i][j].peca = new Peao(i, j, -1);
				} else if (posicaoInicialPecas[j][i] == 'P') {
					casas[i][j].peca = new Peao(i, j, 1);
				} else if (posicaoInicialPecas[j][i] == 't') {
					casas[i][j].peca = new Torre(i, j, -1);
				} else if (posicaoInicialPecas[j][i] == 'T') {
					casas[i][j].peca = new Torre(i, j, 1);
				} else if (posicaoInicialPecas[j][i] == 'c') {
					casas[i][j].peca = new Cavalo(i, j, -1);
				} else if (posicaoInicialPecas[j][i] == 'C') {
					casas[i][j].peca = new Cavalo(i, j, 1);
				} else if (posicaoInicialPecas[j][i] == 'b') {
					casas[i][j].peca = new Bispo(i, j, -1);
				} else if (posicaoInicialPecas[j][i] == 'B') {
					casas[i][j].peca = new Bispo(i, j, 1);
				} else if (posicaoInicialPecas[j][i] == 'd') {
					casas[i][j].peca = new Rainha(i, j, -1);
				} else if (posicaoInicialPecas[j][i] == 'D') {
					casas[i][j].peca = new Rainha(i, j, 1);
				} else if (posicaoInicialPecas[j][i] == 'r') {
					casas[i][j].peca = new Rei(i, j, -1);
				} else if (posicaoInicialPecas[j][i] == 'R') {
					casas[i][j].peca = new Rei(i, j, 1);
				}
			}
		}
	}

	public boolean casaOcupada(Peca p) {
		if (p != null) {
			return true;
		}

		return false;
	}

	public void trocaCasa(Casa ci, Casa cf) {
		Casa.trocaPeca(ci, cf);
	}

	public void trocaTudo() {
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i <= 7; i++) {
				trocaCasa(casas[i][j], casas[(7 - i)][(7 - j)]);
			}
		}
	}
}
