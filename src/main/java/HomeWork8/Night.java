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
public class Night implements Serializable
{
    @JsonProperty("IconPhrase")
    private String weather_text;
    @Override
    public String toString() {
        return "Ночью ожидается - " + weather_text;
    }
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7794709856751554012L;

    public Night() {
    }

    public Night(String weather_text) {
        super();

        this.weather_text = weather_text;
    }

    @JsonProperty("IconPhrase")
    public String getWeather_text() {
        return weather_text;
    }

    @JsonProperty("IconPhrase")
    public void setWeather_text(String iconPhrase) {
        this.weather_text = iconPhrase;
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