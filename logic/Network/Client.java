package Network;

import java.net.*; 
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.LayoutStyle.ComponentPlacement;

import objects.*;

public class Client {
	private JFrame frmTestWindow;
	private JTextField NameField;
	private JTextField TotalValueField;
	private JTextField StateField;

	private JTextField Op1NameField;
	private JTextField Op1StateField;
	private JTextField Op1TotalValueField;
	private JTextField Op1ColorPanelField;

	private JTextField Op2NameField;
	private JTextField Op2StateField;
	private JTextField Op2ColorPanelField;
	private JTextField Op2TotalValueField;

	private JTextField Op3NameField;
	private JTextField Op3StateField;
	private JTextField Op3ColorPanelField;
	private JTextField Op3TotalValueField;

	private JTextField Op4NameField;
	private JTextField Op4StateField;
	private JTextField Op4ColorPanelField;
	private JTextField Op4TotalValueField;

	private JPanel Op1ColorPanel;
	private JPanel Op2ColorPanel;
	private JPanel Op3ColorPanel;
	private JPanel Op4ColorPanel;

	private JPanel PlayerPanel;
	private JPanel RedTokenPanel;
	private JPanel PurpleTokenPanel;
	private JPanel BlueTokenPanel;
	private JPanel GreenTokenPanel;
	private JPanel YellowTokenPanel;

	private JPanel OpponentsPanel;

	private JPanel Op1Panel;
	private JPanel Op2Panel;
	private JPanel Op3Panel;
	private JPanel Op4Panel;
	private JPanel OpTokensPanel;

	private JLabel Op1NameLabel;
	private JLabel Op2NameLabel;
	private JLabel Op3NameLabel;
	private JLabel Op4NameLabel;
	private JLabel Op1TokensNameLabel;

	private JLabel Op1StateLabel;
	private JLabel Op1CardLabel;
	private JLabel Op1TotalValueLabel;

	private JLabel Op2StateLabel;
	private JLabel Op2CardLabel;
	private JLabel Op2TotalValueLabel;

	private JLabel Op3StateLabel;
	private JLabel Op3CardLabel;
	private JLabel Op3TotalValueLabel;

	private JLabel Op4StateLabel;
	private JLabel Op4CardLabel;
	private JLabel Op4TotalValueLabel;

	private JPanel GameInfoPanel;
	private JLabel TokensLabel;
	private JLabel NameLabel;
	private JPanel TokensPanel;
	private JLabel TotalValueLabel;

	private JButton btnEndTurn;
	private JButton btnForfeit;
	private JButton btnDisplay;

	private ArrayList<String> PlayerIDs = new ArrayList<String>();
	private ArrayList<JButton> cardButtons = new ArrayList<JButton>();

	private ArrayList<JPanel> OpPanels = new ArrayList<JPanel>();
	private ArrayList<JPanel> OpColorPanels = new ArrayList<JPanel>();

	private ArrayList<JLabel> OpTokensNameLabels = new ArrayList<JLabel>();
	private ArrayList<ArrayList<JPanel>> OpTokensPanels = new ArrayList<ArrayList<JPanel>>();
	private ArrayList<JPanel> Op1TokensPanels = new ArrayList<JPanel>();
	private ArrayList<JPanel> Op2TokensPanels = new ArrayList<JPanel>();
	private ArrayList<JPanel> Op3TokensPanels = new ArrayList<JPanel>();
	private ArrayList<JPanel> Op4TokensPanels = new ArrayList<JPanel>();

	private ArrayList<JTextField> OpColorPanelFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> OpNameFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> OpStateFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> OpTotalValueFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> OpStunnedFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> OpShieldFields = new ArrayList<JTextField>();

	private String PLAYER_ID;

	private final Color HIGHLIGHT  = new Color(255, 215, 0);
	private final Color PLAIN  = new Color(240, 240, 240);
	private final Color ACTIVE = new Color(0, 255, 255);

	private JPanel Op1PurpleTokenPanel;
	private JPanel Op1RedTokenPanel;
	private JPanel Op1BlueTokenPanel;
	private JPanel Op1YellowTokenPanel;
	private JPanel Op1GreenTokenPanel;
	private JLabel Op2TokensNameLabel;
	private JPanel Op2TokensPanel;
	private JPanel Op2PurpleTokenPanel;
	private JPanel Op2RedTokenPanel;
	private JPanel Op2BlueTokenPanel;
	private JPanel Op2YellowTokenPanel;
	private JPanel Op2GreenTokenPanel;
	private JLabel Op3TokensNameLabel;
	private JPanel Op3TokensPanel;
	private JPanel Op3PurpleTokenPanel;
	private JPanel Op3RedTokenPanel;
	private JPanel Op3BlueTokenPanel;
	private JPanel Op3YellowTokenPanel;
	private JPanel Op3GreenTokenPanel;
	private JLabel Op4TokensNameLabel;
	private JPanel Op4TokensPanel;
	private JPanel Op4PurpleTokenPanel;
	private JPanel Op4RedTokenPanel;
	private JPanel Op4BlueTokenPanel;
	private JPanel Op4YellowTokenPanel;
	private JPanel Op4GreenTokenPanel;

	private JTextField Op1StunnedField;
	private JTextField Op1ShieldField;
	private JTextField Op2StunnedField;
	private JTextField Op2ShieldField;
	private JTextField Op3StunnedField;
	private JTextField Op3ShieldField;
	private JTextField Op4StunnedField;
	private JTextField Op4ShieldField;
	private JTextField myStunnedField;
	private JTextField myShieldField;
	private JLabel myNameLabel;

	private boolean firstTime = true;
	private int ID = 0;
	private Socket socket            = null;
	private ClientThread   client    = null;
	private ObjectInputStream input  = null;
	private ObjectOutputStream output = null;
	private Game game;
	private boolean testing;
	private String StringPassedIn;

	public Client (String serverName, int serverPort, boolean testing) 
	{
		Op1NameField = new JTextField();
		Op1StateField = new JTextField();
		Op1ColorPanel = new JPanel();
		Op1ColorPanelField = new JTextField();
		Op1TotalValueField = new JTextField();

		Op2NameField = new JTextField();
		Op2StateField = new JTextField();
		Op2ColorPanel = new JPanel();
		Op2ColorPanelField = new JTextField();
		Op2TotalValueField = new JTextField();

		Op3NameField = new JTextField();
		Op3StateField = new JTextField();
		Op3ColorPanel = new JPanel();
		Op3ColorPanelField = new JTextField();
		Op3TotalValueField = new JTextField();

		Op4NameField = new JTextField();
		Op4StateField = new JTextField();
		Op4ColorPanel = new JPanel();
		Op4ColorPanelField = new JTextField();
		Op4TotalValueField = new JTextField();

		PlayerPanel = new JPanel();
		RedTokenPanel = new JPanel();
		PurpleTokenPanel = new JPanel();
		BlueTokenPanel = new JPanel();
		GreenTokenPanel = new JPanel();
		YellowTokenPanel = new JPanel();

		frmTestWindow = new JFrame();
		frmTestWindow.setResizable(false);
		frmTestWindow.setTitle("Ivanhoe Client");
		frmTestWindow.setBounds(100, 100, 770, 536);
		frmTestWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestWindow.getContentPane().setLayout(null);

		OpponentsPanel = new JPanel();
		OpponentsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		OpponentsPanel.setBackground(new Color(250, 240, 230));
		OpponentsPanel.setBounds(10, 11, 741, 309);
		frmTestWindow.getContentPane().add(OpponentsPanel);
		frmTestWindow.getContentPane().add(PlayerPanel);

		Op1Panel = new JPanel();
		Op1Panel.setBounds(11, 12, 139, 280);
		Op1Panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		Op2Panel = new JPanel();
		Op2Panel.setBounds(156, 12, 139, 280);
		Op2Panel.setLayout(null);
		Op2Panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		Op2NameLabel = new JLabel("Name");
		Op2NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op2NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2NameLabel.setBounds(54, 6, 31, 15);
		Op2Panel.add(Op2NameLabel);

		Op2NameField.setHorizontalAlignment(SwingConstants.CENTER);
		Op2NameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2NameField.setEditable(false);
		Op2NameField.setColumns(10);
		Op2NameField.setBounds(16, 26, 106, 21);
		Op2Panel.add(Op2NameField);

		Op2StateLabel = new JLabel("State");
		Op2StateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op2StateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2StateLabel.setBounds(54, 52, 30, 15);
		Op2Panel.add(Op2StateLabel);

		Op2StateField.setHorizontalAlignment(SwingConstants.CENTER);
		Op2StateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2StateField.setEditable(false);
		Op2StateField.setColumns(10);
		Op2StateField.setBounds(16, 72, 106, 21);
		Op2Panel.add(Op2StateField);

		Op2CardLabel = new JLabel("Card");
		Op2CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op2CardLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2CardLabel.setBounds(57, 98, 24, 15);
		Op2Panel.add(Op2CardLabel);

		Op2ColorPanel.setLayout(null);
		Op2ColorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op2ColorPanel.setBounds(16, 114, 106, 50);
		Op2Panel.add(Op2ColorPanel);

		Op2ColorPanelField.setHorizontalAlignment(SwingConstants.CENTER);
		Op2ColorPanelField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2ColorPanelField.setEditable(false);
		Op2ColorPanelField.setColumns(10);
		Op2ColorPanelField.setBounds(15, 14, 75, 20);
		Op2ColorPanel.add(Op2ColorPanelField);

		Op2TotalValueLabel = new JLabel("Total Value");
		Op2TotalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op2TotalValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2TotalValueLabel.setBounds(16, 171, 106, 15);
		Op2Panel.add(Op2TotalValueLabel);

		Op2TotalValueField.setHorizontalAlignment(SwingConstants.CENTER);
		Op2TotalValueField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2TotalValueField.setEditable(false);
		Op2TotalValueField.setColumns(10);
		Op2TotalValueField.setBounds(16, 186, 106, 21);
		Op2Panel.add(Op2TotalValueField);

		Op3Panel = new JPanel();
		Op3Panel.setBounds(301, 12, 139, 280);
		Op3Panel.setLayout(null);
		Op3Panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		Op3NameLabel = new JLabel("Name");
		Op3NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op3NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3NameLabel.setBounds(54, 6, 31, 15);
		Op3Panel.add(Op3NameLabel);

		Op3NameField.setHorizontalAlignment(SwingConstants.CENTER);
		Op3NameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3NameField.setEditable(false);
		Op3NameField.setColumns(10);
		Op3NameField.setBounds(16, 26, 106, 21);
		Op3Panel.add(Op3NameField);

		Op3StateLabel = new JLabel("State");
		Op3StateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op3StateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3StateLabel.setBounds(54, 52, 30, 15);
		Op3Panel.add(Op3StateLabel);

		Op3StateField.setHorizontalAlignment(SwingConstants.CENTER);
		Op3StateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3StateField.setEditable(false);
		Op3StateField.setColumns(10);
		Op3StateField.setBounds(16, 72, 106, 21);
		Op3Panel.add(Op3StateField);

		Op3CardLabel = new JLabel("Card");
		Op3CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op3CardLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3CardLabel.setBounds(57, 98, 24, 15);
		Op3Panel.add(Op3CardLabel);

		Op3ColorPanel.setLayout(null);
		Op3ColorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op3ColorPanel.setBounds(16, 114, 106, 50);
		Op3Panel.add(Op3ColorPanel);

		Op3ColorPanelField.setHorizontalAlignment(SwingConstants.CENTER);
		Op3ColorPanelField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3ColorPanelField.setEditable(false);
		Op3ColorPanelField.setColumns(10);
		Op3ColorPanelField.setBounds(15, 14, 75, 20);
		Op3ColorPanel.add(Op3ColorPanelField);

		Op3TotalValueLabel = new JLabel("Total Value");
		Op3TotalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op3TotalValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3TotalValueLabel.setBounds(16, 171, 106, 15);
		Op3Panel.add(Op3TotalValueLabel);

		Op3TotalValueField.setHorizontalAlignment(SwingConstants.CENTER);
		Op3TotalValueField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3TotalValueField.setEditable(false);
		Op3TotalValueField.setColumns(10);
		Op3TotalValueField.setBounds(16, 186, 106, 21);
		Op3Panel.add(Op3TotalValueField);

		Op4Panel = new JPanel();
		Op4Panel.setBounds(446, 12, 139, 280);
		Op4Panel.setLayout(null);
		Op4Panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		Op4NameLabel = new JLabel("Name");
		Op4NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op4NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4NameLabel.setBounds(54, 6, 31, 15);
		Op4Panel.add(Op4NameLabel);

		Op4NameField.setHorizontalAlignment(SwingConstants.CENTER);
		Op4NameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4NameField.setEditable(false);
		Op4NameField.setColumns(10);
		Op4NameField.setBounds(16, 26, 106, 21);
		Op4Panel.add(Op4NameField);

		Op4StateLabel = new JLabel("State");
		Op4StateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op4StateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4StateLabel.setBounds(54, 52, 30, 15);
		Op4Panel.add(Op4StateLabel);

		Op4StateField.setHorizontalAlignment(SwingConstants.CENTER);
		Op4StateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4StateField.setEditable(false);
		Op4StateField.setColumns(10);
		Op4StateField.setBounds(16, 72, 106, 21);
		Op4Panel.add(Op4StateField);

		Op4CardLabel = new JLabel("Card");
		Op4CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op4CardLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4CardLabel.setBounds(57, 98, 24, 15);
		Op4Panel.add(Op4CardLabel);

		Op4ColorPanel.setLayout(null);
		Op4ColorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op4ColorPanel.setBounds(16, 114, 106, 50);
		Op4Panel.add(Op4ColorPanel);

		Op4ColorPanelField.setHorizontalAlignment(SwingConstants.CENTER);
		Op4ColorPanelField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4ColorPanelField.setEditable(false);
		Op4ColorPanelField.setColumns(10);
		Op4ColorPanelField.setBounds(15, 14, 75, 20);
		Op4ColorPanel.add(Op4ColorPanelField);

		Op4TotalValueLabel = new JLabel("Total Value");
		Op4TotalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op4TotalValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4TotalValueLabel.setBounds(16, 171, 106, 15);
		Op4Panel.add(Op4TotalValueLabel);

		Op4TotalValueField.setHorizontalAlignment(SwingConstants.CENTER);
		Op4TotalValueField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4TotalValueField.setEditable(false);
		Op4TotalValueField.setColumns(10);
		Op4TotalValueField.setBounds(16, 186, 106, 21);
		Op4Panel.add(Op4TotalValueField);

		OpTokensPanel = new JPanel();
		OpTokensPanel.setBounds(591, 12, 139, 280);
		OpTokensPanel.setLayout(null);
		OpTokensPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

		Op1TokensNameLabel = new JLabel("Name");
		Op1TokensNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op1TokensNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1TokensNameLabel.setBounds(16, 6, 106, 15);
		OpTokensPanel.add(Op1TokensNameLabel);

		JPanel Op1TokensPanel = new JPanel();
		FlowLayout fl_Op1TokensPanel = (FlowLayout) Op1TokensPanel.getLayout();
		fl_Op1TokensPanel.setVgap(1);
		fl_Op1TokensPanel.setHgap(2);
		Op1TokensPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op1TokensPanel.setBounds(16, 21, 106, 21);
		OpTokensPanel.add(Op1TokensPanel);

		Op1PurpleTokenPanel = new JPanel();
		Op1PurpleTokenPanel.setBackground(Color.MAGENTA);
		FlowLayout fl_Op1PurpleTokenPanel = (FlowLayout) Op1PurpleTokenPanel.getLayout();
		fl_Op1PurpleTokenPanel.setVgap(8);
		fl_Op1PurpleTokenPanel.setHgap(9);
		Op1TokensPanel.add(Op1PurpleTokenPanel);

		Op1RedTokenPanel = new JPanel();
		Op1RedTokenPanel.setBackground(Color.RED);
		FlowLayout fl_Op1RedTokenPanel = (FlowLayout) Op1RedTokenPanel.getLayout();
		fl_Op1RedTokenPanel.setVgap(8);
		fl_Op1RedTokenPanel.setHgap(9);
		Op1TokensPanel.add(Op1RedTokenPanel);

		Op1BlueTokenPanel = new JPanel();
		Op1BlueTokenPanel.setBackground(Color.BLUE);
		FlowLayout fl_Op1BlueTokenPanel = (FlowLayout) Op1BlueTokenPanel.getLayout();
		fl_Op1BlueTokenPanel.setVgap(8);
		fl_Op1BlueTokenPanel.setHgap(9);
		Op1TokensPanel.add(Op1BlueTokenPanel);

		Op1YellowTokenPanel = new JPanel();
		Op1YellowTokenPanel.setBackground(Color.YELLOW);
		FlowLayout fl_Op1YellowTokenPanel = (FlowLayout) Op1YellowTokenPanel.getLayout();
		fl_Op1YellowTokenPanel.setVgap(8);
		fl_Op1YellowTokenPanel.setHgap(9);
		Op1TokensPanel.add(Op1YellowTokenPanel);

		Op1GreenTokenPanel = new JPanel();
		Op1GreenTokenPanel.setBackground(Color.GREEN);
		FlowLayout fl_Op1GreenTokenPanel = (FlowLayout) Op1GreenTokenPanel.getLayout();
		fl_Op1GreenTokenPanel.setVgap(8);
		fl_Op1GreenTokenPanel.setHgap(9);
		Op1TokensPanel.add(Op1GreenTokenPanel);

		Op2TokensNameLabel = new JLabel("Name");
		Op2TokensNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op2TokensNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2TokensNameLabel.setBounds(16, 53, 106, 15);
		OpTokensPanel.add(Op2TokensNameLabel);

		Op2TokensPanel = new JPanel();
		FlowLayout fl_Op2TokensPanel = (FlowLayout) Op2TokensPanel.getLayout();
		fl_Op2TokensPanel.setVgap(1);
		fl_Op2TokensPanel.setHgap(2);
		Op2TokensPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op2TokensPanel.setBounds(16, 68, 106, 21);
		OpTokensPanel.add(Op2TokensPanel);

		Op2PurpleTokenPanel = new JPanel();
		FlowLayout fl_Op2PurpleTokenPanel = (FlowLayout) Op2PurpleTokenPanel.getLayout();
		fl_Op2PurpleTokenPanel.setVgap(8);
		fl_Op2PurpleTokenPanel.setHgap(9);
		Op2PurpleTokenPanel.setBackground(Color.MAGENTA);
		Op2TokensPanel.add(Op2PurpleTokenPanel);

		Op2RedTokenPanel = new JPanel();
		FlowLayout fl_Op2RedTokenPanel = (FlowLayout) Op2RedTokenPanel.getLayout();
		fl_Op2RedTokenPanel.setVgap(8);
		fl_Op2RedTokenPanel.setHgap(9);
		Op2RedTokenPanel.setBackground(Color.RED);
		Op2TokensPanel.add(Op2RedTokenPanel);

		Op2BlueTokenPanel = new JPanel();
		FlowLayout fl_Op2BlueTokenPanel = (FlowLayout) Op2BlueTokenPanel.getLayout();
		fl_Op2BlueTokenPanel.setVgap(8);
		fl_Op2BlueTokenPanel.setHgap(9);
		Op2BlueTokenPanel.setBackground(Color.BLUE);
		Op2TokensPanel.add(Op2BlueTokenPanel);

		Op2YellowTokenPanel = new JPanel();
		FlowLayout fl_Op2YellowTokenPanel = (FlowLayout) Op2YellowTokenPanel.getLayout();
		fl_Op2YellowTokenPanel.setVgap(8);
		fl_Op2YellowTokenPanel.setHgap(9);
		Op2YellowTokenPanel.setBackground(Color.YELLOW);
		Op2TokensPanel.add(Op2YellowTokenPanel);

		Op2GreenTokenPanel = new JPanel();
		FlowLayout fl_Op2GreenTokenPanel = (FlowLayout) Op2GreenTokenPanel.getLayout();
		fl_Op2GreenTokenPanel.setVgap(8);
		fl_Op2GreenTokenPanel.setHgap(9);
		Op2GreenTokenPanel.setBackground(Color.GREEN);
		Op2TokensPanel.add(Op2GreenTokenPanel);

		Op3TokensNameLabel = new JLabel("Name");
		Op3TokensNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op3TokensNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3TokensNameLabel.setBounds(16, 100, 106, 15);
		OpTokensPanel.add(Op3TokensNameLabel);

		Op3TokensPanel = new JPanel();
		FlowLayout fl_Op3TokensPanel = (FlowLayout) Op3TokensPanel.getLayout();
		fl_Op3TokensPanel.setVgap(1);
		fl_Op3TokensPanel.setHgap(2);
		Op3TokensPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op3TokensPanel.setBounds(16, 115, 106, 21);
		OpTokensPanel.add(Op3TokensPanel);

		Op3PurpleTokenPanel = new JPanel();
		FlowLayout fl_Op3PurpleTokenPanel = (FlowLayout) Op3PurpleTokenPanel.getLayout();
		fl_Op3PurpleTokenPanel.setVgap(8);
		fl_Op3PurpleTokenPanel.setHgap(9);
		Op3PurpleTokenPanel.setBackground(Color.MAGENTA);
		Op3TokensPanel.add(Op3PurpleTokenPanel);

		Op3RedTokenPanel = new JPanel();
		FlowLayout fl_Op3RedTokenPanel = (FlowLayout) Op3RedTokenPanel.getLayout();
		fl_Op3RedTokenPanel.setVgap(8);
		fl_Op3RedTokenPanel.setHgap(9);
		Op3RedTokenPanel.setBackground(Color.RED);
		Op3TokensPanel.add(Op3RedTokenPanel);

		Op3BlueTokenPanel = new JPanel();
		FlowLayout fl_Op3BlueTokenPanel = (FlowLayout) Op3BlueTokenPanel.getLayout();
		fl_Op3BlueTokenPanel.setVgap(8);
		fl_Op3BlueTokenPanel.setHgap(9);
		Op3BlueTokenPanel.setBackground(Color.BLUE);
		Op3TokensPanel.add(Op3BlueTokenPanel);

		Op3YellowTokenPanel = new JPanel();
		FlowLayout fl_Op3YellowTokenPanel = (FlowLayout) Op3YellowTokenPanel.getLayout();
		fl_Op3YellowTokenPanel.setVgap(8);
		fl_Op3YellowTokenPanel.setHgap(9);
		Op3YellowTokenPanel.setBackground(Color.YELLOW);
		Op3TokensPanel.add(Op3YellowTokenPanel);

		Op3GreenTokenPanel = new JPanel();
		FlowLayout fl_Op3GreenTokenPanel = (FlowLayout) Op3GreenTokenPanel.getLayout();
		fl_Op3GreenTokenPanel.setVgap(8);
		fl_Op3GreenTokenPanel.setHgap(9);
		Op3GreenTokenPanel.setBackground(Color.GREEN);
		Op3TokensPanel.add(Op3GreenTokenPanel);

		Op4TokensNameLabel = new JLabel("Name");
		Op4TokensNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op4TokensNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4TokensNameLabel.setBounds(16, 147, 106, 15);
		OpTokensPanel.add(Op4TokensNameLabel);

		Op4TokensPanel = new JPanel();
		FlowLayout fl_Op4TokensPanel = (FlowLayout) Op4TokensPanel.getLayout();
		fl_Op4TokensPanel.setVgap(1);
		fl_Op4TokensPanel.setHgap(2);
		Op4TokensPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op4TokensPanel.setBounds(16, 162, 106, 21);
		OpTokensPanel.add(Op4TokensPanel);

		Op4PurpleTokenPanel = new JPanel();
		FlowLayout fl_Op4PurpleTokenPanel = (FlowLayout) Op4PurpleTokenPanel.getLayout();
		fl_Op4PurpleTokenPanel.setVgap(8);
		fl_Op4PurpleTokenPanel.setHgap(9);
		Op4PurpleTokenPanel.setBackground(Color.MAGENTA);
		Op4TokensPanel.add(Op4PurpleTokenPanel);

		Op4RedTokenPanel = new JPanel();
		FlowLayout fl_Op4RedTokenPanel = (FlowLayout) Op4RedTokenPanel.getLayout();
		fl_Op4RedTokenPanel.setVgap(8);
		fl_Op4RedTokenPanel.setHgap(9);
		Op4RedTokenPanel.setBackground(Color.RED);
		Op4TokensPanel.add(Op4RedTokenPanel);

		Op4BlueTokenPanel = new JPanel();
		FlowLayout fl_Op4BlueTokenPanel = (FlowLayout) Op4BlueTokenPanel.getLayout();
		fl_Op4BlueTokenPanel.setVgap(8);
		fl_Op4BlueTokenPanel.setHgap(9);
		Op4BlueTokenPanel.setBackground(Color.BLUE);
		Op4TokensPanel.add(Op4BlueTokenPanel);

		Op4YellowTokenPanel = new JPanel();
		FlowLayout fl_Op4YellowTokenPanel = (FlowLayout) Op4YellowTokenPanel.getLayout();
		fl_Op4YellowTokenPanel.setVgap(8);
		fl_Op4YellowTokenPanel.setHgap(9);
		Op4YellowTokenPanel.setBackground(Color.YELLOW);
		Op4TokensPanel.add(Op4YellowTokenPanel);

		Op4GreenTokenPanel = new JPanel();
		FlowLayout fl_Op4GreenTokenPanel = (FlowLayout) Op4GreenTokenPanel.getLayout();
		fl_Op4GreenTokenPanel.setVgap(8);
		fl_Op4GreenTokenPanel.setHgap(9);
		Op4GreenTokenPanel.setBackground(Color.GREEN);
		Op4TokensPanel.add(Op4GreenTokenPanel);
		OpponentsPanel.setLayout(null);

		Op1Panel.setLayout(null);
		Op1NameLabel = new JLabel("Name");
		Op1NameLabel.setBounds(54, 6, 31, 15);
		Op1NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op1NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1Panel.add(Op1NameLabel);

		Op1NameField.setBounds(16, 26, 106, 21);
		Op1NameField.setHorizontalAlignment(SwingConstants.CENTER);
		Op1NameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1NameField.setEditable(false);
		Op1NameField.setColumns(10);
		Op1Panel.add(Op1NameField);

		Op1StateLabel = new JLabel("State");
		Op1StateLabel.setBounds(54, 52, 30, 15);
		Op1StateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op1StateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1Panel.add(Op1StateLabel);

		Op1StateField.setBounds(16, 72, 106, 21);
		Op1StateField.setHorizontalAlignment(SwingConstants.CENTER);
		Op1StateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1StateField.setEditable(false);
		Op1StateField.setColumns(10);
		Op1Panel.add(Op1StateField);

		Op1CardLabel = new JLabel("Card");
		Op1CardLabel.setBounds(57, 98, 24, 15);
		Op1CardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op1CardLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1Panel.add(Op1CardLabel);

		Op1ColorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Op1ColorPanel.setBounds(16, 114, 106, 50);
		Op1Panel.add(Op1ColorPanel);
		Op1ColorPanel.setLayout(null);

		Op1ColorPanelField.setBounds(15, 14, 75, 20);
		Op1ColorPanelField.setHorizontalAlignment(SwingConstants.CENTER);
		Op1ColorPanelField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1ColorPanelField.setEditable(false);
		Op1ColorPanelField.setColumns(10);
		Op1ColorPanel.add(Op1ColorPanelField);

		Op1TotalValueLabel = new JLabel("Total Value");
		Op1TotalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Op1TotalValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1TotalValueLabel.setBounds(16, 171, 106, 15);
		Op1Panel.add(Op1TotalValueLabel);

		Op1TotalValueField.setHorizontalAlignment(SwingConstants.CENTER);
		Op1TotalValueField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1TotalValueField.setEditable(false);
		Op1TotalValueField.setColumns(10);
		Op1TotalValueField.setBounds(16, 186, 106, 21);
		Op1Panel.add(Op1TotalValueField);
		OpponentsPanel.add(Op1Panel);

		Op1StunnedField = new JTextField();
		Op1StunnedField.setText("Stunned");
		Op1StunnedField.setHorizontalAlignment(SwingConstants.CENTER);
		Op1StunnedField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1StunnedField.setEditable(false);
		Op1StunnedField.setColumns(10);
		Op1StunnedField.setBounds(16, 218, 106, 21);
		Op1Panel.add(Op1StunnedField);

		Op1ShieldField = new JTextField();
		Op1ShieldField.setText("Shield");
		Op1ShieldField.setHorizontalAlignment(SwingConstants.CENTER);
		Op1ShieldField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op1ShieldField.setEditable(false);
		Op1ShieldField.setColumns(10);
		Op1ShieldField.setBounds(16, 250, 106, 21);
		Op1Panel.add(Op1ShieldField);
		OpponentsPanel.add(Op2Panel);

		Op2StunnedField = new JTextField();
		Op2StunnedField.setText("Stunned");
		Op2StunnedField.setHorizontalAlignment(SwingConstants.CENTER);
		Op2StunnedField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2StunnedField.setEditable(false);
		Op2StunnedField.setColumns(10);
		Op2StunnedField.setBounds(16, 218, 106, 21);
		Op2Panel.add(Op2StunnedField);

		Op2ShieldField = new JTextField();
		Op2ShieldField.setText("Shield");
		Op2ShieldField.setHorizontalAlignment(SwingConstants.CENTER);
		Op2ShieldField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op2ShieldField.setEditable(false);
		Op2ShieldField.setColumns(10);
		Op2ShieldField.setBounds(16, 250, 106, 21);
		Op2Panel.add(Op2ShieldField);
		OpponentsPanel.add(Op3Panel);

		Op3StunnedField = new JTextField();
		Op3StunnedField.setText("Stunned");
		Op3StunnedField.setHorizontalAlignment(SwingConstants.CENTER);
		Op3StunnedField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3StunnedField.setEditable(false);
		Op3StunnedField.setColumns(10);
		Op3StunnedField.setBounds(16, 218, 106, 21);
		Op3Panel.add(Op3StunnedField);

		Op3ShieldField = new JTextField();
		Op3ShieldField.setText("Shield");
		Op3ShieldField.setHorizontalAlignment(SwingConstants.CENTER);
		Op3ShieldField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op3ShieldField.setEditable(false);
		Op3ShieldField.setColumns(10);
		Op3ShieldField.setBounds(16, 250, 106, 21);
		Op3Panel.add(Op3ShieldField);
		OpponentsPanel.add(Op4Panel);

		Op4StunnedField = new JTextField();
		Op4StunnedField.setText("Stunned");
		Op4StunnedField.setHorizontalAlignment(SwingConstants.CENTER);
		Op4StunnedField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4StunnedField.setEditable(false);
		Op4StunnedField.setColumns(10);
		Op4StunnedField.setBounds(16, 218, 106, 21);
		Op4Panel.add(Op4StunnedField);

		Op4ShieldField = new JTextField();
		Op4ShieldField.setText("Shield");
		Op4ShieldField.setHorizontalAlignment(SwingConstants.CENTER);
		Op4ShieldField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Op4ShieldField.setEditable(false);
		Op4ShieldField.setColumns(10);
		Op4ShieldField.setBounds(16, 250, 106, 21);
		Op4Panel.add(Op4ShieldField);
		OpponentsPanel.add(OpTokensPanel);

		myStunnedField = new JTextField();
		myStunnedField.setText("Stunned");
		myStunnedField.setHorizontalAlignment(SwingConstants.CENTER);
		myStunnedField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		myStunnedField.setEditable(false);
		myStunnedField.setColumns(10);
		myStunnedField.setBounds(16, 223, 106, 21);
		OpTokensPanel.add(myStunnedField);

		myShieldField = new JTextField();
		myShieldField.setText("Shield");
		myShieldField.setHorizontalAlignment(SwingConstants.CENTER);
		myShieldField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		myShieldField.setEditable(false);
		myShieldField.setColumns(10);
		myShieldField.setBounds(16, 248, 106, 21);
		OpTokensPanel.add(myShieldField);

		myNameLabel = new JLabel("Name");
		myNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		myNameLabel.setBounds(16, 204, 106, 15);
		OpTokensPanel.add(myNameLabel);

		PlayerPanel.setBackground(new Color(245, 245, 220));
		PlayerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayerPanel.setBounds(10, 351, 741, 146);

		GameInfoPanel = new JPanel();
		GameInfoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GameInfoPanel.setBounds(10, 320, 741, 31);
		frmTestWindow.getContentPane().add(GameInfoPanel);
		GameInfoPanel.setLayout(null);

		TokensLabel = new JLabel("Tokens");
		TokensLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TokensLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TokensLabel.setBounds(212, 0, 57, 31);
		GameInfoPanel.add(TokensLabel);

		NameLabel = new JLabel("Name");
		NameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NameLabel.setBounds(565, 0, 44, 31);
		GameInfoPanel.add(NameLabel);

		NameField = new JTextField();
		NameField.setHorizontalAlignment(SwingConstants.CENTER);
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NameField.setEditable(false);
		NameField.setColumns(10);
		NameField.setBounds(608, 5, 123, 20);
		GameInfoPanel.add(NameField);

		TokensPanel = new JPanel();
		TokensPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TokensPanel.setBounds(269, 0, 170, 31);
		GameInfoPanel.add(TokensPanel);
		TokensPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 1));

		PurpleTokenPanel.setBackground(Color.MAGENTA);
		FlowLayout fl_PurpleTokenPanel = (FlowLayout) PurpleTokenPanel.getLayout();
		fl_PurpleTokenPanel.setVgap(13);
		fl_PurpleTokenPanel.setHgap(15);
		TokensPanel.add(PurpleTokenPanel);

		RedTokenPanel.setBackground(Color.RED);
		FlowLayout fl_RedTokenPanel = (FlowLayout) RedTokenPanel.getLayout();
		fl_RedTokenPanel.setVgap(13);
		fl_RedTokenPanel.setHgap(15);
		TokensPanel.add(RedTokenPanel);

		BlueTokenPanel.setBackground(Color.BLUE);
		FlowLayout fl_BlueTokenPanel = (FlowLayout) BlueTokenPanel.getLayout();
		fl_BlueTokenPanel.setVgap(13);
		fl_BlueTokenPanel.setHgap(15);
		TokensPanel.add(BlueTokenPanel);

		YellowTokenPanel.setBackground(Color.YELLOW);
		FlowLayout fl_YellowTokenPanel = (FlowLayout) YellowTokenPanel.getLayout();
		fl_YellowTokenPanel.setVgap(13);
		fl_YellowTokenPanel.setHgap(15);
		TokensPanel.add(YellowTokenPanel);

		GreenTokenPanel.setBackground(Color.GREEN);
		FlowLayout fl_GreenTokenPanel = (FlowLayout) GreenTokenPanel.getLayout();
		fl_GreenTokenPanel.setVgap(13);
		fl_GreenTokenPanel.setHgap(15);
		TokensPanel.add(GreenTokenPanel);

		btnForfeit = new JButton("FORFEIT");
		btnForfeit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnForfeit.setForeground(new Color(255, 255, 255));
		btnForfeit.setBackground(Color.BLACK);
		btnForfeit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("About to Call Forfiet");
				game.update(getMyIndex(), false);
				try{sendGame();}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		PlayerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		PlayerPanel.add(btnForfeit);

		btnEndTurn = new JButton("END TURN");
		btnEndTurn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEndTurn.setBackground(Color.WHITE);
		btnEndTurn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("About End Turn");
				game.update(getMyIndex(), true);
				try{sendGame();}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		PlayerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		PlayerPanel.add(btnEndTurn);

		btnDisplay = new JButton("DISPLAY");
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDisplay.setBackground(Color.cyan);
		btnDisplay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0)
			{	showDisplay(getMyIndex());	}
		});
		PlayerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		PlayerPanel.add(btnDisplay);

		TotalValueLabel = new JLabel("Total Value");
		TotalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TotalValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TotalValueLabel.setBounds(438, 0, 78, 31);
		GameInfoPanel.add(TotalValueLabel);

		TotalValueField = new JTextField();
		TotalValueField.setHorizontalAlignment(SwingConstants.CENTER);
		TotalValueField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TotalValueField.setEditable(false);
		TotalValueField.setColumns(10);
		TotalValueField.setBounds(513, 5, 45, 20);
		GameInfoPanel.add(TotalValueField);

		JLabel StateLabel = new JLabel("State");
		StateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StateLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		StateLabel.setBounds(33, 7, 45, 15);
		GameInfoPanel.add(StateLabel);

		StateField = new JTextField();
		StateField.setHorizontalAlignment(SwingConstants.CENTER);
		StateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		StateField.setEditable(false);
		StateField.setColumns(10);
		StateField.setBounds(75, 5, 114, 21);
		GameInfoPanel.add(StateField);

		initOpPlayers();
		initUser();
		this.testing = testing;
		if(!testing) frmTestWindow.setVisible(true);

		System.out.println("Before createConnection():");
		createConnection(serverName,serverPort);
		open();
	}

	public void createConnection (String serverName,Integer serverPort) {
		System.out.println(ID + ": Establishing server connection. Please wait ...");
		try {
			this.socket = new Socket(serverName, serverPort);
			this.ID = socket.getLocalPort();

			if (client == null) {
				client = new ClientThread(this, socket);
			}
			System.out.printf("%d : Connected to %s:%d\n", ID, socket.getInetAddress(), socket.getLocalPort());//this doesn't print!
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void open () {           
		try {  
			output = new ObjectOutputStream(socket.getOutputStream());

			if(!testing){
				String name = JOptionPane.showInputDialog("Please enter name");
				//Object o = "Client Initialized";
				Object o = name;
				
				PLAYER_ID = name;
				output.writeObject(o);
				output.flush();
			}
			/*
			Object o = "Client";//
			output.writeObject(o);
			output.flush();
			*/
		} catch(IOException ioe) {  
			ioe.printStackTrace();
			stop();
		}
	}
	public Socket getSocket(){
		return socket;
	}

	public void handle (Object msg) {//FIX THIS: it should send the new game object to the gui
		if (msg instanceof Game) {  
			game = (Game)msg;//setGameState
			update(game);
		}
		else if(msg instanceof String){
			this.StringPassedIn = (String)msg;
		}

	}
	public String StringPassedIn(){
		return StringPassedIn;
	}

	public void sendGame()throws Exception{//change name of this function
		output.writeObject(game);
		output.flush();

	}


	public void stop() 
	{  
		try 
		{ 
			if (client != null) client = null;
			if (input != null) input.close();
			if (output != null) output.close();
			if (socket != null) socket.close();
			this.socket = null;
			this.input = null;
			this.output = null;    	  
		} catch(IOException ioe) {  
			ioe.printStackTrace();
		}
		client.close();  
	}

	private void showDisplay(int id)
	{
		String[] display = new String[game.getPlayerArray().get(id).getDisplay().size()];
		for(int i=0; i < display.length; i++)	
		{
			if(game.getPlayerArray().get(id).getDisplay().get(i).getCardName().equals("regular"))
			{
				display[i] = game.getPlayerArray().get(id).getDisplay().get(i).getColor() + " " +
						Integer.toString(game.getPlayerArray().get(id).getDisplay().get(i).getValue());
			}
			if(!game.getPlayerArray().get(id).getDisplay().get(i).getCardName().equals("regular"))
				display[i] = game.getPlayerArray().get(id).getDisplay().get(i).getCardName();	
		}
		JOptionPane.showMessageDialog(null, display, "Your Display", 1);
	}

	private void addCardMethod(Card card)
	{
		String name = null;
		if(card.getCardName().equals("regular"))
		{
			name = card.getColor();
			String number = Integer.toString(card.getValue());
			name = name + " " + number;
		}
		else if(!card.getCardName().equals("regular"))
			name = card.getCardName();

		String n = name;
		JButton button = new JButton(name);
		button.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent arg0)
			{
				if(card.getCardName().equals("Unhorse"))
					actionNewColorTournament();
				if(card.getCardName().equals("Change weapon"))
					actionNewColorTournament();
				if(card.getCardName().equals("Break Lance"))
					game.getPlayerArray().get(getMyIndex()).setTargetPlayer(getPlayerIndex(actionChooseOpponent()));
				if(card.getCardName().equals("Riposte"))
					game.getPlayerArray().get(getMyIndex()).setTargetPlayer(getPlayerIndex(actionChooseOpponent()));
				if(card.getCardName().equals("Dodge"))
				{	String op = actionChooseOpponent();
				int opCard = actionChooseOpDisplay(op);
				game.getPlayerArray().get(getMyIndex()).setTargetPlayer(getPlayerIndex(op));
				game.getPlayerArray().get(getMyIndex()).setChosenCard(opCard); }
				if(card.getCardName().equals("Retreat"))
					game.getPlayerArray().get(getMyIndex()).setChosenCard(actionChooseMyDisplay());
				if(card.getCardName().equals("Knock down"))
					game.getPlayerArray().get(getMyIndex()).setTargetPlayer(getPlayerIndex(actionChooseOpponent()));
				if(card.getCardName().equals("Outwit"))
				{	String op = actionChooseOpponent();
				int opFaceUp = actionChooseOpFaceUp(op);
				int my = actionChooseMyFaceUp();
				game.getPlayerArray().get(getMyIndex()).setTargetPlayer(getPlayerIndex(op));
				game.getPlayerArray().get(getMyIndex()).setChosenCard(opFaceUp); 
				game.getPlayerArray().get(getMyIndex()).setGivenCard(my);  }
				if(card.getCardName().equals("Stunned"))
					game.getPlayerArray().get(getMyIndex()).setTargetPlayer(getPlayerIndex(actionChooseOpponent()));
				game.update(getMyIndex(), cardButtons.indexOf(button));
				try{sendGame();}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		button.setBackground(getColor(card.getColor()));
		button.setName(name);
		PlayerPanel.add(button);	
		cardButtons.add(button);
	}

	private void chooseToken()
	{
		int i = 0;
		String[] possibleValues = { "Purple", "Red", "Blue", "Yellow", "Green" };
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose a Token Color", "Token Award",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				game.getPlayerArray().get(getMyIndex()).setChosenToken(selectedValue);
				game.afterTokenChoice();
				game.getPlayerArray().get(getMyIndex()).setTokenChoiceNeeded(false);
				try{sendGame();}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	private void actionNewColorTournament()
	{
		int i = 0;
		String[] possibleValues = { "Purple", "Red", "Blue", "Yellow", "Green" };
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose Tournament Color", "New Tournament(Action Card)",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				game.getPlayerArray().get(getMyIndex()).setNewTournamentColor(selectedValue);			 }
		}
	}

	private String actionChooseOpponent()
	{	
		//may want to consider revising //it works so who cares
		int i = 0;
		ArrayList<String> possibleValues = new ArrayList<String>();
		for(int j=0; j < game.getPlayerArray().size(); j++)
			if(!game.getPlayerArray().get(j).getName().equals(PLAYER_ID))
				possibleValues.add(game.getPlayerArray().get(j).getName());
		Object[] possibleValues2 = possibleValues.toArray();
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose A Player", "Choose Opponent",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues2, possibleValues2[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				return selectedValue;
			}
		}
		return null;
	}

	private int actionChooseMyDisplay()
	{
		int i = 0;
		if(game.getPlayerArray().get(getMyIndex()).getDisplay().size() == 0)
		{	JOptionPane.showMessageDialog(null, "Your display is empty..."); 
		return -1;	}
		String[] possibleValues = new String[game.getPlayerArray().get(getMyIndex()).getDisplay().size()];
		for(int j=0; j < game.getPlayerArray().get(getMyIndex()).getDisplay().size(); j++)
			possibleValues[j] = game.getPlayerArray().get(getMyIndex()).getDisplay().get(j).getColor()
			+ " " + Integer.toString(game.getPlayerArray().get(getMyIndex()).getDisplay().get(j).getValue());
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose A Card from your Display", 
					"Cards in Display",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				for(int x=0; x < possibleValues.length; x++)
					if(possibleValues[x].equals(selectedValue))
						return x;
			}
		}
		return -1;
	} 

	private int actionChooseOpDisplay(String name)
	{
		int i = 0;
		int k = getPlayerIndex(name);
		if(game.getPlayerArray().get(k).getDisplay().size() == 0)
		{	JOptionPane.showMessageDialog(null, "Op display is empty..."); 
		return -1;	}
		String[] possibleValues = new String[game.getPlayerArray().get(k).getDisplay().size()];
		for(int j=0; j < game.getPlayerArray().get(k).getDisplay().size(); j++)
			possibleValues[j] = game.getPlayerArray().get(k).getDisplay().get(j).getColor()
			+ " " + Integer.toString(game.getPlayerArray().get(k).getDisplay().get(j).getValue());
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose A Played Card from "+name, 
					name+"'s Cards in Display",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				for(int x=0; x < possibleValues.length; x++)
					if(possibleValues[x].equals(selectedValue))
						return x;
			}
		}
		return -1;
	}

	private int actionChooseMyFaceUp()
	{
		int i = 0;
		if(game.getPlayerArray().get(getMyIndex()).getFaceUpCards().size() == 0)
		{	JOptionPane.showMessageDialog(null, "Your FaceUp is empty..."); 
		return -1;	}
		String[] possibleValues = new String[game.getPlayerArray().get(getMyIndex()).getFaceUpCards().size()];
		for(int j=0; j < game.getPlayerArray().get(getMyIndex()).getFaceUpCards().size(); j++)
			possibleValues[j] = game.getPlayerArray().get(getMyIndex()).getFaceUpCards().get(j).getColor()
			+ " " + Integer.toString(game.getPlayerArray().get(getMyIndex()).getFaceUpCards().get(j).getValue());
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose A Card from your FaceUp", 
					"Cards in my FaceUp",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				for(int x=0; x < possibleValues.length; x++)
					if(possibleValues[x].equals(selectedValue))
						return x;
			}
		}
		return -1;
	} 

	private int actionChooseOpFaceUp(String name)
	{
		int i = 0;
		int k = getPlayerIndex(name);
		if(game.getPlayerArray().get(k).getFaceUpCards().size() == 0)
		{	JOptionPane.showMessageDialog(null, "Op FaceUp is empty..."); 
		return -1;	}
		String[] possibleValues = new String[game.getPlayerArray().get(k).getFaceUpCards().size()];
		for(int j=0; j < game.getPlayerArray().get(k).getFaceUpCards().size(); j++)
			possibleValues[j] = game.getPlayerArray().get(k).getFaceUpCards().get(j).getColor()
			+ " " + Integer.toString(game.getPlayerArray().get(k).getFaceUpCards().get(j).getValue());
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose A FaceUp Card from "+name, 
					name+"'s Cards in FaceUp",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				for(int x=0; x < possibleValues.length; x++)
					if(possibleValues[x].equals(selectedValue))
						return x;
			}
		}
		return -1;
	}

	private void actionAdapt()
	{
		System.out.println("Inside Adapt");
		int one=0, two=0, three=0, four=0, five=0, six=0, seven=0;
		ArrayList<Integer> ones = new ArrayList<Integer>();
		ArrayList<Integer> twos = new ArrayList<Integer>();
		ArrayList<Integer> threes = new ArrayList<Integer>();
		ArrayList<Integer> fours = new ArrayList<Integer>();
		ArrayList<Integer> fives = new ArrayList<Integer>();
		ArrayList<Integer> sixes = new ArrayList<Integer>();
		ArrayList<Integer> sevens = new ArrayList<Integer>();
		System.out.println("Made the ArrayLists");
		for(int i = 0; i < game.getPlayerArray().get(getMyIndex()).getDisplay().size(); i++)
		{
			Card card = game.getPlayerArray().get(getMyIndex()).getDisplay().get(i);
			if(card.getValue() == one)
				ones.add(i);
			if(card.getValue() == two)
				twos.add(i);
			if(card.getValue() == three)
				threes.add(i);
			if(card.getValue() == four)
				fours.add(i);
			if(card.getValue() == five)
				fives.add(i);
			if(card.getValue() == six)
				sixes.add(i);
			if(card.getValue() == seven)
				sevens.add(i);
		}
		System.out.println("Left foor loop");
		System.out.println(ones.size()+" "+twos.size()+ " "+
				threes.size()+" "+fours.size()+" "+fives.size()+" "
				+sixes.size()+" "+sevens.size()+" ");
		System.out.println("Checking if each ArraList is empty or not");
		if(!ones.isEmpty())
		{
			System.out.println("Ones not empty");
			int index = actionAdaptPopUp(ones);
			index = ones.get(index);
			game.getPlayerArray().get(getMyIndex()).getKeptCards().add(
					game.getPlayerArray().get(getMyIndex()).getDisplay().get(index));
		}
		if(!twos.isEmpty())
		{
			System.out.println("Two's not empty");
			int index = actionAdaptPopUp(twos);
			index = ones.get(index);
			game.getPlayerArray().get(getMyIndex()).getKeptCards().add(
					game.getPlayerArray().get(getMyIndex()).getDisplay().get(index));
		}
		if(!threes.isEmpty())
		{
			System.out.println("Threes not empty");
			int index = actionAdaptPopUp(threes);
			index = ones.get(index);
			game.getPlayerArray().get(getMyIndex()).getKeptCards().add(
					game.getPlayerArray().get(getMyIndex()).getDisplay().get(index));
		}
		if(!fours.isEmpty())
		{
			System.out.println("Fours not empty");
			int index = actionAdaptPopUp(fours);
			index = ones.get(index);
			game.getPlayerArray().get(getMyIndex()).getKeptCards().add(
					game.getPlayerArray().get(getMyIndex()).getDisplay().get(index));
		}
		if(!fives.isEmpty())
		{
			System.out.println("Fives not empty");
			int index = actionAdaptPopUp(fives);
			index = ones.get(index);
			game.getPlayerArray().get(getMyIndex()).getKeptCards().add(
					game.getPlayerArray().get(getMyIndex()).getDisplay().get(index));
		}
		if(!sixes.isEmpty())
		{
			System.out.println("Sixes not empty");
			int index = actionAdaptPopUp(sixes);
			index = ones.get(index);
			game.getPlayerArray().get(getMyIndex()).getKeptCards().add(
					game.getPlayerArray().get(getMyIndex()).getDisplay().get(index));
		}
		if(!sevens.isEmpty())
		{
			System.out.println("Sevens not empty");
			int index = actionAdaptPopUp(sevens);
			index = ones.get(index);
			game.getPlayerArray().get(getMyIndex()).getKeptCards().add(
					game.getPlayerArray().get(getMyIndex()).getDisplay().get(index));
		}
		System.out.println("About to call afterAdaptPopup");
		game.afterAdaptPopup();
		System.out.println("Going to call sendGame");
		try {
			sendGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int actionAdaptPopUp(ArrayList<Integer> list)
	{
		int i =0;
		String[] possibleValues = new String[list.size()];
		for(int j=0; j < list.size(); j++)
			possibleValues[j] = game.getPlayerArray().get(getMyIndex()).getDisplay().get(list.get(j)).getColor()
			+ " " + Integer.toString(game.getPlayerArray().get(getMyIndex()).getDisplay().get(list.get(j)).getValue());
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please Choose A Card from your Display to Keep", 
					"Cards in Display of Current Value Category",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(selectedValue != null)
			{
				JOptionPane.showMessageDialog(null, selectedValue);
				i = 1;
				for(int x=0; x < possibleValues.length; x++)
					if(possibleValues[x].equals(selectedValue))
						return x;
			}
		}
		return -1;
	}

	private Color getColor(String color)
	{
		if(color.equals("red") || color.equals("RED") || color.equals("Red"))
			return Color.RED;
		if(color.equals("blue") || color.equals("BLUE") || color.equals("Blue"))
			return Color.BLUE;
		if(color.equals("yellow") || color.equals("YELLOW") || color.equals("Yellow"))
			return Color.YELLOW;
		if(color.equals("green") || color.equals("GREEN") || color.equals("Green"))
			return Color.GREEN;
		if(color.equals("purple") || color.equals("PURPLE") || color.equals("Purple"))
			return Color.MAGENTA;
		return Color.WHITE;
	}

	private void setTotalValue(int value)
	{
		TotalValueField.setText(Integer.toString(value));
	}

	private void setName(String name)
	{
		NameField.setText(name);
		myNameLabel.setText(name);
	}

	private void initOpPlayers()
	{
		///////////// ADD to Array Lists ///////
		OpPanels.add(Op1Panel);
		OpPanels.add(Op2Panel);
		OpPanels.add(Op3Panel);
		OpPanels.add(Op4Panel);

		OpColorPanels.add(Op1ColorPanel);
		OpColorPanels.add(Op2ColorPanel);
		OpColorPanels.add(Op3ColorPanel);
		OpColorPanels.add(Op4ColorPanel);

		OpColorPanelFields.add(Op1ColorPanelField);
		OpColorPanelFields.add(Op2ColorPanelField);
		OpColorPanelFields.add(Op3ColorPanelField);
		OpColorPanelFields.add(Op4ColorPanelField);

		OpNameFields.add(Op1NameField);
		OpNameFields.add(Op2NameField);
		OpNameFields.add(Op3NameField);
		OpNameFields.add(Op4NameField);

		OpStateFields.add(Op1StateField);
		OpStateFields.add(Op2StateField);
		OpStateFields.add(Op3StateField);
		OpStateFields.add(Op4StateField);

		OpTotalValueFields.add(Op1TotalValueField);
		OpTotalValueFields.add(Op2TotalValueField);
		OpTotalValueFields.add(Op3TotalValueField);
		OpTotalValueFields.add(Op4TotalValueField);

		OpTokensNameLabels.add(Op1TokensNameLabel);
		OpTokensNameLabels.add(Op2TokensNameLabel);
		OpTokensNameLabels.add(Op3TokensNameLabel);
		OpTokensNameLabels.add(Op4TokensNameLabel);

		OpTokensPanels.add(Op1TokensPanels);
		OpTokensPanels.add(Op2TokensPanels);
		OpTokensPanels.add(Op3TokensPanels);
		OpTokensPanels.add(Op4TokensPanels);

		OpStunnedFields.add(Op1StunnedField);
		OpStunnedFields.add(Op2StunnedField);
		OpStunnedFields.add(Op3StunnedField);
		OpStunnedFields.add(Op4StunnedField);

		OpShieldFields.add(Op1ShieldField);
		OpShieldFields.add(Op2ShieldField);
		OpShieldFields.add(Op3ShieldField);
		OpShieldFields.add(Op4ShieldField);

		Op1TokensPanels.add(Op1PurpleTokenPanel);
		Op1TokensPanels.add(Op1RedTokenPanel);
		Op1TokensPanels.add(Op1BlueTokenPanel);
		Op1TokensPanels.add(Op1YellowTokenPanel);
		Op1TokensPanels.add(Op1GreenTokenPanel);

		Op2TokensPanels.add(Op2PurpleTokenPanel);
		Op2TokensPanels.add(Op2RedTokenPanel);
		Op2TokensPanels.add(Op2BlueTokenPanel);
		Op2TokensPanels.add(Op2YellowTokenPanel);
		Op2TokensPanels.add(Op2GreenTokenPanel);

		Op3TokensPanels.add(Op3PurpleTokenPanel);
		Op3TokensPanels.add(Op3RedTokenPanel);
		Op3TokensPanels.add(Op3BlueTokenPanel);
		Op4TokensPanels.add(Op3YellowTokenPanel);
		Op4TokensPanels.add(Op3GreenTokenPanel);

		Op4TokensPanels.add(Op4PurpleTokenPanel);
		Op4TokensPanels.add(Op4RedTokenPanel);
		Op4TokensPanels.add(Op4BlueTokenPanel);
		Op4TokensPanels.add(Op4YellowTokenPanel);
		Op4TokensPanels.add(Op4GreenTokenPanel);

		////////////// Set Fields to Null/Initialize /////////////
		OpColorPanelFields.get(0).setText("0");
		OpColorPanelFields.get(1).setText("0");
		OpColorPanelFields.get(2).setText("0");
		OpColorPanelFields.get(3).setText("0");

		OpNameFields.get(0).setText("Vacant");
		OpNameFields.get(1).setText("Vacant");
		OpNameFields.get(2).setText("Vacant");
		OpNameFields.get(3).setText("Vacant");

		OpStateFields.get(0).setText("Empty");
		OpStateFields.get(1).setText("Empty");
		OpStateFields.get(2).setText("Empty");
		OpStateFields.get(3).setText("Empty");

		OpTotalValueFields.get(0).setText("0");
		OpTotalValueFields.get(1).setText("0");
		OpTotalValueFields.get(2).setText("0");
		OpTotalValueFields.get(3).setText("0");
	}

	private int getOpGuiIndex(String ID)
	{
		return PlayerIDs.indexOf(ID);
	}

	private int getMyIndex()
	{
		for(int k=0; k < game.getPlayerArray().size(); k++)
		{
			if(game.getPlayerArray().get(k).getName().equals(PLAYER_ID))
				return k;
		}
		return -1;
	}

	private int getPlayerIndex(String name)
	{
		for(int k=0; k < game.getPlayerArray().size(); k++)
		{
			if(game.getPlayerArray().get(k).getName().equals(name))
				return k;
		}
		return -1;
	}

	private void obtainNewTournamentColor()
	{
		int i = 0;
		String[] possibleValues = { "Purple", "Red", "Blue", "Yellow", "Green", "Can't Choose Color" };
		while(i != 1)
		{	
			String selectedValue = (String) JOptionPane.showInputDialog(null,
					"Please choose a new Tournament color", "New Tournament!",
					JOptionPane.INFORMATION_MESSAGE, null,
					possibleValues, possibleValues[0]);
			if(!selectedValue.equals(null))
			{
				i = 1; 
				if(selectedValue.equals(possibleValues[5]))
					game.update(getMyIndex(), selectedValue);
				else if(!selectedValue.equals(possibleValues[5]))
					game.update(getMyIndex(), selectedValue);
				try{sendGame();}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	private void setTournamentColor(String str)
	{
		frmTestWindow.getContentPane().setBackground(getColor(str));
	}

	private void setVictory(String victor)
	{
		int index = getOpGuiIndex(victor);
		if(victor.equals(PLAYER_ID))
			StateField.setText("WINNER");
		else if(!victor.equals(PLAYER_ID))
			StateField.setText("LOSER");
		for(int i=0; i < PlayerIDs.size(); i++)
		{
			if(i == index)
				OpStateFields.get(i).setText("WINNER");
			else if(i != index)
				OpStateFields.get(i).setText("LOSER");
		}
	}

	private void initUser()
	{
		TotalValueField.setText("0");
		StateField.setText("Empty");
		NameField.setText("Vacant");
		PurpleTokenPanel.setVisible(false);
		RedTokenPanel.setVisible(false);
		BlueTokenPanel.setVisible(false);
		YellowTokenPanel.setVisible(false);
		GreenTokenPanel.setVisible(false);
	}

	private void setOpName(String name, String id)
	{
		int index = getOpGuiIndex(id); 
		OpNameFields.get(index).setText(name);
		OpTokensNameLabels.get(index).setText(name);
	}

	private void setOpState(int state, String id)
	{
		int index = getOpGuiIndex(id);
		if(state == 0)
		{
			OpStateFields.get(index).setText("Waiting");
			OpStateFields.get(index).setFont(new Font("Tahoma", Font.PLAIN, 12));
			OpPanels.get(index).setBackground(PLAIN);
		}
		if(state == 1)
		{
			OpStateFields.get(index).setText("Playing");
			OpStateFields.get(index).setFont(new Font("Tahoma", Font.PLAIN, 12));
			OpPanels.get(index).setBackground(HIGHLIGHT);
		}
		if(state == 2)
		{
			OpStateFields.get(index).setText("Forfieted");
			OpStateFields.get(index).setFont(new Font("Tahoma", Font.BOLD, 12));
			OpPanels.get(index).setBackground(Color.DARK_GRAY);
		}
	}

	private void setOpShield(boolean affected, String id)
	{
		int index = getOpGuiIndex(id);
		if(affected == false)
			OpShieldFields.get(index).setBackground(PLAIN);
		if(affected == true)
			OpShieldFields.get(index).setBackground(ACTIVE);
	}

	private void setOpStunned(boolean affected, String id)
	{
		int index = getOpGuiIndex(id);
		if(affected == false)
			OpStunnedFields.get(index).setBackground(PLAIN);
		if(affected == true)
			OpStunnedFields.get(index).setBackground(ACTIVE);
	}

	private void setMyShield(boolean affected)
	{
		if(affected == false)
			myShieldField.setBackground(PLAIN);
		if(affected == true)
			myShieldField.setBackground(ACTIVE);
	}

	private void setMyStunned(boolean affected)
	{
		if(affected == false)
			myStunnedField.setBackground(PLAIN);
		if(affected == true)
			myStunnedField.setBackground(ACTIVE);
	}

	private void setState(int a)
	{
		if(a == 0)
		{
			StateField.setText("Waiting");
			StateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GameInfoPanel.setBackground(PLAIN);
		}
		if(a == 1)
		{
			StateField.setText("Playing");
			StateField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GameInfoPanel.setBackground(HIGHLIGHT);
		}
		if(a == 2)
		{
			StateField.setText("Forfieted");
			StateField.setFont(new Font("Tahoma", Font.BOLD, 12));
			GameInfoPanel.setBackground(Color.DARK_GRAY);
		}
	}

	private void setOpColorPanel(String color, int value, String id)
	{
		int index = getOpGuiIndex(id);
		OpColorPanels.get(index).setBackground(getColor(color));
		OpColorPanelFields.get(index).setText(Integer.toString(value));
	}

	private void setOpTotalValue(String id, int value)
	{
		int index = getOpGuiIndex(id);
		OpTotalValueFields.get(index).setText(Integer.toString(value));
	}

	private void resetTokens()
	{
		PurpleTokenPanel.setVisible(false);
		RedTokenPanel.setVisible(false);
		BlueTokenPanel.setVisible(false);
		YellowTokenPanel.setVisible(false);
		GreenTokenPanel.setVisible(false);
		for(int i=0; i < OpTokensPanels.size(); i++)
		{
			for(int j=0; j < OpTokensPanels.get(i).size(); j++)
			{
				OpTokensPanels.get(i).get(j).setVisible(false);
			}
		}
	}

	int updateNum = 0;
	private void update(Game game)
	{
		System.out.println("GUI.Update() - starting.");
		if(firstTime)
		{
			firstTime = false;
			System.out.println("GUI.Update() - Your ID has been set.");
			for(int i=0; i < game.getPlayerArray().size(); i++)
			{
				if(!game.getPlayerArray().get(i).getName().equals(PLAYER_ID))
				{
					PlayerIDs.add(game.getPlayerArray().get(i).getName());
				}
			}
			System.out.println("PlayerIDs.size(): "+PlayerIDs.size());
		}
		if(game.isAdaptPlayed() && !game.getPlayerArray().get(getMyIndex()).isSheilded())
			actionAdapt();
		System.out.println("About to clear");
		cardButtons.clear();
		PlayerPanel.removeAll();
		resetTokens();
		PlayerPanel.add(btnForfeit);
		PlayerPanel.add(btnEndTurn);
		PlayerPanel.add(btnDisplay);
		System.out.println("***** Added buttons + Players: "+
		game.getPlayerArray().size());
		System.out.println(game.getPlayerArray().get(0).getName());
		System.out.println(game.getPlayerArray().get(1).getName());
		for(int k=0; k < game.getPlayerArray().size(); k++)
		{
			if(game.getPlayerArray().get(k).getName().equals(PLAYER_ID))
			{
				System.out.println("Inside Me - for loop");
				game.getPlayerArray().get(k).playerSync(game);
				for(int z=0; z < game.getPlayerArray().get(k).getHand().size(); z++)
				{
					System.out.println("Adding card: " +z);
					addCardMethod(game.getPlayerArray().get(k).getHand().get(z));
					System.out.println("Added card: " +z);
				}
				if(game.getPlayerArray().get(k).isForfiet())
					setState(2);
				else if(game.getPlayerArray().get(k).isMyTurn())
					setState(1);
				else
					setState(0);
				setTotalValue(game.getPlayerArray().get(k).getPlayedValue());
				setName(game.getPlayerArray().get(k).getName());
				setMyShield(game.getPlayerArray().get(k).isSheilded());
				setMyStunned(game.getPlayerArray().get(k).isStunned());
				if(game.getPlayerArray().get(k).hasPToken())
					PurpleTokenPanel.setVisible(true);
				if(game.getPlayerArray().get(k).hasRToken())
					RedTokenPanel.setVisible(true);
				if(game.getPlayerArray().get(k).hasBToken())
					BlueTokenPanel.setVisible(true);
				if(game.getPlayerArray().get(k).hasYToken())
					YellowTokenPanel.setVisible(true);
				if(game.getPlayerArray().get(k).hasGToken())
					GreenTokenPanel.setVisible(true);
				PlayerPanel.revalidate();
				PlayerPanel.repaint();
			}
			else if(!game.getPlayerArray().get(k).getName().equals(PLAYER_ID))
			{
				System.out.println("Inside OP - else if - for loop");
				setOpName(game.getPlayerArray().get(k).getName(), game.getPlayerArray().get(k).getName());
				setOpTotalValue(game.getPlayerArray().get(k).getName(), game.getPlayerArray().get(k).getPlayedValue());
				setOpShield(game.getPlayerArray().get(k).isSheilded(), game.getPlayerArray().get(k).getName());
				setOpStunned(game.getPlayerArray().get(k).isStunned(), game.getPlayerArray().get(k).getName());
				if(game.getPlayerArray().get(k).isForfiet())
					setOpState(2, game.getPlayerArray().get(k).getName());
				else if(game.getPlayerArray().get(k).isMyTurn())
					setOpState(1, game.getPlayerArray().get(k).getName());
				else
					setOpState(0, game.getPlayerArray().get(k).getName());
				int index = getOpGuiIndex(game.getPlayerArray().get(k).getName());
				if(game.getPlayerArray().get(k).hasPToken())
					OpTokensPanels.get(index).get(0).setVisible(true);
				if(game.getPlayerArray().get(k).hasRToken())
					OpTokensPanels.get(index).get(1).setVisible(true);
				if(game.getPlayerArray().get(k).hasBToken())
					OpTokensPanels.get(index).get(2).setVisible(true);
				if(game.getPlayerArray().get(k).hasYToken())
					OpTokensPanels.get(index).get(3).setVisible(true);
				if(game.getPlayerArray().get(k).hasGToken())
					OpTokensPanels.get(index).get(4).setVisible(true);		
				if(game.getPlayerArray().get(k).getLastCardPlayed() != null)
					setOpColorPanel(game.getPlayerArray().get(k).getLastCardPlayed().getColor(), 
							game.getPlayerArray().get(k).getLastCardPlayed().getValue(), 
							game.getPlayerArray().get(k).getName());
			}
			if(game.getPlayerArray().get(k).isTokenChoiceNeeded() == true
					&& game.getPlayerArray().get(k).getName().equals(PLAYER_ID))
				chooseToken();
		}
		if(game.isGameOver())
		{
			for(int i=0; i < game.getNumPlayers(); i++)
			{
				if(game.getPlayerArray().get(i).isGameWinner())
					setVictory(game.getPlayerArray().get(i).getName());
			}
			cardButtons.clear();
			PlayerPanel.removeAll();
			PlayerPanel.revalidate();
			PlayerPanel.repaint();
			System.out.println("The Game is Over!");
		}
		else if(!game.isGameOver())
		{
			System.out.println("Inside !game.isGameOver() - "+game.isGameOver());
			for(int i=0; i < game.getNumPlayers(); i++)
			{
				if((game.getPlayerArray().get(game.whosTurn()).getName().equals(PLAYER_ID))
						&& (game.getPlayerArray().get(game.whosTurn()).isTournamentColorNeeded()))
				{
					System.out.println(game.getPlayerArray().get(game.whosTurn()).getName().equals(PLAYER_ID)+
							" "+game.getPlayerArray().get(game.whosTurn()).isTournamentColorNeeded());
					obtainNewTournamentColor();
				}	
			}
			if(game.getCurrTournamentColor() != null)
				setTournamentColor(game.getCurrTournamentColor());
			else if(game.getCurrTournamentColor() == null)
				frmTestWindow.getContentPane().setBackground(Color.WHITE);
		}
		System.out.println("Update Num: "+updateNum++);
		System.out.println("GUI.Update() - finished.\n");
	}
}
//End of Code