import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.realtime.RealtimePlayer;

public class midi extends JFrame implements ActionListener, Runnable {
	public JFrame frame;
	public JPanel pa;

	public btn j1, j2, j3, j4, j5, j6, j7, j8, j9, j10,j11,j12,j13,j14,j15,j16,j17;
	public btnb b1, b2, b3, b4, b5, b6, b7, b8, b9;
	public btn f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14;

	class btn extends JButton {
		public btn(String command, ActionListener a) {
			this.setActionCommand(command);
			this.addActionListener(a);
			this.setFocusable(false);
			this.setBorderPainted(false);
			this.setContentAreaFilled(false);
			this.setOpaque(true);
			this.setBackground(Color.white);

		}
	}

	class btnb extends JButton {
		public btnb(String command, ActionListener a) {
			this.setActionCommand(command);
			this.addActionListener(a);
			this.setFocusable(false);
			this.setBorderPainted(false);
			this.setContentAreaFilled(false);
			this.setOpaque(true);
			this.setBackground(Color.black);
		}

	}

	public midi() {

		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(925, 220);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				char a = e.getKeyChar();
				// TODO Auto-generated method stub
				if (a == 'a') {
					 
					j5.setBackground(Color.white);
					f5.setBackground(Color.white);
				}
				if (a == 's') {
					 
					j6.setBackground(Color.white);
					f6.setBackground(Color.white);
				}
				if (a == 'd') {
					 
					j7.setBackground(Color.white);
					f7.setBackground(Color.white);
				}
				if (a == 'f') {
					 
					j8.setBackground(Color.white);
					f8.setBackground(Color.white);
				}
				if (a == 'g') {
					 
					j9.setBackground(Color.white);
					f9.setBackground(Color.white);
				}
				if (a == 'h') {
				 
					j10.setBackground(Color.white);
					f10.setBackground(Color.white);
				}
				if (a == 'j') {
					 
					j11.setBackground(Color.white);
					f11.setBackground(Color.white);
				}
				if (a == 'k') {
					 
					j12.setBackground(Color.white);
					f12.setBackground(Color.white);
				}
				if (a == 'l') {
				 
					j13.setBackground(Color.white);
					f13.setBackground(Color.white);
				}
				if (a == ';') {
					 
					j14.setBackground(Color.white);
					f14.setBackground(Color.white);
				}
				if (a == 'i') {
				 
					j4.setBackground(Color.white);
					f4.setBackground(Color.white);
				}
				if (a == 'o') {
					 
					j3.setBackground(Color.white);
					f3.setBackground(Color.white);
				}
				if (a == 'p') {
					 
					j2.setBackground(Color.white);
					f2.setBackground(Color.white);
				}
				if (a == 'u') {
					 
					j1.setBackground(Color.white);
					f1.setBackground(Color.white);
				}
				 
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				char a = e.getKeyChar();
				if (a == 'a') {
					(new Thread(new c())).start();
					j5.setBackground(Color.gray);
					f5.setBackground(Color.gray);
				}
				if (a == 's') {
					(new Thread(new d())).start();
					j6.setBackground(Color.gray);
					f6.setBackground(Color.gray);
				}
				if (a == 'd') {
					(new Thread(new e())).start();
					j7.setBackground(Color.gray);
					f7.setBackground(Color.gray);
				}
				if (a == 'f') {
					(new Thread(new f())).start();
					j8.setBackground(Color.gray);
					f8.setBackground(Color.gray);
				}
				if (a == 'g') {
					(new Thread(new g())).start();
					j9.setBackground(Color.gray);
					f9.setBackground(Color.gray);
				}
				if (a == 'h') {
					(new Thread(new a())).start();
					j10.setBackground(Color.gray);
					f10.setBackground(Color.gray);
				}
				if (a == 'j') {
					(new Thread(new b())).start();
					j11.setBackground(Color.gray);
					f11.setBackground(Color.gray);
				}
				if (a == 'k') {
					(new Thread(new c6())).start();
					j12.setBackground(Color.gray);
					f12.setBackground(Color.gray);
				}
				if (a == 'l') {
					(new Thread(new d6())).start();
					j13.setBackground(Color.gray);
					f13.setBackground(Color.gray);
				}
				if (a == ';') {
					(new Thread(new e6())).start();
					j14.setBackground(Color.gray);
					f14.setBackground(Color.gray);
				}
				if (a == 'i') {
					(new Thread(new b4())).start();
					j4.setBackground(Color.gray);
					f4.setBackground(Color.gray);
				}
				if (a == 'o') {
					(new Thread(new a4())).start();
					j3.setBackground(Color.gray);
					f3.setBackground(Color.gray);
				}
				if (a == 'p') {
					(new Thread(new g4())).start();
					j2.setBackground(Color.gray);
					f2.setBackground(Color.gray);
				}
				if (a == 'u') {
					(new Thread(new f4())).start();
					j1.setBackground(Color.gray);
					f1.setBackground(Color.gray);
				}
				if (a == 't') {
					(new Thread(new gs())).start();
				}
				if (a == 'r') {
					(new Thread(new fs())).start();
				}
				if (a == 'e') {
					(new Thread(new es())).start();
				}
				if (a == 'w') {
					(new Thread(new ds())).start();
				}
				if (a == 'q') {
					(new Thread(new cs())).start();
				}
				if (a == '7') {
					(new Thread(new b4s())).start();
				}
				if (a == '8') {
					(new Thread(new a4s())).start();
				}
				if (a == '9') {
					(new Thread(new g4s())).start();
				}
			}
		});

		j1 = new btn("j1", this);
		j1.setBounds(0, 0, 50, 105);
		f1 = new btn("j1", this);
		f1.setBounds(0, 105, 63, 95);
		 

		j2 = new btn("j2", this);
		j2.setBounds(80, 0, 50, 105);
		f2 = new btn("j2", this);
		f2.setBounds(67, 105, 63, 95);
		 

		j3 = new btn("j3", this);
		j3.setBounds(132, 0, 50, 105);
		f3 = new btn("j3", this);
		f3.setBounds(132, 105, 63, 95);
		 
		j4 = new btn("j4", this);
		j4.setBounds(212, 0, 50, 105);
		f4 = new btn("j4", this);
		f4.setBounds(199, 105, 63, 95);

		j5 = new btn("j5", this);
		j5.setBounds(264, 0, 50, 105);
		f5 = new btn("j5", this);
		f5.setBounds(264, 105, 63, 95);

		j6 = new btn("j6", this);
		j6.setBounds(344, 0, 50, 105);
		f6 = new btn("j6", this);
		f6.setBounds(331, 105, 63, 95);

		j7 = new btn("j7", this);
		j7.setBounds(396, 0, 50, 105);
		f7 = new btn("j7", this);
		f7.setBounds(396, 105, 63, 95);
		
		j8 = new btn("j8", this);
		j8.setBounds(476, 0, 50, 105);
		f8 = new btn("j8", this);
		f8.setBounds(463, 105, 63, 95);
		 
		j9 = new btn("j9", this);
		j9.setBounds(528, 0, 50, 105);
		f9 = new btn("j9", this);
		f9.setBounds(528, 105, 63, 95);
		 
		j10 = new btn("j10", this);
		j10.setBounds(608, 0, 50, 105);
		f10 = new btn("j10", this);
		f10.setBounds(595, 105, 63, 95);
		
		j11 = new btn("j11", this);
		j11.setBounds(660, 0, 50, 105);
		f11 = new btn("j11", this);
		f11.setBounds(660, 105, 63, 95);
		
		j12 = new btn("j12", this);
		j12.setBounds(740, 0, 50, 105);
		f12 = new btn("j12", this);
		f12.setBounds(727, 105, 63, 95);
		
		j13 = new btn("j13", this);
		j13.setBounds(792, 0, 50, 105);
		f13 = new btn("j13", this);
		f13.setBounds(792, 105, 63, 95);
		
		j14 = new btn("j14", this);
		j14.setBounds(872, 0, 50, 105);
		f14 = new btn("j14", this);
		f14.setBounds(859, 105, 63, 95);
	 
		b1 = new btnb("b1", this);
		b1.setBounds(50, 0, 30, 105);
		
		b2 = new btnb("b2", this);
		b2.setBounds(182, 0, 30, 105);
		
		b3 = new btnb("b3", this);
		b3.setBounds(314, 0, 30, 105);
		
		b4 = new btnb("b4", this);
		b4.setBounds(446, 0, 30, 105);
		
		b5 = new btnb("b5", this);
		b5.setBounds(578, 0, 30, 105);
		
		b6 = new btnb("b6", this);
		b6.setBounds(710, 0, 30, 105);
		
		b7 = new btnb("b7", this);
		b7.setBounds(842, 0, 30, 105);
		
		 
		pa = new JPanel();
		pa.setLayout(null);
		pa.setBackground(Color.black);
		pa.setBounds(0, 0, 925, 200);

		pa.add(j1);
		pa.add(j2);
		pa.add(j3);
		pa.add(j4);
		pa.add(j5);
		pa.add(j6);
		pa.add(j7);
		pa.add(j8);
		pa.add(j9);
		pa.add(j10);
		pa.add(j11);
		pa.add(j12);
		pa.add(j13);
		pa.add(j14);
		
		pa.add(b1);
		pa.add(b2);
		pa.add(b3);
		pa.add(b4);
		pa.add(b5);
		pa.add(b6);
		pa.add(b7);
		 
		
		pa.add(f1);
		pa.add(f2);
		pa.add(f3);
		pa.add(f4);
		pa.add(f5);
		pa.add(f6);
		pa.add(f7);
		pa.add(f8);
		pa.add(f9);
		pa.add(f10);
		pa.add(f11);
		pa.add(f12);
		pa.add(f13);
		pa.add(f14);
		
		
		frame.add(pa);

		frame.setVisible(true);

	}

	class c extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			
			play.play("CW");
		}
	}

	class d extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("DW");
		}
	}

	class e extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("EW");
		}
	}

	class f extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("FW");
		}
	}

	class g extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("GW");
		}
	}

	class a extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("AW");
		}
	}

	class b extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("BW");
		}
	}

	class c6 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("C6W");
		}
	}
	
	class d6 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("D6W");
		}
	}
	
	class e6 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("E6W");
		}
	}
	
	class a4 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("A4W");
		}
	}
	
	class b4 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("B4W");
		}
	}
	
	class c4 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("C4W");
		}
	}
	
	class g4 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("G4W");
		}
	}
	
	class f4 extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("F4W");
		}
	}
	
	class gs extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("G#W");
		}
	}
	
	class cs extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("C#W");
		}
	}

	class ds extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("D#W");
		}
	}
	
	class es extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("E#W");
		}
	}
	
	class fs extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("F#W");
		}
	}
	
	class as extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("A#W");
		}
	}
	
	class a4s extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("A4#W");
		}
	}
	
	class b4s extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("B4#W");
		}
	}
	
	class g4s extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("G4#W");
		}
	}
	
	class bs extends Thread implements Runnable {
		public void run() {
			Player play = new Player();
			play.play("B#W");
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String arg = e.getActionCommand();
		if (arg.equals("j1")) {
			(new Thread(new f4())).start();

		}
		if (arg.equals("j2")) {
			(new Thread(new g4())).start();

		}
		if (arg.equals("j3")) {
			(new Thread(new a4())).start();

		}
		if (arg.equals("j4")) {
			(new Thread(new b4())).start();

		}
		if (arg.equals("j5")) {
			(new Thread(new c())).start();

		}
		if (arg.equals("j6")) {
			(new Thread(new d())).start();

		}
		if (arg.equals("j7")) {
			(new Thread(new e())).start();

		}
		if (arg.equals("j8")) {
			(new Thread(new f())).start();

		}
		if (arg.equals("j9")) {
			(new Thread(new g())).start();

		}
		if (arg.equals("j10")) {
			(new Thread(new a())).start();

		}
		if (arg.equals("j11")) {
			(new Thread(new b())).start();

		}
		if (arg.equals("j12")) {
			(new Thread(new c6())).start();

		}
		if (arg.equals("j13")) {
			(new Thread(new d6())).start();

		}
		if (arg.equals("j14")) {
			(new Thread(new e6())).start();

		}
		if (arg.equals("b1")) {
			(new Thread(new g4s())).start();

		}
		if (arg.equals("b2")) {
			(new Thread(new a4s())).start();

		}
		if (arg.equals("b3")) {
			(new Thread(new b4s())).start();

		}
		if (arg.equals("b4")) {
			(new Thread(new ds())).start();

		}
		if (arg.equals("b5")) {
			(new Thread(new es())).start();

		}
		if (arg.equals("b6")) {
			(new Thread(new fs())).start();

		}
		if (arg.equals("b7")) {
			(new Thread(new gs())).start();

		}
		if (arg.equals("b8")) {
			(new Thread(new as())).start();

		}
		if (arg.equals("b9")) {
			(new Thread(new bs())).start();

		}

	}

	public static void main(String[] args) throws MidiUnavailableException {
		// TODO Auto-generated method stub
		new midi();
		// Player mu = new Player();
		// mu.play("T120 I[Piano] A4 B4 C C C CW C C C4 C D D D D D D D D C4 G C C C G C G C C C C G C G C C C C D E E E E E F E DW C D E E E E E E E F E D C4 C D D D D D D D E D C C C D G F F E E D D C D D C D C D C F E E D D C C D EW F E GW C");
	 
	 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
