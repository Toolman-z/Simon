package com.chinasofti.controller;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.model.Concert;
import com.chinasofti.model.Delicacies;
import com.chinasofti.model.Display;
import com.chinasofti.model.Movie;
import com.chinasofti.model.Music;
import com.chinasofti.model.PekingOpera;
import com.chinasofti.model.Play;
import com.chinasofti.model.User;
import com.chinasofti.service.CcService;
import com.chinasofti.service.ConcertService;
import com.chinasofti.service.DeService;
import com.chinasofti.service.DelicaciesService;
import com.chinasofti.service.DisplayService;
import com.chinasofti.service.MovieService;
import com.chinasofti.service.MusicService;
import com.chinasofti.service.MvService;
import com.chinasofti.service.PekingOperaService;
import com.chinasofti.service.PkoService;
import com.chinasofti.service.PlayService;
import com.chinasofti.service.PyService;
import com.chinasofti.service.UserService;
import com.chinasofti.service.McService;
public class LifeController extends HttpServlet {	
	private static final long serialVersionUID = 1L;
    private UserService userService  = new UserService();
    private DisplayService displayService=new DisplayService();
    private MusicService musicService=new MusicService();
    private ConcertService concertService=new ConcertService();
    private PekingOperaService pkService=new PekingOperaService();
    private PlayService playService=new PlayService();
    private MovieService movieService=new MovieService();
    private DelicaciesService delicaciesService=new DelicaciesService();
    private DeService deService=new DeService();
    private McService mcService=new McService();
    private PkoService pkoService=new PkoService();
    private PyService pyService=new PyService();
    private MvService mvService=new MvService();
    private CcService ccService=new CcService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		System.out.println("�ɹ�");
		int cmd = Integer.parseInt(request.getParameter("cmd"));
	    String jsonCode= null;//ִ�н����Jason�ַ���
		switch (cmd) {
	    case 0:
	    	//��¼�߼�
	    	User login =new User();
	    	login.setName(request.getParameter("username"));
	    	login.setPassword(request.getParameter("password")); 
	    	login.setUid(UUID.randomUUID().toString());
	    	jsonCode= userService.select(login);
	    	System.out.println("user-insert:"+jsonCode);
    	break;
	    case 1:
	    	//ע���߼�
	    	User user =new User();
	    	user.setName(request.getParameter("username"));
	    	user.setPassword(request.getParameter("password"));
	    	user.setUid(UUID.randomUUID().toString());//�����ֻ�ʶ����
	    	jsonCode= userService.insert(user);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 301:
	    	//��ʳ�б��߼�
	    	Delicacies delicacies=new Delicacies();
	    	jsonCode=delicaciesService.select(delicacies);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 302:
	    	//��ʳ�б�����ҳ�߼�
	    	Delicacies de=new Delicacies();
	    	de.setDelicacies_id(request.getParameter("did"));	    	
	    	jsonCode=deService.select(de);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 401:
	    	//չ���б��߼�
	    	Display display=new Display();	    	
	    	jsonCode=displayService.select(display);
	        System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 501:
	    	//���ֻ��б��߼�
	    	Music music=new Music();	    	
	    	jsonCode=musicService.select(music);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 502:
	    	//���ֻ������߼�
	    	Music mc=new Music();
	    	mc.setMusicid(request.getParameter("mid"));
	    	jsonCode=mcService.select(mc);
	        System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 201:
	        //�ݳ����б��߼�
	    	Concert concert=new Concert();	    	
	    	jsonCode=concertService.select(concert);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;	     	
	    case 202:
	        //�ݳ��������б��߼�
	    	Concert cc=new Concert();	
	    	cc.setConcert_id(request.getParameter("cid"));
	    	jsonCode=ccService.select(cc);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;	
	    case 601:
	    	//�����б��߼�	
	    	PekingOpera pk=new PekingOpera();
	    	jsonCode=pkService.select(pk);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 602:
	    	//���������߼�
	    	PekingOpera pko=new PekingOpera();
	    	pko.setPekingopera_id(request.getParameter("pid"));
	    	jsonCode=pkoService.select(pko);
	        System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 701:
	    	//�����б��߼�	
	    	Play play=new Play();
	    	jsonCode=playService.select(play);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 702:
	    	//���������б��߼�	
	    	Play py=new Play();
	    	py.setPlay_id(request.getParameter("pid"));
	    	jsonCode=pyService.select(py);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;	
	    case 101:
	    	//Ӱ���б��߼�	
	    	Movie movie=new Movie();
	    	jsonCode=movieService.select(movie);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;
	    case 102:
	    	//Ӱ�������б��߼�	
	    	Movie mv=new Movie();
	    	mv.setMovieid(request.getParameter("mid"));
	    	jsonCode=mvService.select(mv);
	    	System.out.println("user-insert:"+jsonCode);
	    	break;		
	    }
		OutputStream out =response.getOutputStream();
		out.write(jsonCode.getBytes());
		out.flush();
	}
	
}

