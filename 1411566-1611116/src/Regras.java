/*
 * Decompiled with CFR 0_123.
 */
public class Regras {
	public static Tabuleiro tab = new Tabuleiro();
	private static int lado = 64;
	public static int selectx = -1;
	public static int selecty = -1;
	public static int turnoJogador = 1;
	private static int modo = 1;
	public int mx = -1;
	public int my = -1;

	public static void clique(Tabuleiro tab, int posx, int posy, int button) {
		if (button == 1) {
			if (!Peca.pecaAtiva) {
				selectx = posx;
				selecty = posy;
				if (tab.casas[selectx][selecty] != null && tab.casas[Regras.selectx][Regras.selecty].peca != null
						&& tab.casas[Regras.selectx][Regras.selecty].peca.cor == turnoJogador) {
					tab.casas[Regras.selectx][Regras.selecty].peca.acionaPeca(tab);
				}
			} else {
				int selectmx = posx;
				int selectmy = posy;
				if (selectmx == selectx && selectmy == selecty) {
					tab.casas[Regras.selectx][Regras.selecty].peca.desativaPeca(tab);
					selectx = -1;
					selecty = -1;
				} else if (tab.casas[selectmx][selectmy].getMarcador()) {
					tab.casas[Regras.selectx][Regras.selecty].peca.desativaPeca(tab);
					tab.casas[selectx][selecty].movePeca(tab.casas[selectmx][selectmy]);
					Regras.mudaTurno(tab);
				} else if (!tab.casas[selectmx][selectmy].estaLivre()
						&& tab.casas[Regras.selectx][Regras.selecty].peca.cor == tab.casas[selectmx][selectmy].peca.cor) {
					tab.casas[Regras.selectx][Regras.selecty].peca.apagaCasas(tab);
					tab.casas[Regras.selectx][Regras.selecty].peca.desativaPeca(tab);
					tab.casas[selectmx][selectmy].peca.acionaPeca(tab);
					selectx = selectmx;
					selecty = selectmy;
				} else {
					tab.casas[Regras.selectx][Regras.selecty].peca.desativaPeca(tab);
				}
			}
		}
	}

	public static void teclado(int button) {
		int turnoJogador = Regras.getTurnoJogador();
		if (turnoJogador == 1 && button == 77) {
			if (modo == 1) {
				Regras.alteraModo(2);
			} else if (modo == 2) {
				Regras.alteraModo(1);
			}
		}
	}

	public static boolean casaOcupada(Tabuleiro t, int x, int y) {
		boolean b = t.casaOcupada(t.casas[x][y].getPeca());
		return b;
	}

	public static boolean getMarcador(Tabuleiro t, int x, int y) {
		boolean marcador = t.casas[x][y].getMarcador();
		return marcador;
	}

	public static void mudaTurno(Tabuleiro tab) {
		turnoJogador *= -1;
		if (modo == 2) {
			tab.trocaTudo();
		}
	}

	private static void alteraModo(int m) {
		modo = m;
	}

	public static int getTurnoJogador() {
		return turnoJogador;
	}

	public static int getModo() {
		return modo;
	}

	public static Tabuleiro getTabuleiro() {
		return tab;
	}
}
