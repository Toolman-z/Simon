package com.chinasofti.service.system;

import java.util.List;

public interface RoleAuthService {

	List<String> authIdList(int roleId);

	List<String> urlList(int roleid);

}
