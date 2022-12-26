package HomeWork7;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;




@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

        "DailyForecasts"
})
@Generated("jsonschema2pojo")
public class Weather implements Serializable
{

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "" +

                "" + dailyForecasts;
    }

    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1215222368393267118L;

    public Weather() {
    }

    public Weather(List<DailyForecast> dailyForecasts) {
        super();

        this.dailyForecasts = dailyForecasts;
    }

    @JsonProperty("DailyForecasts")
    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    @JsonProperty("DailyForecasts")
    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
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
