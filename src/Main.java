import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class Main {

	public static Main depart ;
	public static String str =""; 
	
	public static char[][] s = new char[3][3] ;
	
	// liste des successeurs
	public static Hashtable<String, char[][]> sc = new Hashtable<String, char[][]>();
	// liste Frontiï¿½re
	public static Hashtable<String, char[][]> fr = new Hashtable<String, char[][]>();
	// liste des noeuds visitï¿½s
	public static Hashtable<String, char[][]> nv = new Hashtable<String, char[][]>();
	// listes des ï¿½tats buts rq: j'en ai pris que qlq uns
	public static ArrayList<char[][]> buts = new ArrayList<char[][]>();

	public Main() {
		

		buts.add(new char[][] { { '1', '2', '3' }, { '4', '5', '6' },
				{ '7', '8', ' ' } });

		buts.add(new char[][] { { '1', '4', '7' }, { '2', '5', '8' },
				{ '3', '6', ' ' } });

		buts.add(new char[][] { { '7', '4', '1' }, { '8', '5', '2' },
				{ ' ', '6', '3' } });

		buts.add(new char[][] { { '3', '2', '1' }, { '6', '5', '4' },
				{ ' ', '8', '7' } });

		buts.add(new char[][] { { '7', '8', ' ' }, { '4', '5', '6' },
				{ '1', '2', '3' } });

	}

	/***************************************************************************/

	public static int Actions(char[][] tab) {
		int i = 0, j = 0;
		boolean bool = true;

		while ((i != 3) && bool) {
			for (j = 0; j < 3; j++) {
				if (tab[i][j] == ' ') {
					bool = false;
					break;
				}

			}
			if (bool)
				i++;
		}

		if ((i == 0 || i == 2) && (j == 0 || j == 2)) {
			return 2;
		} else if ((i == 1) && (j == 1)) {
			return 4;
		} else {
			return 3;
		}

	}

	/***************************************************************************/

	public static int cout(char[][] tab) {
		int cout = 0, max = 0;
		int i = 0, j = 0;

		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				if (tab[i][j] == buts.get(0)[i][j])
					cout++;
			}
		}
		max = cout;

		for (int k = 1; k != buts.size(); k++) {
			cout = 0;
			for (i = 0; i < 3; i++) {
				for (j = 0; j < 3; j++) {
					if (tab[i][j] == buts.get(k)[i][j])
						cout++;
				}

				if (cout > max) {
					max = cout;
				}

			}

		}

		return max;
	}

	/********************************************************************************/

	public static char[][] permute(char[][] tab, int i, int perI, int j,
			int perJ) {
		char p[][] = copier(tab);

		char x =' ';

		x = p[i][j];
		p[i][j] = p[i + perI][j + perJ]; // les valeurs de perI et perJ sont de
											// -1 ou 1 selon la position de i et
											// de j
		p[i + perI][j + perJ] = x;

		return p;
	}

	/***************************************************************************************/

	public static Hashtable successeurs(char[][] tab, String cléNodeCourant) {
		int cp = Actions(tab), perI = 0, perJ = 0;
		int compteur = 1;
		Hashtable Sc = new Hashtable();
		char p[][] = tab;
		char p1[][] = tab;
		int i = 0, j = 0;
		boolean bool = true;
		while ((i != 3) && bool) {
			for (j = 0; j < 3; j++) {
				if (tab[i][j] == ' ') {
					bool = false;
					break;
				}

			}
			if (bool)
				i++;
		}

		String cle1 = "", cle2 = "", cle3 = "", cle4 = ""; // tous ï¿½a pour
															// obtenir une clï¿½
															// du genre 11
		cle1 = String.valueOf(cléNodeCourant) + String.valueOf(compteur++);
		cle2 = String.valueOf(cléNodeCourant) + String.valueOf(compteur++);
		cle3 = String.valueOf(cléNodeCourant) + String.valueOf(compteur++);
		cle4 = String.valueOf(cléNodeCourant) + String.valueOf(compteur++);
		if (cp == 2) {

			if (i == 0) {
				if (j == 0) {
					Sc.put(cle1, permute(p1, i, 1, j, 0));
					Sc.put(cle2, permute(p, i, 0, j, 1));

					return Sc;

				} else {

					Sc.put(cle1, permute(tab, i, 0, j, -1));
					Sc.put(cle2, permute(tab, i, 1, j, 0));
					return Sc;

				}
			} else {
				// i ==3
				if (j == 0) {
					Sc.put(cle1, permute(tab, i, -1, j, 0));
					Sc.put(cle2, permute(tab, i, 0, j, 1));

					return Sc;
				} else {
					Sc.put(cle1, permute(tab, i, 0, j, -1));
					Sc.put(cle2, permute(tab, i, -1, j, 0));
					return Sc;
				}
			}

		} else if (cp == 3) {

			if ((i == 0) || (i == 2)) {
				perI = (i == 0) ? 1 : -1;

				Sc.put(cle1, permute(tab, i, 0, j, -1));
				Sc.put(cle2, permute(tab, i, 0, j, 1));
				Sc.put(cle3, permute(tab, i, perI, j, 0));

				return Sc;
			} else {
				perJ = (j == 0) ? 1 : -1;

				Sc.put(cle1, permute(tab, i, -1, j, 0));
				Sc.put(cle2, permute(tab, i, 1, j, 0));
				Sc.put(cle3, permute(tab, i, 0, j, perJ));
				return Sc;
			}

		} else {
			Sc.put(cle1, permute(tab, i, 0, j, 1));
			Sc.put(cle2, permute(tab, i, 0, j, -1));
			Sc.put(cle3, permute(tab, i, 1, j, 0));
			Sc.put(cle4, permute(tab, i, -1, j, 0));
			return Sc;
		}

	}

	public static  String maxCout(Hashtable<String, char[][]> fr) {
		Enumeration e = fr.keys();
		// key recoit le premier elm de la liste de keys
		// j'initialise key
		String key = null ; 
		key = String.valueOf(e.nextElement());
		char[][] tab = fr.get(key);
		// j'initialise m comme le max
		int c = 0, m = cout(tab);
		// va recevoir la clï¿½ de l'elm ayant le cout superieur
		String testKey;
		while (e.hasMoreElements()) {
			// testkey recoit l'elm suivant
			testKey =String.valueOf( e.nextElement());
			// donne moi le tableau de cette clï¿½
			tab = fr.get(testKey);
			// donne moi son cout
			c = cout(tab);

			if (m < c) {
				m = c;
				key = testKey;
			}
		}

		return key;
	}

	/*************************************************************************************/

	public static void recherche() {
		int r = 0;
		
		// petit cours de complexitï¿½: j'ai exprï¿½s pris des tableaux de char,
		// pour  info une variable char ne prend que un octet
		// donc si je fais mon petit calcul, au pire des cas :
		// j'ai mon tableau qui consomme 9 octets pour ses neuf cases
		// donc la taille max = 9 * 4001 = 36009 Octets
		// je crois que votre RAM de 4Go y survivra :D
		char[][] tab = null;
		String key = null;

		while ((!fr.isEmpty()) &&(r <= 1000)) {
			//System.out.println(r);
			
			
			// rï¿½cuperer la clï¿½ de elm ayant le cout le plus elevï¿½
			key = maxCout(fr);
			
			// suuuuuuuuuper important, il ne suffit pas de copier l'adresse du
			// tableau pour copier le tableau, il faut crï¿½er un nouvel espace
			// mï¿½moire !
			tab = copier(fr.get(key));

			// supprimer l'elm de fr
			fr.remove(key);

			if (cout(tab) == 9) {
				
				// on parcourt l'arborescence de cette clï¿½ , ex :124324 on aura
				// les elm 1,12,124.. 'fin t'as pigï¿½ :/
				parcourt(key);
				// ï¿½a suffit pour la boucle
				break;

			} else {
				sc = successeurs(tab, key);
				ajout(sc);

			}

			r++;
			
		}

		if(r == 1000 ){
			System.out.println("Rï¿½sultat impossible, essayez une autre fois !!!");
		}
	}

	private static void afficher(char[][] tab) {
		String str = ""; 
		for (int i = 0; i != 3; i++) {
			str="";
			for (int j = 0; j != 3; j++) {

				str += "[" + tab[i][j] + "]" + "  ";
			}
			System.out.println(str);
			System.out.println("");
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	

	/***************************************************
	 * HYPER IMPORTANT,CREER UN NOUVEL ESPACE MEMOIRE * *
	 ***************************************************/

	public static char[][] copier(char[][] cs) {
		char[][] tab = new char[3][3];
		for (int i = 0; i != 3; i++) {
			for (int j = 0; j != 3; j++) {
				tab[i][j] = cs[i][j];

			}
		}

		return tab;
	}

	/********************************************************************/

	public static  void ajout(Hashtable<String, char[][]> sc) {

		// vï¿½rifier si un elm de sc (successeurs ) n'appartient pas nv( noeuds
		// visitï¿½s )
		// ajouter l'elm si non ï¿½ fr et nv
		// vider sc
		Enumeration e = sc.keys();
		String key = null;
		char[][] tab = null;
		while (e.hasMoreElements()) {

			key = String.valueOf(e.nextElement());
			tab = copier(sc.get(key));

			// true donc appartient, il faut donc le supp
			if (compare(nv, tab)) {
				sc.remove(key);
			} else {
				// on l'ajoute ï¿½ nv
				nv.put(key, tab);
				// bon aller on abrï¿½ge, on l'ajoute ï¿½galement ï¿½ fr
				fr.put(key, tab);
			}
		}
		// e recoit ï¿½ nouveau la liste des keys
		e = sc.keys();
		while (e.hasMoreElements()) {
			// supprimer
			sc.remove(e.nextElement());
		}

	}

	/*********************************************************************************/

	private static boolean compare(Hashtable<String, char[][]> nv, char[][] test) {
		// cette fct permet de vï¿½rifier si un noeud test appartient ï¿½ la liste
		// nv et retourne un boolean
		boolean bool;
		Enumeration e = nv.keys();
		String key = null;
		char[][] tab = null;
		while (e.hasMoreElements()) {
			key = String.valueOf(e.nextElement());
			tab = nv.get(key);
			bool = true;
			for (int i = 0; i != 3; i++) {
				for (int j = 0; j != 3; j++) {
					if (tab[i][j] != test[i][j]) {
						bool = false;
					}

				}
			}
			// si bool rest ï¿½ true donc les deux tab sont identiques
			if (bool) {
				return true;
			}

		}

		return false;

	}

	/**************************************************************************************/

	private static void parcourt(String key) {

		
		
		
		
		
	  String  con ="";
		
		char[][] tab  ; 
		for (int k = 0; k != key.length(); k++) {
			
			con += key.charAt(k);
			

			str +=  "Clé N° :"+con+" \n";
			tab= nv.get(con);
			
			
			for (int i = 0; i != 3; i++) {
				
				for (int j = 0; j != 3; j++) {
					
					str += "[" + tab[i][j] + "]" + "  ";
				}
				str+="\n";
			}

			str += "\n\n\n\n\n";
		}  

		str+= " Le nombre d'états parcouru est "+key.length();

	}

	/************************************************************************************/
	public static void main(String[] args) throws Exception {

		depart = new Main();
	
		new Fenetre(); 
		
		
	}

}
