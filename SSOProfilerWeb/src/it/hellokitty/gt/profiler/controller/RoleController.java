package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.Role;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController extends BaseController {
	@RequestMapping(value="/role")
	public List<Role> getRole(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<Role> roleList = null;
		try {
			roleList = Service.searchRole(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roleList;
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.GET)
	public Role getRoleById(@PathVariable String id){
		Role role = null;
		try {
			role = Service.getRoleById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
}
