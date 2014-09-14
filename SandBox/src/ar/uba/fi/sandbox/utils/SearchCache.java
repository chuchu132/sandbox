package ar.uba.fi.sandbox.utils;

import java.util.ArrayList;
import java.util.List;
import ar.uba.fi.sandbox.models.ResultadoPublicacion;

public class SearchCache {
	
	private static SearchCache INSTANCE = null;
	List<ResultadoPublicacion> results = null;

	private SearchCache(){
		results = new ArrayList<ResultadoPublicacion>();
	};
	
	static public SearchCache getInstance(){
		if(INSTANCE == null){
			INSTANCE =  new SearchCache();
		}
		return	INSTANCE;
	}
	
	public List<ResultadoPublicacion> getResults(){
		return results;
	}
	
	public List<ResultadoPublicacion> addResults(List<ResultadoPublicacion> moreResults ){
		results.addAll(moreResults);
		return  results;
	}

	public void clearResults(){
		results.clear();
	}
}
