package zone.nora.emojis;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Emoji {
    @SerializedName("name")
    private String name = "null";
    @SerializedName("unicode")
    private String unicode = "null";
    @SerializedName("keywords")
    private List<String> keywords = new ArrayList<>();
    @SerializedName("skins")
    private List<String> skins = null;

    public String getName() {
        return name;
    }

    public String getUnicode() {
        return unicode;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public boolean supportsSkins() {
        return skins != null;
    }

    public List<String> getSkins() {
        return skins;
    }
}
