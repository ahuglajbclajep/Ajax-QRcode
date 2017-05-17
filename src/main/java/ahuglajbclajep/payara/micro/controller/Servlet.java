package ahuglajbclajep.payara.micro.controller;

import ahuglajbclajep.payara.micro.model.QRCode;
import com.google.zxing.WriterException;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/ajax")
public class Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        res.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("image/jpeg");

        try (OutputStream out = res.getOutputStream()) {
            ImageIO.write(QRCode.create(req.getReader().readLine()), "jpg", out);
        } catch (WriterException | IOException e) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
