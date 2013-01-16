


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * stoke le corpus parallile
 * */
public class BiCorpus {

	
	BiPhrase [] Corpus;
	// autres attributs comme par exemple les noms du fichier
	public BiCorpus(String  nom) throws Exception
	{
		String fichier_e,fichier_f;
		fichier_e = nom + ".e";
		fichier_f = nom + ".f";
		Scanner pe , pf;
		pe = new Scanner(new File(fichier_e));
		pf = new Scanner(new File(fichier_f));
		List<BiPhrase> temp;
		temp = new ArrayList() ;
		BiPhrase temp_b;
		while(pe.hasNext()&&pf.hasNext())
		{
			temp_b = new BiPhrase(pf.nextLine(), pe.nextLine());
			if(!temp.add(temp_b))throw new Exception("problem dans list sur BiCorpus") ;
			
		}
		Corpus = new BiPhrase[temp.size()];
		Corpus =  temp.toArray( Corpus );
		if(pe.hasNext()||pf.hasNext())
		{
			throw new Exception("Les deux fichiers n'ont pas meme nombre des lignes");
		}
		pe.close();
		pf.close();
		
		
		
	}
	public int size()
	{
		return Corpus.length;
	}
	public BiPhrase get(int n)
	{
		return Corpus[n];
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		BiCorpus test = new BiCorpus("lc.full.hansard.5000");
		
		System.out.println("fin du programme");
	}

}
