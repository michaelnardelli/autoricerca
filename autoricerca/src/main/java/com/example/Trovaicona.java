package autoricerca.src.main.java.com.example;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Point;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.Scalar;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import static org.bytedeco.opencv.global.opencv_imgproc.TM_CCOEFF_NORMED;

public class Trovaicona {

    public static Point findIcon(String iconPath) throws AWTException {
        Robot robot = new Robot();

        // Cattura lo schermo
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenCapture = robot.createScreenCapture(screenRect);

        // Carica l'immagine dell'icona
        Mat icon = opencv_imgcodecs.imread(iconPath);

        // Converte l'immagine catturata in Mat
        Java2DFrameConverter java2DFrameConverter = new Java2DFrameConverter();
        OpenCVFrameConverter.ToMat converterToMat = new OpenCVFrameConverter.ToMat();
        Mat screenMat = converterToMat.convert(java2DFrameConverter.convert(screenCapture));

        // Template Matching
        Mat result = new Mat();
        opencv_imgproc.matchTemplate(screenMat, icon, result, TM_CCOEFF_NORMED);

        // Trova la posizione del migliore match
        org.bytedeco.opencv.opencv_core.Point minLoc = new org.bytedeco.opencv.opencv_core.Point();
        org.bytedeco.opencv.opencv_core.Point maxLoc = new org.bytedeco.opencv.opencv_core.Point();
        opencv_core.minMaxLoc(result, null, null, (org.bytedeco.opencv.opencv_core.Point) minLoc, (org.bytedeco.opencv.opencv_core.Point) maxLoc, null);

        // Restituisce il punto del miglior match
        return maxLoc;
    }
}
