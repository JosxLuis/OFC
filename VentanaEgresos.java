import javax.swing.*;
import java.awt.*;

public class VentanaEgresos extends JFrame {
    private PanelEgresos pe;
    public VentanaEgresos(){
        super("Egresos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pe=new PanelEgresos(this);
        this.add(pe);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        VentanaEgresos ve =new VentanaEgresos();
    }
}
