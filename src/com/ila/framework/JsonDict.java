package com.ila.framework;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"source",
"phone_home",
"password",
"utm_source",
"utm_medium",
"utm_content",
"utm_term",
"utm_campaign",
"ip",
"pan",
"userId"
})
public class JsonDict {

@JsonProperty("source")
public String source;
@JsonProperty("phone_home")
public String phoneHome;
@JsonProperty("email_id")
public String emailid;
@JsonProperty("password")
public String password;
@JsonProperty("utm_source")
public String utmSource;
@JsonProperty("utm_medium")
public String utmMedium;
@JsonProperty("utm_content")
public String utmContent;
@JsonProperty("utm_term")
public String utmTerm;
@JsonProperty("utm_campaign")
public String utmCampaign;
@JsonProperty("ip")
public String ip;
@JsonProperty("pan")
public String pan;
@JsonProperty("userId")
public Integer userId;
@JsonProperty("oic")
public String oic;
@JsonProperty("leadId")
public Integer leadId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@Override
public String toString() {
return ToStringBuilder.reflectionToString(this);
}

@JsonAnyGetter
public Map<String, Object> getProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}