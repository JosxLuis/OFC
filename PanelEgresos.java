import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PanelEgresos extends JPanel {
    private JButton mov;
    private VentanaEgresos ve;
    public PanelEgresos(VentanaEgresos ve){
        super();
        this.setPreferredSize(new Dimension(800,500));
        this.setLayout(null);
        this.ve=ve;
        this.mov=new JButton("Añadir movimiento");
        this.mov.setBounds(320,400,150,25);
        mov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ve.setVisible(false);
                VentanaMovimiento vm=new VentanaMovimiento();
                vm.setVisible(true);
            }
        });
        this.add(mov);
    }

    public void paintComponent(Graphics g){
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("Noviembre",320,50);
        g.setFont(new Font("Arial",0,18));
        g.drawString("Ganado: ",160,100);
        g.drawString("Siembra por Pastura: ",160,150);
        g.drawString("Siembra por Grano: ",160,200);
        g.drawString("Camioneta: ",160,250);
        g.drawString("Casa: ",160,300);
        try{
            BufferedReader br =new BufferedReader(new FileReader("datos.txt"));
            g.drawString("$ "+br.readLine(),550,100);
            g.drawString("$ "+br.readLine(),550,150);
            g.drawString("$ "+br.readLine(),550,200);
            g.drawString("$ "+br.readLine(),550,250);
            g.drawString("$ "+br.readLine(),550,300);
            br.close();
        }catch (FileNotFoundException ex){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
