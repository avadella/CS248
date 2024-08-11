package Projects.assignment8;
//Jerry-Tac-Toe: A interactive GUI program that plays Jerry-Tac-Toe with the user.
//Written by Anna Vadella and Noah Baker
//AI is based off a random number generator 

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class buttons
{
	int x;
	int y;
	int size;
	Color color;

	public buttons(int x, int y, int size, Color color)
	{
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x,y, size, size);
	}

	public void setColor(Color color) 
	{ 
		this.color = color;
	}
}

class background extends JPanel
{
	buttons [] tacToe;
	int [] tacToeX =  new int [] {85, 317, 550, 155, 317, 480, 85, 317, 550};
	int [] tacToeY =  new int [] {85, 85, 85, 300, 300, 300, 515, 515, 515};

	public background()
	{
		setSize(750, 750);
		tacToe = new buttons[9];

		for(int i = 0; i < tacToe.length; i++)
			tacToe[i] = new buttons(tacToeX[i], tacToeY[i], 75, new Color(166,139,165));
	}

	public void change(int i, Color color)
	{
      tacToe[--i].setColor(color);
	  repaint();
	}

	public void paintComponent(Graphics g)
	{
		Color C1 = new Color(255, 194, 219);
		g.setColor(C1);
		g.fillRect(0, 0, 750, 750);

		Color C2 = new Color(166, 139, 165);
		g.setColor(C2);
		g.drawLine(100, 100, 600, 575);
		g.drawLine(100, 120, 575, 120);
		g.drawLine(100, 550, 575, 550);
		g.drawLine(100, 570, 575, 135);
		g.drawLine(160, 340, 500, 340);
		g.drawLine(120, 145, 200, 320);
		g.drawLine(200, 320, 100, 550);
		g.drawLine(575, 120, 525, 320);
		g.drawLine(515, 320, 575, 550);
		g.drawLine(350, 100, 200, 320);
		g.drawLine(350, 100, 515, 320);
		g.drawLine(200, 320, 350, 550);
		g.drawLine(515, 320, 350, 550);

		for(int i = 0; i < tacToe.length; i++)
			tacToe[i].draw(g);

		g.setColor(Color.white);
		Font myFont = new Font ("Times New Roman", 1, 30);
		g.setFont (myFont);
		g.drawString("1",115,130);
		g.drawString("2",347,130);
		g.drawString("3",580,130);
		g.drawString("4",185,347);
		g.drawString("5",347,347);
		g.drawString("6",510,347);
		g.drawString("7",115,563);
		g.drawString("8",347,563);
		g.drawString("9",580,563);
	}
}

class closer extends WindowAdapter
{
  public void windowClosing(WindowEvent e)
  {
    System.out.println("Closing window, thanks for playing!");
    System.exit(0);
  }
}

class BTS
{
	boolean boardFilled(char player, char [][] board)
	{
  	for (int i = 0; i < 3; i++) {
    	if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
		{
			return true;
    	}
  		if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
		{
			return true;
  		}
  		if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
		{
			return true;
  		}
		if (board[0][1] == player && board[1][0] == player && board[2][0] == player)
		{
			return true;
    	}
  		if (board[0][1] == player && board[1][2] == player && board[2][2] == player)
		{
			return true;
  		}
  		if (board[0][0] == player && board[1][0] == player && board[2][1] == player)
		{
			return true;
  		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
		{
			return true;
    	}
  		if (board[0][2] == player && board[1][2] == player && board[2][1] == player)
		{
			return true;
  		}
	}
		return false;
	}
	
	public int playermove(char[][] board, int i)
	{
			switch(i)
			{
				case 1:
					board[0][0]='X';
					return 1;
				case 2:
					board[0][1]='X';
					return 2;
				case 3:
					board[0][2]='X';
					return 3;
				case 4:
					board[1][0]='X';
					return 4;
				case 5:
					board[1][1]='X';
					return 5;
				case 6:
					board[1][2]='X';
					return 6;
				case 7:
					board[2][0]='X';
					return 7;
				case 8:
					board[2][1]='X';
					return 8;
				case 9:
					board[2][2]='X';
					return 9;
			}
			return 0;
		}
		
	public int computerMove(char [][] board)
	{
		int move = (int)(Math.random()*8)+1;
		switch(move)
			{
				case 1:
					if(board [0][0]==0)
					{
						board[0][0]='O';
						return 1;
					}
				case 2:
					if(board [0][1]==0)
					{
						board[0][1]='O';
						return 2;
					}
				case 3:
					if(board [0][2]==0)
					{
						board[0][2]='O';
						return 3;
					}
				case 4:
					if(board [1][0]==0)
					{
						board[1][0]='O';
						return 4;
					}
				case 5:
					if(board [1][1]==0)
					{
						board[1][1]='O';
						return 5;
					}
				case 6:
					if(board [1][2]==0)
					{
						board[1][2]='O';
						return 6;
					}
				case 7:
					if(board [2][0]==0)
					{
						board[2][0]='O';
						return 7;
					}
				case 8:
					if(board [2][1]==0)
					{
						board[2][1]='O';
						return 8;
					}
				case 9:
					if(board [2][2]==0)
					{
						board[2][2]='O';
						return 9;
					}
			}
		return computerMove(board);
	}
	
	char answer;
	
	//NOT IN USE
	public boolean first()
	{
		System.out.println("Who goes first, (C)omputer or (P)layer?");
		Scanner cin = new Scanner(System.in);
		answer = cin.next().charAt(0);
		if(answer == 'C')
			return false;
		else if(answer == 'P')
			return true;
		return true;
	}
}

class JerryTacToe extends JFrame implements ActionListener
{
	JButton move;
	JButton userButton;
	JButton computerButton;

	background back;

	JTextField input;

	JLabel header;
	JLabel instruction;

	Color userColor = new Color(92, 93, 103);
	Color computerColor = new Color(0, 0, 255);

	BTS work = new BTS();

	int count = 0;
	char[][] board = new char[3][3];
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == move)
		{
			int i;
			int move;
			//boolean gameover;
			i = Integer.parseInt(input.getText());
			if(++count < 10)
			{
				move = work.playermove(board,i);
				back.change(i, userColor);
				if(work.boardFilled('X', board) == true)
				{
					if(++count == 9)
					{
						System.out.println("It's a tie!");
					}
					else
					{
						System.out.println("Player Win!");
						count = 10;
					}
				}
			}
			
			if(++count < 10)
			{
				move = work.computerMove(board);
				back.change(move, computerColor);
				if(work.boardFilled('O', board) == true)
				{
					if(++count == 9)
					{
						System.out.println("It's a tie!");
					}
					else
					{
						System.out.println("Computer Win!");
						count = 10;
					}
				}
		 	}
		}
		else if(e.getSource() == userButton)
		{
			Color newColor = JColorChooser.showDialog(this, "Choose a color!", userColor);
			if (newColor != null)
				userColor = newColor;
		}
		else if(e.getSource() == computerButton)
		{
			Color newColor = JColorChooser.showDialog(this, "Choose a color!", computerColor);
			if (newColor != null)
				computerColor = newColor;
		}
		repaint();
	}
	
	public JerryTacToe()
	{
		addWindowListener(new closer());
		setTitle("Jerry-Tac-Toe.");
		setSize(750, 750);

		header = new JLabel("Welcome to Jerry Tac Toe. Have fun playing.");
		back = new background();
		input = new JTextField("1");
		move = new JButton("Submit move");
		userButton = new JButton("User Color");
		computerButton = new JButton("Computer Color");

		move.addActionListener(this);
		userButton.addActionListener(this);
		computerButton.addActionListener(this);

		java.awt.Container pane = getContentPane();
		pane.setLayout(new BorderLayout());

		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());

		top.add(input, "Center");
		top.add(move, "East");
		top.add(userButton, "West");

		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());

		bottom.add(computerButton, "West");

		pane.add(back, "Center");
		pane.add(top, "North");
		pane.add(bottom, "South");

		setVisible(true);
	}

	public static void main(String [] args)
	{
		JerryTacToe TacToe = new JerryTacToe();
	}
}