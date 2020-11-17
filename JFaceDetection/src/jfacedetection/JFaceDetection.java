package jfacedetection;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
public class JFaceDetection {
    public static void main(String[] args) {
       //Loading OpenCV core library 
       System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                //Reading image from file
		String imgFile = "D:/image2.jpg";
		Mat src = Imgcodecs.imread(imgFile);
                //Instantiating Cascade classifier
		String xmlFile = "xml/lbpcascade_frontalface.xml";
		CascadeClassifier cc = new CascadeClassifier(xmlFile);
                //Detecting face in snap
		MatOfRect faceDetection = new MatOfRect();
		cc.detectMultiScale(src, faceDetection);
		System.out.println(String.format("Detected faces: %d", faceDetection.toArray().length));
                //Drawing Boxes
		for(Rect rect: faceDetection.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height) , new Scalar(0, 0, 255), 3);
		}
                //Writing image
		Imgcodecs.imwrite("D:/image2_o.jpg", src);
		System.out.println("Image Detection Finished");
    }
}
