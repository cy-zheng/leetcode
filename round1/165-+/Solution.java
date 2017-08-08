/*
    "1.0" = "1"
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null) return -1;
        if (version2 == null) return 1;
        
        String[] versionList1 = version1.split("\\.");
        String[] versionList2 = version2.split("\\.");
        
        int i1, i2;
        i1 = i2 = 0;
        
        while (i1 < versionList1.length && i2 < versionList2.length) {
            if (Integer.parseInt(versionList1[i1]) < Integer.parseInt(versionList2[i2]))
                return -1;
            else if (Integer.parseInt(versionList1[i1]) > Integer.parseInt(versionList2[i2]))
                return 1;
            i1++;
            i2++;
        }
        
        while (i1 < versionList1.length) {
            if (Integer.parseInt(versionList1[i1]) > 0)
                return 1;
            i1++;
        }
        while (i2 < versionList2.length) {
            if (Integer.parseInt(versionList2[i2]) > 0)
                return -1;
            i2++;
        }
        return 0;
    }
}