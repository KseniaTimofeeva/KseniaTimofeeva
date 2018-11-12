package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import dto.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MetalsAndColorsDataProvider {

    @DataProvider
    public static Object[][] metalsAndColorsDataProvider() {
        Type type = new TypeToken<HashMap<String, MetalsAndColorsData>>() {
        }.getType();

        Object[][] result = null;
        JsonParser jsonParser = new JsonParser();
        try {
            JsonObject jsonNode = (JsonObject) jsonParser.parse(new FileReader(new File("src/main/resources/JDI_ex8_metalsColorsDataSet.json")));
            HashMap<String, MetalsAndColorsData> data = new Gson().fromJson(jsonNode.getAsJsonObject(), type);
            result = new Object[data.size()][1];

            int i = 0;
            for (Map.Entry<String, MetalsAndColorsData> entry : data.entrySet()) {
                result[i][0] = entry.getValue();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
