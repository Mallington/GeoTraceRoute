package com.company;


import java.io.Serializable;

public class LookupInfo implements Serializable {
    public	String	ip	;	//	IP used for the query
    public	boolean	success	;	//	true or false
    public	String	message	;	//	included only when success is false 
    public	String	type	;	//	IP address type (IPv4 or IPv6)
    public	String	continent	;	//	Continent name
    public	String	continent_code	;	//	Two-letter continent code
    public	String	country	;	//	Country name
    public	String	country_code	;	//	Two-letter country code
    public	String	country_capital	;	//	The capital of country
    public	String	country_phone	;	//	Country Phone Code
    public	String	country_neighbours	;	//	Neighboring countries
    public	String	region	;	//	Region/state
    public	String	city	;	//	City
    public	float	latitude	;	//	Latitude
    public	float	longitude	;	//	Longitude
    public	String	asn	;	//	AS number
    public	String	org	;	//	Organization name
    public	String	isp	;	//	ISP name
    public	String	timezone	;	//	City timezone
    public	String	timezone_name	;	//	Full time zone name
    public	int	timezone_dstOffset	;	//	The offset for daylight-savings time in seconds.
    public	int	timezone_gmtOffset	;	//	The offset from UTC (in seconds) for the given location.
    public	String	timezone_gmt	;	//	Timezone GMT.
    public	String	currency	;	//	Country currency name.
    public	String	currency_code	;	//	Country currency code.
    public	String	currency_symbol	;	//	Country currency symbol.
    public	float	currency_rates	;	//	The current exchange rate against the US dollar.
    public	String	currency_plural	;	//	Currency plural.
    public String country_flag; // URL for country flag

    //Extreme specific
    public String businessName; //e.g University of Bath
    public String ipType; //e.g education


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent_code() {
        return continent_code;
    }

    public void setContinent_code(String continent_code) {
        this.continent_code = continent_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_capital() {
        return country_capital;
    }

    public void setCountry_capital(String country_capital) {
        this.country_capital = country_capital;
    }

    public String getCountry_phone() {
        return country_phone;
    }

    public void setCountry_phone(String country_phone) {
        this.country_phone = country_phone;
    }

    public String getCountry_neighbours() {
        return country_neighbours;
    }

    public void setCountry_neighbours(String country_neighbours) {
        this.country_neighbours = country_neighbours;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getAsn() {
        return asn;
    }

    public void setAsn(String as) {
        this.asn = as;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public int getTimezone_dstOffset() {
        return timezone_dstOffset;
    }

    public void setTimezone_dstOffset(int timezone_dstOffset) {
        this.timezone_dstOffset = timezone_dstOffset;
    }

    public int getTimezone_gmtOffset() {
        return timezone_gmtOffset;
    }

    public void setTimezone_gmtOffset(int timezone_gmtOffset) {
        this.timezone_gmtOffset = timezone_gmtOffset;
    }

    public String getTimezone_gmt() {
        return timezone_gmt;
    }

    public void setTimezone_gmt(String timezone_gmt) {
        this.timezone_gmt = timezone_gmt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public float getCurrency_rates() {
        return currency_rates;
    }

    public void setCurrency_rates(float currency_rates) {
        this.currency_rates = currency_rates;
    }

    public String getCurrency_plural() {
        return currency_plural;
    }

    public void setCurrency_plural(String currency_plural) {
        this.currency_plural = currency_plural;
    }

    public String getCountry_flag() {
        return country_flag;
    }

    public void setCountry_flag(String country_flag) {
        this.country_flag = country_flag;
    }
}
