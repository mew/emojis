package zone.nora.emojis;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmojiLoader {
    private static final Gson gson = new Gson();
    private static final HashMap<String, Emoji> EMOJI_MAP = new HashMap<>();

    public static void load(File emojisJson) throws IOException {
        JsonArray emojiArray = new JsonParser().parse(FileUtils.readFileToString(emojisJson)).getAsJsonArray();
        emojiArray.forEach(it -> {
            Emoji emoji = gson.fromJson(it, Emoji.class);
            EMOJI_MAP.put(emoji.getName(), emoji);
        });
    }

    private static boolean isEmoji(String str) {
        return EMOJI_MAP.containsKey(str);
    }

    public static void parseForEmojis(String text) {
        List<Emoji> emojis2 = new ArrayList<>();
        for (String possible : text.split(":")) {
            if (isEmoji(possible)) {
                emojis2.add(EMOJI_MAP.get(possible));
            }
        }
        for (Emoji emoji : emojis2) {
            int index = text.indexOf(":" + emoji.getName() + ":");
            if (index == -1) continue;
            text = text.replaceFirst(":" + emoji.getName() + ":", "  ");
            System.out.println(emoji.getName() + " -> " + emoji.getUnicode());
        }
        System.out.println(text);
    }
}
