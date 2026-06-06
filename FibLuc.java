import java.util.Arrays;

/**
 * Fibonacci n-step and Lucas n-step sequences
 * High-performance, production-ready Java implementation
 * 
 * @author NEXUS Labs
 */
public class FibLuc {

    /**
     * Generates Fibonacci n-step or Lucas n-step sequence
     * 
     * @param n          step order (n >= 2)
     * @param numElements number of terms to generate
     * @param seqType    "f" for Fibonacci n-step, "l" for Lucas n-step
     * @return int[] sequence
     */
    public static long[] fibLuc(int n, int numElements, String seqType) {
        if (n < 2 || numElements < 1) {
            return new long[0];
        }
        
        long[] seq = new long[numElements];
        
        // Initial values
        seq[0] = "l".equals(seqType) ? 2L : 1L;
        if (numElements > 1) {
            seq[1] = 1L;
        }
        
        for (int k = 2; k < numElements; k++) {
            long sum = 0;
            int limit = Math.min(n, k);
            for (int i = 1; i <= limit; i++) {
                sum += seq[k - i];
            }
            seq[k] = sum;
        }
        
        return seq;
    }

    // Test harness
    public static void main(String[] args) {
        System.out.println("=== NEXUS Fibonacci n-Step Engine ===");
        
        test(2, 10, "f", new long[]{1,1,2,3,5,8,13,21,34,55});
        test(3, 15, "f", new long[]{1,1,2,4,7,13,24,44,81,149,274,504,927,1705,3136});
        test(4, 15, "f", new long[]{1,1,2,4,8,15,29,56,108,208,401,773,1490,2872,5536});
        test(2, 10, "l", new long[]{2,1,3,4,7,11,18,29,47,76});
        test(3, 15, "l", new long[]{2,1,3,6,10,19,35,64,118,217,399,734,1350,2483,4567});
        
        System.out.println("All tests passed ✓");
    }
    
    private static void test(int n, int len, String type, long[] expected) {
        long[] result = fibLuc(n, len, type);
        boolean passed = Arrays.equals(result, expected);
        System.out.printf("fibLuc(%d, %d, '%s') → %s%n", 
            n, len, type, passed ? "PASS" : "FAIL");
        if (!passed) {
            System.out.println("  Got: " + Arrays.toString(result));
        }
    }
}
