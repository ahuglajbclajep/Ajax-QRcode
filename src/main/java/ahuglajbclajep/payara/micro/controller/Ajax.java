package ahuglajbclajep.payara.micro.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
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

    private BufferedImage createQR(String text) throws WriterException {
        final int size = 171 + 4*2;
        EnumMap<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
