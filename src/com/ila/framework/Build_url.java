package com.ila.framework;

public class Build_url 
{
	static final String baseurl = "http://cmol-api.creditmantri.in/api/v1";
	public String geturl(String method)
	{
		switch (method)
		{
		case "login":
			return baseurl+ "/login";
			
		case "Vpan":
			return baseurl+ "/verify/pan";
		
		case "ProductList":
			return baseurl + "/product-list";
		
		case "OfferEligibility":
			return "offerEligibilityForm requires offer type";
			
		case "offerEligibilityCheck":
			return "offerEligibilityCheck requires offer type";
			
		case "temp":
			return "cmol-api2.creditmantri.in/api/v1/eligibility/save/answers";
			
		
		}
		return "error building URL: Invalid method";

	}
	
	public String geturl(String method,String offertype)
	{
		//System.out.println("method:" + method + "  Offer type" + offertype);
		String tempurl = null;
		switch (method)
		{
		case "login":
			return baseurl+ "/login";
			
		case "Vpan":
			return  baseurl+ "/verify/pan";
			
		case "OfferEligibilityForm":
			tempurl =  baseurl + "/eligibility-form";
			break;
		case "OfferEligibilityCheck":
			tempurl =  baseurl + "/eligibility-check";
			break;
			
		default:
			//return "error building URL: Invalid method";
		
		}
		System.out.println("test:" + offertype);
		switch(offertype)
		{
		case "Credit Card":
			return tempurl + "/1";
		case "Personal Loan":
			return tempurl + "/2";
		case "Home Loan":
			return tempurl + "/3";
		case "Car Loan":
			return tempurl + "/4";
		case "Education Loan":
			return tempurl + "/13";
		case "Gold Loan":
			return tempurl + "/6";
		case "Loan Against Property":
			return tempurl + "/10";
		case "Business Loan":
			return tempurl + "/21";
		default:
			return "error building URL: Invalid Offer Type";
		
		
		}
		

	}
}
