package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.Application;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController extends BaseController {
	@RequestMapping(value="/application")
	public List<Application> getApplication(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<Application> applicationList = null;
		try {
			applicationList = Service.searchApplication(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicationList;
	}
	
	@RequestMapping(value="/application/{id}", method=RequestMethod.GET)
	public Application getApplicationById(@PathVariable String id){
		Application application = null;
		try {
			application = Service.getApplicationById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return application;
	}
}