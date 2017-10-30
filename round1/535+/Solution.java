import java.util.*;

public class Codec {
    
    private Random rand = new Random();
    private Map<String, String> map = new HashMap<>();
    

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = genRandStr();
        while (map.containsKey(key))
            key = genRandStr();
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] seg = shortUrl.split("/");
        String key = seg[seg.length - 1];
        return map.get(key);
    }
    
    private String genRandStr() {
        String result = "";
        for (int i = 0; i < 6; i++) {
            int rInt = rand.nextInt(62);
            if (rInt < 10)
                result += rInt;
            else if (rInt < 36)
                result += (char) (rInt - 10 + 'a');
            else
                result += (char) (rInt - 36 + 'A');
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));