package com.ila.framework;

import com.fasterxml.jackson.core.JsonProcessingException;



public class Ila_Calls {

	public static void main(String[] args) throws JsonProcessingException {
		//private static final String ENDPOINT = "the_rest_endpoint_here";
		Ila_Rest a = new Ila_Rest();
		a.Login("9962927658","aaaaaaaaaaaa");
		//a.Verify_Pan("dgcpk3244m", 4);
		//a.Listoffer("9999");
		a.OfferEligibility("9999");
		a.OfferEligibilityCheck("9999", "PL");
		
		
		
	}
        
		
		
	

}


