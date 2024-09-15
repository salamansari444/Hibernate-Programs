package in.ineuron.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String countryName;
	private String cityName;
	private String stateName;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "Address [countryName=" + countryName + ", cityName=" + cityName + ", stateName=" + stateName + "]";
	}

}
