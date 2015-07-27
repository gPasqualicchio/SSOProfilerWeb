package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.GeoAreas;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoAreasController extends BaseExtController {

	@RequestMapping(value="/geoareas")
	public List<GeoAreas> getGeoAreas(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<GeoAreas> geoareasList = null;
		try {
			geoareasList = extService.searchGeoAreas(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return geoareasList;
	}

	@RequestMapping(value="/geoareas/{id}", method=RequestMethod.GET)
	public GeoAreas getGeoAreasById(@PathVariable String id){
		GeoAreas geoareas = null;
		try {
			geoareas = extService.getAGeoAreasById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return geoareas;
	}
}
