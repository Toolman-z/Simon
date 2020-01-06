package text;

public class Day04 {
	public static void main(String[]args) {
		int a=1;
		int b=2;
		int c=3;
		int d=++a + b++ + ++c +a++;
		System.out.println(d);
		boolean e=true;
		boolean f=false;
		System.out.println(e|f);
		System.out.println(e&f);
		int g=100;
		if(g<10) 
		{
			System.out.println("dd");
			System.out.println("cc");
		}else 
		{
			System.out.println("你是猪");
			System.out.println("你是程哥");
		}
		if(g%2==0) {
			System.out.println("是偶数");
		}else 
		{
			System.out.println("是鸡数");
		}
		if(g>10) 
		{
			System.out.println("g>10");
		}else if(g>5)
		      {
			     System.out.println("g>5");
		      }else if(g>1)
		           {
		    	     System.out.println("g>1");
		           }
		System.out.println(g%2==0?"偶数":"基数");
		switch(g) 
		{case 1:System.out.println("g=1");
		break;
		case 2:System.out.println("g=2");
		break;
		case 4:System.out.println("g=4");
		break;
		default:System.out.println("啥啊");		
		}
		String h="CN";
		switch(h) 
		{
		case "CN":System.out.println("中国");
		break;
		case "USA":System.out.println("美国");
		break;
		case "UK":System.out.println("英国");
		break;
		case "AE":System.out.println("阿联酋");
		break;		
		}
		for(int i=0;i<2;i++) {
			System.out.println("我是詹天佑");
			System.out.println("你是华罗庚");
			System.out.println("不如跳舞");
		}
		int[] as= {1,2,3,4,5,6,7,8,9,10};//数组
		for(int j=0;j< as.length;j++) {
			System.out.println(as[j]);
		} 
		for(int o=100;o>0;o--) {
			if(o%7==0) {
				System.out.println(o+"能被7整除");
				if(o==70) {
					break;
				}
			}
		}
	int[] p= {1,2,3,4,5,6,7,8,9,10}	;
	for(int q:p) {
		System.out.println(q);
	}
	}
	

}
