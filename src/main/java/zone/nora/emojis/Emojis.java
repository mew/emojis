package zone.nora.emojis;

import com.vdurmont.emoji.EmojiManager;

public class Emojis {
    public static void main(String[] args) {
        EmojiManager.getAll().forEach(it -> {
            System.out.println(it.getUnicode());󠁮󠁧󠁿
        });
    }
}
