import java.util.*;

class File {
    boolean isFile;
    Map<String, File> map;
    String content;
    public File(boolean isFile) {
        this.isFile = isFile;
        this.map = new HashMap<>();
        this.content = "";
    }
}

public class FileSystem {

    private File root;

    public FileSystem() {
        root = new File(false);
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        String[] segs = path.substring(1, path.length()).split("/");
        File curr = root;
        for (int i = 0; i < segs.length; i++) {
            String seg = segs[i];
            if (seg.length() == 0)
                continue;
            curr = curr.map.get(seg);
        }
        if (curr.isFile) {
            result.add(segs[segs.length - 1]);
        }
        else {
            for (String key : curr.map.keySet()) {
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        String[] segs = path.substring(1, path.length()).split("/");
        File curr = root;
        for (String seg : segs) {
            if (seg.length() == 0)
                continue;
            if (!curr.map.containsKey(seg)) {
                curr.map.put(seg, new File(false));
            }
            curr = curr.map.get(seg);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] segs = filePath.substring(1, filePath.length()).split("/");
        File curr = root;
        for (int i = 0; i < segs.length - 1; i++) {
            String seg = segs[i];
            curr = curr.map.get(seg);
        }
        if (!curr.map.containsKey(segs[segs.length - 1])) {
            curr.map.put(segs[segs.length - 1], new File(true));
        }
        curr = curr.map.get(segs[segs.length - 1]);
        curr.content += content;
    }

    public String readContentFromFile(String filePath) {
        String[] segs = filePath.substring(1, filePath.length()).split("/");
        File curr = root;
        for (int i = 0; i < segs.length; i++) {
            String seg = segs[i];
            curr = curr.map.get(seg);
        }
        return curr.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
