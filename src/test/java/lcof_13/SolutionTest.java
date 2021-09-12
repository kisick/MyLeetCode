package lcof_13;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class SolutionTest extends TestCase {
    int[][] dp;
    int ans = 0;
    public int movingCount(int m, int n, int k) {
        dp = new int[m][n];
        dfs(0,0,m,n,k);
        return ans;
    }

    // (i,j) 表示本次访问的位置
    public void dfs(int i, int j, int m, int n, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || dp[i][j] != 0) {
            return;
        }
        if (!sum(i,j,k)) {
            dp[i][j] = -1;
            return;
        }
        dp[i][j] = 1;
        ans++;
        dfs(i-1,j,m,n,k);
        dfs(i+1,j,m,n,k);
        dfs(i,j-1,m,n,k);
        dfs(i,j+1,m,n,k);
    }

    @Test
    public void test() {
        int i = movingCount(11, 8, 16);
        assertEquals(i,88);
    }
    // i和j的数位之和大于k 则返回false， 否则返回true

    public boolean sum(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }


    @Test
    public void test5804() {
        int cap = 10;
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        assertEquals(n,15);
        assertTrue(areOccurrencesEqual("abacbc"));
        assertFalse(areOccurrencesEqual("aaabb"));
    }
    /**
     * 输入：s = "abacbc"
     * 输出：true
     * 解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
     *
     * 输入：s = "aaabb"
     * 输出：false
     * 解释：s 中出现过的字符为 'a' 和 'b' 。
     * 'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
     * @param s
     * @return
     */
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer integer = hashMap.get(s.charAt(i));
            if (integer != null) {
                integer++;
            } else {
                integer = 1;
            }
            hashMap.put(s.charAt(i),integer);
        }
        Integer i = hashMap.get(s.charAt(0));
        for (Integer value : hashMap.values()) {
            if (!value.equals(i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test5823() {
        int ans = getLucky("fleyctuuajsr", 5);
        assertEquals(ans,6);
    }

    public int getLucky(String s, int k) {
        s.charAt(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 96);
        }
        int ans = 0;
        while (k != 0) {
            ans = 0;
            for (int i = 0; i < sb.length(); i++) {
                ans += sb.charAt(i)-48;
            }
            k--;
            sb = new StringBuilder(String.valueOf(ans));
        }
        return ans;
    }


    @Test
    public void test5824() {
        String s = maximumNumber("132", new int[]{9,8,5,0,3,6,4,2,6,8});
        assertEquals(s,"832");
        assertEquals(maximumNumber("021", new int[]{9,4,3,5,7,2,1,9,0,6}),"934");
        assertEquals(maximumNumber("214010", new int[]{6,7,9,7,4,0,3,4,4,7}),"974676");
    }

    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder(num);
        boolean haveReplaced = false;
        for (int i = 0; i < sb.length(); i++) {
            if (haveReplaced && sb.charAt(i) - 48 > change[sb.charAt(i) - 48]) {
                break;
            }
            if (sb.charAt(i) - 48 < change[sb.charAt(i) - 48]) {
                // 需要替换
                sb.setCharAt(i,Character.forDigit((change[sb.charAt(i) - 48]),10));
                haveReplaced = true;
            }
        }
        return sb.toString();

    }

}
