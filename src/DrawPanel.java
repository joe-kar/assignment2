import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // Just a single image, Done: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    // To keep track of a single car's position
    ArrayList<Point> carsPos = new ArrayList<>();
    ArrayList<String> carTypes = new ArrayList<>();

    // DONE: Make this general for all cars
    void moveit(int x, int y, String cartype, int count) {
        if (carsPos.size() <= count) {
            carsPos.add(new Point(x, y));
            carTypes.add(cartype);
        } else {
            carsPos.set(count, new Point(x, y));
            carTypes.set(count, cartype);
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // DONE: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < carTypes.size(); i++) {
            if (carTypes.get(i).equals("Volvo240")) {
                g.drawImage(volvoImage, carsPos.get(i).x, carsPos.get(i).y, null); // see javadoc for more info on the parameters
            } else if (carTypes.get(i).equals("Saab95")) {
                g.drawImage(saabImage, carsPos.get(i).x, carsPos.get(i).y, null);
            }
        }
    }
}
