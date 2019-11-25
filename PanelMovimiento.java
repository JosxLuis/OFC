import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PanelMovimiento extends JPanel {
    private String gan, sie, sieG, cam,cas;
    private JTextField tg;
    private JButton save;
    private VentanaMovimiento vm;
    public PanelMovimiento(VentanaMovimiento vm){
        super();
        this.vm=vm;
        try{
            BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
            //PrintWriter pw = new PrintWriter(new FileWriter("datos.txt"));
            this.gan=br.readLine();
            this.sie=br.readLine();
            this.sieG=br.readLine();
            this.cam=br.readLine();
            this.cas=br.readLine();
            this.setLayout(null);
            this.setPreferredSize(new Dimension(800,500));

            this.tg=new JTextField();
            tg.setBounds(550,100,100,20);
            this.add(tg);

            save=new JButton("Guardar");
            save.setBounds(320,400,150,25);
            this.add(save);

            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calcular();
                    vm.setVisible(false);
                    VentanaEgresos ve=new VentanaEgresos();
                    ve.setVisible(true);
                }
            });

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
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


            //g.drawString("$ "+br.readLine(),550,100);
            g.drawString("$ "+sie,550,150);
            g.drawString("$ "+sieG,550,200);
            g.drawString("$ "+cam,550,250);
            g.drawString("$ "+cas,550,300);


    }

    public void calcular(){
        try {
            String tmp = tg.getText();
            double t = Double.parseDouble(tmp);
            double g = Double.parseDouble(gan) + t;
            PrintWriter pw = new PrintWriter(new FileWriter("datos.txt"));
            pw.println(g);
            pw.println(sie);
            pw.println(sieG);
            pw.println(cam);
            pw.println(cas);
            pw.close();
        }catch(IOException ex){

        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Porfavor ingrese un numero");
        }

    }
}
