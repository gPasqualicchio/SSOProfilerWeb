package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.AdUsers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdUsersController extends BaseExtController {
	@RequestMapping(value="/adusers")
	public List<AdUsers> getAdUsers(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<AdUsers> adUsersList = null;
		try {
			adUsersList = extService.searchAdUsers(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adUsersList;
	}
	
	@RequestMapping(value="/adusers/{id}", method=RequestMethod.GET)
	public AdUsers getAdUsersById(@PathVariable String id){
		AdUsers adUsers = null;
		try {
			adUsers = extService.getAdUsersById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adUsers;
	}
}