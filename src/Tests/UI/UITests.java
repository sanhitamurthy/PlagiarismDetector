package Tests.UI;
import application.App;
import application.MainPageController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
public class UITests {



        boolean res = true;

        //testing the start of an application
        @Test
        public void starttest() throws InterruptedException {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    new JFXPanel(); // Initializes the JavaFx Platform
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            new App().start(new Stage()); // Create and initialize your app.
                        }
                    });
                }
            });
            try {
                thread.start();// Initialize the thread
                Thread.sleep(10000); // Time to use the app, with out this, the thread will be killed very quickly
            } catch (Exception e) {
                res = false;
            }
            assertEquals(true, res);
        }


        //testing if the compare files in UI works
        @Test
        public void compareFilestest() throws InterruptedException {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    new JFXPanel(); // Initializes the JavaFx Platform
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            App a = new App();
                            a.setFile1Path("./resources/sum_original.java");
                            a.setFile2Path("./resources/sum_copied.java");
                            a.compareFiles();
                        }
                    });
                }
            });
            try {
                thread.start();// Initialize the thread
                Thread.sleep(10000); // Time to use the app, with out this, the thread
                // will be killed before you can tell.
            } catch (Exception e) {
                res = false;
            }
            assertEquals(true, res);
        }

        //testing of the detailed result in UI
        @Test
        public void detailedResultTest() throws InterruptedException {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    new JFXPanel(); // Initializes the JavaFx Platform
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            App a = new App();
                            a.setFile1Path("./resources/sum_original.java");
                            a.setFile2Path("./resources/sum_copied.java");
                            a.compareFiles();
                            a.viewDetailedResult();
                        }
                    });
                }
            });
            try {
                thread.start();// Initialize the thread
                Thread.sleep(10000); // Time to use the app, with out this, the thread
                // will be killed before you can tell.
            } catch (Exception e) {
                res = false;
            }
            assertEquals(true, res);
        }

        //testing returning to main function in UI
        @Test
        public void returnToMainPageTest() throws InterruptedException {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    new JFXPanel(); // Initializes the JavaFx Platform
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            App a = new App();
                            a.setFile1Path("./resources/sum_original.java");
                            a.setFile2Path("./resources/sum_copied.java");
                            a.compareFiles();
                            a.returnToMainPage();

                        }
                    });
                }
            });
            try {
                thread.start();// Initialize the thread
                Thread.sleep(10000); // Time to use the app, with out this, the thread
                // will be killed before you can tell.
            } catch (Exception e) {
                res = false;
            }
            assertEquals(true, res);
        }

        //testing clear function in UI
        @Test
        public void clearUITest() throws InterruptedException {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    new JFXPanel(); // Initializes the JavaFx Platform
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            App a = new App();
                            a.setFile1Path("./resources/sum_original.java");
                            a.setFile2Path("./resources/sum_copied.java");
                            a.compareFiles();
                            a.clear();

                        }
                    });
                }
            });
            try {
                thread.start();// Initialize the thread
                Thread.sleep(10000); // Time to use the app, with out this, the thread
                // will be killed before you can tell.
            } catch (Exception e) {
                res = false;
            }
            assertEquals(true, res);
        }

        //testing setFile functionality in UI
        @Test
        public void setFileTest() throws InterruptedException {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    new JFXPanel(); // Initializes the JavaFx Platform
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            App a = new App();
                            a.setFile1Name("TestFile1");
                            a.setFile2Name("TestFile2");
                            a.setFile1Path("./resources/sum_original.java");
                            a.setFile2Path("./resources/sum_similar.java");
                        }
                    });
                }
            });
            try {
                thread.start();// Initialize the thread
                Thread.sleep(10000); // Time to use the app, with out this, the thread
                // will be killed before you can tell.
            } catch (Exception e) {
                res = false;
            }
            assertEquals(true, res);
        }





    /**
     * Checks if two files are uploaded
     * @throws InterruptedException
     */
    @Test
    public void hasFileTest() throws InterruptedException {
        App myapp = new App();
        MainPageController mpc = new MainPageController();
        mpc.setApp(myapp);
        String path = "C:/Users/LENOVO/Desktop/sum_original.java";
        File testfile = new File(path);
        mpc.setfile1(testfile);
        mpc.setfile2(testfile);
        assertEquals(true,(mpc.gethasfilevalue()&&mpc.gethasfile2value()));
    }

}