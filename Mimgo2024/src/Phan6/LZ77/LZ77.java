package Phan6.LZ77;

import java.util.ArrayList;

public class LZ77 {
    /**
     * This function takes an input array t, the current position in the array,
     * and the size of the window. It returns the largest Occurrence found in the window.
     * Don't forget that the current character is not in the window.
     * @param t
     * @param currentPosition
     * @param windowSize
     * @return an occurrence
     */

    public static Occurrence longestOccurrence(int[] t, int currentPosition, int windowSize) {
        int maxLen = 0;
        int bestDistance = 0;

        for (int distance = 1; distance <= Math.min(windowSize, currentPosition); distance++) {
            int matchLen = 0;

            while (currentPosition + matchLen < t.length &&
                    t[currentPosition - distance + matchLen] == t[currentPosition + matchLen]) {
                matchLen++;
                if (matchLen >= windowSize) {
                    break;
                }
            }

            if (matchLen > maxLen) {
                maxLen = matchLen;
                bestDistance = distance;
            }
        }
        return new Occurrence(bestDistance, maxLen);
    }

    /**
     * Computes the length of the compressed array.
     * @param t
     * @param windowSize
     * @return the length of the compressed array.
     */
    public static int length(int[] t, int windowSize) {
        int totalLength = 0;
        int i = 0;

        while (i < t.length) {
            Occurrence occ = longestOccurrence(t, i, windowSize);
            totalLength += (occ.size > 0) ? 2 : 1; // 2 for (retour, size) + next symbol, 1 for just the symbol
            i += (occ.size > 0) ? occ.size + 1 : 1;
        }
        return totalLength;
    }

    /**
     * Compresses an array t.
     * @param t
     * @param windowSize
     * @return an array of Element.
     */
    public static Element[] compress(int[] t, int windowSize) {
        ArrayList<Element> compressed = new ArrayList<>();
        int i = 0;

        while (i < t.length) {
            Occurrence occ = longestOccurrence(t, i, windowSize);

            if (occ.size > 0) {
                int nextSymbol = (i + occ.size < t.length) ? t[i + occ.size] : -1;
                compressed.add(new Element(occ, nextSymbol));
                i += occ.size + 1;
            } else {
                compressed.add(new Element(new Occurrence(0, 0), t[i]));
                i++;
            }
        }
        return compressed.toArray(new Element[0]);
    }

    /**
     * Prints out the compression array.
     * @param t
     */
    public static void printCompression(Element[] t) {
        StringBuilder sb = new StringBuilder(1024);
        for (Element e : t) {
            sb.append(e.toString()).append(" ");
        }
        System.out.println(sb);
    }

    /**
     * Computes the length of the decompressed data, given the
     * compressed data.
     * @param t
     * @return a length
     */
    public static int lengthInverse(Element[] t) {
        int totalLength = 0;

        for (Element e : t) {
            totalLength += e.o.size > 0 ? e.o.size : 1; // size if there is a match, otherwise 1 for the symbol
        }
        return totalLength;
    }

    /**
     * Decompresses data.
     * @param t
     * @return an array representing decompressed data
     */
    public static int[] decompress(Element[] t) {
        ArrayList<Integer> decompressed = new ArrayList<>();

        for (Element e : t) {
            Occurrence o = e.o;
            int s = e.s;

            if (o.size > 0) {
                // Copy the matching substring from earlier in the decompressed data
                int startPos = decompressed.size() - o.retour;
                for (int i = 0; i < o.size; i++) {
                    decompressed.add(decompressed.get(startPos + i));
                }
            }

            // Add the next symbol if it exists
            if (s != -1) {
                decompressed.add(s);
            }
        }
        // Convert ArrayList to int[]
        return decompressed.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Copy the characters of array t1, going from start1 to start1 + len - 1
     * to the array t2, starting from position start2.
     * @param t1
     * @param t2
     * @param start1
     * @param len
     * @param start2
     */
    static void blit(int[] t1, int[] t2, int start1, int len, int start2) {
        for (int i = 0; i < len; i++) {
            t2[start2 + i] = t1[start1 + i];
        }
    }

    public static void printDecompression(int[] t) {
        for (int i : t) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
