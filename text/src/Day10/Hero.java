package Day10;

public class Hero {
	int exp , lever;
	
	int[] Exp=new int[31];
	{
		for(int i=0;i<=30;i++) {
			Exp[i]=30*(i*i*i+5*i)-80;
			//System.out.println(Exp[i]);
		}
		
	}
	Hero () {
		this.exp = 0;
	}
	Hero (int exp){
		
		if(exp >Exp[30] || exp <Exp[0]) 
		{
			System.out.println("ÊäÈë´íÎó");return;
		}
		for(int i=0;i<=30;i++) {
			if(Exp[i]>exp) break;
		this.lever=i;
		}
	}
	public static void main(String[] arges) {
		Hero hero = new Hero(460);
		int lv = hero.lever ;
		System.out.println("Ó¢ÐÛµÈ¼¶" + lv);
	}
	}

