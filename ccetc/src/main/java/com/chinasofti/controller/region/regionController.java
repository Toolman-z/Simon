package com.chinasofti.controller.region;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.chinasofti.model.region.Department;
import com.chinasofti.model.region.Duties;
import com.chinasofti.model.region.Region;
import com.chinasofti.model.region.Tech;
import com.chinasofti.model.system.Role;
import com.chinasofti.model.user.User;
import com.chinasofti.service.region.RegionService;
import com.chinasofti.util.MessageUtil;
@Controller
@RequestMapping("/region")
public class regionController {
	
	@Autowired
	private RegionService regionService;
	
	
	
	
	@RequestMapping("/adm.action")
	public String areaTree(Model model,@ModelAttribute("region")Region region) {//区域管理查询地址
		List<Region> area = regionService.selectArea(region);
		int total = regionService.selectCount(region);
		model.addAttribute("regionList", area);
		model.addAttribute("total", total);
		System.out.println(total);
		System.out.println(region.getPage());
		return "region/area";
		
	}
	
	@RequestMapping("/department.action")
	public String depTree(Model model,@ModelAttribute("department")Department department) {//区域管理查询部门
		List<Department> area = regionService.selectDepartment(department);
		int total = regionService.selectdeptCount(department);
		model.addAttribute("total", total);
		model.addAttribute("departmentList", area);
		return "region/dept";
		
	}
	
	@RequestMapping("/duties.action")
	public String dutiesTree(Model model,@ModelAttribute("duties")Duties duties) {//区域管理查询职务
		List<Duties> area = regionService.selectDuties(duties);
		int total = regionService.selectdutiesCount(duties);
		model.addAttribute("total", total);
		model.addAttribute("dutiesList", area);
		return "region/duties";		
	}
	
	
	@RequestMapping("/tech.action")
	public String tech(Model model) {//技术方向查询地址
		List<Tech> tech = regionService.selectTech(model);
		model.addAttribute("techList", tech);
		return "region/tech";
		
	}
	
	@RequestMapping("/deptAdd.action")
	@ResponseBody
	public String adddeptTree(Department department,HttpSession session) {//添加部门	
		MessageUtil msg = new MessageUtil();
		try {
			regionService.insertdept(department, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);	
	}
	
	@RequestMapping("/techAddJump.action")
	public String techjump(Model model,Region region) {//添加技术方向跳转
		List<Region> area = regionService.selectArea(region);
		model.addAttribute("List", area);
		return "region/addtech";		
	}
	
	@RequestMapping("/deptAddJump.action")
	public String Tree(Model model,Region region) {//添加部门时查找有哪些区域
		List<Region> area = regionService.selectArea(region);
		model.addAttribute("List", area);
		return "region/adddept";		
	}
	
	@RequestMapping("/areaAddJump.action")
	public String areaaddjumpTree(Model model) {//添加区域跳转
	
		return "region/addarea";		
	}
	
	@RequestMapping("/testareaname.action")
	@ResponseBody
	public String testareaname(Region region) {//添加区域时检测区域名是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<Region> a=this.regionService.testareaname(region);
			System.out.println(a);
			if(regionService.testareaname(region).isEmpty()) {
				msg.setSuccess(false);
			}else {
				msg.setSuccess(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	
	@RequestMapping("/testtechname.action")
	@ResponseBody
	public String testtechname(Tech tech) {//添加技术方向时检测是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<Tech> a=this.regionService.testtechname(tech);
			System.out.println(a);
			if(regionService.testtechname(tech).isEmpty()) {
				msg.setSuccess(false);
			}else {
				msg.setSuccess(true);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/techAdd.action")
	@ResponseBody
	public String techadd(Tech tech,HttpSession session) {//添加技术方向
		MessageUtil msg = new MessageUtil();
		try {
			regionService.inserttech(tech, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/areaAdd.action")
	@ResponseBody
	public String areaadd(Region region,HttpSession session) {//添加区域
		MessageUtil msg = new MessageUtil();
		try {
			regionService.insertarea(region, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/areaEditjump.action")
	public String roleAdd(Region region,Model model) {//修改区域跳转
		List<Region> area = regionService.selectAreaname(region);
		System.out.println(region.getAreaid()); 
		model.addAttribute("area", area);
		return "region/areaedit";
	}
	
	@RequestMapping("/techEditjump.action")
	public String techeditjump(Tech tech,Model model,Region region) {//修改技术方向跳转
		System.out.println(tech.getTechnologyid());
		List<Tech> areaa = regionService.techeditjump(tech);
		List<Region> area = regionService.selectArea(region);
		model.addAttribute("List", area);
		model.addAttribute("tech", areaa);
		return "region/techedit";
	}
	
	@RequestMapping("/areaEdit.action")
	@ResponseBody
	public String area(Region region,HttpSession session) {//修改区域
		MessageUtil msg = new MessageUtil();
		try {
			regionService.editarea(region, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/testdeptname.action")
	@ResponseBody
	public String testdeptname(Department department) {//添加部门时检测区域名是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<Department> a=this.regionService.testdeptname(department);
			System.out.println(a);
			if(regionService.testdeptname(department).isEmpty()) {
				msg.setSuccess(true);
			}else {
				msg.setSuccess(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	@RequestMapping("/deptEditjump.action")
	public String editdeptjump(Department department,Model model) {//修改部门跳转
		System.out.println(department.getAreaid()); 
		List<Department> dept = regionService.selectDeptname(department);
		List<Region> areab = regionService.selectAreaall();
		model.addAttribute("List", areab);
		model.addAttribute("dept", dept);
		return "region/deptedit";
	}
	
	@RequestMapping("/testdepteditname.action")
	@ResponseBody
	public String testdepteditname(Department department) {//修改部门时检测是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<Department> a=this.regionService.testdepteditname(department);
			System.out.println(a);
			if(regionService.testdepteditname(department).isEmpty()) {
				msg.setSuccess(true);
			}else {
				msg.setSuccess(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	
	@RequestMapping("/testtechnameedit.action")
	@ResponseBody
	public String testtechnameedit(Tech tech) {//修改技术方向时检测是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<Tech> a=this.regionService.testtecheditname(tech);
			System.out.println(a);
			if(regionService.testtecheditname(tech).isEmpty()) {
				msg.setSuccess(true);
			}else {
				msg.setSuccess(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/deptEdit.action")
	@ResponseBody
	public String dept(Department department,HttpSession session) {//修改部门
		MessageUtil msg = new MessageUtil();
		try {
			regionService.editdept(department, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/techEdit.action")
	@ResponseBody
	public String techedit(Tech tech,HttpSession session) {//修改部门
		MessageUtil msg = new MessageUtil();
		try {
			regionService.edittech(tech, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/dutiesAddJump.action")
	public String dutiesaddjumpTree(Model model) {//添加职务跳转
		List<Region> area = regionService.selectAreaall();//添加时查询所有的区域
		List<Department> dept =regionService.selectDept();//添加时查询所有的部门
		model.addAttribute("List", area);
		model.addAttribute("deptList", dept);
		return "region/addduties";		
	}
	
	@RequestMapping("/testdutiesname.action")
	@ResponseBody
	public String testdutiesname(Duties duties) {//添加职务时检测是否重复
		MessageUtil msg = new MessageUtil();
		try {
			List<Duties> a=this.regionService.testdutiesname(duties);
			System.out.println(a);
			if(regionService.testdutiesname(duties).isEmpty()) {
				msg.setSuccess(true);
			}else {
				msg.setSuccess(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/dutiesAdd.action")
	@ResponseBody
	public String dutiesadd(Duties duties,HttpSession session) {//添加职务
		MessageUtil msg = new MessageUtil();
		try {
			regionService.insertduties(duties, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/dutiesEditjump.action")
	public String editdutiesjump(Duties duties,Model model) {//修改职务跳转
		
		List<Region> area = regionService.selectAreaall();//查询所有的区域
		List<Department> dept =regionService.selectDept();//查询所有的部门
		List<Duties> dutiess = regionService.selecteditDuties(duties);//查询你要修改的职务信息
		model.addAttribute("dutiesList", dutiess);
		model.addAttribute("areaList", area);
		model.addAttribute("deptList", dept);
		return "region/dutiesedit";
	}
	
	@RequestMapping("/dutiesEdit.action")
	@ResponseBody
	public String duties(Duties duties,HttpSession session) {//修改职务
		MessageUtil msg = new MessageUtil();
		System.out.println(duties.getAreaid());
		try {
			regionService.editduties(duties, session);
			msg.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			msg.setSuccess(false);
			msg.setMessage(e.getMessage());
		}
		return JSON.toJSONString(msg);		
	}
	
	@RequestMapping("/childone.action")
	@ResponseBody
	public String childone(Department department) {//二表联动		
			List<Department> a=this.regionService.childone(department);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
	
	@RequestMapping("/childtwo.action")
	@ResponseBody
	public String childtwo(Duties duties) {//二表联动		
			List<Duties> a=this.regionService.childtwo(duties);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
	
	@RequestMapping("/childthree.action")
	@ResponseBody
	public String childthree(Tech tech) {//三表联动		
			List<Tech> a=this.regionService.childthree(tech);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
	
	@RequestMapping("/deltfive.action")
	@ResponseBody
	public String deltfive(Region region) {//五表联动		
			List<Region> a=this.regionService.deltfive(region);
			System.out.println(a);
				
			return JSON.toJSONString(a);
	}
}
