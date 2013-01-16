

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Corriger {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		String nomfichier = "lc.full.hansard.5000.e";
		Scanner scan = new Scanner(new File(nomfichier));
		HashMap<String, Integer> t = new HashMap<String, Integer>();
		HashMap<String,Integer> p = new HashMap();
		
		
		
		while(scan.hasNextLine())
		{
			String [] mots = scan.nextLine().split(" ");
			int l = mots.length;
			while(l>0)
			{
				l--;
				String mot = mots[l];
				System.out.println(mot);
		
			}
			for(String mot : mots)
			{
				if(t.containsKey(mot))
				{
					 t.put(mot , t.get(mot)+1);
					
				}
				else
				{
					t.put(mot,1);
				}
			}
			
			
		}//fin while
		String nomDUfichier = "resoultat.mstat";
		PrintWriter out = new PrintWriter(new FileWriter(nomDUfichier));
		Set cles = t.keySet();
		java.util.Iterator it =  cles.iterator();
		while(it.hasNext())
		{
			String cle = (String) it.next();
			int valeur = t.get(cle);
			out.println(cle+" "+valeur);
			
		}// fin while ecrire
		out.close();
		scan.close();
		// reconstruire les donne a paritir de fichier
		Scanner fichier_mstat = new Scanner(new File(nomDUfichier));
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		while(fichier_mstat.hasNext())
		{
			String [] temp = fichier_mstat.nextLine().split(" ");
			
			hm.put(temp[0], Integer.parseInt(temp[1]));
			
		}/*fin test  */
		{//partie pour test les donne lire a partire de fichier
			Set Cle = hm.keySet();
			java.util.Iterator It = Cle.iterator();
			Boolean nombre;
			nombre = (cles.size() == Cle.size());
			Boolean bt = true;
			if(nombre)
			{
				while(it.hasNext())
				{
					String temp = (String) it.next();
					if(hm.get(temp) != t.get(temp) )
					{
					
						bt = false;break;
					}
				}
			}
			if(bt&&nombre)System.out.println("La reconstruction est correcte");
			else
			{
				System.out.println("false ");
			}
			
		}//fin test
		

	}

}
