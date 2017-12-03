package jdbcDatabase;
	
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.io.BufferedInputStream;
import java.io.File;

import javax.sound.sampled.AudioSystem;

import javax.sound.sampled.Clip;

import com.mysql.jdbc.PreparedStatement;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.TextAlignment;




public class Main extends Application {

	boolean warningRefillFlag = false;
	
	Image imgMusic, imgScore, imgCredit;
	
	
	
	Button btn1 = new Button("Administrator" + "\n (DB Creation and Initialization)");
	Button btn2 = new Button("User" + "\n (Sign-up and Login)");
	Button btn3 = new Button("Create the Database");
	Button btn4 = new Button("Initialize the Database");
	Button btn5 = new Button("Display the Database");
	Button btn6 = new Button("Exit Admin");
	Button btn7 = new Button("Return to Admin Page");
	Button btn8 = new Button("User Login");
	Button btn9 = new Button("New user, please Sign up");
	Button btn10 = new Button("OK");
	Button btn11 = new Button("OK");
	
	Button btnStart = new Button( "Start the Game" );
	Button btnMusic;
	Button btnScore;
	Button btnCredit;
	
	TextArea carRacing = new TextArea();


	
	
	Label ln1 = new Label("Last_Name:");
	Label ln2 = new Label("First_Name:");
	Label ln3 = new Label("Group:");
	Label ln4 = new Label("Login:");
	Label ln5 = new Label("Password:");
	Label ln6 = new Label("Prefered_Car_Name:");
	Label ln7 = new Label("Credit:");
	Label ln8 = new Label("Score:");
	Label ln9 = new Label("Logo:");
	
	Label id = new Label("User ID:");
	Label pw = new Label("Password:");
	
    BorderPane initPane = new BorderPane();
    BorderPane gamePane = new BorderPane();
    Label info = new Label();
    TextField info2 = new TextField();
   
    
	Image image;
	ImageView imageView;
	Label lb_logo, lb_title, lb_title2, lb_members;
	
	
	TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();
    TextField tf4 = new TextField();
    TextField tf5 = new TextField();
    TextField tf6 = new TextField();
    TextField tf7 = new TextField();
    TextField tf8 = new TextField();
    TextField tf9 = new TextField();
    
    TextField tid = new TextField();
    TextField tpw = new TextField();
    
	Alert alertW = new Alert(AlertType.WARNING);
	Alert alertI = new Alert(AlertType.INFORMATION);

	FlowPane fp1 = new FlowPane();
	FlowPane fp2 = new FlowPane();
	FlowPane fp3 = new FlowPane();
	BorderPane bp = new BorderPane();
	BorderPane bp1 = new BorderPane();
	BorderPane bp2 = new BorderPane();
	GridPane gp = new GridPane();
	GridPane gp1 = new GridPane();
	
	
	ArrayList<String> laptopList = new ArrayList<String>();
	
	int count = 0;
	int index;
	
	String login="";
	
	



	
	
	
	@Override
	public void start(Stage primaryStage) {
		// System.out.println(success);

		
		try {
			FileInputStream input = new FileInputStream("sheridan_logo.png");
			image = new Image(input);
	        imageView = new ImageView(image);
	        lb_logo = new Label( "", imageView);
	        
	        input = new FileInputStream("title.png");
			image = new Image(input);
	        imageView = new ImageView(image);
	        lb_title = new Label( "", imageView);
	        lb_title2 = new Label( "", imageView);
	        
	        input = new FileInputStream("members.png");
			image = new Image(input);
	        imageView = new ImageView(image);
	        lb_members = new Label( "", imageView);
	        
	        
	        input = new FileInputStream("music.png");
			image = new Image(input);
	        imageView = new ImageView(image);
	        btnMusic = new Button( "", imageView );
	        
	        
	        input = new FileInputStream("score.png");
			image = new Image(input);
	        imageView = new ImageView(image);
	        btnScore = new Button( "", imageView );
	        
	        
	        input = new FileInputStream("credit.png");
			image = new Image(input);
	        imageView = new ImageView(image);
	        btnCredit = new Button( "", imageView );
	        
		}
		catch( Exception e) {}
		
	
		
		


	//	imgMusic = new Image( getClass().getResourceAsStream( "music.png"));
	//	imgScore = new Image( getClass().getResourceAsStream( "score.png"));
	//	imgCredit = new Image( getClass().getResourceAsStream( "credit.png"));
		
		
//		btnScore = new Button( "View Score");
//		btnCredit = new Button( "Credit Refill");
		
		
		 info.setTextAlignment( TextAlignment.CENTER );
		
		fp1.setAlignment(Pos.CENTER);
		fp1.setHgap(20);
		btn1.setPadding(new Insets(10, 10, 10, 10));
		btn2.setPadding(new Insets(10, 10, 10, 10));
		
		lb_logo.setPadding(new Insets(1, 1, 10, 10));

		fp1.getChildren().add(btn1);
		fp1.getChildren().add(btn2);
//		fp1.getChildren().add(lb_logo);

		fp2.setAlignment(Pos.CENTER);
		fp2.setHgap(20);
		btn3.setPadding(new Insets(10, 10, 10, 10));
		btn4.setPadding(new Insets(10, 10, 10, 10));
		btn5.setPadding(new Insets(10, 10, 10, 10));
		btn6.setPadding(new Insets(10, 10, 10, 10)); // should modify to the element of borderpane...

		fp2.getChildren().add(btn3);
		fp2.getChildren().add(btn4);
		fp2.getChildren().add(btn5);
		fp2.getChildren().add(btn6);
		
		fp3.setAlignment(Pos.CENTER);
		fp3.setHgap(20);
		btn8.setPadding(new Insets(10, 10, 10, 10));
		btn9.setPadding(new Insets(10, 10, 10, 10));

		fp3.getChildren().add(btn8);
		fp3.getChildren().add(btn9);
		
		gp.add(ln1, 0, 0);
		gp.add(tf1, 1, 0);
		gp.add(ln2, 0, 1);
		gp.add(tf2, 1, 1);
		gp.add(ln3, 0, 2);
		gp.add(tf3, 1, 2);
		gp.add(ln4, 0, 3);
		gp.add(tf4, 1, 3);
		gp.add(ln5, 0, 4);
		gp.add(tf5, 1, 4);
		gp.add(ln6, 0, 5);
		gp.add(tf6, 1, 5);
		gp.add(ln7, 0, 6);
		gp.add(tf7, 1, 6);
		gp.add(ln8, 0, 7);
		gp.add(tf8, 1, 7);
		gp.add(ln9, 0, 8);
		gp.add(tf9, 1, 8);
		
		gp.setAlignment(Pos.CENTER);
		gp.setPadding(new Insets(11,12,13,14));
        gp.setHgap(10);
        gp.setVgap(10);
        
        bp1.setCenter(gp);
        bp1.setBottom(btn10);
		bp1.setAlignment(btn10, Pos.CENTER);
	
		//-----------------------button8
		gp1.add(id, 0, 0);
		gp1.add(tid, 1, 0);
		gp1.add(pw, 0, 1);
		gp1.add(tpw, 1, 1);
		
		gp1.setAlignment(Pos.CENTER);
		gp1.setPadding(new Insets(11,12,13,14));
        gp1.setHgap(10);
        gp1.setVgap(10);
        
        bp2.setCenter(gp1);
        bp2.setBottom(btn11);
		bp2.setAlignment(btn11, Pos.CENTER);

		
		
		
		initPane.setTop( lb_title );
		initPane.setCenter( fp1 );

		BorderPane center = new BorderPane();
		center.setTop( btnStart );
		center.setCenter( carRacing );
		center.setAlignment(btnStart, Pos.CENTER );
		
		carRacing.setPrefColumnCount(500);
		carRacing.setPrefRowCount(30);

		FlowPane rightPane = new FlowPane();
		rightPane.setAlignment(Pos.TOP_CENTER);

		rightPane.setPrefWrapLength(80);
		rightPane.setPadding(new Insets(10, 10, 10, 10));
		rightPane.getChildren().add(btnMusic);
		rightPane.getChildren().add(btnScore);
		rightPane.getChildren().add(btnCredit);
		
		gamePane.setTop( lb_title2 );
		gamePane.setCenter( center );
//		gamePane.setBottom(info);
		gamePane.setBottom(info2);
		info2.setEditable(false);
		gamePane.setRight( rightPane );
		
		
	
		Scene gameScene = new Scene( gamePane, 700, 800 );
		Stage gameStage = new Stage();
		gameStage.setTitle("Car Racing Game");
		gameStage.setScene( gameScene );
		
		
		
		
       // Scene scene = new Scene(fp1, 400, 400);
		Scene scene = new Scene(initPane, 700, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Car Racing Game");
		primaryStage.show();
		
		Scene scene1 = new Scene(fp2, 600, 300);
		Stage newStage1 = new Stage();
		newStage1.setTitle("Car Racing Game");
		newStage1.setScene(scene1);
		// newStage1.show();
		
		Scene scene2 = new Scene(bp, 500, 200);
		Stage newStage2 = new Stage();
		newStage2.setTitle("Car Racing Game");
		newStage2.setScene(scene2);
		// newStage2.show();
		
		Scene scene3 = new Scene(fp3, 500, 200);
		Stage newStage3 = new Stage();
		newStage3.setTitle("Car Racing Game");
		newStage3.setScene(scene3);
		// newStage3.show();
		
		Scene scene4 = new Scene(bp1, 500, 400);
		Stage newStage4 = new Stage();
		newStage4.setTitle("Car Racing Game");
		newStage4.setScene(scene4);
		// newStage4.show();
		
		Scene scene5 = new Scene(bp2, 500, 400);
		Stage newStage5 = new Stage();
		newStage5.setTitle("Car Racing Game");
		newStage5.setScene(scene5);
		// newStage5.show();

		btnStart.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				btnStart.setDisable( true );
				
				
				RacingResult.reset();
				new UseMyISCar().begin( getPreferedCar( tid.getText() ) );
				
				Timer m_timer = new Timer();
				TimerTask m_task = new TimerTask() {
					
					@Override
					public void run() {
	System.out.println( "&&&&&& num=" + RacingResult.num+ ",  myNum=" + RacingResult.myNum + ", gameOver = " + RacingResult.gameOver );					
						if( RacingResult.num > RacingResult.myNum ) {
						

							Platform.runLater( ()-> {
								if( RacingResult.result[ RacingResult.myNum ] != null )
									carRacing.appendText( RacingResult.result[ RacingResult.myNum ] + "\n" );
							});
							RacingResult.myNum++;
						}
						
						if( RacingResult.gameOver && ( RacingResult.myNum == RacingResult.num ) ) {
							m_timer.cancel();
							btnStart.setDisable( false );
							
							// 내가 이겼으면 DB에 점수 추가
							
							if( RacingResult.winner == 0 ) {
								
								
								increaseScore();
								Platform.runLater( ()-> {
									alertI.setTitle("Game Result");
									alertI.setContentText("You Won!!! Your Score is " + getScore( tid.getText() ) );
									alertI.showAndWait();
								});
							}
							else if( RacingResult.winner == 1 ) {
								Platform.runLater( ()-> {
									alertI.setTitle("Game Result");
									alertI.setContentText("You Lost!!! Your Score is " + getScore( tid.getText() ) );
									alertI.showAndWait();
								});
							}
							else {
								Platform.runLater( ()-> {
									alertI.setTitle("Game Result");
									alertI.setContentText("Draw!!! Your Score is " + getScore( tid.getText() ) );
									alertI.showAndWait();
								});
							}
							
						}
					}
				};
				
				m_timer.schedule(m_task, 0, 1000);
							
				
			}

		});
		btnMusic.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				
				try{
/*
					File Sound =new File("wewillrockyou.wav");
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(Sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
*/
					
					String bip = "wewillrockyou.wav";
					//String bip = "star.mp3";
					Media hit = new Media(new File(bip).toURI().toString());
					MediaPlayer mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();
				}

				catch(Exception e)
				{
					System.out.println( e );
				}



			}

		});
		btnScore.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// DB에서 점수 가져와서 팝업창으로 보여준다.
				
				int score = getScore( tid.getText() );
				
	System.out.println( "USER : " + tid.getText() + "     - SCORE : " + score);			
				
				alertI.setTitle("Your Score");
				alertI.setContentText("Your Score is " + score);
				alertI.showAndWait();
			}

		});
		btnCredit.setOnAction( new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				
				
				// DB에 크레딧 추가하고 팝업창으로 알려준다.
				addCredit();
				double credit = getCredit( tid.getText() );
				
				
				alertI.setTitle("Your Credit");
				alertI.setContentText("Your Credit is " + credit);
				alertI.showAndWait();
				
				warningRefillFlag = false;
				btnStart.setDisable( false );
			}

		});
		
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				primaryStage.hide();
				newStage1.show();

			}

		});

		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				primaryStage.hide();
				newStage3.show();
			}

		});
		
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DBConnection dbC = new DBConnection();
				String success = dbC.connection();

				if (success.equals("done")) {
					try {

						alertW.setTitle("Car Racing Game");
						alertW.setContentText("This Database already exists");
						// sp.getChildren().add(btn);
						// sp.getChildren(alert);
						alertW.showAndWait();

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (success.equals("fail")) {
					dbC.createDB();
					try {

						alertI.setTitle("Car Racing Game");
						alertI.setContentText("Database successfull created" + "\n Click Ok to continue");
						alertI.showAndWait();

					} catch (Exception e) {

						alertW.setTitle("Car Racing Game");
						alertW.setContentText("Error occurred. Check your code!");
						alertW.showAndWait();
						e.printStackTrace();
					}

				}

				dbC.createTable();

				try {

					alertI.setTitle("Car Racing Game");
					alertI.setContentText("Tables successfull created" + "\n Click Ok to continue");
					alertI.showAndWait();

					// Scene scene = new Scene(alert,400,400);
					// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					// primaryStage.setScene(alert);
					// primaryStage.show();
				} catch (Exception e) {

					alertW.setTitle("Car Racing Game");
					alertW.setContentText("Error occurred. Check your code!");
					alertW.showAndWait();
					e.printStackTrace();
				}
			}
		});
		
		btn4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event)
			{

				try
				{
					StudentList sl = new StudentList();
					sl.readFile();
					sl.inputData();
					sl.selectData();

					alertI.setTitle("Car Racing Game");
					alertI.setContentText("Database initialization successfully completed..." + "\n Click Ok to continue");
					alertI.showAndWait();

				}
				catch (Exception e)
				{

					alertW.setTitle("Car Racing Game");
					alertW.setContentText("Error occurred. Check your code!");
					alertW.showAndWait();
					e.printStackTrace();
				}

			}

		}); 
		
		btn5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try 
				{
					Laptop lt = new Laptop();
					lt.deriveData();
					laptopList = lt.readFile();
					//System.out.println(laptopList.size());
					
					GridPane gp = new GridPane();
					StackPane sp = new StackPane();
					
					Label lpTitle = new Label ("Owner  Model     Manufacturer  Screen  Year");
					gp.add(lpTitle, 0, 0);
					
					Label lb[] = new Label[laptopList.size()];
					for (int i = 0 ; i < laptopList.size() ; i++)
					{
						String s = laptopList.get(i);
						lb[i] = new Label(s);
						
						
						
						gp.add(lb[i], 0, 1+i); // column=1 row=0
						
					}
					bp.setCenter(gp);
					bp.setAlignment(gp, Pos.CENTER);
					
					
					
					bp.setBottom(btn7);
					bp.setAlignment(btn7, Pos.TOP_RIGHT);
					
					newStage2.show();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
				
			}

		}); 
		
		btn6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				newStage1.hide();
				primaryStage.show();

			}

		});
		
		
		btn7.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				newStage1.hide();
				newStage2.hide();
				primaryStage.show();

			}

		});
		
		
		
		btn8.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				newStage5.show();
				
			}

		});
		
		btn9.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				newStage4.show();
				
			}

		}); 
		
		btn10.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				ArrayList<String> userData = new ArrayList<String>();
				
				try 
				{
					
					String lName = tf1.getText();
		            String fName = tf2.getText();
		            String nGroup = tf3.getText();
		            login = tf4.getText();
		            String password = tf5.getText();
		            String pCar = tf6.getText();
		            String credit = tf7.getText();
		            String score = tf8.getText();
		            String logo = tf9.getText();
System.out.println( "----" +  login );					
					Login li = new Login();
					userData = li.getData();
					
					System.out.println(userData.size());
					//String elem [] = new String[3];
					
					int count = 0;
					
					for (int i = 0 ; i < userData.size() ; i++)
					{
						String elem[] = userData.get(i).split(",");
						String lastN = elem[0];
						String firstN = elem[1];
						String groupN = elem[2];
						
						if (lName.equals(lastN) && fName.equals(firstN) && nGroup.equals(groupN))
						{
							count++;
						}
						
					}
					
					if (count == 0)
					{
						alertW.setTitle("Car Racing Game");
						alertW.setContentText("Either you are not yet registered or your Last Name, First Name, and Group are not Correct");
						alertW.showAndWait();
					}
					else
					{
						
						Login li1 = new Login(lName, fName, nGroup, login, password, pCar, credit, score, logo);
						boolean x = li1.updateTable();
						
						if (x)
						{
							alertI.setTitle("Car Racing Game");
							alertI.setContentText("You are now registered, you can login");
							alertI.showAndWait();
						}
					}
					
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}

		}); 
		
		
		
		btn11.setOnAction(new EventHandler<ActionEvent>() {

			/* (non-Javadoc)
			 * @see javafx.event.EventHandler#handle(javafx.event.Event)
			 */
			@Override
			public void handle(ActionEvent event) {
				
				ArrayList<String> uIDPW = new ArrayList<String>();
				
				try 
				{
					
		            String loginID = tid.getText();
		            String password = tpw.getText();
		            String com1 = loginID + "," + password;
					
					userIDPW li = new userIDPW();
					uIDPW = li.getData();
					
					//System.out.println(userData.size());
					//String elem [] = new String[3];
					
					String com2 = null;
					
					String innerid = null;
					String innerpw = null;
					
					boolean find = false;
					
					for (int i = 0 ; i < uIDPW.size() ; i++)
					{
						
					
						com2 = uIDPW.get(i);
						
						//System.out.println(com1 + "   " + com2);
						
						String elem[] = uIDPW.get(i).split(",");
						innerid = elem[0];
						//innerpw = elem[1];
						
						System.out.println(innerid + "jj");
						System.out.println(loginID);
						
						
						
						/*
						System.out.println(uIDPW.get(0));
						System.out.println(loginID+ ","+ password);
						*/
						
						//if ((com1.equals(com2)))
						
						if ((loginID.equals(innerid)))
						{
							
							index = uIDPW.indexOf(uIDPW.get(i));
							find = true;
								//System.out.println("index" + index);
							break;
						}
							
						else
						{
							find = false;
						}
							
					} 
					
					if (find == false)
					{
						
						alertW.setTitle("Car Racing Game");
						alertW.setContentText("The Login and password provided are not correct. \n Please try again if you are  already registered or complete your registration if you are not");
						alertW.showAndWait();	
							
					}
					
					else
					{
						String elem1[] = uIDPW.get(index).split(",");
						innerpw = elem1[1];
						
						System.out.println(uIDPW.get(index));
						
						System.out.println(innerpw);
						System.out.println(password);
						
					    if(innerpw.equals("xxxx")) 
						{
							alertW.setTitle("Car Racing Game");
							alertW.setContentText("Your account has been locked. \n Please contact your Database Administrator.");
							alertW.showAndWait();	
							
						}
					    
					    else if (!(password.equals(innerpw)) && count < 2) 
						{
							alertW.setTitle("Car Racing Game");
							alertW.setContentText("The Login and password provided are not correct. \n Please try again if you are  already registered or complete your registration if you are not");
							alertW.showAndWait();
							count++;
						}
						
						else if (!(password.equals(innerpw)) && count == 2) 
						{
							alertW.setTitle("Car Racing Game");
							alertW.setContentText("The Login and password provided are not correct. \n Please try again if you are  already registered or complete your registration if you are not");
							alertW.showAndWait();
							
							alertW.setTitle("Car Racing Game");
							alertW.setContentText("Your account has been locked. \n Please contact your Database Administrator.");
							alertW.showAndWait();
							
							userIDPW xx = new userIDPW();
							xx.setLogin(innerid);
							xx.updateTable();
							
						}
						
						else if (count < 3 && (com1.equals(com2)))
						{
							// start game
							System.out.println("good");
							count = 0;
							
							
////////////////////////////////
							newStage5.hide();
							
							gameStage.show();
							
							
							Timer m_timer_info = new Timer();
							TimerTask m_task_info = new TimerTask() {
								
								@Override
								public void run() {
									
									decreaseCredit();
									
									Platform.runLater( ()-> {
										
										//
										//info.setStyle( "-fx-right-padding : 1 ");
										
										info.setText( "Your score is " + getScore( tid.getText() ) + ".  Your credit is " + getCredit(tid.getText() ));
										info2.setText( "Your score is " + getScore( tid.getText() ) + ".  Your credit is " + getCredit(tid.getText() ));
										info2.setAlignment( Pos.CENTER_RIGHT);
										
										//info.setAlignment(Pos.CENTER);
										
										if( getCredit(tid.getText() ) <= 0.0 && !warningRefillFlag ) {
											
											btnStart.setDisable( true );
											warningRefillFlag = true;
											
											alertW.setTitle("Warning");
											alertW.setContentText( "Please refill your credit!" );
											alertW.showAndWait();
											
											
											
											
										}
										
										
									});
								}
							};
							m_timer_info.schedule(m_task_info, 0, 1000);
							
							
////////////////////////////////						
							
							
							
							
							
							
						}
					}
							
					System.out.println(count);
					
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}

		}); 
	
	}
	
	
	
	public String getPreferedCar( String u ) {
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/DBProg32758";
		String user = "root";
		String pw = "q1w2e3r4";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = null;
		String preferedCar ="";
		try 
		{
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			
			String sqlselect = "select preferedCar from idpassword where Login=" + "'" + u + "';";	
			res = stmt.executeQuery(sqlselect);
System.out.println( sqlselect);			
			while(res.next())
			{				
				preferedCar = res.getString("preferedCar");
			}

			
			res.close();
			stmt.close();
			con.close();
				
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return preferedCar;
	}
	
	
	public void addCredit() {
		
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/DBProg32758";
		String user = "root";
		String pw = "q1w2e3r4";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = null;
		
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			PreparedStatement ps = null;
			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			
			double credit = getCredit( tid.getText() ) + 100;
			
			String sqlUpdate = "UPDATE idPassword SET Credit=" + credit + " WHERE Login='" + tid.getText() + "';";
			ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
System.out.println( sqlUpdate);			
			
			ps.executeUpdate();
			
			
			stmt.close();
			con.close();
			 
	
		} catch (Exception e) 
		{
			System.out.println(e);
			//return false;
		}
	
		
		
		//return true;
	
	}
	
	public void decreaseCredit() {
		
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/DBProg32758";
		String user = "root";
		String pw = "q1w2e3r4";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = null;
		
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			PreparedStatement ps = null;
			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			
			double credit = getCredit( tid.getText() ) - 0.5;
			if( credit <= 0.0 )
				credit = 0.0;
			
			String sqlUpdate = "UPDATE idPassword SET Credit=" + credit + " WHERE Login='" + tid.getText() + "';";
			ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
System.out.println( sqlUpdate);			
			
			ps.executeUpdate();
			
			
			stmt.close();
			con.close();
			 
	
		} catch (Exception e) 
		{
			System.out.println(e);
			//return false;
		}

	}
	
	public void increaseScore() {
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/DBProg32758";
		String user = "root";
		String pw = "q1w2e3r4";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = null;
		
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			PreparedStatement ps = null;
			String sqlUse = "USE DBProg32758;";
			stmt.executeUpdate(sqlUse);
			
			int score = getScore( tid.getText() ) + 50;

			
			String sqlUpdate = "UPDATE idPassword SET Score=" + score + " WHERE Login='" + tid.getText() + "';";
			ps = (PreparedStatement) con.prepareStatement(sqlUpdate);
System.out.println( sqlUpdate);			
			
			ps.executeUpdate();
			
			
			stmt.close();
			con.close();
			 
	
		} catch (Exception e) 
		{
			System.out.println(e);
			//return false;
		}
		
	}
	
	public int getScore( String u ) {
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/DBProg32758";
		String user = "root";
		String pw = "q1w2e3r4";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = null;
		int score = 0;
		try 
		{
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			
			String sqlselect = "select Score from idpassword where Login=" + "'" + u + "';";	
			res = stmt.executeQuery(sqlselect);
System.out.println( sqlselect);			
			while(res.next())
			{				
				score = res.getInt("Score");
			}

			
			res.close();
			stmt.close();
			con.close();
				
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return score;
	}
	

	public double getCredit( String u ) {
		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/DBProg32758";
		String user = "root";
		String pw = "q1w2e3r4";
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String sql = null;
		double credit = 0;
		try 
		{
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, user, pw);
			stmt = con.createStatement();
			
			String sqlselect = "select Credit from idpassword where Login=" + "'" + u + "';";	
			res = stmt.executeQuery(sqlselect);
System.out.println( sqlselect);			
			while(res.next())
			{				
				credit = res.getDouble("Credit");
			}

			
			res.close();
			stmt.close();
			con.close();
				
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return credit;
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
