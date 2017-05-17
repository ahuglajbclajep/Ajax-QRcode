package ahuglajbclajep.payara.micro.model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.awt.image.BufferedImage;
import java.util.EnumMap;

public class QRCode {

    public static BufferedImage create(String contents) throws WriterException {
        // The width and height of the image are determined by first creating an image,
        // adding a margin (4*2 pixels), and comparing it with the specified length.
        final int SIZE = 200;

        return MatrixToImageWriter.toBufferedImage(
                new com.google.zxing.qrcode.QRCodeWriter().encode(contents, BarcodeFormat.QR_CODE, SIZE, SIZE,
                        new EnumMap<EncodeHintType, Object>(EncodeHintType.class) {
                            {
                                put(EncodeHintType.CHARACTER_SET, "UTF-8");
                            }
                        }
                )
        );
    }
}
