package HomeWork8;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IconPhrase"
})
@Generated("jsonschema2pojo")
public class Day implements Serializable
{
    @Override
    public String toString() {
        return "Днем ожидается - " + weather_text;
    }

    @JsonProperty("IconPhrase")
    private String weather_text;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6472682498829028717L;

    public Day() {
    }

    public Day( String weather_text) {
        super();
        this.weather_text = weather_text;
    }

    @JsonProperty("IconPhrase")
    public String getWeather_text() {
        return weather_text;
    }

    @JsonProperty("IconPhrase")
    public void setWeather_text(String weather_text) {
        this.weather_text = weather_text;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
