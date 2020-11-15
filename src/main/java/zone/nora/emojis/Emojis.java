package zone.nora.emojis;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Emojis {
    public static void main(String[] args) throws IOException {
        File input = new File("emojis.json");
        String contents = FileUtils.readFileToString(input);
        JsonObject obj = new JsonParser().parse(contents).getAsJsonObject();
        JsonArray newJson = new JsonArray();
        obj.entrySet().forEach(it -> {
            JsonArray array = it.getValue().getAsJsonArray();
            array.forEach(it_ -> {
                JsonObject emoji = it_.getAsJsonObject();
                String emojiName = emoji.get("name").getAsString().replace('-', '_');
                emoji.remove("name");
                emoji.addProperty("name", emojiName);
                newJson.add(emoji);
                System.out.println(emojiName);
            });
        });
        File output = new File("output.json");
        if (output.createNewFile()) {
            FileUtils.writeStringToFile(output, newJson.toString());
        } else {
            System.out.println(newJson.toString());
        }
    }
}
