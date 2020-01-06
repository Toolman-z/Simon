package Day14;

import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class Time {
public static void main(String[]args) {
	Timer timer= new Timer();
	TimerTask tt = new Clock();
	timer.schedule(tt,new Date(119,8,20,10,45,0));
}
}
