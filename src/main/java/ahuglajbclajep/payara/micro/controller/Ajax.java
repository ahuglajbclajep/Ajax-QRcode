package ahuglajbclajep.payara.micro.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumMap;

@WebServlet("/ajax")
public class Ajax extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("image/jpeg");

        try (OutputStream out = res.getOutputStream()) {
            ImageIO.write(createQR(req.getReader().readLine()), "jpg", out);
        } catch (WriterException | IOException e) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private BufferedImage createQR(String contents) throws WriterException {
        // The width and height of the image are determined by first creating an image,
        // adding a margin (4*2 pixels), and comparing it with the specified length.
        final int SIZE = 200;

        return MatrixToImageWriter.toBufferedImage(
                new QRCodeWriter().encode(contents, BarcodeFormat.QR_CODE, SIZE, SIZE,
                        new EnumMap<EncodeHintType, Object>(EncodeHintType.class) {
                            {
                                put(EncodeHintType.CHARACTER_SET, "UTF-8");
                            }
                        }
                )
        );
    }
}
