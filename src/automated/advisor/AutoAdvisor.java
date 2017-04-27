/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated.advisor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Jonathan
 */
public class AutoAdvisor extends Application {

    CheckBox CS114, CS115, CS211, CS220, CS320, CS460, M144, M221W;
    CheckBox B110, B111, C110, C111, P112, P113, P120, P121;
    CheckBox CS362, CS451, E231, E232, CS275, CS351, CS365, CS371, CS375, CS340, M220, M222W;
    Label CSCore, CSMath;
    CSBAElectives BAElectives = new CSBAElectives();
    CSBSElectives BSElectives = new CSBSElectives();
    CSCore core = new CSCore();
    CSScience science = new CSScience();
    VBox vbchecks, vblabels, vblabell, vblabels1;
    boolean isCoreCompleted, isElectivesCompleted, isScienceCompleted;
    Collection<String> classes = new ArrayList<String>();

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Computer Science Majors");

        primaryStage.show();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Auto Advisor");
        scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 10.0));
        grid.add(scenetitle, 1, 0, 2, 1);

        Text sceneDesc = new Text("Please select a degree path below");
        scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 33.0));
        grid.add(sceneDesc, 1, 1, 2, 2);

        Button btnS = new Button("Getting A BS");
        HBox btnBS = new HBox(10);
        btnBS.setAlignment(Pos.TOP_CENTER);
        btnBS.getChildren().add(btnS);
        grid.add(btnBS, 1, 3);

        btnS.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();

                Text scenetitle = new Text("Select All the Core CS classes you've passed.");
                scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 22));
                vbchecks = new VBox();
                vbchecks.setSpacing(10);
                vbchecks.setPadding(new Insets(20));

                vblabels = new VBox();
                vblabels.setSpacing(10);
                vblabels.setPadding(new Insets(20));

                CS114 = new CheckBox("CS 114 - Foundations of Computing I");
                CS115 = new CheckBox("CS 115 - Foundations of Computing II");
                CS211 = new CheckBox("CS 211 - Architecture and Assembly Language");
                CS220 = new CheckBox("CS 220 - Data Structures ");
                CS320 = new CheckBox("CS 320 - Concepts of Programming Languages");
                CS460 = new CheckBox("CS 460 - Software Development");
                M144 = new CheckBox("M 144 - Calculus I");
                M221W = new CheckBox("M 221W - Discrete Mathematics");

                vbchecks.getChildren().addAll(CS114, CS115, CS211, CS220, CS320, CS460, M144, M221W);

                CS114.setOnAction(e -> handleButtonAction(e));
                CS115.setOnAction(e -> handleButtonAction(e));
                CS211.setOnAction(e -> handleButtonAction(e));
                CS220.setOnAction(e -> handleButtonAction(e));
                CS320.setOnAction(e -> handleButtonAction(e));
                CS460.setOnAction(e -> handleButtonAction(e));
                M144.setOnAction(e -> handleButtonAction(e));
                M221W.setOnAction(e -> handleButtonAction(e));

                final Stage ClassStage = new Stage();
                ClassStage.setTitle("Select All Your Core CS classes");

                ClassStage.show();

                GridPane BSgrid = new GridPane();
                BSgrid.setAlignment(Pos.CENTER);
                BSgrid.setHgap(20);
                BSgrid.setVgap(20);
                BSgrid.add(scenetitle, 0, 1, 2, 1);
                BSgrid.getChildren().addAll(vbchecks);
                BSgrid.setPadding(new Insets(25, 25, 25, 25));

                Scene BSscene = new Scene(BSgrid, 450, 450);;
                ClassStage.setScene(BSscene);

                Button Sub = new Button("Submit");
                HBox btnBS = new HBox(10);

                btnBS.setAlignment(Pos.CENTER);
                btnBS.getChildren().add(Sub);
                BSgrid.add(btnBS, 1, 2);

                Sub.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        ClassStage.close();

                        Text scenetitle = new Text("Select the science course you've taken");
                        scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 24));

                        vbchecks = new VBox();
                        vbchecks.setSpacing(10);
                        vbchecks.setPadding(new Insets(20));

                        B110 = new CheckBox("BIO 110 - General Biology");
                        B111 = new CheckBox("BIO 111 - General Biology:\n\t\tThe Human Body");
                        C110 = new CheckBox("CH 110 - College Chemistry I");
                        C111 = new CheckBox("CH 111 - College Chemistry II");
                        P112 = new CheckBox("PHY 112 - Calc Based Physics I");
                        P113 = new CheckBox("PHY 113 - Calc Based Physics II");
                        P120 = new CheckBox("PHY 120 - Algebra Based Physics II");
                        P121 = new CheckBox("PHY 121 - Algebra Based Physics II");

                        vbchecks.getChildren().addAll(B110, B111, C110, C111, P112, P113, P120, P121);
                        B110.setOnAction(e -> handleBSScience(e));
                        B111.setOnAction(e -> handleBSScience(e));
                        C110.setOnAction(e -> handleBSScience(e));
                        C111.setOnAction(e -> handleBSScience(e));
                        P112.setOnAction(e -> handleBSScience(e));
                        P113.setOnAction(e -> handleBSScience(e));
                        P120.setOnAction(e -> handleBSScience(e));
                        P121.setOnAction(e -> handleBSScience(e));
                        final Stage ClassStage = new Stage();
                        ClassStage.setTitle("Select The Science Course You've Taken");

                        ClassStage.show();

                        GridPane BSgrid = new GridPane();
                        BSgrid.setAlignment(Pos.CENTER);
                        BSgrid.setHgap(20);
                        BSgrid.setVgap(20);
                        BSgrid.add(scenetitle, 0, 1, 2, 1);
                        BSgrid.getChildren().addAll(vbchecks);
                        BSgrid.setPadding(new Insets(25, 25, 25, 25));

                        Scene BSscene = new Scene(BSgrid, 450, 450);;
                        ClassStage.setScene(BSscene);

                        Button Sub = new Button("Submit");
                        HBox btnBS = new HBox(10);
                        btnBS.setAlignment(Pos.CENTER);
                        btnBS.getChildren().add(Sub);
                        BSgrid.add(btnBS, 1, 2);

                        Sub.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent event) {
                                ClassStage.close();

                                Text scenetitle = new Text("Select the CS electives you've passed.");
                                scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 15));

                                vbchecks = new VBox();
                                vbchecks.setSpacing(10);
                                vbchecks.setPadding(new Insets(20));

                                CS362 = new CheckBox("CS 362 - Systems");
                                CS451 = new CheckBox("CS 451 - Systems");
                                E231 = new CheckBox("ECE231 & ECE232 - Systems");
                                CS275 = new CheckBox("CS 275 - Applications");
                                CS351 = new CheckBox("CS 351 - Applications");
                                CS365 = new CheckBox("CS 365 - Applications");
                                CS371 = new CheckBox("CS 371 - Applications");
                                CS375 = new CheckBox("CS 375 - Applications");
                                CS340 = new CheckBox("CS 340 - Theory");
                                M220 = new CheckBox("M 220 - Theory");
                                M222W = new CheckBox("M 222W - Theory");

                                vbchecks.getChildren().addAll(CS362, CS451, E231, CS275, CS351, CS365, CS371, CS375, CS340, M220, M222W);
                                CS362.setOnAction(e -> handleCS362BS(e));
                                CS451.setOnAction(e -> handleCS451BS(e));
                                E231.setOnAction(e -> handleE231BS(e));
                                CS275.setOnAction(e -> handleCS275BS(e));
                                CS351.setOnAction(e -> handleCS351BS(e));
                                CS365.setOnAction(e -> handleCS365BS(e));
                                CS371.setOnAction(e -> handleCS371BS(e));
                                CS375.setOnAction(e -> handleCS375BS(e));
                                CS340.setOnAction(e -> handleCS340BS(e));
                                M220.setOnAction(e -> handleM220BS(e));
                                M222W.setOnAction(e -> handleM222WBS(e));
                                final Stage ClassStage = new Stage();
                                ClassStage.setTitle("Select All Your CS Electives");

                                ClassStage.show();

                                GridPane BSgrid = new GridPane();
                                BSgrid.setAlignment(Pos.CENTER);
                                BSgrid.setHgap(20);
                                BSgrid.setVgap(20);
                                BSgrid.add(scenetitle, 0, 1, 2, 1);
                                BSgrid.getChildren().addAll(vbchecks);
                                BSgrid.setPadding(new Insets(25, 25, 25, 25));

                                Scene BSscene = new Scene(BSgrid, 450, 450);;
                                ClassStage.setScene(BSscene);

                                Button Sub = new Button("Submit");
                                HBox btnBS = new HBox(10);
                                btnBS.setAlignment(Pos.CENTER);
                                btnBS.getChildren().add(Sub);
                                BSgrid.add(btnBS, 1, 2);

                                Sub.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        ClassStage.close();

                                        final Stage ClassStage = new Stage();
                                        ClassStage.setTitle("Results");

                                        ClassStage.show();

                                        GridPane BSgrid = new GridPane();
                                        BSgrid.setAlignment(Pos.CENTER);
                                        BSgrid.setHgap(20);
                                        BSgrid.setVgap(20);
                                        BSgrid.setPadding(new Insets(25, 25, 25, 25));

                                        Scene BSscene = new Scene(BSgrid, 450, 450);;
                                        ClassStage.setScene(BSscene);

                                        Text scenetitle = new Text("The List of classes you've taken");
                                        scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 25));
                                        BSgrid.add(scenetitle, 0, 0, 2, 1);
                                        Label userName = new Label("Classes:");
                                        BSgrid.add(userName, 0, 1);

                                        final TextArea userTextField = new TextArea();
                                        userTextField.setEditable(false);

                                        for (Map.Entry<String, Boolean> entry : core.map.entrySet()) {
                                            String key = entry.getKey();
                                            Boolean value = core.map.get(key);
                                            if (value) {
                                                classes.add(key);
                                            }
                                        }
                                        for (Map.Entry<String, Boolean> entry : science.map.entrySet()) {
                                            String key = entry.getKey();
                                            Boolean value = science.map.get(key);
                                            if (value) {
                                                classes.add(key);
                                            }
                                        }
                                        for (Map.Entry<String, BreadthKey> entry : BAElectives.map.entrySet()) {
                                            String key = entry.getKey();
                                            BreadthKey value = BAElectives.map.get(key);
                                            if (value.getKey()) {
                                                classes.add(key);
                                            }
                                        }
                                        for (Map.Entry<String, BreadthKey> entry : BSElectives.map.entrySet()) {
                                            String key = entry.getKey();
                                            BreadthKey value = BSElectives.map.get(key);
                                            if (value.getKey()) {
                                                classes.add(key);
                                            }
                                        }

                                        for (String s : classes) {
                                            userTextField.setText(userTextField.getText() + s + "\n");
                                        }

                                        BSgrid.add(userTextField, 1, 1);

                                        Button Next = new Button("Confirm");
                                        HBox NX = new HBox(10);
                                        NX.setAlignment(Pos.CENTER);
                                        NX.getChildren().add(Next);
                                        BSgrid.add(NX, 1, 2);

                                        Next.setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent event) {
                                                ClassStage.close();

                                                final Stage ClassStage = new Stage();
                                                ClassStage.setTitle("Results");

                                                ClassStage.show();

                                                GridPane BSgrid = new GridPane();
                                                BSgrid.setAlignment(Pos.CENTER);
                                                BSgrid.setHgap(20);
                                                BSgrid.setVgap(20);
                                                BSgrid.setPadding(new Insets(25, 25, 25, 25));

                                                Scene BSscene = new Scene(BSgrid, 450, 450);;
                                                ClassStage.setScene(BSscene);

                                                Text scenetitle = new Text("Classes you still need to take");
                                                scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 25));
                                                BSgrid.add(scenetitle, 0, 0, 2, 1);
                                                Label userName = new Label("Classes:");
                                                BSgrid.add(userName, 0, 1);

                                                final TextArea userTextField = new TextArea();
                                                userTextField.setEditable(false);

                                                userTextField.setText(userTextField.getText() + "Core Courses: \n" + core.coreResults());
                                                userTextField.setText(userTextField.getText() + "\n\nScience Courses: \n" + science.scienceResults());
                                                userTextField.setText(userTextField.getText() + "\n\nElective Courses: \n" + BSElectives.breadthResults());

                                                BSgrid.add(userTextField, 1, 1);

                                                Button Done = new Button("Got It!");
                                                HBox D = new HBox(10);
                                                D.setAlignment(Pos.CENTER);
                                                D.getChildren().add(Done);
                                                BSgrid.add(D, 1, 2);

                                                Done.setOnAction(new EventHandler<ActionEvent>() {
                                                    public void handle(ActionEvent event) {
                                                        ClassStage.close();
                                                    }
                                                });
                                            }
                                        });

                                    }
                                });
                            }
                        });

                    }
                });
            }

            private void handleCS362BS(ActionEvent e) {
                if (CS362.isSelected()) {
                    BSElectives.setClass("CS362", true);
                    System.out.println("CS362 - " + BSElectives.checkClass("CS362"));
                } else if (!CS362.isSelected()) {
                    BSElectives.setClass("CS362", false);
                    System.out.println("CS362 - " + BSElectives.checkClass("CS362"));
                }
            }

            private void handleCS451BS(ActionEvent e) {
                if (CS451.isSelected()) {
                    BSElectives.setClass("CS451", true);
                    System.out.println("CS451 - " + BSElectives.checkClass("CS451"));
                } else if (!CS451.isSelected()) {
                    BSElectives.setClass("CS451", false);
                    System.out.println("CS451 - " + BSElectives.checkClass("CS451"));
                }
            }

            private void handleE231BS(ActionEvent e) {
                if (E231.isSelected()) {
                    BSElectives.setClass("ECE231 & ECE232", true);
                    System.out.println("ECE231 & ECE232 - " + BSElectives.checkClass("ECE231 & ECE232"));
                } else if (!E231.isSelected()) {
                    BSElectives.setClass("ECE231 & ECE232", false);
                    System.out.println("ECE231 & ECE232 - " + BSElectives.checkClass("ECE231 & ECE232"));
                }
            }

            private void handleCS275BS(ActionEvent e) {
                if (CS275.isSelected()) {
                    BSElectives.setClass("CS275", true);
                    System.out.println("CS275 - " + BSElectives.checkClass("CS275"));
                } else if (!CS275.isSelected()) {
                    BSElectives.setClass("CS275", false);
                    System.out.println("CS275 - " + BSElectives.checkClass("CS275"));
                }
            }

            private void handleCS351BS(ActionEvent e) {
                if (CS351.isSelected()) {
                    BSElectives.setClass("CS351", true);
                    System.out.println("CS351 - " + BSElectives.checkClass("CS351"));
                } else if (!CS351.isSelected()) {
                    BSElectives.setClass("CS351", false);
                    System.out.println("CS351 - " + BSElectives.checkClass("CS351"));
                }
            }

            private void handleCS365BS(ActionEvent e) {
                if (CS365.isSelected()) {
                    BSElectives.setClass("CS365", true);
                    System.out.println("CS365 - " + BSElectives.checkClass("CS365"));
                } else if (!CS365.isSelected()) {
                    BSElectives.setClass("CS365", false);
                    System.out.println("CS365 - " + BSElectives.checkClass("CS365"));
                }
            }

            private void handleCS371BS(ActionEvent e) {
                if (CS371.isSelected()) {
                    BSElectives.setClass("CS371", true);
                    System.out.println("CS371 - " + BSElectives.checkClass("CS371"));
                } else if (!CS371.isSelected()) {
                    BSElectives.setClass("CS371", false);
                    System.out.println("CS371 - " + BSElectives.checkClass("CS371"));
                }
            }

            private void handleCS375BS(ActionEvent e) {
                if (CS375.isSelected()) {
                    BSElectives.setClass("CS375", true);
                    System.out.println("CS375 - " + BSElectives.checkClass("CS375"));
                } else if (!CS375.isSelected()) {
                    BSElectives.setClass("CS375", false);
                    System.out.println("CS375 - " + BSElectives.checkClass("CS375"));
                }
            }

            private void handleCS340BS(ActionEvent e) {
                if (CS340.isSelected()) {
                    BSElectives.setClass("CS340", true);
                    System.out.println("CS340 - " + BSElectives.checkClass("CS340"));
                } else if (!CS340.isSelected()) {
                    BSElectives.setClass("CS340", false);
                    System.out.println("CS340 - " + BSElectives.checkClass("CS340"));
                }
            }

            private void handleM220BS(ActionEvent e) {
                if (M220.isSelected()) {
                    BSElectives.setClass("M220", true);
                    System.out.println("M220 - " + BSElectives.checkClass("M220"));
                } else if (!M220.isSelected()) {
                    BSElectives.setClass("M220", false);
                    System.out.println("M220 - " + BSElectives.checkClass("M220"));
                }
            }

            private void handleBSScience(ActionEvent e) {

                /*
                SCIENCE BS
                 */
                if (B110.isSelected()) {
                    science.setClass("B110", true);
                    System.out.println("B110 - " + science.checkClass("B110"));
                } else if (!B110.isSelected()) {
                    science.setClass("B110", false);
                    System.out.println("B110 - " + science.checkClass("B110"));
                }

                if (B111.isSelected()) {
                    science.setClass("B111", true);
                    System.out.println("B111 - " + science.checkClass("B111"));
                } else if (!B111.isSelected()) {
                    science.setClass("B111", false);
                    System.out.println("B111 - " + science.checkClass("B111"));
                }

                if (C110.isSelected()) {
                    science.setClass("C110", true);
                    System.out.println("C110 - " + science.checkClass("C110"));
                } else if (!C110.isSelected()) {
                    science.setClass("C110", false);
                    System.out.println("C110 - " + science.checkClass("C110"));
                }

                if (C111.isSelected()) {
                    science.setClass("C111", true);
                    System.out.println("C111 - " + science.checkClass("C111"));
                } else if (!C111.isSelected()) {
                    science.setClass("C111", false);
                    System.out.println("C111 - " + science.checkClass("C111"));
                }

                if (P112.isSelected()) {
                    science.setClass("P112", true);
                    System.out.println("P112 - " + science.checkClass("P112"));
                } else if (!P112.isSelected()) {
                    science.setClass("P112", false);
                    System.out.println("P112 - " + science.checkClass("P112"));
                }

                if (P113.isSelected()) {
                    science.setClass("P113", true);
                    System.out.println("P113 - " + science.checkClass("P113"));
                } else if (!P113.isSelected()) {
                    science.setClass("P113", false);
                    System.out.println("P113 - " + science.checkClass("P113"));
                }
                if (P120.isSelected()) {
                    science.setClass("P120", true);
                    System.out.println("P120 - " + science.checkClass("P120"));
                } else if (!P120.isSelected()) {
                    science.setClass("P120", false);
                    System.out.println("P120 - " + science.checkClass("P120"));
                }
                if (P121.isSelected()) {
                    science.setClass("P121", true);
                    System.out.println("P121 - " + science.checkClass("P121"));
                } else if (!P121.isSelected()) {
                    science.setClass("P121", false);
                    System.out.println("P121 - " + science.checkClass("P121"));
                }
            }

            private void handleM222WBS(ActionEvent e) {
                if (M222W.isSelected()) {
                    BSElectives.setClass("M222W", true);
                    System.out.println("M222W - " + BSElectives.checkClass("M222W"));
                } else if (!M222W.isSelected()) {
                    BSElectives.setClass("M222W", false);
                    System.out.println("M222W - " + BSElectives.checkClass("M222W"));
                }
            }

            private void handleButtonAction(ActionEvent e) {
                if (CS114.isSelected()) {
                    core.setClass("CS114", true);
                    System.out.println("CS114 - " + core.checkClass("CS114"));
                } else if (!CS114.isSelected()) {
                    core.setClass("CS114", false);
                    System.out.println("CS114 - " + core.checkClass("CS114"));
                }

                if (CS115.isSelected()) {
                    core.setClass("CS115", true);
                    System.out.println("CS115 - " + core.checkClass("CS115"));
                } else if (!CS115.isSelected()) {
                    core.setClass("CS115", false);
                    System.out.println("CS115 - " + core.checkClass("CS115"));
                }

                if (CS211.isSelected()) {
                    core.setClass("CS211", true);
                    System.out.println("CS211 - " + core.checkClass("CS211"));
                } else if (!CS211.isSelected()) {
                    core.setClass("CS211", false);
                    System.out.println("CS211 - " + core.checkClass("CS211"));
                }

                if (CS220.isSelected()) {
                    core.setClass("CS220", true);
                    System.out.println("CS220 - " + core.checkClass("CS220"));
                } else if (!CS220.isSelected()) {
                    core.setClass("CS220", false);
                    System.out.println("CS220 - " + core.checkClass("CS220"));
                }

                if (CS320.isSelected()) {
                    core.setClass("CS320", true);
                    System.out.println("CS320 - " + core.checkClass("CS320"));
                } else if (!CS320.isSelected()) {
                    core.setClass("CS320", false);
                    System.out.println("CS320 - " + core.checkClass("CS320"));
                }

                if (CS460.isSelected()) {
                    core.setClass("CS460", true);
                    System.out.println("CS460 - " + core.checkClass("CS460"));
                } else if (!CS460.isSelected()) {
                    core.setClass("CS460", false);
                    System.out.println("CS460 - " + core.checkClass("CS460"));
                }

                if (M144.isSelected()) {
                    core.setClass("M144", true);
                    System.out.println("M144 - " + core.checkClass("M144"));
                } else if (!M144.isSelected()) {
                    core.setClass("M144", false);
                    System.out.println("M144 - " + core.checkClass("M144"));
                }

                if (M221W.isSelected()) {
                    core.setClass("M221W", true);
                    System.out.println("M221W - " + core.checkClass("M221W") + "\n");
                } else if (!M221W.isSelected()) {
                    core.setClass("M221W", false);
                    System.out.println("M221W - " + core.checkClass("M221W") + "\n");
                }
            }

        });

        Button btnA = new Button("Getting A BA");
        HBox btnBA = new HBox(10);
        btnBA.setAlignment(Pos.TOP_CENTER);
        btnBA.getChildren().add(btnA);
        grid.add(btnBA, 2, 3);

        btnA.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();

                Text scenetitle = new Text("Select All the Core CS classes you've passed.");
                scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 22));
                vbchecks = new VBox();
                vbchecks.setSpacing(10);
                vbchecks.setPadding(new Insets(20));

                vblabels = new VBox();
                vblabels.setSpacing(10);
                vblabels.setPadding(new Insets(20));

                CS114 = new CheckBox("CS 114 - Foundations of Computing I");
                CS115 = new CheckBox("CS 115 - Foundations of Computing II");
                CS211 = new CheckBox("CS 211 - Architecture and Assembly Language");
                CS220 = new CheckBox("CS 220 - Data Structures ");
                CS320 = new CheckBox("CS 320 - Concepts of Programming Languages");
                CS460 = new CheckBox("CS 460 - Software Development");
                M144 = new CheckBox("M 144 - Calculus I");
                M221W = new CheckBox("M 221W - Discrete Mathematics");

                vbchecks.getChildren().addAll(CS114, CS115, CS211, CS220, CS320, CS460, M144, M221W);
                CS114.setOnAction(e -> handleButtonAction(e));
                CS115.setOnAction(e -> handleButtonAction(e));
                CS211.setOnAction(e -> handleButtonAction(e));
                CS220.setOnAction(e -> handleButtonAction(e));
                CS320.setOnAction(e -> handleButtonAction(e));
                CS460.setOnAction(e -> handleButtonAction(e));
                M144.setOnAction(e -> handleButtonAction(e));
                M221W.setOnAction(e -> handleButtonAction(e));
                final Stage ClassStage = new Stage();
                ClassStage.setTitle("Select All Your Core CS classes");

                ClassStage.show();

                GridPane BSgrid = new GridPane();
                BSgrid.setAlignment(Pos.CENTER);
                BSgrid.setHgap(20);
                BSgrid.setVgap(20);
                BSgrid.add(scenetitle, 0, 1, 2, 1);
                BSgrid.getChildren().addAll(vbchecks);
                BSgrid.setPadding(new Insets(25, 25, 25, 25));

                Scene BSscene = new Scene(BSgrid, 450, 450);;
                ClassStage.setScene(BSscene);

                Button Sub = new Button("Submit");
                HBox btnBS = new HBox(10);
                btnBS.setAlignment(Pos.CENTER);
                btnBS.getChildren().add(Sub);
                BSgrid.add(btnBS, 1, 2);

                Sub.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        ClassStage.close();

                        Text scenetitle = new Text("Select the science course you've taken");
                        scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 24));

                        vbchecks = new VBox();
                        vbchecks.setSpacing(10);
                        vbchecks.setPadding(new Insets(20));

                        B110 = new CheckBox("BIO 110 - General Biology");
                        B111 = new CheckBox("BIO 111 - General Biology:\n\t\tThe Human Body");
                        C110 = new CheckBox("CH 110 - College Chemistry I");
                        C111 = new CheckBox("CH 111 - College Chemistry II");
                        P112 = new CheckBox("PHY 112 - Calc Based Physics I");
                        P113 = new CheckBox("PHY 113 - Calc Based Physics II");
                        P120 = new CheckBox("PHY 120 - Algebra Based Physics II");
                        P121 = new CheckBox("PHY 121 - Algebra Based Physics II");

                        vbchecks.getChildren().addAll(B110, B111, C110, C111, P112, P113, P120, P121);

                        B110.setOnAction(e -> handleButtonActionScience(e));
                        B111.setOnAction(e -> handleButtonActionScience(e));
                        C110.setOnAction(e -> handleButtonActionScience(e));
                        C111.setOnAction(e -> handleButtonActionScience(e));
                        P112.setOnAction(e -> handleButtonActionScience(e));
                        P113.setOnAction(e -> handleButtonActionScience(e));
                        P120.setOnAction(e -> handleButtonActionScience(e));
                        P121.setOnAction(e -> handleButtonActionScience(e));

                        final Stage ClassStage = new Stage();
                        ClassStage.setTitle("Select The Science Course You've Taken");

                        ClassStage.show();

                        GridPane BSgrid = new GridPane();
                        BSgrid.setAlignment(Pos.CENTER);
                        BSgrid.setHgap(20);
                        BSgrid.setVgap(20);
                        BSgrid.add(scenetitle, 0, 1, 2, 1);
                        BSgrid.getChildren().addAll(vbchecks);
                        BSgrid.setPadding(new Insets(25, 25, 25, 25));

                        Scene BSscene = new Scene(BSgrid, 450, 450);;
                        ClassStage.setScene(BSscene);

                        Button Sub = new Button("Submit");
                        HBox btnBS = new HBox(10);
                        btnBS.setAlignment(Pos.CENTER);
                        btnBS.getChildren().add(Sub);
                        BSgrid.add(btnBS, 1, 2);

                        Sub.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent event) {
                                ClassStage.close();

                                Text scenetitle = new Text("Select the CS electives you've passed.");
                                scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 24));

                                vbchecks = new VBox();
                                vbchecks.setSpacing(10);
                                vbchecks.setPadding(new Insets(20));

                                CS362 = new CheckBox("CS 362 - Systems");
                                CS451 = new CheckBox("CS 451 - Systems");
                                E231 = new CheckBox("ECE231 & ECE232 - Systems");
                                CS275 = new CheckBox("CS 275 - Applications");
                                CS351 = new CheckBox("CS 351 - Applications");
                                CS365 = new CheckBox("CS 365 - Applications");
                                CS371 = new CheckBox("CS 371 - Applications");
                                CS375 = new CheckBox("CS 375 - Applications");
                                CS340 = new CheckBox("CS 340 - Theory");
                                M220 = new CheckBox("M 220 - Theory");
                                M222W = new CheckBox("M 222W - Theory");
                                vbchecks.getChildren().addAll(CS362, CS451, E231, CS275, CS351, CS365, CS371, CS375, CS340, M220, M222W);

                                CS362.setOnAction(e -> handleCS362(e));
                                CS451.setOnAction(e -> handleCS451(e));
                                E231.setOnAction(e -> handleE231(e));
                                CS275.setOnAction(e -> handleCS275(e));
                                CS351.setOnAction(e -> handleCS351(e));
                                CS371.setOnAction(e -> handleCS371(e));
                                CS375.setOnAction(e -> handleCS375(e));
                                CS340.setOnAction(e -> handleCS340(e));
                                M220.setOnAction(e -> handleM220(e));
                                M222W.setOnAction(e -> handleM222W(e));
                                final Stage ClassStage = new Stage();
                                ClassStage.setTitle("Select All Your CS Electives");

                                ClassStage.show();

                                GridPane BSgrid = new GridPane();
                                BSgrid.setAlignment(Pos.CENTER);
                                BSgrid.setHgap(20);
                                BSgrid.setVgap(20);
                                BSgrid.add(scenetitle, 0, 1, 2, 1);
                                BSgrid.getChildren().addAll(vbchecks);
                                BSgrid.setPadding(new Insets(25, 25, 25, 25));

                                Scene BSscene = new Scene(BSgrid, 450, 450);;
                                ClassStage.setScene(BSscene);

                                Button Sub = new Button("Submit");
                                HBox btnBS = new HBox(10);
                                btnBS.setAlignment(Pos.CENTER);
                                btnBS.getChildren().add(Sub);
                                BSgrid.add(btnBS, 1, 2);

                                Sub.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        ClassStage.close();

                                        final Stage ClassStage = new Stage();
                                        ClassStage.setTitle("Results");

                                        ClassStage.show();

                                        GridPane BSgrid = new GridPane();
                                        BSgrid.setAlignment(Pos.CENTER);
                                        BSgrid.setHgap(20);
                                        BSgrid.setVgap(20);
                                        BSgrid.setPadding(new Insets(25, 25, 25, 25));

                                        Scene BSscene = new Scene(BSgrid, 450, 450);;
                                        ClassStage.setScene(BSscene);

                                        Text scenetitle = new Text("The List of classes you've taken");
                                        scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 25));
                                        BSgrid.add(scenetitle, 0, 0, 2, 1);
                                        Label userName = new Label("Classes:");
                                        BSgrid.add(userName, 0, 1);

                                        final TextArea userTextField = new TextArea();
                                        userTextField.setEditable(false);

                                        for (Map.Entry<String, Boolean> entry : core.map.entrySet()) {
                                            String key = entry.getKey();
                                            Boolean value = core.map.get(key);
                                            if (value) {
                                                classes.add(key);
                                            }
                                        }
                                        for (Map.Entry<String, Boolean> entry : science.map.entrySet()) {
                                            String key = entry.getKey();
                                            Boolean value = science.map.get(key);
                                            if (value) {
                                                classes.add(key);
                                            }
                                        }
                                        for (Map.Entry<String, BreadthKey> entry : BAElectives.map.entrySet()) {
                                            String key = entry.getKey();
                                            BreadthKey value = BAElectives.map.get(key);
                                            if (value.getKey()) {
                                                classes.add(key);
                                            }
                                        }
                                        for (Map.Entry<String, BreadthKey> entry : BSElectives.map.entrySet()) {
                                            String key = entry.getKey();
                                            BreadthKey value = BSElectives.map.get(key);
                                            if (value.getKey()) {
                                                classes.add(key);
                                            }
                                        }

                                        for (String s : classes) {
                                            userTextField.setText(userTextField.getText() + s + "\n");
                                        }
                                        System.out.println(classes.size());

                                        BSgrid.add(userTextField, 1, 1);

                                        Button Next = new Button("Confirm");
                                        HBox NX = new HBox(10);
                                        NX.setAlignment(Pos.CENTER_RIGHT);
                                        NX.getChildren().add(Next);
                                        BSgrid.add(NX, 1, 2);

                                        Next.setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent event) {
                                                ClassStage.close();

                                                final Stage ClassStage = new Stage();
                                                ClassStage.setTitle("Results");

                                                ClassStage.show();

                                                GridPane BSgrid = new GridPane();
                                                BSgrid.setAlignment(Pos.CENTER);
                                                BSgrid.setHgap(20);
                                                BSgrid.setVgap(20);
                                                BSgrid.setPadding(new Insets(25, 25, 25, 25));

                                                Scene BSscene = new Scene(BSgrid, 450, 450);;
                                                ClassStage.setScene(BSscene);

                                                Text scenetitle = new Text("Classes you still need to take");
                                                scenetitle.setFont(Font.font("Californian FB", FontWeight.NORMAL, 25));
                                                BSgrid.add(scenetitle, 0, 0, 2, 1);
                                                Label userName = new Label("Classes:");
                                                BSgrid.add(userName, 0, 1);

                                                final TextArea userTextField = new TextArea();
                                                userTextField.setEditable(false);
                                                BSgrid.add(userTextField, 1, 1);

                                                userTextField.setText(userTextField.getText() + "Core Courses: \n" + core.coreResults());
                                                userTextField.setText(userTextField.getText() + "\n\nScience Courses: \n" + science.scienceResults());
                                                userTextField.setText(userTextField.getText() + "\n\nElective Courses: \n" + BAElectives.breadthResults());

                                                Button Done = new Button("Got It!");
                                                HBox D = new HBox(10);
                                                D.setAlignment(Pos.CENTER);
                                                D.getChildren().add(Done);
                                                BSgrid.add(D, 1, 2);

                                                Done.setOnAction(new EventHandler<ActionEvent>() {
                                                    public void handle(ActionEvent event) {
                                                        ClassStage.close();
                                                    }
                                                });
                                            }
                                        });

                                    }
                                });

                            }
                        });

                    }
                });
            }

            /**
             * Handles BA CheckBoxes
             *
             * @param e
             */
            private void handleButtonActionScience(ActionEvent e) {
                if (B110.isSelected()) {
                    science.setClass("B110", true);
                    System.out.println("B110 - " + science.checkClass("B110"));
                } else if (!B110.isSelected()) {
                    science.setClass("B110", false);
                    System.out.println("B110 - " + science.checkClass("B110"));
                }

                if (B111.isSelected()) {
                    science.setClass("B111", true);
                    System.out.println("B111 - " + science.checkClass("B111"));
                } else if (!B111.isSelected()) {
                    science.setClass("B111", false);
                    System.out.println("B111 - " + science.checkClass("B111"));
                }

                if (C110.isSelected()) {
                    science.setClass("C110", true);
                    System.out.println("C110 - " + science.checkClass("C110"));
                } else if (!C110.isSelected()) {
                    science.setClass("C110", false);
                    System.out.println("C110 - " + science.checkClass("C110"));
                }

                if (C111.isSelected()) {
                    science.setClass("C111", true);
                    System.out.println("C111 - " + science.checkClass("C111"));
                } else if (!C111.isSelected()) {
                    science.setClass("C111", false);
                    System.out.println("C111 - " + science.checkClass("C111"));
                }

                if (P112.isSelected()) {
                    science.setClass("P112", true);
                    System.out.println("P112 - " + science.checkClass("P112"));
                } else if (!P112.isSelected()) {
                    science.setClass("P112", false);
                    System.out.println("P112 - " + science.checkClass("P112"));
                }

                if (P113.isSelected()) {
                    science.setClass("P113", true);
                    System.out.println("P113 - " + science.checkClass("P113"));
                } else if (!P113.isSelected()) {
                    science.setClass("P113", false);
                    System.out.println("P113 - " + science.checkClass("P113"));
                }
                if (P120.isSelected()) {
                    science.setClass("P120", true);
                    System.out.println("P120 - " + science.checkClass("P120"));
                } else if (!P120.isSelected()) {
                    science.setClass("P120", false);
                    System.out.println("P120 - " + science.checkClass("P120"));
                }
                if (P121.isSelected()) {
                    science.setClass("P121", true);
                    System.out.println("P121 - " + science.checkClass("P121"));
                } else if (!P121.isSelected()) {
                    science.setClass("P121", false);
                    System.out.println("P121 - " + science.checkClass("P121"));
                }
                System.out.println(science.checkScience());

            }

            private void handleCS362(ActionEvent e) {
                if (CS362.isSelected()) {
                    BAElectives.setClass("CS362", true);
                    System.out.println("CS362 - " + BAElectives.checkClass("CS362"));
                } else if (!CS362.isSelected()) {
                    BAElectives.setClass("CS362", false);
                    System.out.println("CS362 - " + BAElectives.checkClass("CS362"));
                }
            }

            private void handleCS451(ActionEvent e) {
                if (CS451.isSelected()) {
                    BAElectives.setClass("CS451", true);
                    System.out.println("CS451 - " + BAElectives.checkClass("CS451"));
                } else if (!CS451.isSelected()) {
                    BAElectives.setClass("CS451", false);
                    System.out.println("CS451 - " + BAElectives.checkClass("CS451"));
                }
            }

            private void handleE231(ActionEvent e) {
                if (E231.isSelected()) {
                    BAElectives.setClass("ECE231 & ECE232", true);
                    System.out.println("ECE231 & ECE232 - " + BAElectives.checkClass("ECE231 & ECE232"));
                } else if (!E231.isSelected()) {
                    BAElectives.setClass("ECE231 & ECE232", false);
                    System.out.println("ECE231 & ECE232 - " + BAElectives.checkClass("ECE231 & ECE232"));
                }
            }

            private void handleCS275(ActionEvent e) {
                if (CS275.isSelected()) {
                    BAElectives.setClass("CS275", true);
                    System.out.println("CS275 - " + BAElectives.checkClass("CS275"));
                } else if (!CS275.isSelected()) {
                    BAElectives.setClass("CS275", false);
                    System.out.println("CS275 - " + BAElectives.checkClass("CS275"));
                }
            }

            private void handleCS351(ActionEvent e) {
                if (CS351.isSelected()) {
                    BAElectives.setClass("CS351", true);
                    System.out.println("CS351 - " + BAElectives.checkClass("CS351"));
                } else if (!CS351.isSelected()) {
                    BAElectives.setClass("CS351", false);
                    System.out.println("CS351 - " + BAElectives.checkClass("CS351"));
                }
            }

            private void handleCS371(ActionEvent e) {
                if (CS371.isSelected()) {
                    BAElectives.setClass("CS371", true);
                    System.out.println("CS371 - " + BAElectives.checkClass("CS371"));
                } else if (!CS371.isSelected()) {
                    BAElectives.setClass("CS371", false);
                    System.out.println("CS371 - " + BAElectives.checkClass("CS371"));
                }
            }

            private void handleCS375(ActionEvent e) {
                if (CS375.isSelected()) {
                    BAElectives.setClass("CS375", true);
                    System.out.println("CS375 - " + BAElectives.checkClass("CS375"));
                } else if (!CS375.isSelected()) {
                    BAElectives.setClass("CS375", false);
                    System.out.println("CS375 - " + BAElectives.checkClass("CS375"));
                }
            }

            private void handleCS340(ActionEvent e) {
                if (CS340.isSelected()) {
                    BAElectives.setClass("CS340", true);
                    System.out.println("CS340 - " + BAElectives.checkClass("CS340"));
                } else if (!CS340.isSelected()) {
                    BAElectives.setClass("CS340", false);
                    System.out.println("CS340 - " + BAElectives.checkClass("CS340"));
                }
            }

            private void handleM220(ActionEvent e) {
                if (M220.isSelected()) {
                    BAElectives.setClass("M220", true);
                    System.out.println("M220 - " + BAElectives.checkClass("M220"));
                } else if (!M220.isSelected()) {
                    BAElectives.setClass("M220", false);
                    System.out.println("M220 - " + BAElectives.checkClass("M220"));
                }
            }

            private void handleM222W(ActionEvent e) {
                if (M222W.isSelected()) {
                    BAElectives.setClass("M222W", true);
                    System.out.println("M222W - " + BAElectives.checkClass("M222W"));
                } else if (!M222W.isSelected()) {
                    BAElectives.setClass("M222W", false);
                    System.out.println("M222W - " + BAElectives.checkClass("M222W"));
                }
            }

            private void handleButtonAction(ActionEvent e) {
                if (CS114.isSelected()) {
                    core.setClass("CS114", true);
                    System.out.println("CS114 - " + core.checkClass("CS114"));
                } else if (!CS114.isSelected()) {
                    core.setClass("CS114", false);
                    System.out.println("CS114 - " + core.checkClass("CS114"));
                }

                if (CS115.isSelected()) {
                    core.setClass("CS115", true);
                    System.out.println("CS115 - " + core.checkClass("CS115"));
                } else if (!CS115.isSelected()) {
                    core.setClass("CS115", false);
                    System.out.println("CS115 - " + core.checkClass("CS115"));
                }

                if (CS211.isSelected()) {
                    core.setClass("CS211", true);
                    System.out.println("CS211 - " + core.checkClass("CS211"));
                } else if (!CS211.isSelected()) {
                    core.setClass("CS211", false);
                    System.out.println("CS211 - " + core.checkClass("CS211"));
                }

                if (CS220.isSelected()) {
                    core.setClass("CS220", true);
                    System.out.println("CS220 - " + core.checkClass("CS220"));
                } else if (!CS220.isSelected()) {
                    core.setClass("CS220", false);
                    System.out.println("CS220 - " + core.checkClass("CS220"));
                }

                if (CS320.isSelected()) {
                    core.setClass("CS320", true);
                    System.out.println("CS320 - " + core.checkClass("CS320"));
                } else if (!CS320.isSelected()) {
                    core.setClass("CS320", false);
                    System.out.println("CS320 - " + core.checkClass("CS320"));
                }

                if (CS460.isSelected()) {
                    core.setClass("CS460", true);
                    System.out.println("CS460 - " + core.checkClass("CS460"));
                } else if (!CS460.isSelected()) {
                    core.setClass("CS460", false);
                    System.out.println("CS460 - " + core.checkClass("CS460"));
                }

                if (M144.isSelected()) {
                    core.setClass("M144", true);
                    System.out.println("M144 - " + core.checkClass("M144"));
                } else if (!M144.isSelected()) {
                    core.setClass("M144", false);
                    System.out.println("M144 - " + core.checkClass("M144"));
                }

                if (M221W.isSelected()) {
                    core.setClass("M221W", true);
                    System.out.println("M221W - " + core.checkClass("M221W") + "\n");
                } else if (!M221W.isSelected()) {
                    core.setClass("M221W", false);
                    System.out.println("M221W - " + core.checkClass("M221W") + "\n");
                }
                System.out.println(core.checkCore());

                /*
                SCIENCE BA
                 */
            }
        }
        );

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
