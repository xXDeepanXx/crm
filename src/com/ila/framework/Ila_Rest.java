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

public class Ila_Rest {
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
	private Response Do_post(String Call,String offertype,String payload)
	{	
		Build_url url = new Build_url();
		String a = url.geturl(Call,offertype);
		//System.out.println(a);
		WebTarget target = client.target(a);
		Response response = target.request().post(Entity.entity(payload,"application/json"));
		if (Call == "login")
		{	
			AuthToken = "Bearer " + response.getHeaderString("authorization");
			client.register(new AuthHeadersRequestFilter(AuthToken));
		}
		
		return response;
		
	}
	
	//@Deprecated
	private Response Do_get(String Call,String payload)
	{	Build_url url = new Build_url();
		String a = url.geturl(Call);
		WebTarget target = client.target(a);
		Response response = target.request().get();
		AuthToken = "Bearer " + response.getHeaderString("authorization");
		client.register(new AuthHeadersRequestFilter(AuthToken));
		return response;
		
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
		System.out.println(payload);
		Response response = Do_post("login",payload);
		String value = response.readEntity(String.class);
       // System.out.println(value);
        
}

	public void  Verify_Pan(String pan, int userId) throws JsonProcessingException
	{
		
		String payload;
		ObjectMapper mapper = new ObjectMapper();
		JsonDict verifypan = new JsonDict();
		verifypan.pan = pan;
		verifypan.userId = userId;
		payload =  mapper.writeValueAsString(verifypan);

		//System.out.println(payload);

		System.out.println(AuthToken);
		
		
		Response response =  Do_post("Vpan",payload);
		String value = response.readEntity(String.class);
		//System.out.println(value);
        
	}

		
	public String  Listoffer(String oic) throws JsonProcessingException
	{
		
		String payload;
		ObjectMapper mapper = new ObjectMapper();
		JsonDict Json = new JsonDict();
		Json.oic = oic;
		//Json.setProperty(oic, oic);
		payload =  mapper.writeValueAsString(Json);

		System.out.println(payload);

		
		
		Response response =  Do_post("ProductList",payload);
		
		String value = response.readEntity(String.class);
		System.out.println(value);
		return value;
        
	}
	
	public String  OfferEligibility(String oic) throws JsonProcessingException
	{
		
		String payload;
		ObjectMapper mapper = new ObjectMapper();
		JsonDict Json = new JsonDict();
		Json.oic = oic;
		//Json.setProperty(oic, oic);
		payload =  mapper.writeValueAsString(Json);

		//System.out.println(payload);

		
		
		Response response =  Do_post("OfferEligibilityForm","Personal Loan",payload);
		
		
		String value = response.readEntity(String.class);
		System.out.println(value);
		changeworkexp();
		return value;
        
	}	
	public void  OfferEligibilityCheck(String oic,String type) throws JsonProcessingException
	{
		
		String payload,temp = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp = new JsonParser();
		JsonDict Json = new JsonDict();
		Json.oic = oic;
		//To get leadid
		JsonObject obj = jp.parse(Listoffer(oic)).getAsJsonObject();
		JsonArray temparray = obj.getAsJsonObject("data").getAsJsonArray("productFamily");
			
		System.out.println("****************************************");
		
		for (int i = 0; i < temparray.size(); i++)
		{ 
			System.out.println(temparray.get(i).getAsJsonObject().get("name").getAsString());
			System.out.println(temparray.get(i).getAsJsonObject().get("leadId").getAsNumber());
			//System.out.println(type);
			if (temparray.get(i).getAsJsonObject().get("shortName").getAsString().equals(type))
			{	temparray.get(i).getAsJsonObject().get("shortName").getAsString();
				Json.leadId = temparray.get(i).getAsJsonObject().get("leadId").getAsInt();
				 temp = temparray.get(i).getAsJsonObject().get("name").getAsString();
				 System.out.println(temp);
				System.out.println(Json.leadId);
				
			}
		}
		System.out.println("****************************************");
		
		Json.oic = oic;
		//Json.leadId = 2971664; 
		payload =  mapper.writeValueAsString(Json);

		System.out.println(payload);
		

		
		
		Response response =  Do_post("OfferEligibilityCheck",temp ,payload);
		String value = response.readEntity(String.class);
		System.out.println(value);
		//JsonObject EligibleOffers = EligibleOffers(value);
		
		JsonObject obj1 = jp.parse(value).getAsJsonObject();
		JsonArray temparray1 = obj1.getAsJsonObject("offers").getAsJsonArray("list");
		System.out.println(temparray1);
		for(int i=0; i<temparray1.size(); i++)
		{
			System.out.println(temparray1.get(i));
		}
		
	}		
	
	public void  changeworkexp()
	{
		String payload = "{\r\n" + 
				"  \"oic\": 9999,\r\n" + 
				"  \"leadId\": 2971664,\r\n" + 
				"  \"answers\":  {\r\n" + 
				"    \"questionId\": 18,\r\n" + 
				"    \"questionSlug\": \"employmentType:salaried__workExp\",\r\n" + 
				"    \"answer\": \"10\",\r\n" + 
				"    \"answerSlug\": 10\r\n" + 
				"  } \r\n" + 
				"}\r\n" + 
				"";
		System.out.println(payload);
		Response response = Do_post("temp",payload);
		String value = response.readEntity(String.class);
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
	
	public JsonObject EligibleOffers(String response)
	{ JsonObject eligibleoffers;
	JsonParser jp = new JsonParser();
	 eligibleoffers = jp.parse(response).getAsJsonObject().getAsJsonObject("offers");
	 System.out.println(eligibleoffers.getAsJsonArray("list").get(1));
	 return eligibleoffers;
		
	}

	
}
