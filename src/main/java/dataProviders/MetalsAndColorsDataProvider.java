package dataProviders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class MetalsAndColorsDataProvider {

    @DataProvider
    public static Object[][] metalsAndColorsDataProvider() {
        // TODO Take a look on TypeToken
        Object[][] result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/JDI_ex8_metalsColorsDataSet.json"));
            int size = jsonNode.size();
            result = new Object[size][1];
            for (int i = 0; i < size; i++) {
                JsonNode jsonNodeData = jsonNode.get("data_" + (i + 1));
                MetalsAndColorsData data = objectMapper.treeToValue(jsonNodeData, MetalsAndColorsData.class);
                result[i][0] = data;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
