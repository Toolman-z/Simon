package com.chinasofti.service;
import com.chinasofti.model.Delicacies;
public class DeService {	
	public String select(Delicacies de) {
		String rs=null;
		switch (de.getDelicacies_id()) {
		case "1":
			rs="{'cmd':'302','code':'0','did':'1','call':'010-58591188','mapx':'116.33332258227847','mapy':'39.92314568402951','name':'”„≥·','list':[{'name':'”„≥·','image':'30001','oprice':'0','nprice':'0'},{'name':'Õ∑≈Ã','image':'30002','oprice':'0','nprice':'0'},{'name':'¥Û∂π√ÁÀ˙∂π∏Ø','image':'30003','oprice':'0','nprice':'0'}]}";		
			break;
        case "2":
        	rs="{'cmd':'302','code':'0','did':'1','call':'010-58591188','mapx':'116.33332258227847','mapy':'39.92314568402951','name':'”„≥·','list':[{'name':'”„≥·','image':'30002','oprice':'0','nprice':'0'},{'name':'Õ∑≈Ã','image':'30001','oprice':'0','nprice':'0'},{'name':'¥Û∂π√ÁÀ˙∂π∏Ø','image':'30003','oprice':'0','nprice':'0'}]}";	
			break;
        case "3":
            rs="{'cmd':'302','code':'0','did':'3','call':'010-63333329','mapx':'116.42126641534423','mapy':'39.89312789999999','name':'”„≥·','list':[{'name':'ƒ√Ã˙','image':'30003','oprice':'0','nprice':'0'},{'name':'≤››ÆÀ…±˝','image':'30002','oprice':'0','nprice':'0'},{'name':'Ω«π”„»˝√˜÷Œ','image':'30003','oprice':'0','nprice':'0'}]}";
			break;			

        case "4":
        	rs="{'cmd':'302','code':'0','did':'4','call':'010-88438044','mapx':'116.27940164152528','mapy':'39.95312751211249','name':'”„≥·','list':[{'name':'∫Ï…’»‚','image':'30004','oprice':'0','nprice':'0'},{'name':'≤Ëœ„º¶','image':'30002','oprice':'0','nprice':'0'},{'name':'¬Ã≤Ë±˝','image':'30003','oprice':'0','nprice':'0'}]}";
			break;
		}													
			System.out.println(rs);							
		return rs;		
	}
}
