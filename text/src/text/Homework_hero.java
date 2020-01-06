package text;



public class Homework_hero {
	
		int level;
		int exp;
  Homework_hero(int exp) {
		
		if(exp>=0&&exp<=100000) {
			
			int downexp = exp;
			for (int a = 0; a <= 29; a++) {
				if (downexp >= 30 * ((a - 1) * (a - 1) * (a - 1) + 5 * (a - 1)) - 80
						&& downexp < 30 * (a * a * a + 5 * a) - 80) {
					System.out.println("经验值为" + downexp + "时等级为" + a);
					break;
				}
			}

		
		}
		
	}
  Homework_hero(){
	  int level=0;
	  int exp=0;
	  System.out.println("初始等级为"+level+"初始经验为"+exp);
  }	
	public static void main(String[]args) {
		Homework_hero a=new Homework_hero();
		Homework_hero b=new Homework_hero(99999);
	}	
	}


