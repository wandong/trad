

// Une phrase est representer par table de string;
/*
 * stoker un couple de phrase 
 * +consructeur
 * +getteur
 * */
public class BiPhrase {
	
	String [] f;
	String [] e;
	static int English=0;
	static int French=1;
	
	// f est Francais
	//e est Anglais
	BiPhrase(String fp,String ep)
	{
		f = fp.split(" ");
		e = ep.split(" ");
		
	}
	BiPhrase(String [] tf,String [] te)
	{
		f = tf;
		e = te;
	}
	String get(int n,int type)
	{
		if(type == French) return f[n];
		if(type == English) return e[n];
		return "";
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiPhrase test;
		test = new BiPhrase("xixi haha ","haha xixi");
		

	}

}
