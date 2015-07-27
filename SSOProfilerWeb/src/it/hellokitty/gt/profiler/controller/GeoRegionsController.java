package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.GeoRegions;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoRegionsController extends BaseExtController {

	@RequestMapping(value="/georegions")
	public List<GeoRegions> getGeoRegions(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<GeoRegions> georegionsList = null;
		try {
			georegionsList = extService.searchGeoRegions(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return georegionsList;
	}

	@RequestMapping(value="/georegions/{id}", method=RequestMethod.GET)
	public GeoRegions getGeoRegionsById(@PathVariable String id){
		GeoRegions georegions = null;
		try {
			georegions = extService.getGeoRegionsById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return georegions;
	}
}
