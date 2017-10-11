package zhao.blog.managementsystem.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class matchName {
	public static void main(String[] args) throws Exception {
		test();
	}
	static String txtpath;
	static String folder;
	static StringBuffer msg = new StringBuffer();
	static JTextArea jTextArea = new JTextArea();
	static JTextField jField =  new JTextField("");
	static JTextField jField1 =  new JTextField("");
	static JButton tb = new JButton("选择文件");
	static JButton fb = new JButton("选择文件夹");
	static JButton mb = new JButton("匹配");
	static JScrollPane jb = new JScrollPane(jTextArea);
	static List<String> notMatchs = new ArrayList<String>();
	private static void test() throws Exception{
		final JFrame frame =new JFrame("名字匹配");
		frame.setResizable(false);
		frame.setLayout(null);;
		frame.setBounds(200, 200, 300,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
			}
		});
		final JFileChooser jChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		tb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jChooser.setFileSelectionMode(jChooser.FILES_ONLY);
				jChooser.showOpenDialog(frame);
				txtpath = jChooser.getSelectedFile().getPath();
				jField.setText(txtpath);
			}
		});
		fb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jChooser.setFileSelectionMode(jChooser.DIRECTORIES_ONLY);
				jChooser.showOpenDialog(frame);
				folder = jChooser.getSelectedFile().getPath();
				jField1.setText(folder);
			}
		});
		mb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					doMatch();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		tb.setBounds(10,10,100,30);
		jField.setBounds(10, 50,220,20);
		fb.setBounds(10,80,100,30);
		jField1.setBounds(10, 120,220,20);
		mb.setBounds(10,150,100,30);
		jTextArea.setBounds(10, 180, 260, 300);
		jb.setBounds(10, 180, 260, 300);
		frame.add(jField);
		frame.add(jField1);
		frame.add(tb);
		frame.add(fb);
		frame.add(mb);
		frame.add(jb);
		frame.setVisible(true);
	}
	
	private static void doMatch() throws Exception{
		long start = System.currentTimeMillis();
		File file = new File(txtpath);
		@SuppressWarnings("resource")
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] b = new byte[fileInputStream.available()];
		fileInputStream.read(b);
		String str = new String(b,"GBK");
		String[] strs = str.split("\r\n");
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> excluding = new ArrayList<String>();
		for (String string : strs) {
			names.add(string.replace(" ",""));
		}
		notMatchs = (List<String>)names.clone();
		File file2 = new File(folder);
		File[] files = file2.listFiles();
		A:
		for (File file3 : files) {
			push("["+file3.getName()+"]匹配中---->");
			for (String string : names) {
				if(file3.isDirectory() && file3.getName().replace(" ", "").equalsIgnoreCase(string)){
					push("结果:["+file3.getName()+"]已找到\r\n");
					notMatchs.remove(string);
					continue A;
				}
				else if(file3.isFile() && file3.getName().substring(0,file3.getName().lastIndexOf(".")).replace(" ", "").equalsIgnoreCase(string)){
					push("结果:["+file3.getName()+"]已找到\r\n");
					notMatchs.remove(string);
					continue A;
				}
			}
			excluding.add(file3.getName());
			push(file3.getName()+"没有匹配到!\r\n","e");
		}
		push("存在但没有匹配的信息:\r\n");
		for (String string : excluding) {
			push(string+"\r\n");
		}
		push("没有匹配到的人员信息:\r\n");	
		for (String string : notMatchs) {
			push(string+"\r\n");
		}
		long time = System.currentTimeMillis()-start;
		push("============\r\n");
		push("运行结果:耗时:"+time+"ms  \r\n共"+strs.length+"条\r\n,匹配成功"+(names.size()-excluding.size())+"条\r\n");
	}
	private static void push(String msgs,String... e) throws Exception{
		msg.append(msgs);
		if(e.length>0){
			jTextArea.setText("ERROR:>>>>>>>>>>>>");
		}
		jTextArea.setText(msg.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
