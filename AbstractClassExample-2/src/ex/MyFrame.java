package ex;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by vika on 21.10.16.
 */
public class MyFrame extends MyAbstractFrame {

    public MyFrame() throws HeadlessException {
        //super();
        jbAdd.setText("Add_One");
        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Кнопка Add нажата в MyFrame");
                clickAdd();
            }
        });
        jbEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickEdit();
            }
        });
        jbDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickDelete();
            }
        });
    }

    @Override
    public void clickAdd() {
        System.out.println("Кнопка Add нажата в MyFrame");
    }

    @Override
    public void clickDelete() {
        System.out.println("Кнопка Delete нажата в MyFrame");
    }

    @Override
    public void clickEdit() {
        //super.clickEdit();
        System.out.println("Кнопка Edit нажата в MyFrame");
    }
}
