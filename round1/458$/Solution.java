/*
    1000桶水，死亡时间15mins，测试时间1小时。需要至少死几头猪能找到有毒的水桶呢？
    对于每头猪，它应有5种状态：15min、30min、45min、60min死亡和活着，所以一头猪，至多可以检验5桶水。
    2头猪，则对应25桶水，3头猪对应125桶水。可以理解为5进制编码。
*/

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) return 0;  
        int base = minutesToTest / minutesToDie + 1;  
        int r = 1;  
        int i = 1;
        while (true) {  
            r *= base;  
            if (r >= buckets)  
                return i;
            i += 1;
        }  
    }
}