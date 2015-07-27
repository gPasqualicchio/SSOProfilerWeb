package it.hellokitty.gt.profiler.controller;

import it.hellokitty.gt.json.JsonRequestBody;
import it.hellokitty.gt.ssoprofiler.entity.GeoCountries;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoCountriesController extends BaseExtController {

	@RequestMapping(value="/geocountries")
	public List<GeoCountries> getGeoCountries(@RequestBody(required=false) JsonRequestBody body){
		if(null==body){
			body = new JsonRequestBody();
		}
		List<GeoCountries> geocountriesList = null;
		try {
			geocountriesList = extService.searchGeoCountries(body.getStart(), body.getLimit(), body.getOrderColumn(), body.getParamEquals(), body.getParamLike(), body.getParamGE(), body.getParamLE(), body.getParamGT(), body.getParamLT(), body.getParamIN(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return geocountriesList;
	}

	@RequestMapping(value="/geocountries/{id}", method=RequestMethod.GET)
	public GeoCountries getGeoCountriesById(@PathVariable String id){
		GeoCountries geocountries = null;
		try {
			geocountries = extService.getGeoCountriesById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return geocountries;
	}
}