package com.ila.framework;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class hashmap<Key, Value> implements Map {
static final int DEFAULT_INITIAL_CAPACITY = 64;
	
	
	public void QSlugHash() {
		this.put("City", 1);
		this.put("dob", 2);
		this.put("gender", 42);
		this.put("residentialPincode", 50);
		this.put("employmentType", 3);
		this.put("employmentType:salaried__nth", 4);
		this.put("employmentType:salariedDoctor__nth", 4);
		this.put("salaryRecieveType:viaSalaryAccount__salaryAccount", 5);
		this.put("employmentType:salariedDoctor__salaryAccount", 5);
		this.put("employmentType:selfEmployedProfessional__professionType", 6);
		this.put("employmentType:selfEmployedBusiness__savingsAccount", 8);
		this.put("employmentType:selfEmployedProfessional__savingsAccount", 8);
		this.put("employmentType:selfEmployedBusiness__savingsAccount", 8);
		this.put("employmentType:selfEmployedBusiness__annualTurnOver", 10);
		this.put("employmentType:selfEmployedProfessional__annualTurnOver", 10);
		this.put("employmentType:selfEmployedBusiness__annualTurnOver",10);
		this.put("employmentType:salaried__company", 16);
		this.put( "employmentType:salaried__joiningDate", 17);
		this.put("employmentType:salariedDoctor__joiningDate", 17);
		this.put("employmentType:salaried__workExp", 18);
		this.put("employmentType:salariedDoctor__workExp", 18);
		this.put("employmentType:selfEmployedProfessional__currentBussinessDate", 19);
		this.put("employmentType:selfEmployedBusiness__currentBussinessDate", 19);	
		this.put("employmentType:selfEmployedBusiness__currentBussinessDate", 19);
		this.put("employmentType:selfEmployedBusiness__firmType", 20);
		this.put("employmentType:selfEmployedProfessional__firmType", 20);
		this.put("firmType:proprietor__itr", 22);
		this.put("firmType:partnershipFirm__itr", 22);
		this.put("firmType:individualPartner__itr", 22);
		this.put("firmType:privateLimitedCompany__itr", 22);
		this.put("firmType:proprietor__latestItrAudited", 23);
		this.put("firmType:partnershipFirm__latestItrAudited", 23);
		this.put("firmType:individualPartner__latestItrAudited", 23);
		this.put("firmType:privateLimitedCompany__latestItrAudited", 23);
		this.put("loanAmount", 43);
		this.put("employmentType:salariedDoctor__medicalQualification", 44);
		this.put("employmentType:salaried__officePincode", 52);
		this.put("employmentType:salaried__designation", 76);
		this.put("employmentType:selfEmployedBusiness__pat", 115);
		this.put("firmType:privateLimitedCompany__pat", 115);
		this.put("firmType:proprietor__pat", 115);
		this.put("firmType:partnershipFirm__pat", 115);
		this.put("firmType:individualPartner__pat", 115);
		this.put("employmentType:salaried__companyType", 137);
		this.put("employmentType:selfEmployedProfessional__loanPurpose", 170);
		this.put( "employmentType:selfEmployedBusiness__loanPurpose", 170);
		this.put( "employmentType:salaried__salaryRecieveType", 217);
																				
													
		//get the values
				System.out.println("****Questions:****");
				Collection<String> collectionValues = this.values();
				for(String s: collectionValues){
					System.out.println(s);
				}
							
				for(String s: collectionValues){
					System.out.println(s);
				}
	}
	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}
}
