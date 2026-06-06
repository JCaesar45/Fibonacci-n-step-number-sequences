/**
 * Fibonacci n-step and Lucas n-step sequence generator
 * Pure, type-safe, efficient implementation
 */
export function fibLuc(n: number, numElements: number, seqType: 'f' | 'l'): number[] {
    if (n < 2 || numElements < 1) return [];
    
    const seq: number[] = new Array(numElements).fill(0);
    
    // Initial conditions
    seq[0] = seqType === 'l' ? 2 : 1;
    if (numElements > 1) {
        seq[1] = 1;
    }
    
    for (let k = 2; k < numElements; k++) {
        let sum = 0;
        const limit = Math.min(n, k);
        for (let i = 1; i <= limit; i++) {
            sum += seq[k - i];
        }
        seq[k] = sum;
    }
    
    return seq;
}

// Example usage + tests
if (import.meta.env?.DEV) {
    console.log("fibLuc(2,10,'f')", fibLuc(2, 10, 'f'));
    console.log("fibLuc(3,15,'f')", fibLuc(3, 15, 'f'));
    console.log("fibLuc(2,10,'l')", fibLuc(2, 10, 'l'));
}
