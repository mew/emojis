package zone.nora.emojis.test;

import zone.nora.emojis.EmojiLoader;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        EmojiLoader.load(new File("output.json"));
        EmojiLoader.parseForEmojis(":transgender_flag: :flag_ru: :dab: :grin:");
    }
}
