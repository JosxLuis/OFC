import javax.swing.*;

public class VentanaMovimiento extends JFrame {
    private PanelMovimiento pm;
    public VentanaMovimiento(){
        super("Movimientos");
        this.pm=new PanelMovimiento(this);
        this.add(pm);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
