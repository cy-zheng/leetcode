class Solution {
    public String pushDominoes(String dominoes) {
        int[] left = new int[dominoes.length()];
        int[] right = new int[dominoes.length()];
        int times = -1;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            char curr = dominoes.charAt(i);
            if (curr == 'L') {
                times = 0;
                left[i] = 0;
            } else if (curr == 'R') {
                times = -1;
                left[i] = -1;
            } else {
                if (times == -1) {
                    left[i] = -1;
                } else {
                    times += 1;
                    left[i] = times;
                }
            }
        }
        times = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            char curr = dominoes.charAt(i);
            if (curr == 'R') {
                times = 0;
                right[i] = 0;
            } else if (curr == 'L') {
                times = -1;
                right[i] = -1;
            } else {
                if (times == -1) {
                    right[i] = -1;
                } else {
                    times += 1;
                    right[i] = times;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            if (left[i] == -1 && right[i] == -1) {
                sb.append('.');
            } else if (left[i] == -1) {
                sb.append('R');
            } else if (right[i] == -1) {
                sb.append('L');
            } else if (left[i] < right[i]) {
                sb.append('L');
            } else if (left[i] > right[i]) {
                sb.append('R');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}
