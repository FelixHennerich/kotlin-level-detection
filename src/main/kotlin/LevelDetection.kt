import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Scalar
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc

fun main() {
    // Lade das Bild
    val inputImage = Imgcodecs.imread("/Users/felix/Downloads/level-detection/Images/image1.png")

    // Überprüfe, ob das Bild erfolgreich geladen wurde
    if (inputImage.empty()) {
        println("Fehler beim Laden des Bildes.")
        return
    }

    // Konvertiere das Bild in Graustufen
    val grayImage = Mat()
    Imgproc.cvtColor(inputImage, grayImage, Imgproc.COLOR_BGR2GRAY)

    // Füge einen Text zum Bild hinzu
    /*Core.putText(
        inputImage,
        "Hello, OpenCV!",
        org.opencv.core.Point(50.0, 50.0),
        Core.FONT_HERSHEY_SIMPLEX,
        1.0,
        Scalar(0.0, 255.0, 0.0),
        2
    )*/

    // Zeige das Originalbild und das bearbeitete Bild an
    showImage("Original Image", inputImage)
    showImage("Gray Image", grayImage)

    // Warte auf eine Taste, um das Programm zu beenden
    System.`in`.read()
}

fun showImage(windowName: String, image: Mat) {
    // Erstelle ein Fenster
    org.opencv.highgui.HighGui.namedWindow(windowName, org.opencv.highgui.HighGui.WINDOW_NORMAL)

    // Zeige das Bild im Fenster an
    org.opencv.highgui.HighGui.imshow(windowName, image)

    // Warte auf eine Taste, um fortzufahren
    org.opencv.highgui.HighGui.waitKey(0)

    // Schließe das Fenster
    org.opencv.highgui.HighGui.destroyWindow(windowName)
}
