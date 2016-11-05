package ex;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

/**
 * Данный абстрактный класс является предком для всех окон
 * Все окна-наследники имеют три кнопки,
 * два абстрактных метода, которые обязательно должны быть переопределены
 * в наследниках(нет тела) и один пустой метод(clickEdit)- тело есть, который необязательно переопределять в наследниках
 */
public abstract class MyAbstractFrame extends JFrame {
    JButton jbAdd;
    JButton jbDelete;
    JButton jbEdit;

    public MyAbstractFrame() throws HeadlessException {
        setTitle("Working with Excel");
        getContentPane().setLayout(new FlowLayout());
        this.jbAdd = new JButton("Add");
        add(jbAdd);
        this.jbDelete = new JButton("Delete");
        add(jbDelete);
        this.jbEdit = new JButton("Edit");
        add(jbEdit);
        setBounds(100, 100, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //this.frame = frame;
    }

    public abstract void clickAdd();

    public abstract void clickDelete();

    public void clickEdit() {
        System.out.println("Привет из абстрактного класса");
    }
}