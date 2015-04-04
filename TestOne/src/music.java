import java.io.*;

import javazoom.jl.player.advanced.jlap;
import javazoom.jl.decoder.Control;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

import com.google.code.mp3fenge.Mp3Fenge;
import com.google.code.mp3fenge.Mp3Info;

import javax.swing.*;
import javax.swing.text.html.ImageView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.applet.*;

import javax.sound.*;

import javazoom.jl.player.advanced.*;
import javazoom.jl.decoder.*;

public class music extends Thread implements Runnable, ActionListener {
	public InputStream f1;
	public BufferedInputStream bis;
	public AdvancedPlayer p3;
	public JFrame frame;
	public JButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8;
	public JPanel pa;
	public JTextArea jt_1;
	public JLabel jl_1, jl_2, jl_3, jl_4, jl_5, jl_6,jl_7,jl_8,notice;
	public Thread m3;
	public int len, flag, f4;
	private AudioDevice audio;
	public int f, flag2 = 0, f3 = 0;
	public long total, left;
	public static ArrayList<String> arr = new ArrayList<String>();
	String add, name;
	 

	public music() {
		// 创建按钮对象,并添加监听事件
		btn_1 = new JButton();
		btn_1.setActionCommand("Play");
		btn_2 = new JButton();
		btn_2.setActionCommand("Stop");
		btn_3 = new JButton();
		btn_3.setActionCommand("Pause");
		btn_4 = new JButton();
		btn_4.setActionCommand("Continue");
		btn_5 = new JButton();
		btn_5.setActionCommand("Add new Music");
		btn_6 = new JButton();
		btn_6.setActionCommand("Next Music");
		btn_7 = new JButton();
		btn_7.setActionCommand("Delete");
		btn_8 = new JButton();
		btn_8.setActionCommand("previous");
		btn_1.addActionListener(this);
		btn_2.addActionListener(this);
		btn_3.addActionListener(this);
		btn_4.addActionListener(this);
		btn_5.addActionListener(this);
		btn_6.addActionListener(this);
		btn_7.addActionListener(this);
		btn_8.addActionListener(this);

		// 设置按钮在面板中的位置以及大小
		btn_1.setBounds(90, 10, 57, 57);
		btn_2.setBounds(150, 10, 57, 57);
		btn_3.setBounds(90, 10, 57, 57);
		btn_4.setBounds(90, 10, 57, 57);
		btn_5.setBounds(330, 10, 57, 57);
		btn_4.setVisible(false);
		btn_6.setBounds(210, 10, 57, 57);
		btn_7.setBounds(270, 10, 57, 57);
		btn_8.setBounds(30, 10, 57, 57);

		// 以图片当成按钮，取消原来按钮的边框
		btn_1.setIcon(new ImageIcon("play.png"));
		btn_1.setContentAreaFilled(false);
		btn_1.setBorderPainted(false);

		btn_2.setIcon(new ImageIcon("stop.png"));
		btn_2.setContentAreaFilled(false);
		btn_2.setBorderPainted(false);

		btn_3.setIcon(new ImageIcon("pause.png"));
		btn_3.setContentAreaFilled(false);
		btn_3.setBorderPainted(false);

		btn_4.setIcon(new ImageIcon("play.png"));
		btn_4.setContentAreaFilled(false);
		btn_4.setBorderPainted(false);

		btn_5.setIcon(new ImageIcon("add.png"));
		btn_5.setContentAreaFilled(false);
		btn_5.setBorderPainted(false);

		btn_6.setIcon(new ImageIcon("next.png"));
		btn_6.setContentAreaFilled(false);
		btn_6.setBorderPainted(false);

		btn_7.setIcon(new ImageIcon("delete.png"));
		btn_7.setContentAreaFilled(false);
		btn_7.setBorderPainted(false);

		btn_8.setIcon(new ImageIcon("pre.png"));
		btn_8.setContentAreaFilled(false);
		btn_8.setBorderPainted(false);
		
		// 设置panel面板，设置标签的位置和字体
		frame = new JFrame();
		pa = new JPanel();
		pa.setLayout(null);
		pa.setBounds(0, 0, 650, 500);
		// pa.setBackground(Color.black);
		frame.setSize(650, 500);
		frame.setLayout(null);
		frame.setTitle("This is NogizakaZ's first java musicplayer");
		jt_1 = new JTextArea();
		jt_1.setBounds(350, 85, 250, 300);
		jt_1.setEditable(false);
		jt_1.setFont(new Font("Hiragino Maru Gothic ProN", 1, 15));
		jt_1.setOpaque(true);
		jl_1 = new JLabel();
		jl_1.setFont(new Font("Hiragino Maru Gothic ProN", 1, 20));
		jl_1.setBounds(30, 85 + 30, 300, 30);
		jl_1.setOpaque(true);
		jl_4 = new JLabel();
		jl_5 = new JLabel();
		jl_2 = new JLabel();
		jl_2.setOpaque(true);
		jl_3 = new JLabel();
		jl_3.setBounds(0, 70, 800, 3);
		jl_3.setOpaque(true);
		jl_2.setFont(new Font("Hiragino Maru Gothic ProN", 1, 20));
		jl_4.setFont(new Font("Hiragino Maru Gothic ProN", 1, 20));
		jl_5.setFont(new Font("Kozuka Mincho Pro", 1, 15));
		jl_5.setText("这是王一洲的超级播放器ver 1.0");
		jl_2.setBounds(30, 125 + 30, 300, 30);
		notice = new JLabel();
		notice.setOpaque(true);
		notice.setFont(new Font("Hiragino Maru Gothic ProN", 1, 20));
		notice.setBounds(110, 268, 200, 40);
		notice.setText(" Notice Here!");
//		notice.setBackground(Color.gray);
//		
//		jl_1.setBackground(Color.red);
//	    jl_2.setBackground(Color.black);
//		jl_4.setBackground(Color.green);
		jl_4.setBounds(30, 165 + 30, 300, 30);
		jl_4.setOpaque(true);
		jl_5.setOpaque(true);
		// jl_5.setBackground(Color.yellow);
		jl_5.setBounds(400, 15, 250, 40);
		jl_3.setBackground(Color.black);
	
		//设置装饰图片
		jl_6 = new JLabel();
		jl_7 = new JLabel();
		jl_8 = new JLabel();
		jl_6.setIcon(new ImageIcon("cd1.png"));
		jl_7.setIcon(new ImageIcon("cd2.png"));
		jl_8.setIcon(new ImageIcon("peo.png"));
		jl_6.setOpaque(true);
		jl_7.setOpaque(true);
		jl_8.setOpaque(true);
		jl_6.setBounds(30, 245, 78, 78);
		jl_7.setBounds(30, 245, 78, 78);
		jl_8.setBounds(560, 390, 78,78);
		jl_7.setVisible(false);
		
		// 添加按钮和标签
		frame.add(pa);
		pa.add(jt_1);
		pa.add(jl_1);
		pa.add(jl_2);
		pa.add(jl_3);
		pa.add(jl_4);
		pa.add(jl_5);
		pa.add(jl_6);
		pa.add(jl_7);
		pa.add(jl_8);
		pa.add(notice);
		pa.add("North", btn_1);
		pa.add("North", btn_2);
		pa.add("North", btn_3);
		pa.add("North", btn_4);
		pa.add("North", btn_5);
		pa.add("North", btn_6);
		pa.add("North", btn_7);
		pa.add("North", btn_8);
		jt_1.setText("Music List: " + "\n");
		btn_3.setVisible(false);
		frame.addWindowListener(new WindowAdapter() {
			public void close(WindowEvent e){
				System.exit(0);
			}
		});
		frame.setVisible(true);

	}

	public void run() {
	}

	// 设置事件响应
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		if (arg.equals("Play")) {
			btn_1.setVisible(false);
			btn_3.setVisible(true);
			jl_6.setVisible(false);
			jl_7.setVisible(true);
				try {
					mplay play = new mplay();
					Thread m3 = new Thread(play);
					// m3.setPriority(10);//设置权限
					m3.start();
					if (f4 == 1) {
						f3 = 1;
						(new Thread(new update())).start();
					} else {
						update up = new update();
						Thread m8 = new Thread(up);
						m8.start();
					}
			} catch (Exception e1) {

			}
		}
		if (arg.equals("Stop")) {
			btn_1.setVisible(true);
			btn_3.setVisible(false);
			jl_6.setVisible(true);
			jl_7.setVisible(false);
			f4 = 1;
			try {
				mstop stop = new mstop();
				Thread m4 = new Thread(stop);
				m4.start();
			} catch (Exception e2) {

			}
		}
		if (arg.equals("Pause")) {
			btn_3.setVisible(false);
			btn_4.setVisible(true);
			jl_6.setVisible(true);
			jl_7.setVisible(false);
				try {
					mpause pause = new mpause();
					Thread m5 = new Thread(pause);
					m5.start();
			} catch (Exception e3) {

			}
		}
		if (arg.equals("Continue")) {
			btn_4.setVisible(false);
			btn_3.setVisible(true);
				try {
					mcon con = new mcon();
					Thread m6 = new Thread(con);
					m6.start();
			} catch (Exception e5) {

			}
		}
		if (arg.equals("Add new Music")) {
			try {
				mnew m_new = new mnew();
				Thread m7 = new Thread(m_new);
				m7.start();
			} catch (Exception e6) {
			}
		}
		if (arg.equals("Next Music")) {
			try {
				mnext next = new mnext();
				Thread m9 = new Thread(next);
				m9.start();
			} catch (Exception e7) {
			}

		}
		if (arg.equals("Delete")) {
			try {
				(new Thread(new delete())).start();
			} catch (Exception e8) {
			}
		}
		if (arg.equals("previous")) {
			mpre pre = new mpre();
			Thread m10 = new Thread(pre);
			m10.start();
		}

	}
	
	//播放前一首
	class mpre extends Thread implements Runnable {
		public void run() {
			if (flag2 == 0) {
				flag2 = arr.size() - 1;
				p3.close();
				(new Thread(new mplay())).start();
			} else {
				flag2--;
				p3.close();
				(new Thread(new mplay())).start();
			}

		}
	}
	
	//删除当前播放的音乐，并播放下一首
	class delete extends Thread implements Runnable {

		public void run() {
			try {
				arr.remove(flag2);
				f3 = 1;
				p3.close();
				(new Thread(new update())).start();
				(new Thread(new mplay())).start();

			} catch (Exception e8) {

			}
		}
	}

	//播放下一首
	class mnext extends Thread implements Runnable {
		public void run() {
			if (flag2 == arr.size() - 1) {
				flag2 = 0;
				p3.close();
				(new Thread(new mplay())).start();
			} else {
				flag2++;
				p3.close();
				(new Thread(new mplay())).start();
			}

		}
	}

	//更新音乐列表
	class update extends Thread implements Runnable {
		public void run() {
			int ff = 0;
			if (f3 == 0) {
				for (ff = 0; ff < arr.size(); ff++) {
					Mp3Fenge mp11 = new Mp3Fenge(new File(arr.get(ff)));
					Mp3Info mp22 = mp11.getMp3Info();
					jt_1.append((ff + 1) + ". " + mp22.getTitle() + "\n");
				}
			} else {
				jt_1.setText(" ");
				jt_1.setText("Music List: " + "\n");
				for (ff = 0; ff < arr.size(); ff++) {
					Mp3Fenge mp11 = new Mp3Fenge(new File(arr.get(ff)));
					Mp3Info mp22 = mp11.getMp3Info();
					jt_1.append((ff + 1) + ". " + mp22.getTitle() + "\n");
				}
			}
		}
	}

	//添加音乐
	class mnew extends Thread implements Runnable {
		public void run() {
			FileDialog fi1 = new FileDialog(frame, "ADD", FileDialog.LOAD);
			fi1.setVisible(true);
			add = fi1.getDirectory();
			name = fi1.getFile();
			arr.add(add + name);
			f3 = 1;
			(new Thread(new update())).start();
		}
	}

	//暂停后继续播放
	class mcon extends Thread implements Runnable {
		public void run() {
			try {
				f1 = new FileInputStream(arr.get(flag2));
				f1.skip(total - left);
				bis = new BufferedInputStream(f1);
				p3 = new AdvancedPlayer(f1);
				p3.play();
			} catch (Exception e5) {
				
			}
		}
	}

	//暂停
	class mpause extends Thread implements Runnable {
		public void run() {
			try {
				left = f1.available();
				p3.close();
			} catch (Exception e4) {

			}
		}
	}

	//播放音乐
	class mplay extends Thread implements Runnable {
		public void run() {
			Mp3Fenge mp1 = new Mp3Fenge(new File(arr.get(flag2)));
			Mp3Info mp2 = mp1.getMp3Info();
			len = mp2.getTrackLength();
			jl_1.setText("Artist" + ":  " + mp2.getArtist());
			jl_2.setText("Title" + ":  " + mp2.getTitle());
			jl_4.setText("Album" + ":  " + mp2.getAlbum());
				try {
					f1 = new FileInputStream(arr.get(flag2));
					total = f1.available();
					bis = new BufferedInputStream(f1);
					p3 = new AdvancedPlayer(bis);
					p3.play();
						if (f1.available()==0) {
							if (flag2 == arr.size() - 1) {
								flag2 = 0;
								p3.close();
								(new Thread(new mplay())).start();
							} else {
								flag2++;
								(new Thread(new mplay())).start();
					}
				}
			} catch (Exception e2) {
				
			}
		}
	}

	//停止播放
	class mstop extends Thread implements Runnable {
		public void run() {
			try {
				p3.close();

			} catch (Exception e3) {

			}
		}
	}

	//主函数
	public static void main(String[] args) throws FileNotFoundException,JavaLayerException {
		music m1 = new music();
		arr.add("My Dearest.mp3");
		arr.add("桜.mp3");
		arr.add("高嶺の花子さん.mp3");
		 
	}
}
