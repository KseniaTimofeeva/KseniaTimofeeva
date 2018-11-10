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

public class MetalsAndColorsDataProvider {

    @DataProvider
    public static Object[][] metalsAndColorsDataProvider() {
        Type type = new TypeToken<MetalsAndColorsData>() {
        }.getType();

        Object[][] result = null;
        JsonParser jsonParser = new JsonParser();
        try {
            JsonObject jsonNode = (JsonObject) jsonParser.parse(new FileReader(new File("src/main/resources/JDI_ex8_metalsColorsDataSet.json")));
            int size = jsonNode.size();
            result = new Object[size][1];
            for (int i = 0; i < size; i++) {
                MetalsAndColorsData data = new Gson().fromJson(jsonNode.getAsJsonObject("data_" + (i + 1)), type);
                result[i][0] = data;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
