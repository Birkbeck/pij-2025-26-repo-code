public class ArrayCopier {
    public void copy(int[] src, int[] dst) {
        // copy everything up to the last position that both arrays have
        int minLength = Math.min(src.length, dst.length);
        for (int i = 0; i < minLength; i++) {
            dst[i] = src[i];
        }
        // if dst has more positions, fill them with 0 entries
        for (int i = minLength; i < dst.length; i++) {
            dst[i] = 0; // overwrite old content with zeroes
        }
    }
}
