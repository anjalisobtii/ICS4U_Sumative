import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.awt.GridLayout;

public class ScheduleGUI extends JPanel {

    public ScheduleGUI() {
        super(new GridLayout(1, 0));

        String[] columnNames = {"Time",
                "Duty",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday"
        };

        Object[][] data = null; // Declare the data array outside the try block

        try {
            ArrayList<Object[]> list = new ArrayList<>(getSheets.fetchDataFromSheet());
            data = new Object[][]{
                {"11:25 am - 12:02 pm", "Cafeteria", list.get(0)[0], list.get(0)[1], list.get(0)[2], list.get(0)[3], list.get(0)[4]},
                {"", "Library", list.get(1)[0], list.get(1)[1], list.get(1)[2], list.get(1)[3], list.get(1)[4]},
                {"11:35 am - 12:12 pm", "Back Foyer & Art/ASD hallways", list.get(2)[0], list.get(2)[1], list.get(2)[2], list.get(2)[3], list.get(2)[4]},
                {"", "Front Foyer & Gym/Tech hallways", list.get(3)[0], list.get(3)[1], list.get(3)[2], list.get(3)[3], list.get(3)[4]},
                {"", "Library", list.get(4)[0], list.get(4)[1], list.get(4)[2], list.get(4)[3], list.get(4)[4]},
                {"11:38 am - 12:15 pm", "Gym/Weight Room", list.get(5)[0], list.get(5)[1], list.get(5)[2], list.get(5)[3], list.get(5)[4]},
                {"", "Student Services", list.get(6)[0], list.get(6)[1], list.get(6)[2], list.get(6)[3], list.get(6)[4]},
                {"", "Fornt & Back Foyer", list.get(7)[0], list.get(7)[1], list.get(7)[2], list.get(7)[3], list.get(7)[4]},
                {"", "Floor 2 & 3", list.get(8)[0], list.get(8)[1], list.get(8)[2], list.get(8)[3], list.get(8)[4]},
                {"", "Room 314", list.get(9)[0], list.get(9)[1], list.get(9)[2], list.get(9)[3], list.get(9)[4]},
                {"", "ASD", list.get(10)[0], list.get(10)[1], list.get(10)[2], list.get(10)[3], list.get(10)[4]},
                {"11:48 am - 12:25 pm", "Back Foyer & Art/ASD hallways", list.get(11)[0], list.get(11)[1], list.get(11)[2], list.get(11)[3], list.get(11)[4]},
                {"", "Front Foyer & Gym/Tech hallways", list.get(12)[0], list.get(12)[1], list.get(12)[2], list.get(12)[3], list.get(12)[4]},
                {"", "Cafeteria", list.get(13)[0], list.get(13)[1], list.get(13)[2], list.get(13)[3], list.get(13)[4]},
                {"", "Library", list.get(14)[0], list.get(14)[1], list.get(14)[2], list.get(14)[3], list.get(14)[4]}
            };
            
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
            System.out.println("error");
        }

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1300, 250));
        table.setFillsViewportHeight(true);
        table.setEnabled(false);

        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to this panel.
        add(scrollPane);
    }

    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Supervision Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        ScheduleGUI newContentPane = new ScheduleGUI();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
