package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.Dealers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealersController extends BaseExtController {

	@RequestMapping(value="/dealers")
	public List<Dealers> getDealers(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<Dealers> dealerList = null;
		try {
			dealerList = extService.searchDealers(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dealerList;
	}
	
	@RequestMapping(value="/dealers/{id}", method=RequestMethod.GET)
	public Dealers getDealersById(@PathVariable String id){
		Dealers dealer = null;
		try {
			dealer = extService.getDealersById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dealer;
	}
}
