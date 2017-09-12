package com.ila.framework;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Ila_Restold1 {
	static final String baseurl = "http://cmol-api.creditmantri.in/api/v1";
	Client client = ClientBuilder.newBuilder().build();
	String AuthToken;
	
	private Response Do_post(String Call,String payload)
	{	
		Build_url url = new Build_url();
		String a = url.geturl(Call);
		WebTarget target = client.target(a);
		Response response = target.request().post(Entity.entity(payload,"application/json"));
		if (Call == "login")
		{	
			AuthToken = "Bearer " + response.getHeaderString("authorization");
			client.register(new AuthHeadersRequestFilter(AuthToken));
			System.out.println(AuthToken);
		}
		
		return response;
		
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public  void Login(String user, String password) throws JsonProcessingException
	{	ObjectMapper mapper = new ObjectMapper();
		JsonDict json = new JsonDict();
		Boolean Phone = isNumeric(user);
		if (Phone)
		{
			json.phoneHome = user;
		}
		else
		{
		json.emailid = user;
		}
		json.password = password;
		json.source = "Website";
		String payload =  mapper.writeValueAsString(json);
		Response response = Do_post("login",payload);
		String value = response.readEntity(String.class);
        System.out.println(value);
        
	}
	public JsonObject  Listoffer(String oic) throws JsonProcessingException
	{
		
		String payload;
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp = new JsonParser();
		JsonDict Json = new JsonDict();
		
		Json.oic = oic;
		payload =  mapper.writeValueAsString(Json);
		//System.out.println(payload);
		Response response =  Do_post("ProductList",payload);
		
		String value = response.readEntity(String.class);
		JsonObject obj = jp.parse(value).getAsJsonObject();
		System.out.println(obj);
		return obj;
        
	}
	public void  OfferEligibilityCheck(String oic) throws JsonProcessingException
	{
		
		String payload;
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp = new JsonParser();
		JsonDict Json = new JsonDict();
		Json.oic = oic;
		//To get leadid
		JsonObject obj = Listoffer(oic);
		JsonArray temparray = obj.getAsJsonObject("data").getAsJsonArray("productFamily");
		
		System.out.println("****************************************");
		
		for (int i = 0; i < temparray.size(); i++)
		{ 
			System.out.println(temparray.get(i).getAsJsonObject().get("shortName").getAsString());
			System.out.println(temparray.get(i).getAsJsonObject().get("leadId").getAsNumber());
			if (temparray.get(i).getAsJsonObject().get("shortName").getAsString() == "CC")
			{
				Json.leadId = temparray.get(i).getAsJsonObject().get("leadId").getAsInt();
				System.out.println(Json.leadId);
			}
		}
		System.out.println("****************************************");
		
		Json.oic = oic;
		Json.leadId = 2971522; 
		payload =  mapper.writeValueAsString(Json);

		System.out.println(payload);

		
		
		Response response =  Do_post("OfferEligibilityCheck","Credit Cards",payload);
		String value = response.readEntity(String.class);
		JsonObject EligibleOffers = EligibleOffers(value);
		System.out.println(value);
        
	}		
	
	
}
