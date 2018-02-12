import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ByteUtils {

    public static byte[] compress(byte[] source) {
        byte[] compressed = new byte[1024];
        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
        deflater.setInput(source);
        deflater.finish();
        int totalCompressed = deflater.deflate(compressed);
        byte[] result = new byte[totalCompressed];
        System.arraycopy(compressed, 0, result, 0, totalCompressed);
        deflater.end();
        return result;
    }

    public static byte[] decompress(byte[] source) throws DataFormatException {
        byte[] decompressed = new byte[1024];
        Inflater inflater = new Inflater();
        inflater.setInput(source);
        int totalDecompressed = inflater.inflate(decompressed);
        byte[] result = new byte[totalDecompressed];
        System.arraycopy(decompressed, 0, result, 0, totalDecompressed);
        inflater.end();
        return result;
    }
}
