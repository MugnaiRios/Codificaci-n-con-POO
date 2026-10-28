
package polizas.general;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import polizas.*;

public class Mensaje extends JPanel{
    Mensaje(){
        setLayout(new FlowLayout(FlowLayout.CENTER, 10,30));
        add(
        new JLabel(
        "Mensaje actializacion...", SwingConstants.CENTER
        )
        );
    }
    
}
