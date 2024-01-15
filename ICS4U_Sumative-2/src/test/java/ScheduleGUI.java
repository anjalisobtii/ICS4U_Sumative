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
                {"Name", list.get(3)[1]},
                {"Schedule", list.get(5)[1]},
                {"Total", list.get(8)[1]},
            };
            // for (int x = 0; x < 14; x++) {
            //     for (int i = 0; i < 5; i++) {
            //         System.out.print(list.get(x)[i] + "\n");
            //     }
            // }

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
        JFrame frame = new JFrame("Sample Output");
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
