package tp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Corriger {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		String nomfichier = "lc.full.hansard.5000.e";
		Scanner scan = new Scanner(new File(nomfichier));
		HashMap<String, Integer> t = new HashMap<String, Integer>();
		
		
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
			
			break;
		}
		

	}

}
