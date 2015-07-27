package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.CompanyRole;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyRoleController extends BaseController {

	@RequestMapping(value="/companyrole")
	public List<CompanyRole> getCompanyRole(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<CompanyRole> companyroleList = null;
		try {
			companyroleList = Service.searchCompanyRole(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyroleList;
	}

	@RequestMapping(value="/companyrole/{id}", method=RequestMethod.GET)
	public CompanyRole getCompanyRoleById(@PathVariable String id){
		CompanyRole companyrole = null;
		try {
			companyrole = Service.getCompanyRoleById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyrole;
	}
}
