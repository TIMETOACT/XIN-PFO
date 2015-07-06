import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiTest {

	public static void main(String[] args) {
		
		String[][] data = new String[2][1];
		data[0][0] = "Tom";
		data[1][0] = "Peter";
		String[] names = new String[]{"Name"};
		
		JTable table = new JTable(data,names);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		JScrollPane sp = new JScrollPane(table);
		
		final JFrame frame = new JFrame("Tracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0,1));
				
		frame.add(sp);
		frame.setVisible(true);
		frame.pack();	
		//Update
		String[][] temp= new String [data.length+1][1];
		for(int i=0; i<data.length; i++){
			temp[i][0] = data[i][0];
		}
		temp[data.length][0] = "Jan";
		data = temp;
		
		for(int i=0; i<data.length; i++){
			System.out.println(data[i][0]);
		}
		
		sp.getViewport().remove(table);
		JTable table2 = new JTable(data,names);
		table2.setPreferredScrollableViewportSize(table2.getPreferredSize());
		sp.getViewport().add(table2);
		frame.pack();
		}
}