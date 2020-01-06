package text;

public class Hero {
	int kill=1;
	int Exp=10;
	int level=30;
boolean c(Monster die) {
	die.life=die.life-kill;
	
	if(die.life<=0)return true;
	return false;
}
}
