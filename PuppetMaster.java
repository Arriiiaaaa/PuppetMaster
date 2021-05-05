import ecs100.*;
/**
 * User Interface to Command the Cartoon Characters.
 *
 * @author Arianna
 * @version 4/5/21
 */
public class PuppetMaster
{
    // fields to store calues between events/method calls
    private static final int CANVASWIDTH = 1000;
    private static final int CANVASHEIGHT = 500;
    private CartoonCharacter cc = new CartoonCharacter(200, 100, "casey");
    private double walkDist = 20;
    // methods to respond to the buttons, slider, textField
    /**
     * Tell cartoon character to smile
     */
    public void doSmile() {
        this.cc.smile();
    }
    
    /**
     * Tell cartoon character to frown
     */
    public void doFrown() {
        this.cc.frown();
    }
    
    /**
     * Tell cartoon character to turn left
     */
    public void doLeft() {
        this.cc.lookLeft();
    }
    
    /**
     * Tell cartoon character to turn right
     */
    public void doRight() {
        this.cc.lookRight();
    }
    
    /**
     * Tell cartoon character to say the words
     */
    public void doSpeak(String words) {
        this.cc.speak(words);
    }
    
    /**
     * Tell cartoon character to Think the words
     */
    public void doThink(String words) {
        this.cc.think(words);
    }
    
    /**
     * Set distance to walk
     */
    public void setDist(double dist) {
        this.walkDist = dist;
    }
    
    /**
     * Tell Cartoon Character to walk
     */
    public void doWalk() {
        this.cc.walk(this.walkDist);
    }
    
    /**
     *  Clear graphics pane
     */
    private void clear() {
        UI.clearPanes(); // Clear the graphics pane
        UI.setDivider(0.0); // Hide the text pane
    }
    
    
    
    // main setup GUI
    public static void main(String[]args) {
        // make a puppet master object
        PuppetMaster pm = new PuppetMaster();
        
        final int DISTMIN = 1;
        final int DISTMAX = 100;
        final int DISTINIT = 20;
        // setup buttons, slider, textField, to call methods on the object
        UI.initialise();
        UI.setWindowSize(CANVASWIDTH, CANVASHEIGHT);
        UI.addButton("Smile", pm::doSmile);
        UI.addButton("Frown", pm::doFrown);
        UI.addButton("Left", pm::doLeft);
        UI.addButton("Right", pm::doRight);
        UI.addTextField("Say", pm::doSpeak);
        UI.addTextField("Think", pm::doThink);
        UI.addButton("Walk", pm::doWalk);
        UI.addSlider("Distance", DISTMIN, DISTMAX, DISTINIT, pm::setDist);
        
        // sTANDARD bUTTONS
        UI.addButton("Clear", pm::clear);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0); // must come after setting up buttons
        
    }
}
